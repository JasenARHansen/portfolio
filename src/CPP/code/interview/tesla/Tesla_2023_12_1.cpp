#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#pragma ide diagnostic ignored "cppcoreguidelines-pro-type-member-init"
#pragma ide diagnostic ignored "cert-msc50-cpp"
#pragma ide diagnostic ignored "cert-msc51-cpp"
/*
    Aristos C++ interview question
*/
#include <chrono>
#include <thread>
#include <stdexcept>
#include <vector>
#include <unistd.h>
#include <mutex>
#include <atomic>
#include <iostream>

using Time = std::chrono::steady_clock;
using float_sec = std::chrono::duration<float>;
using time_point = std::chrono::time_point<Time, float_sec>;
enum Status {
    Valid,
    NoChange,
    Error,
};
struct VoltageSensorReading {
    Status status;
    double voltage;
    time_point timestamp;
};

int randInt() {
    return rand();
}

int randRange(int min, int max) {
    // return rand() * (max - min) + min;
    // I had to change this due to the output being to large
    // Reference https://cplusplus.com/reference/cstdlib/rand/
    //   sample: rand() % 30 + 1985;   // in the range 1985-2014
    // so to get the correct range I had to modify the output to the following:
    return rand() % (max - min + 1) + min;
}

VoltageSensorReading getVoltageReading() {
    VoltageSensorReading ret;
    int i = randInt();
    switch (i % 3) {
        case 0:
            std::this_thread::sleep_for(std::chrono::milliseconds(randRange(0, 1000)));
            ret.status = Valid;
            ret.voltage = double(randInt());
            break;
        case 1:
            std::this_thread::sleep_for(std::chrono::seconds(1));
            ret.status = NoChange;
            ret.voltage = 0;
            break;
        case 2:
            ret.status = Error;
            ret.voltage = double(randInt());
            break;
        default:
            ret.status = Error; // Not technically necessary since an exception is thrown but clears warnings
            throw std::runtime_error("not possible - programming error");
    }
    ret.timestamp = Time::now();
    return ret;
}
/* DO NOT EDIT ABOVE THIS LINE ----------------------------------------------------------------------------- */
/*
    You are given this function to use.
    DO NOT IMPLEMENT.
    VoltageSensorReading getVoltageReading();
    This function blocks for 0-1 seconds.
    It returns only when:
        1: The sensor value changes.
        2: There is a read error.
        3: 1 second timeout.
*/
/*
    Design a class that lets us read the values from a voltage sensor.
    The library will be used by other programmers in their code.
    Expect it to be used in a multithreaded program.
    Use the provided low-level function getVoltageReading().
*/
class Sensor {
public:
    // constructor initializing thread
    Sensor() {
        continuation_token.store(true);
        myThread = std::thread(&Sensor::getDataOnTimer, std::ref(dataLock), std::ref(history),
                               std::ref(continuation_token), cutoff);
    }

    // destructor to cleanly exit thread
    ~Sensor() {
        continuation_token.store(false);
        myThread.join();
    }

    // Implement this.
    // Part 1: Read the most recent valid sensor reading
    // Do not block.
    double GetReading() {
        // If there is no history there is no valid reading.
        // Wait for history to be available.
        while (history.empty()) {
            usleep(Sensor::interval);
        }
        // Lock the history since we are looking for the last value and that changes
        dataLock.lock();
        auto data = history.at(history.size() - 1).second;
        dataLock.unlock();
        return data;
    }

    // Implement this.
    // Part 2: Read the sensor reading nearest to any provided timestamp.
    // Do not block.
    double GetReadingAtTime(time_point t) {
        double result = 0;
        dataLock.lock();
        // Edge case 1: The provided timestamp is greater than the current time.
        //              Return 0
        // Edge case 2: There is no stored data.
        //              Return 0
        // Edge case 3: The provided timestamp is older than the oldest stored data.
        //              Return 0
        // If none of the above, perform binary search
        if (!((Time::now() < t) || (history.empty()) || (t < history.at(0).first))) {
            // find the first element that is smaller than the target
            unsigned long long low = 0;
            unsigned long long high = history.size();
            while (low != high) {
                unsigned long long mid = (low + high) / 2;
                if (history.at(mid).first <= t) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            result = history.at(low).second;
        }
        dataLock.unlock();
        return result;
    }

private:
    // usleep interval
    const unsigned int interval = 50;
    // Maximum age of stored record
    const std::chrono::milliseconds cutoff = std::chrono::milliseconds(24 * 60 * 60 * 1000);
    // Thread to monitor data
    std::thread myThread;
    // History or valid voltages
    std::vector<std::pair<time_point, double>> history;
    // mutex to lock critical region
    std::mutex dataLock;
    // Token to be used to terminate the thread
    std::atomic<bool> continuation_token;

    // Method to use in thread
    static void getDataOnTimer(std::mutex &dataLock, std::vector<std::pair<time_point, double>> &history,
                               std::atomic<bool> &continuation_token, std::chrono::milliseconds cutoff) {
        // Infinite execution until token is set to false
        while (continuation_token) {
            auto data = getVoltageReading();
            if (data.status != Error) {
                dataLock.lock();
                if (data.status == Valid) {
                    history.emplace_back(data.timestamp, data.voltage);
                } else if (!history.empty()) {
                    // Edge case 1: If the history is empty we do not want to store 0 on an initial
                    //   NoChange so skip
                    // Edge case 2: If the history is not empty we do not want to store 0 on NoChange
                    //   so store the previous valid voltage
                    history.emplace_back(data.timestamp, history.at(history.size() - 1).second);
                }
                dataLock.unlock();
            }
            // If data is older than threshold, prune old data
            time_point threshold = Time::now() - cutoff;
            dataLock.lock();
            while ((!history.empty()) && ((time_point) history.at(0).first < threshold)) {
                history.erase(history.begin());
            }
            dataLock.unlock();
        }
    }
};
/*
int main() {
    srand(time(nullptr));
    // write any debug code or tests here
    auto s = Sensor();
    auto reading = s.GetReading();
    if (reading == 0) {
        std::cout << "Not an expected reading.  Using cout since I do not want to add asserts to this." << std::endl;
    } else {
        std::cout << "Reading: " << reading << std::endl;
    }
    sleep(4);
    auto testTime = Time::now();
    sleep(6);
    auto readingAtTime = s.GetReadingAtTime(testTime);
    if (readingAtTime == 0) {
        std::cout << "Not an expected reading.  Using cout since I do not want to add asserts to this." << std::endl;
    } else {
        std::cout << "GetReadingAtTime: " << readingAtTime << std::endl;
    }
}
*/
#pragma clang diagnostic pop