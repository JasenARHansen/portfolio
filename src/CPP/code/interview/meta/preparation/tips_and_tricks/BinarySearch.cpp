#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class BinarySearch {
public:
    static void description() {
        cout << R"(Question: Bubble Sort
    Generate a bubble sort method for a vector.)" << endl;
    }

    static int binarySearchRecursive(const vector<int> &input, int value) {
        return binarySearchRecursive(input, 0, (int)input.size() - 1, value);
    }

    static int binarySearch(const vector<int> &input, int value) {
        auto result = 0;
        if (!input.empty()) {
            auto left = 0;
            auto right = (int)input.size() - 1;
            int middle;
            while (left <= right) {
                middle = (right + left) / 2;
                if (input.at(middle) == value) {
                    result = middle;
                    break;
                } else if (value < input.at(middle)) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            if (left > right) {
                result = -1;
            }
        }
        return result;
    }

private:
    static int binarySearchRecursive(const vector<int> &input, int left, int right, int value) {
        int result;
        if (right < left) {
            result = -1;
        } else {
            int middle = (left + right) / 2;
            if (input.at(middle) == value) {
                result = middle;
            } else if (value < input.at(middle)) {
                result = binarySearchRecursive(input, left, middle - 1, value);
            } else {
                result = binarySearchRecursive(input, middle + 1, right, value);
            }
        }
        return result;
    }

    static vector<int> copy(const vector<int> &input) {
        vector<int> result;
        result.reserve(input.size());
        for (auto value: input) {
            result.push_back(value);
        }
        return result;
    }

};

#pragma clang diagnostic pop