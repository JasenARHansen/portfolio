#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <unordered_map>
#include <cmath>

using namespace std;

class ValidAnagram {
public:

    static void description() {
        cout << R"(242. Valid Anagram
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false

    Constraints:
        1 <= s.length, t.length <= 5 * 10^4
        s and t consist of lowercase English letters.

    Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?)"
             << endl;
    }

    static bool isAnagram(const string &s, const string &t) {
        assert (!s.empty());
        assert (s.size() <= 5 * pow(10, 4));
        assert (!t.empty());
        assert (t.size() <= 5 * pow(10, 4));
        if (s.size() != t.size()) {
            return false;
        }
        unordered_map<char, int> s_map;
        for (char index: s) {
            if (!s_map.count(index)) {
                s_map[index] = 0;
            }
            s_map.at(index)++;
        }
        unordered_map<char, int> t_map;
        for (char index: t) {
            if (!t_map.count(index)) {
                t_map[index] = 0;
            }
            t_map.at(index)++;
        }
        if (s_map.size() != t_map.size()) {
            return false;
        }
        for (const auto &myPair: s_map) {
            if (!t_map.count(myPair.first)) {
                return false;
            }
            if (s_map.at(myPair.first) != t_map.at(myPair.first)) {
                return false;
            }
        }
        return true;
    }
};

#pragma clang diagnostic pop