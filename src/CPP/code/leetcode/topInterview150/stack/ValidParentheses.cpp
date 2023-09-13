#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <stack>

using namespace std;

class ValidParentheses {
public:
    static void description() {
        cout << R"(20. Valid Parentheses
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.

    Example 1:
        Input: s = "() "
        Output: true

    Example 2:
        Input: s = "()[]{}"
        Output: true

    Example 3:
        Input: s = "(]"
        Output: false

    Constraints:
        1 ≤ s.length ≤ 10^4
        s consists of parentheses only '()[]{}'.)" << endl;
    }

    static bool isValid(const string &s) {
        assert (!s.empty());
        assert (s.size() <= pow(10, 4));
        stack<char> base;
        for (auto character: s) {
            switch (character) {
                case '(':
                case '[':
                case '{':
                    base.push(character);
                    break;
                case ')':
                    if (base.empty() || (base.top() != '(')) {
                        return false;
                    }
                    base.pop();
                    break;
                case ']':
                    if (base.empty() || (base.top() != '[')) {
                        return false;
                    }
                    base.pop();
                    break;
                case '}':
                    if (base.empty() || (base.top() != '{')) {
                        return false;
                    }
                    base.pop();
                    break;
                default:
                    break;
            }
        }
        return base.empty();
    }
};

#pragma clang diagnostic pop