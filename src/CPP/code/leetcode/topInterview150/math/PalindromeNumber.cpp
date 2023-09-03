#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class PalindromeNumber {

public:

    static void description() {
        cout << R"(9. Palindrome Number
    Given an integer x, return true if x is a palindrome, and false otherwise.

    Example 1:
        Input: x = 121
        Output: true
        Explanation:
            121 reads as 121 from left to right and from right to left.

    Example 2:
        Input: x = -121
        Output: false
        Explanation:
            From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    Example 3:
        Input: x = 10
        Output: false
        Explanation:
            Reads 01 from right to left. Therefore it is not a palindrome.

    Constraints:
        -2^31 <= x <= 2^31 - 1

    Follow up:
        Could you solve it without converting the integer to a string?)" << endl;
    }

    static bool isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        vector<int> digits;
        while (x > 0) {
            digits.push_back(x % 10);
            x /= 10;
        }
        for (auto index = 0; index < digits.size() / 2; index++) {
            if (digits[index] != digits[digits.size() - index - 1]) {
                return false;
            }
        }
        return true;
    }
};

#pragma clang diagnostic pop