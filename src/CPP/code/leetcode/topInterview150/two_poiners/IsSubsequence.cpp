#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class IsSubsequence {

public:

    static void description() {
        cout << R"(392. Is Subsequence
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

    Example 1:
        Input: s = "abc", t = "ahbgdc"
        Output: true

    Example 2:
        Input: s = "axc", t = "ahbgdc"
        Output: false

    Constraints:
        0 <= s.length <= 100
        0 <= t.length <= 10^4
        s and t consist only of lowercase English letters.)" << endl;
    }

    static bool isSubsequence(const string &s, const string &t) {
        assert (s.size() <= 100);
        assert (t.size() <= pow(10, 4));
        auto tIndex = 0;
        auto find = s.size();
        for (char sIndex: s) {
            while (tIndex < t.size()) {
                if (sIndex == t.at(tIndex++)) {
                    find--;
                    break;
                }
            }
        }
        return find == 0;
    }
};

#pragma clang diagnostic pop