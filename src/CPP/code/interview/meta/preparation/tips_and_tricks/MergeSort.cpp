#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <sstream>
#include <iterator>

using namespace std;

class MergeSort {
public:
    static void description() {
        cout << R"(Question: Merge Sort
    Generate a merge sort method for a vector.)" << endl;
    }

    static vector<int> sort(const vector<int> &input) {
        vector<int> result;
        if (!input.empty()) {
            if (input.size() == 1) {
                result.push_back(input.at(0));
            } else {
                auto const half_size = (int) input.size() / 2;
                vector<int> split_left(input.begin(), input.begin() + half_size);
                vector<int> split_right(input.begin() + half_size, input.end());
                auto left = sort(split_left);
                auto right = sort(split_right);
                result = merge(left, right);
            }
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
    static vector<int> merge(const vector<int> &left, const vector<int> &right) {
        vector<int> result;
        auto leftPointer = 0;
        auto rightPointer = 0;
        while ((leftPointer < left.size()) && (rightPointer < right.size())) {
            if (left.at(leftPointer) < right.at(rightPointer)) {
                result.push_back(left.at(leftPointer));
                leftPointer++;
            } else {
                result.push_back(right.at(rightPointer));
                rightPointer++;
            }
        }
        while (leftPointer < left.size()) {
            result.push_back(left.at(leftPointer));
            leftPointer++;
        }
        while (rightPointer < right.size()) {
            result.push_back(right.at(rightPointer));
            rightPointer++;
        }
        return result;
    }

};

#pragma clang diagnostic pop