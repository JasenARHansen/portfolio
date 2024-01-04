#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class AddBinary {
public:
    static void description() {
        cout << R"(67: Add Binary
    Given two binary strings a and b, return their sum as a binary string.
    Example 1:
        Input: a = "11", b = "1"
        Output: "100"
    Example 2:
        Input: a = "1010", b = "1011"
        Output: "10101"
    Constraints:
        1 ≤ a.length, b.length ≤ 10^4
        a and b consist only of '0' or '1' characters.
        Each string does not contain leading zeros except for the zero itself.)" << endl;
    }

    static string addBinary(const string &a, const string &b) {
        assert (!a.empty());
        assert (a.size() <= pow(10, 4));
        assert (!b.empty());
        assert (b.size() <= pow(10, 4));
        string result;
        int indexA = (int) a.size() - 1;
        int indexB = (int) b.size() - 1;
        auto carry = 0;
        int current;
        while ((indexA >= 0) & (indexB >= 0)) {
            current = carry + a.at(indexA--) + b.at(indexB--) - 2 * '0';
            carry = 0;
            if (current > 1) {
                carry = 1;
                current -= 2;
            }
            result.insert(0, to_string(current));
        }
        if (a.size() > b.size()) {
            while (indexA >= 0) {
                current = carry + a.at(indexA--) - '0';
                carry = 0;
                if (current > 1) {
                    carry = 1;
                    current -= 2;
                }
                result.insert(0, to_string(current));
            }
        } else if (a.size() < b.size()) {
            while (indexB >= 0) {
                current = carry + b.at(indexB--) - '0';
                carry = 0;
                if (current > 1) {
                    carry = 1;
                    current -= 2;
                }
                result.insert(0, to_string(current));
            }
        }
        if (carry) {
            result.insert(0, "1");
        }
        return result;
    }
};

#pragma clang diagnostic pop