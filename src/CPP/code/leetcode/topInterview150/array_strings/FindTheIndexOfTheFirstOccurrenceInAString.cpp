#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class FindTheIndexOfTheFirstOccurrenceInAString {

public:

    static void description() {
        cout << R"(28. Find the Index of the First Occurrence in a String
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:
        Input: haystack = "sadbutsad", needle = "sad"
        Output: 0
        Explanation:
            "sad" occurs at index 0 and 6.
            The first occurrence is at index 0, so we return 0.

    Example 2:
        Input: haystack = "leetcode", needle = "leeto"
        Output: -1
        Explanation:
            "leeto" did not occur in "leetcode", so we return -1.

    Constraints:
        1 <= haystack.length, needle.length <= 10^4
        haystack and needle consist of only lowercase English characters.)" << endl;
    }

    static int strStr(const string &haystack, const string &needle) {
        assert (!haystack.empty());
        assert (haystack.size() <= pow(10, 4));
        assert (!needle.empty());
        assert (needle.size() <= pow(10, 4));
        int result = -1;
        if (haystack.size() < needle.size()) {
            return result;
        }
        for (int index = 0; index <= haystack.size() - needle.size(); index++) {
            string foo = haystack.substr(index, needle.size());
            if (needle == haystack.substr(index, needle.size())) {
                result = index;
                break;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop