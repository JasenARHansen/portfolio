#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>

using namespace std;

class Factorial {
public:
    static void description() {
        cout << R"(Question: Factorial
    Program a factorial method.)" << endl;
    }

    static int factorialRecursion(int base) {
        int result;
        if (base <= 0) {
            result = 0;
        } else if (base == 1) {
            result = 1;
        } else {
            result = base * factorialRecursion(base - 1);
        }
        return result;
    }

    static int factorial(int base) {
        int result;
        if (base <= 0) {
            result = 0;
        } else if (base == 1) {
            result = 1;
        } else {
            result = base;
            base--;
            while (base > 0) {
                result *= base;
                base--;
            }
        }
        return result;
    }


};

#pragma clang diagnostic pop