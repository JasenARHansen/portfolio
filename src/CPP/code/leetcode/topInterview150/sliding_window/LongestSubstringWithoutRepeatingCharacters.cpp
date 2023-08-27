#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <bitset>
#include <cmath>

using namespace std;

class LongestSubstringWithoutRepeatingCharacters {
public:

    static void description() {
        cout << R"(3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

    Example 1:
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.

    Example 2:
        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.

    Example 3:
        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    Constraints:
        0 <= s.length <= 5 * 10^4
        s consists of English letters, digits, symbols and spaces.)" << endl;
    }

    static int lengthOfLongestSubstring(string s) {
        assert (s.size() <= 5 * pow(10, 4));
        int index1 = 0;
        int index2 = 0;
        bitset<256> characters;
        int detected = 0;
        if (s.empty()) {
            return detected;
        }
        char lastChar;
        // expand window to find a potential value
        while (index2 < s.size()) {
            while ((index2 < s.size()) && !characters.test(s.at(index2))) {
                characters.flip(s.at(index2));
                index2++;
                detected = max(detected, (index2 - index1));
            }
            if (index2 >= s.size()) {
                return detected;
            }
            lastChar = s.at(index2);
            // contract the window
            while ((index1 < index2) && characters.test(lastChar)) {
                characters.flip(s.at(index1));
                index1++;
            }
        }
        return detected;
    }
};

#pragma clang diagnostic pop