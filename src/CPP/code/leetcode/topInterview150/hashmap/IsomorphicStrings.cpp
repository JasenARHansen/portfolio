#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <unordered_map>
#include <bitset>
#include <set>

using namespace std;

class IsomorphicStrings {
public:

    static void description() {
        cout << R"(205. Isomorphic Strings
    Given two strings s and t, determine if they are isomorphic.
    Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
    
    Example 1:
        Input: s = "egg", t = "add"
        Output: true
    
    Example 2:
        Input: s = "foo", t = "bar"
        Output: false
    
    Example 3:
        Input: s = "paper", t = "title"
        Output: true
    
    Constraints:
        1 <= s.length <= 5 * 10^4
        t.length == s.length
        s and t consist of any valid ascii character.)" << endl;
    }

    static bool isIsomorphic(string s, string t) {
        // This version does not force a change so "a" would be Isomorphic to "a"
        assert (!s.empty());
        assert (s.size() <= 5 * pow(10, 4));
        assert (!t.empty());
        assert (t.size() <= 5 * pow(10, 4));
        // Process the s string
        unordered_map<char, char> translation_map;
        unordered_map<char, char> translation_reverse_map;
        for (int index = 0; index < s.size(); index++) {
            if ((!translation_map.count(s.at(index))) && (!translation_reverse_map.count(t.at(index)))) {
                translation_map[s.at(index)] = t.at(index);
                translation_reverse_map[t.at(index)] = s.at(index);
            } else if ((!translation_map.count(s.at(index))) || (!translation_reverse_map.count(t.at(index)))) {
                return false;
            }
            if ((translation_map.at(s.at(index)) != t.at(index)) ||
                (translation_reverse_map.at(t.at(index)) != s.at(index))) {
                return false;
            }
        }
        return true;
    }
};

#pragma clang diagnostic pop