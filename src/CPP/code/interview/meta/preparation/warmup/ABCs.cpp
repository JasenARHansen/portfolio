#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>

using namespace std;

class ABCs {
public:
    static void description() {
        cout << R"(ABCs
    Given three integers AA, BB, and CC, determine their sum.
    Your task is to implement the function getSum(A, B, C) which returns the sum A+B+CA+B+C.
    Constraints
    1≤A,B,C≤1001≤A,B,C≤100

    Sample test case #1
        A = 1
        B = 2
        C = 3
        Expected Return Value = 6

    Sample test case #2
        A = 100
        B = 100
        C = 100
        Expected Return Value = 300

    Sample test case #3
        A = 85
        B = 16
        C = 93
        Expected Return Value = 194

    Sample Explanation
        In the first case
        A + B + C = 1 + 2 + 3 = 6.)" << endl;
    }

    static int getSum(int a, int b, int c) {
        assert(1 <= a);
        assert(a <= 100);
        assert(1 <= b);
        assert(b <= 100);
        assert(1 <= c);
        assert(c <= 100);
        return a + b + c;
    }
};

#pragma clang diagnostic pop