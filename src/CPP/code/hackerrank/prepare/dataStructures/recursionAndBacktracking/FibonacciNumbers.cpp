#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>

using namespace std;

class FibonacciNumbers {
public:
    static void description() {
        cout << R"(Recursion: Fibonacci Numbers:
    The Fibonacci Sequence
    The Fibonacci sequence appears in nature all around us, in the arrangement of seeds in a sunflower and the
     spiral of a nautilus for example.
    The Fibonacci sequence begins with fibonacci(0) = 0 and fibonacci(1) = 1 as its first and second terms.
    After these first two elements, each subsequent element is equal to the sum of the previous two elements.
    Programmatically:
        fibonacci(0) = 0
        fibonacci(1) = 1
        fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2)
        Given n, return the nth number in the sequence.
    Example:
        n = 5
        The Fibonacci sequence to 6 is [0, 1, 1, 2, 3, 5, 8].
        With zero-based indexing, fs[5] = 5.
    Function Description:
        Complete the recursive function fibonacci in the editor below.
        fibonacci has the following parameter(s):
            int n: the index of the sequence to return
    Returns:
        int: the nth element in the Fibonacci sequence
    Input Format:
        The integer n.
    Constraints:
        1 < n ≤ 30
    Sample Input:
        STDIN   Function
        -----   --------
        3       n = 3
    Sample Output:
        2
    Explanation:
        The Fibonacci sequence begins as follows:
            fibonacci(0) = 0
            fibonacci(1) = 1
            fibonacci(2) = 0 + 1 = 2
            fibonacci(3) = 1 + 2 = 3
            fibonacci(4) = 2 + 3 = 5
            fibonacci(5) = 3 + 5 = 8
            ...
    In the sequence above, fibonacci(3) is 2.)" << endl;
    }

    static int fibonacci(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            default:
                return fibonacci(n - 2, 0, 1);
        }
    }

private:
    static int fibonacci(int remaining, int first, int second) {
        if (remaining > 0) {
            return fibonacci(remaining - 1, second, first + second);
        } else {
            return first + second;
        }
    }
};

#pragma clang diagnostic pop