#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class ZigzagConversion {

public:

    static void description() {
        cout << R"(6. Zigzag Conversion
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:
    string convert(string s, int numRows);

    Example 1:
        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"

    Example 2:
        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
        Explanation:
            P     I    N
            A   L S  I G
            Y A   H R
            P     I

    Example 3:
        Input: s = "A", numRows = 1
        Output: "A"

    Constraints:
        1 <= s.length <= 1000
        s consists of English letters (lower-case and upper-case), ',' and '.'.
        1 <= numRows <= 1000)" << endl;
    }

    static string convert(const string &s, int numRows) {
        assert (!s.empty());
        assert (s.size() <= 1000);
        assert (0 < numRows);
        assert (numRows <= 1000);
        string result;
        vector<string> data(numRows, "");
        bool down = true;
        int target = 0;
        for (char index: s) {
            data[target].push_back(index);
            if (down) {
                target++;
                if (target >= numRows) {
                    down = false;
                    if (numRows > 1) {
                        target -= 2;
                    } else {
                        target = 0;
                    }
                }
            } else {
                target--;
                if (target < 0) {
                    down = true;
                    if (numRows > 1) {
                        target += 2;
                    } else {
                        target = 0;
                    }
                }
            }
        }
        for (const string &value: data) {
            result.append(value);
        }
        return result;
    }
};

#pragma clang diagnostic pop