#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <sstream>
#include <iterator>

using namespace std;

class BubbleSort {
public:
    static void description() {
        cout << R"(Question: Bubble Sort
    Generate a bubble sort method for a vector.)" << endl;
    }

    static vector<int> sort(const vector<int> &input) {
        vector<int> result = copy(input);
        auto sort = true;
        auto maxIndex = (int) result.size() - 1;
        while (sort) {
            sort = false;
            for (int index = 0; index < maxIndex; index++) {
                if (result.at(index) > result.at(index + 1)) {
                    // out of order
                    swap(result, index, index + 1);
                    sort = true;
                }
            }
            maxIndex--;
        }
        return result;
    }

    static string toString(const vector<int> &input) {
        ostringstream result;
        if (!input.empty()) {
            std::copy(input.begin(), input.end() - 1, ostream_iterator<int>(result, ", "));
            result << input.back();
        }
        return result.str();
    }

private:
    static vector<int> copy(const vector<int> &input) {
        vector<int> result;
        result.reserve(input.size());
        for (auto value: input) {
            result.push_back(value);
        }
        return result;
    }

    static void swap(vector<int> &input, int left, int right) {
        int swap = input.at(left);
        input[left] = input.at(right);
        input[right] = swap;
    }
};

#pragma clang diagnostic pop