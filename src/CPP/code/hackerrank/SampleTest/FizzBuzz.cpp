#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>

using namespace std;

class FizzBuzz {
public:
    static void description() {
        cout << R"(2: FizzBuzz
    Given a number n, for each integer i in the range from 1 to n inclusive, print one value per line as follows:
        If i is a multiple of both 3 and 5, print FizzBuzz.
        If i is a multiple of 3 (but not 5), print Fizz.
        If i is a multiple of 5 (but not 3), print Buzz.
        If i is not a multiple of 3 or 5, print the value of i.
    Function Description
        Complete the function fizzBuzz in the editor below.
        fizzBuzz has the following parameter(s):
            int n:  upper limit of values to test (inclusive)
    Returns:    NONE
    Prints:
        The function must print the appropriate response for each value i in the set {1, 2, ... n}
     in ascending order, each on a separate line.
    Sample Input:
        STDIN    Function
        -----    --------
        15    →  n = 15
    Sample Output:
        1
        2
        Fizz
        4
        Buzz
        Fizz
        7
        8
        Fizz
        Buzz
        11
        Fizz
        13
        14
        FizzBuzz
    Explanation:
        The numbers 3, 6, 9, and 12 are multiples of 3 (but not 5), so print Fizz on those lines.
        The numbers 5 and 10 are multiples of 5 (but not 3), so print Buzz on those lines.
        The number 15 is a multiple of both 3 and 5, so print FizzBuzz on that line.
        None of the other values is a multiple of either 3 or 5, so print the value of i on those lines.)" << endl;
    }

    static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                cout << "FizzBuzz" << endl;
            } else if (i % 3 == 0) {
                cout << "Fizz" << endl;
            } else if (i % 5 == 0) {
                cout << "Buzz" << endl;
            } else {
                cout << i << endl;
            }
        }
    }
};

#pragma clang diagnostic pop