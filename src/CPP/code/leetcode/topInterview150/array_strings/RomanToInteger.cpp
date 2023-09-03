#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <algorithm>
#include <unordered_set>

using namespace std;

class RomanToInteger {

public:

    static void description() {
        cout << R"(13. Roman to Integer
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
    For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:
        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.

    Example 1:
        Input: s = "III"
        Output: 3
        Explanation:
            III = 3.

    Example 2:
        Input: s = "LVIII"
        Output: 58
        Explanation:
            L = 50, V= 5, III = 3.

    Example 3:
        Input: s = "MCMXCIV"
        Output: 1994
        Explanation:
            M = 1000, CM = 900, XC = 90 and IV = 4.

    Constraints:
        1 <= s.length <= 15
        s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
        It is guaranteed that s is a valid roman numeral in the range [1, 3999].)" << endl;
    }

    static int romanToInt(string s) {
        assert (!s.empty());
        assert (s.size() <= 15);
        transform(s.begin(), s.end(), s.begin(), ::toupper);
        int total = 0;
        int index = 0;
        for (; index < s.size() - 1; index++) {
            char leftCharacter = toupper(s.at(index));
            int leftValue = getValue(leftCharacter);
            char rightCharacter = toupper(s.at(index + 1));
            int rightValue = getValue(rightCharacter);
            if (leftValue < rightValue) {
                total += rightValue - leftValue;
                index++;
            } else {
                total += leftValue;
            }
        }
        if (index <= s.size() - 1) {
            char lastCharacter = toupper(s.at(index));
            int lastValue = getValue(lastCharacter);
            total += lastValue;
        }
        assert (0 < total);
        assert (total <= 3999);
        return total;
    }

private:

    static int getValue(char input) {
        unordered_set<char> valid{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        char data = toupper(input);
        assert (valid.find(data) != valid.end());
        int value;
        switch (data) {
            case 'I':

                value = 1;
                break;
            case 'V':

                value = 5;
                break;
            case 'X':

                value = 10;
                break;
            case 'L':

                value = 50;
                break;
            case 'C':

                value = 100;
                break;
            case 'D':

                value = 500;
                break;
            case 'M':

                value = 1000;
                break;
            default:

                value = 0;
        }

        return value;
    }

};

#pragma clang diagnostic pop