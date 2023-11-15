#pragma clang diagnostic push
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
    Given an array of strings strings, group the anagrams together. You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Example 1:
        Input: strings = ["eat", "tea", "tan", "ate", "nat", "bat"]
        Output: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

    Example 2:
        Input: strings = [""]
        Output: [[""]]

    Example 3:
        Input: strings = ["a"]
        Output: [["a"]]

    Constraints:
        1 ≤ strings.length ≤ 10^4
        0 ≤ strings[i].length ≤ 100
        strings[i] consists of lowercase English letters.)" << endl;
    }

    static vector<vector<string>> groupAnagrams(vector<string> &strings) {
        assert (!strings.empty());
        assert (strings.size() <= pow(10, 4));
        vector<vector<string>> result;
        unordered_map<string, vector<string>> s_map;
        string local;
        for (const auto &str: strings) {
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