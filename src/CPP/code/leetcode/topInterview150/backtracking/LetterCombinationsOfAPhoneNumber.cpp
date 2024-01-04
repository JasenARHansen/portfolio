#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;
static const unordered_map<char, vector<char>> digitsMap{{'2', vector<char>{'a', 'b', 'c'}},
                                                         {'3', vector<char>{'d', 'e', 'f'}},
                                                         {'4', vector<char>{'g', 'h', 'i'}},
                                                         {'5', vector<char>{'j', 'k', 'l'}},
                                                         {'6', vector<char>{'m', 'n', 'o'}},
                                                         {'7', vector<char>{'p', 'q', 'r', 's'}},
                                                         {'8', vector<char>{'t', 'u', 'v'}},
                                                         {'9', vector<char>{'w', 'x', 'y', 'z'}}};

class LetterCombinationsOfAPhoneNumber {
public:
    static void description() {
        cout << R"(17: Letter Combinations of a Phone Number
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
     the number could represent.
    Return the answer in any order.
    A mapping of digits to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.
    Example 1:
        Input: digits = "23"
        Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    Example 2:
        Input: digits = ""
        Output: []
    Example 3:
        Input: digits = "2"
        Output: ["a", "b", "c"]
    Constraints:
        0 ≤ digits.length ≤ 4
        digits[i] is a digit in the range ['2', '9'].)" << endl;
    }

    static vector<string> letterCombinations(const string &digits) {
        vector<string> result;
        if (!digits.empty()) {
            result.emplace_back("");
            for (char digit: digits) {
                result = permute(digit, result);
            }
        }
        return result;
    }

private:
    static vector<string> permute(char digit, const vector<string> &inputs) {
        vector<string> result;
        for (const auto &input: inputs) {
            for (char letter: digitsMap.at(digit)) {
                result.push_back(input + letter);
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop