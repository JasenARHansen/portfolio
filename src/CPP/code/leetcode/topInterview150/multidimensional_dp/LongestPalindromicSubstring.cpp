#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <map>

using namespace std;

class LongestPalindromicSubstring {

public:

    static void description() {
        cout << R"(5. Longest Palindromic Substring
    Given a string s, return the longest palindromic substring in s.

    Example 1:
        Input: s = "babad"
        Output: "bab"
        Explanation:
            "aba" is also a valid answer.

    Example 2:
        Input: s = "cbbd"
        Output: "bb"

    Constraints:
        1 <= s.length <= 1000
        s consist of only digits and English letters.)" << endl;
    }

    static string longestPalindrome(const string &s) {
        assert (!s.empty());
        assert (s.size() <= 1000);
        map<string, string> wordMap;
        string longest;
        return longestPalindrome(s, 0, s.size(), wordMap, longest);
    }

private:

    static bool isPalindrome(string s) {
        bool result = true;
        int left = 0;
        int right = s.size() - 1;
        while (left < right) {
            if (s[left] != s[right]) {
                result = false;
                break;
            }
            left++;
            right--;
        }
        return result;
    }

    static string
    longestPalindrome(const string &s, int index, int length, map<string, string> &wordMap, string &longest) {
        string key = s + "-" + to_string(index) + "-" + to_string(length);
        if (!wordMap.count(key)) {
            if (length >= longest.size()) {
                string word = s.substr(index, length);
                if (word.size() == 1) {
                    wordMap[key] = word;
                } else if (isPalindrome(word)) {
                    wordMap[key] = word;
                } else {
                    string left = longestPalindrome(word, 0, word.size() - 1, wordMap, longest);
                    string right = longestPalindrome(word, 1, word.size() - 1, wordMap, longest);
                    if (left.size() >= right.size()) {
                        wordMap[key] = left;
                    } else {
                        wordMap[key] = right;
                    }
                }
                if (wordMap[key].size() > longest.size()) {
                    longest = wordMap[key];
                }
            }
        }
        return wordMap[key];
    }
};

#pragma clang diagnostic pop