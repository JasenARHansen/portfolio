#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>

using namespace std;

class Pow {

public:

    static void description() {
        cout << R"(50. Pow(x, n)
    Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

    Example 1:
        Input: x = 2.00000, n = 10
        Output: 1024.00000

    Example 2:
        Input: x = 2.10000, n = 3
        Output: 9.26100

    Example 3:
        Input: x = 2.00000, n = -2
        Output: 0.25000
        Explanation:
            2-2 = 1/22 = 1/4 = 0.25

    Constraints:
        -100.0 < x < 100.0
        -2^31 <= n <= 2^31-1
        n is an integer.
        Either x is not zero or n > 0.
        -10^4 <= xn <= 10^4)" << endl;
    }

    static double myPow(double x, int n) {
        assert(-100.0 <= x);
        assert(x <= 100.1);
        auto result = x;
        bool isNegative = (n & 0x80000000);
        auto groupSize = 1000000;
        auto groupCount = 0;
        if (isNegative) {
            while (n < -groupSize) {
                groupCount++;
                n += groupSize;
            }
        } else {
            while (n > groupSize) {
                groupCount++;
                n -= groupSize;
            }
        }
        n = abs(n);
        if (n == 0) {
            result = 1;
        } else if (x == 1) {
            result = 1;
        } else if (x == -1) {
            result = 1;
            if (n % 2) {
                result *= -1;
            }
        } else {
            double groupResult = x;
            if (groupCount > 0) {
                for (long int i = 1; i < groupSize; i++) {
                    groupResult *= x;
                }
            }
            for (long int i = 1; i < n; i++) {
                result *= x;
            }
            if (groupCount > 0) {
                for (int i = 0; i < groupCount; i++) {
                    result *= groupResult;
                }
            }
            if (isNegative) {
                result = 1 / result;
            }
        }
        auto value = 100000;
        return ((((long int) (result * value))) / (double) value);
    }
};

#pragma clang diagnostic pop