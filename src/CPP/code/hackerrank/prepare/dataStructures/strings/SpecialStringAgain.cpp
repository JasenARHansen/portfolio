#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>

using namespace std;

class SpecialStringAgain {
public:
    static void description() {
        cout << R"(Strings: Special String Again:
    A string is said to be a special string if either of two conditions is met:
        All of the characters are the same, e.g. aaa.
        All characters except the middle one are the same, e.g. aadaa.
    A special substring is any substring of a string which meets one of those criteria.
    Given a string, determine how many special substrings can be formed from it.
    Example:
        s = mnonopoo contains the following special substrings: { m, n, o, n, p, o, o, non, ono, opo, oo }.
    Function Description:
        Complete the substrCount function in the editor below:
            substrCount has the following parameter(s):
            int n: the length of string s
            string s: a string
        Returns:
            long: the number of special substrings
    Input Format:
        The first line contains an integer, n, the length of s.
        The second line contains the string s.
    Constraints:
        1 ≤ n ≤ 10^6
        Each character of the string is a lowercase English letter, acsii[a-z].
    Sample Input 0:
        5
        asasd
    Sample Output 0:
        7
    Explanation 0:
        The special palindromic substrings of s = asasd are { a, s, a, s, d, asa, sas }
    Sample Input 1:
        7
        abcbaba
    Sample Output 1:
        10
    Explanation 1:
        The special palindromic substrings of s = abcbaba are { a, b, c, b, a, b, a, bcb, bab, aba }
    Sample Input 2:
        4
        aaaa
    Sample Output 2:
        10
    Explanation 2:
        The special palindromic substrings of s = aaaa are { a, a, a, a, aa, aa, aa, aaa, aaa, aaaa })" << endl;
    }

    static long substrCount(int n, const string &s) {
        long result = 0;
        char main;
        int count;
        bool valid;
        for (auto index = 0; index < n; index++) {
            result++;
            main = s[index];
            count = 1;
            for (auto left = index + 1; left < n; left++) {
                if (main == s[left]) {
                    result++;
                    count++;
                } else {
                    if ((left + count) < n) {
                        valid = true;
                        for (auto right = left + 1; right <= left + count; right++) {
                            if (main != s[right]) {
                                valid = false;
                                break;
                            }
                        }
                        if (valid) {
                            result++;
                        }
                    }
                    break;
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop