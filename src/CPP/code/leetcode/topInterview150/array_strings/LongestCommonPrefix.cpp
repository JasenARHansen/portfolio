#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class LongestCommonPrefix {

public:

    static void description() {
        cout << R"(14. Longest Common Prefix
    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".

    Example 1:
    Input: strings = ["flower","flow","flight"]
        Output: "fl"

    Example 2:
        Input: strings = ["dog","racecar","car"]
        Output: ""
        Explanation:
            There is no common prefix among the input strings.

    Constraints:
        1 <= strings.length <= 200
        0 <= strings[i].length <= 200
        strings[i] consists of only lowercase English letters.)" << endl;
    }

    static string longestCommonPrefix(vector<string> &strings) {
        assert (!strings.empty());
        assert (strings.size() <= 200);
        string result;
        auto process = true;
        char current;
        auto index = 0;
        while (process) {
            if (index >= strings[0].size()) {
                break;
            }
            current = strings[0].at(index);
            for (const auto &entry: strings) {
                if ((index >= entry.size()) || (current != entry.at(index))) {
                    process = false;
                    break;
                }
            }
            if (process) {
                result += current;
                index++;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop