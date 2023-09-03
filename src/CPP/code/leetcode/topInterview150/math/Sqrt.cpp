#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>

using namespace std;

class Sqrt {

public:

    static void description() {
        cout << R"(69. Sqrt(x)
    Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
    You must not use any built-in exponent function or operator.
        For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

    Example 1:
        Input: x = 4
        Output: 2
        Explanation:
            The square root of 4 is 2, so we return 2.

    Example 2:
        Input: x = 8
        Output: 2
        Explanation:
            The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

    Constraints:
        0 <= x <= 2^31 - 1
    Note:

        I am using Newton's method: https://en.wikipedia.org/wiki/Newton%27s_method)" << endl;
    }

    static int mySqrt(int x) {
        assert(0 <= x);
        // using a number that will fail the first while check
        double xn = x;
        // using a number that will fail the first while check
        double result = 5 * xn;
        // Test to see if result is within the precision of the answer
        while (abs(result - xn) >= 0.001) {
            // Update result
            xn = result;
            // Calculate new result
            result = 0.5 * (xn + (x / xn));
        }
        return (int) result;
    }
};

#pragma clang diagnostic pop