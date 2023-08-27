#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <unordered_map>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

class GroupAnagrams {
public:

    static void description() {
        cout << R"(49. Group Anagrams
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Example 1:
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    Example 2:
        Input: strs = [""]
        Output: [[""]]

    Example 3:
        Input: strs = ["a"]
        Output: [["a"]]

    Constraints:
        1 <= strs.length <= 10^4
        0 <= strs[i].length <= 100
        strs[i] consists of lowercase English letters.)" << endl;
    }

    static vector<vector<string>> groupAnagrams(vector<string> &strs) {
        assert (!strs.empty());
        assert (strs.size() <= pow(10, 4));
        vector<vector<string>> result;
        unordered_map<string, vector<string>> s_map;
        string local;
        for (const auto &str: strs) {
            assert(str.size() <= 100);
            local = str;
            sort(local.begin(), local.end());
            if (!s_map.count(local)) {
                s_map[local] = vector<string>();
            }
            s_map.at(local).push_back(str);
        }
        for (auto &myPair: s_map) {
            sort(myPair.second.begin(), myPair.second.end(), [](string &a, string &b) { return a < b; });
            result.push_back(myPair.second);
        }
        sort(result.begin(), result.end(),
             [](vector<string> &a, vector<string> &b) { return a.size() < b.size(); });

        return result;
    }
};

#pragma clang diagnostic pop