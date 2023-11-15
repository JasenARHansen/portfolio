#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <vector>

using namespace std;

class RotaryLock {
public:
    static void description() {
        cout << R"(Rotary Lock (Chapter 1)
    Note: Chapter 2 is a harder version of this puzzle.
    You're trying to open a lock. The lock comes with a wheel which has the integers from 1 to N arranged in a circle in order around it (with integers 1 and N adjacent to one another). The wheel is initially pointing at 1.
    For example, the following depicts the lock for N = 10 (as is presented in the second sample case).
    It takes 1 second to rotate the wheel by 1 unit to an adjacent integer in either direction, and it takes no time to select an integer once the wheel is pointing at it.
    The lock will open if you enter a certain code. The code consists of a sequence of M integers, the Ith of which is Ci. Determine the minimum number of seconds required to select all M of the code's integers in order.
    Please take care to write a solution which runs within the time limit.

    Constraints
        3 ≤ N ≤ 50, 000, 000
        1 ≤ M ≤ 1, 000
        1 ≤ Ci ≤ N

    Sample test case #1
        N = 3
        M = 3
        C = [1, 2, 3]
        Expected Return Value = 2

    Sample test case #2
        N = 10
        M = 4
        C = [9, 4, 4, 8]
        Expected Return Value = 11

    Sample Explanation
        In the first case, there are 3 integers on the lock, and the sequence of integers to be selected is [1, 2, 3]. One optimal way to enter the code is: select 1 → rotate to 2 (1 second) → select 2 → rotate to 3 (1 second) → select 3. The total time taken is 1+1=2 seconds.
        In the second case, the lock consists of the integers 1 through 10, and the sequence to be selected is [9, 4, 4, 8]. One optimal way to enter the code is: rotate from 1 backwards to 9 (2 seconds) → select 9 → rotate forwards to 4 (5 seconds) → select 4 twice → rotate forwards to 8 (4 seconds) → select 8. The total time taken is 2+5+4=1 seconds.)"
             << endl;
    }

    static long long getMinCodeEntryTime(int N, int M, const vector<int> &C) {
        assert(3 <= N);
        assert(N <= 5 * pow(10, 7));
        assert(1 <= M);
        assert(M <= pow(10, 3));
        long long result = 0;
        int last = 1;
        for (int number: C) {
            assert(1 <= number);
            assert(number <= N);
            if ((abs(number - last)) < (N - abs(number - last))) {
                result += abs(number - last);
            } else {
                result += N - abs(number - last);
            }
            last = number;
        }
        return result;
    }
};

#pragma clang diagnostic pop