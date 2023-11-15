#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cmath>
#include <cfloat>

using namespace std;

class BillionUsers {
public:
    static void description() {
        cout << R"(1 Billion Users
    We have N different apps with different user growth rates. At a given time t, measured in days, the number of users using an app is g^t (for simplicity we'll allow fractional users), where g is the growth rate for that app. These apps will all be launched at the same time and no user ever uses more than one of the apps. We want to know how many total users there are when you add together the number of users from each app.
    After how many full days will we have 1 billion total users across the N apps?

    Signature
        int getBillionUsersDay(float[] growthRates)

    Input
        1.0 < growthRate < 2.0 for all growth rates
        1 <= N <= 1, 000

    Output
        Return the number of full days it will take before we have a total of 1 billion users across all N apps.

    Example 1
        growthRates = [1.5]
        output = 52

    Example 2
        growthRates = [1.1, 1.2, 1.3]
        output = 79

    Example 3
        growthRates = [1.01, 1.02]
        output = 1047)" << endl;
    }

    static int getBillionUsersDay(const vector<float> &growthRates) {
        auto result = 0;
        auto high = maxStartPower(growthRates);
        auto target = (int) pow(10, 9);
        if (1 == growthRates.size()) {
            result = high;
        } else {
            auto low = 0;
            int middleIndex;
            int current;
            while (low != high) {
                middleIndex = low + (high - low) / 2;
                current = growthSum(growthRates, middleIndex);
                if (current < target) {
                    low = middleIndex + 1;
                } else if (current > target) {
                    high = middleIndex - 1;
                } else {
                    result = middleIndex;
                    break;
                }
            }
            if (low == high) {
                result = low;
            }
        }
        return result;
    }

private:
    static int growthSum(const vector<float> &growthRates, int day) {
        int sum = 0;
        for (auto rate: growthRates) {
            sum += (int) pow(rate, day);
        }
        return sum;
    }

    static int maxStartPower(const vector<float> &growthRates) {
        auto result = DBL_MAX;
        double processing;
        for (auto rate: growthRates) {
            processing = log(pow(10, 9)) / log(rate);
            if (processing < result) {
                result = processing;
            }
        }
        return ceil(result);
    }
};

#pragma clang diagnostic pop