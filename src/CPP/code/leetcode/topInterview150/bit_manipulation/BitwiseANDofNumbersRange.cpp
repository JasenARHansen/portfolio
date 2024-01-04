#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>

using namespace std;

class BitwiseANDofNumbersRange {
public:
    static void description() {
        cout << R"(201: Bitwise AND of Numbers Range
    Given two integers left and right that represent the range [left, right], return the bitwise AND of all
     numbers in this range, inclusive.
    Example 1:
        Input: left = 5, right = 7
        Output: 4
    Example 2:
        Input: left = 0, right = 0
        Output: 0
    Example 3:
        Input: left = 1, right = 2147483647
        Output: 0
    Constraints:
        0 ≤ left ≤ right ≤ 2^31 - 1)" << endl;
    }

    static int rangeBitwiseAnd(int left, int right) {
        assert (0 <= left);
        assert (0 <= right);
        assert (left <= right);
        unsigned int mask = 0xffffffff;
        while ((left & mask) != (right & mask)) {
            mask <<= 1;
        }
        return (int) (left & mask);
    }
};

#pragma clang diagnostic pop