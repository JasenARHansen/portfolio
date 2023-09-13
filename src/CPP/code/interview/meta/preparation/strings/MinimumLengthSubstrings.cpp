#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <unordered_map>

using namespace std;

class MinimumLengthSubstrings {
public:
    static void description() {
        cout << R"(Minimum Length Substrings
    You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring. Determine the minimum length of the substring of s such that string t is a substring of the selected substring.

    Signature
        int minLengthSubstring(String s, String t)

    Input
        s and t are non-empty strings that contain less than 1,000,000 characters each

    Output
        Return the minimum length of the substring of s. If it is not possible, return -1

    Example
        s = "dcbefebce"
        t = "fd"
        output = 5
        Explanation:
            Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the minimum length required is 5.)"
             << endl;
    }

    static int minLengthSubstring(const string &s, const string &t) {
        assert(!s.empty());
        assert(s.size() <= pow(10, 6));
        assert(!t.empty());
        assert(t.size() <= pow(10, 6));
        auto result = INT_MAX;
        if (s.size() < t.size()) {
            result = -1;
        } else {
            // process t to identify required characters
            unordered_map<char, int> sMap;
            unordered_map<char, int> tMap;
            for (auto character: t) {
                if (!tMap.count(character)) {
                    tMap[character] = 0;
                }
                tMap[character]++;
            }
            // Iterate over s until first character is found
            auto index = 0;
            while ((index < s.size()) && (!tMap.count(s.at(index)))) {
                index++;
            }
            auto endIndex = index;
            if (index == s.size()) {
                // no possible substring
                result = -1;
            } else {
                while ((index < s.size()) && (endIndex < s.size())) {
                    // The index is at a required character, advance the endIndex until either the
                    // string is finished or the required characters are in substring.
                    while ((endIndex < s.size()) && !compareMaps(sMap, tMap)) {
                        if (!sMap.count(s.at(endIndex))) {
                            sMap[s.at(endIndex)] = 0;
                        }
                        sMap.at(s.at(endIndex))++;
                        endIndex++;
                    }
                    // All characters found.  If the substring is shorter than previous,update result
                    if ((endIndex < s.size()) && ((endIndex - index) < result)) {
                        result = endIndex - index;
                    }
                    // Advance index while compareMaps passes and update result if necessary
                    while (compareMaps(sMap, tMap)) {
                        result = endIndex - index;
                        sMap.at(s.at(index))--;
                        index++;
                    }
                    // Advance index until a required character
                    while ((index < s.size()) && (!tMap.count(s.at(index)))) {
                        index++;
                    }
                    // in index >= endIndex, update endIndex
                    if (index >= endIndex) {
                        endIndex = index + 1;
                    }
                }
            }
        }
        if (result == INT_MAX) {
            result = -1;
        }
        return result;
    }

private:
    static bool compareMaps(const unordered_map<char, int> &sMap, const unordered_map<char, int> &tMap) {
        bool result = true;
        for (auto key: tMap) {
            if ((!sMap.count(key.first)) || (sMap.at(key.first) < key.second)) {
                result = false;
                break;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop