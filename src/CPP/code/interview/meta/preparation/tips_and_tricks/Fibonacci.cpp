#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>

using namespace std;

class Fibonacci {
public:
    static void description() {
        cout << R"(Question: Fibonacci
    Program a fibonacci method.)" << endl;
    }

    static int fibonacciRecursion(int base) {
        int result;
        if (base <= 0) {
            result = 0;
        } else if (base == 1) {
            result = 1;
        } else {
            result = fibonacciRecursion(base - 1) + fibonacciRecursion(base - 2);
        }
        return result;
    }

    static int fibonacci(int base) {
        int result;
        if (base <= 0) {
            result = 0;
        } else if (base <= 2) {
            result = 1;
        } else {
            auto odd = 1;
            auto even = 1;
            auto isEven = true;
            for (auto count = 2; count < base; count++) {
                if (isEven) {
                    odd = odd + even;
                } else {
                    even = odd + even;
                }
                isEven = !isEven;
            }
            if (isEven) {
                result = even;
            } else {
                result = odd;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop