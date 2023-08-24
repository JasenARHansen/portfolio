#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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
    Input: strs = ["flower","flow","flight"]
        Output: "fl"

    Example 2:
        Input: strs = ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.

    Constraints:
        1 <= strs.length <= 200
        0 <= strs[i].length <= 200
        strs[i] consists of only lowercase English letters.)" << endl;
    }

    static string longestCommonPrefix(vector<string> &strs) {
        assert (!strs.empty());
        assert (strs.size() <= 200);
        string result;
        bool process = true;
        char current;
        int index = 0;
        while (process) {
            if (index >= strs[0].size()) {
                break;
            }
            current = strs[0].at(index);
            for (string entry: strs) {
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