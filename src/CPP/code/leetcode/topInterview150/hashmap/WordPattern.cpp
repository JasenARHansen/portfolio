#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <unordered_map>
#include <unordered_set>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

class WordPattern {

public:

    static void description() {
        cout << R"(290. Word Pattern
    Given a pattern and a string s, find if s follows the same pattern.
    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

    Example 1:
        Input: pattern = "abba", s = "dog cat cat dog"
        Output: true

    Example 2:
        Input: pattern = "abba", s = "dog cat cat fish"
        Output: false

    Example 3:
        Input: pattern = "aaaa", s = "dog cat cat dog"
        Output: false

    Constraints:
        1 ≤ pattern.length ≤ 300
        pattern contains only lower-case English letters.
        1 ≤ s.length ≤ 3000
        s contains only lowercase English letters and spaces ' '.
        s does not contain any leading or trailing spaces.
        All the words in s are separated by a single space.)" << endl;
    }

    static bool wordPattern(const string &pattern, const string &s) {
        assert (!pattern.empty());
        assert (pattern.size() <= 300);
        assert (!s.empty());
        assert (s.size() <= 3000);
        stringstream ss(s);
        istream_iterator<string> begin(ss);
        istream_iterator<string> end;
        vector<string> words(begin, end);
        if (pattern.size() != words.size()) {
            return false;
        }
        unordered_map<char, string> test_map;
        unordered_set<string> used;
        for (auto index = 0; index < pattern.size(); index++) {
            if (!test_map.count(pattern.at(index))) {
                if (used.find(words[index]) != used.end()) {
                    return false;
                }
                test_map[pattern.at(index)] = words[index];
                used.insert(words[index]);
            }
            if (test_map.at(pattern.at(index)) != words[index]) {
                return false;
            }
        }
        return true;
    }
};

#pragma clang diagnostic pop