#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <algorithm>

using namespace std;

class ValidPalindrome {
public:
    static void description() {
        cout << R"(125: Valid Palindrome
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
     removing all non-alphanumeric characters, it reads the same forward and backward.
    Alphanumeric characters include letters and numbers.
    Given a string s, return true if it is a palindrome, or false otherwise.
    Example 1:
        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation:
            "amanaplanacanalpanama" is a palindrome.
    Example 2:
        Input: s = "race a car"
        Output: false
        Explanation:
            "raceacar" is not a palindrome.
    Example 3:
        Input: s = " "
        Output: true
        Explanation:
            s is an empty string "" after removing non-alphanumeric characters.
            Since an empty string reads the same forward and backward, it is a palindrome.
    Constraints:
        1 ≤ s.length ≤ 2 * 10^5
        s consists only of printable ASCII characters.)" << endl;
    }

    static bool isPalindrome(string s) {
        assert (!s.empty());
        assert (s.size() <= 2 * pow(10, 5));
        auto result = true;
        s.erase(remove_if(s.begin(), s.end(), [](char c) { return !iswalnum(c); }), s.end());
        for (auto index = 0; index < s.size() / 2; index++) {
            if (tolower(s[index]) != tolower(s[s.size() - index - 1])) {
                result = false;
                break;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop