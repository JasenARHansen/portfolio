#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class UniformIntegers {

public:
    static void description() {
        cout << R"(Uniform Integers
    A positive integer is considered uniform if all of its digits are equal. For example, 222 is uniform, while 223 is not.
    Given two positive integers A and B, determine the number of uniform integers between A and B, inclusive.
    Please take care to write a solution which runs within the time limit.

    Constraints
        1 ≤ A ≤ B ≤ 10^12

    Sample test case #1
        A = 75
        B = 300
        Expected Return Value = 5

    Sample test case #2
        A = 1
        B = 9
        Expected Return Value = 9

    Sample test case #3
    A = 999999999999
    B = 999999999999
    Expected Return Value = 1

    Sample Explanation
        In the first case, the uniform integers between 75 and 300 are 77, 88, 99, 111, and 222.
        In the second case, all 99 single-digit integers between 11 and 99 (inclusive) are uniform.
        In the third case, the single integer under consideration (999,999,999,999) is uniform.)" << endl;
    }

    static int getUniformIntegerCountInInterval(long long A, long long B) {
        assert(1 <= A);
        assert(A <= pow(10, 15));
        assert(B <= pow(10, 12));
        assert(A <= B);
        auto result = 0;
        string stringA = to_string(A);
        string stringB = to_string(B);
        // string lengths are same
        if (stringA.size() == stringB.size()) {
            // test if stringA is uniform or less
            bool uniformOrLessA = false;
            char firstChar = stringA.at(0);
            int index = 1;
            for (; index < stringA.size();) {
                if (stringA.at(index) == firstChar) {
                    index++;
                } else {
                    break;
                }
            }
            // if index == stringA.size() the number is uniform.  In char at index n+1 < char at index n, then less
            if ((index == stringA.size()) || (stringA.at(index) < firstChar)) {
                uniformOrLessA = true;
            }
            int left = stringA.at(0) - '0';
            if (!uniformOrLessA) {
                left++;
            }
            // test if stringB is uniform or more
            bool uniformOrMoreB = false;
            firstChar = stringB.at(0);
            index = 1;
            for (; index < stringB.size();) {
                if (stringB.at(index) == firstChar) {
                    index++;
                } else {
                    break;
                }
            }
            // if index == stringB.size() the number is uniform.  In char at index n+1 > char at index n, then more
            if ((index == stringB.size()) || (stringB.at(index) > firstChar)) {
                uniformOrMoreB = true;
            }
            int right = stringB.at(0) - '0';
            if (!uniformOrMoreB) {
                right--;
            }
            result = right - left + 1;
        } else {
            // A to end of that digit range.  Ex, if A is 10, the digit range would end at 99
            bool uniformOrLessA = false;
            char firstChar = stringA.at(0);
            int index = 1;
            for (; index < stringA.size();) {
                if (stringA.at(index) == firstChar) {
                    index++;
                } else {
                    break;
                }
            }
            // if index == stringA.size() the number is uniform.  In char at index n+1 < char at index n, then less
            if ((index == stringA.size()) || (stringA.at(index) < firstChar)) {
                uniformOrLessA = true;
            }
            result += 9 - (stringA.at(0) - '0');
            if (uniformOrLessA) {
                result++;
            }
            // B to end of that digit range.  Ex, if B is 100, the digit range would end at 999
            bool uniformOrMoreB = false;
            firstChar = stringB.at(0);
            index = 1;
            for (; index < stringB.size();) {
                if (stringB.at(index) == firstChar) {
                    index++;
                } else {
                    break;
                }
            }
            // if index == stringB.size() the number is uniform.  In char at index n+1 > char at index n, then more
            if ((index == stringB.size()) || (stringB.at(index) > firstChar)) {
                uniformOrMoreB = true;
            }
            result += stringB.at(0) - '0';
            if (!uniformOrMoreB) {
                result--;
            }
            // if the length of the string is off by more than 1, entire digit ranges are added.
            // Ex, if A is 1 and B is 400, the 10's digit range would include all the uniform digits of that range
            if ((stringB.size() - stringA.size()) > 1) {
                result += (((int) stringB.size() - (int) stringA.size()) - 1) * 9;

            }
        }
        return result;
    }

};

#pragma clang diagnostic pop