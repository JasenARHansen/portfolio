#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <unordered_map>

using namespace std;

class RansomNote {
public:
    static void description() {
        cout << R"(383: Ransom Note
    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the
     letters from magazine and false otherwise.
    Each letter in magazine can only be used once in ransomNote.
    Example 1:
        Input: ransomNote = "a", magazine = "b"
        Output: false
    Example 2:
        Input: ransomNote = "aa", magazine = "ab"
        Output: false
    Example 3:
        Input: ransomNote = "aa", magazine = "aab"
        Output: true
    Constraints:
        1 ≤ ransomNote.length, magazine.length ≤ 10^5
        ransomNote and magazine consist of lowercase English letters.)" << endl;
    }

    static bool canConstruct(const string &ransomNote, const string &magazine) {
        assert (!ransomNote.empty());
        assert (ransomNote.size() <= pow(10, 5));
        assert (!magazine.empty());
        assert (magazine.size() <= pow(10, 5));
        unordered_map<char, int> test_map;
        for (auto c: magazine) {
            if (!test_map.count(c)) {
                test_map[c] = 0;
            }
            test_map.at(c)++;
        }
        for (auto c: ransomNote) {
            if ((!test_map.count(c)) || (test_map.at(c) == 0)) {
                return false;
            }
            test_map.at(c)--;
        }
        return true;
    }
};

#pragma clang diagnostic pop