#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cmath>
#include <cassert>

using namespace std;

class FactorialTrailingZeroes {

public:

    static void description() {
        cout << R"(172. Factorial Trailing Zeroes
    Given an integer n, return the number of trailing zeroes in n!.
    Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

    Example 1:
        Input: n = 3
        Output: 0
        Explanation:
            3! = 6, no trailing zero.

    Example 2:
        Input: n = 5
        Output: 1
        Explanation:
            5! = 120, one trailing zero.

    Example 3:
        Input: n = 0
        Output: 0

    Constraints:
        0 <= n <= 10^4

    Follow up:
        Could you write a solution that works in logarithmic time complexity?)" << endl;
    }

    static int trailingZeroes(int n) {
        assert (0 <= n);
        assert (n <= pow(10, 4));
        int result = 0;
        while (n / 5) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }
};

#pragma clang diagnostic pop