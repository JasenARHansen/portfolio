#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

class Cafeteria {
public:
    static void description() {
        cout << R"(Cafeteria
    A cafeteria table consists of a row of N seats, numbered from 1 to N from left to right.
    Social distancing guidelines require that every diner be seated such that K seats to their left and
     K seats to their right (or all the remaining seats to that side if there are fewer than K) remain empty.
    There are currently M diners seated at the table, the Ith of whom is in seat Si.
    No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
    Determine the maximum number of additional diners who can potentially sit at the table without social
     distancing guidelines being violated for any new or existing diners, assuming that the existing diners
     can not move and that the additional diners will cooperate to maximize how many of them can sit down.
    Please take care to write a solution which runs within the time limit.
    Constraints:
        1 ≤ N ≤ 10^15
        1 ≤ K ≤ N
        1 ≤ M ≤ 500, 000
        M ≤ N
        1 ≤ Si ≤ N
    Sample test case #1
        N = 10
        K = 1
        M = 2
        S = [2, 6]
        Expected Return Value = 3
    Sample test case #2
        N = 15
        K = 2
        M = 3
        S = [11, 6, 14]
        Expected Return Value = 1
    Sample Explanation:
    In the first case, the cafeteria table has N=10 seats, with two diners currently at seats 2
     and 6 respectively.
    The table initially looks as follows, with brackets covering the K=1 seat to the left and right of each
     existing diner that may not be taken.
      1 2 3 4 5 6 7 8 9 10
      [   ]   [   ]
    Three additional diners may sit at seats 4, 8, and 10 without violating the social distancing guidelines.
    In the second case, only 1 additional diner is able to join the table, by sitting in any of the
     first 3 seats.)" << endl;
    }

    static long long
    getMaxAdditionalDinersCount(const long long n, const long long k, const int m, vector<long long> &s) {
        assert(1 <= n);
        assert(n <= pow(10, 15));
        assert(1 <= k);
        assert(k <= n);
        assert(1 <= m);
        assert(m <= 5 * pow(10, 5));
        assert(m <= n);
        sort(s.begin(), s.end());
        long long result = 0;
        // left edge
        auto range = s.at(0) - k - 1;
        if (range > 0) {
            result += fromRange(k, range);
        }
        // middle section
        for (long long index = 0; index < s.size() - 1; index++) {
            assert(1 <= s.at(index));
            assert(s.at(index) <= n);
            range = s.at(index + 1) - s.at(index) - 2 * k - 1;
            if (range > 0) {
                result += fromRange(k, range);
            }
        }
        // right edge
        assert(1 <= s.at(s.size() - 1));
        assert(s.at(s.size() - 1) <= n);
        range = n - s.at(s.size() - 1) - k;
        if (range > 0) {
            result += fromRange(k, range);
        }
        return result;
    }

private:
    static long long fromRange(const long long k, long long range) {
        long long result = 0;
        if (range > 0) {
            result++;
            range--;
            result += floor(range / (k + 1));
        }
        return result;
    }
};

#pragma clang diagnostic pop