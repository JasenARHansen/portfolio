#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <algorithm>
#include <vector>

using namespace std;

class IntegerToRoman {

public:

    static void description() {
        cout << R"(112. Integer to Roman
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000

    For example, 2 is written as II in Roman numeral, just two one"s added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
    Given an integer, convert it to a roman numeral.

    Example 1:
        Input: num = 3
        Output: "III"
        Explanation: 3 is represented as 3 ones.

    Example 2:
        Input: num = 58
        Output: "LVIII"
        Explanation: L = 50, V = 5, III = 3.

    Example 3:
        Input: num = 1994
        Output: "MCMXCIV"
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    Constraints:
        1 <= num <= 3999)" << endl;
    }

    static string intToRoman(int num) {
        assert (1 <= num);
        assert (num <= 3999);
        vector<int> values{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        vector<string> numerals{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        string result;
        int index = numerals.size() - 1;
        int current;
        while (num > 0) {
            current = values[index];
            if (current <= num) {
                num -= current;
                result += numerals[index];
            } else {
                index--;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop