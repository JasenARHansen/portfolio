#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <unordered_set>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

class HappyNumber {
public:

    static void description() {
        cout << R"(202. Happy Number
    Write an algorithm to determine if a number n is happy.
    A happy number is a number defined by the following process:
        Starting with any positive integer, replace the number by the sum of the squares of its digits.
        Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
        Those numbers for which this process ends in 1 are happy.
    Return true if n is a happy number, and false if not.

    Example 1:
        Input: n = 19
        Output: true
        Explanation:
            1^2 + 9^2 = 82
            8^2 + 2^2 = 68
            6^2 + 8^2 = 100
            1^2 + 0^2 + 0^2 = 1

    Example 2:
        Input: n = 2
        Output: false

    Constraints:
        1 <= n <= 2^31 - 1)" << endl;
    }

    static bool isHappy(int n) {
        assert (1 <= n);
        unordered_set<int> used;
        vector<int> digits;
        while ((1 < n) && !used.count(n)) {
            used.insert(n);
            digits.clear();
            while (n > 0) {
                digits.push_back(n % 10);
                n /= 10;
            }
            for (const auto &value: digits) {
                n += pow(value, 2);
            }
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
};

#pragma clang diagnostic pop