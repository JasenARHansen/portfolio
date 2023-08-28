#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class LengthOfLastWord {
public:

    static void description() {
        cout << R"(58. Length of Last Word
    Given a string s consisting of words and spaces, return the length of the last word in the string.

    A word is a maximal substring consisting of non-space characters only.

    Example 1:
        Input: s = "Hello World"
        Output: 5
        Explanation: The last word is "World" with length 5.

    Example 2:
        Input: s = "   fly me   to   the moon  "
        Output: 4
        Explanation: The last word is "moon" with length 4.

    Example 3:
        Input: s = "luffy is still joyboy"
        Output: 6
        Explanation: The last word is "joyboy" with length 6.

    Constraints:
        1 <= s.length <= 10^4
        s consists of only English letters and spaces ' '.
        There will be at least one word in s.)" << endl;
    }


    static int lengthOfLastWord(const string &s) {
        assert (!s.empty());
        assert (s.size() <= pow(10, 4));
        int right = s.size() - 1;
        while ((0 <= right) && (isspace(s.at(right)))) {
            right--;
        }
        int left = right;
        while ((0 <= left) && (!isspace(s.at(left)))) {
            left--;
        }
        return right - left;
    }
};

#pragma clang diagnostic pop