#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class ReverseWordsInAString {
public:
    static void description() {
        cout << R"(151: Reverse Words in a String
    Given an input string s, reverse the order of the words.
    A word is defined as a sequence of non-space characters.
    The words in s will be separated by at least one space.
    Return a string of the words in reverse order concatenated by a single space.
    Note that s may contain leading or trailing spaces or multiple spaces between two words.
    The returned string should only have a single space separating the words.
    Do not include any extra spaces.
    Example 1:
        Input: s = "the sky is blue"
        Output: "blue is sky the"
    Example 2:
        Input: s = "  hello world  "
        Output: "world hello"
        Explanation:
            Your reversed string should not contain leading or trailing spaces.
    Example 3:
        Input: s = "a good   example"
        Output: "example good a"
        Explanation:
            You need to reduce multiple spaces between two words to a single space in the reversed string.
    Constraints:
        1 ≤ s.length ≤ 10^4
        s contains English letters (upper-case and lower-case), digits, and spaces ' '.
        There is at least one word in s.)" << endl;
    }

    static string reverseWords(const string &s) {
        assert (!s.empty());
        assert (s.size() <= pow(10, 4));
        string result;
        bool first = true;
        int index = (int) s.size() - 1;
        while (true) {
            int right = index;
            while ((0 <= right) && (isspace(s.at(right)))) {
                right--;
            }
            if (right < 0) {
                break;
            }
            int left = right;
            while ((0 <= left) && (!isspace(s.at(left)))) {
                left--;
            }
            if (first) {
                first = false;
            } else {
                result.append(" ");
            }
            string foo = s.substr(left + 1, right - left);
            result.append(s.substr(left + 1, right - left));
            index = left;
        }
        return result;
    }
};

#pragma clang diagnostic pop