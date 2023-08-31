#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class EvaluateReversePolishNotation {

public:

    static void description() {
        cout << R"(150. Evaluate Reverse Polish Notation
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
    Evaluate the expression. Return an integer that represents the value of the expression.
    Note that:
        The valid operators are '+', '-', '*', and '/'.
        Each operand may be an integer or another expression.
        The division between two integers always truncates toward zero.
        There will not be any division by zero.
        The input represents a valid arithmetic expression in a reverse polish notation.
        The answer and all the intermediate calculations can be represented in a 32-bit integer.

    Example 1:
        Input: tokens = ["2","1","+","3","*"]
        Output: 9
        Explanation: ((2 + 1) * 3) = 9

    Example 2:
        Input: tokens = ["4","13","5","/","+"]
        Output: 6
        Explanation: (4 + (13 / 5)) = 6

    Example 3:
        Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        Output: 22
        Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
            = ((10 * (6 / (12 * -11))) + 17) + 5
            = ((10 * (6 / -132)) + 17) + 5
            = ((10 * 0) + 17) + 5
            = (0 + 17) + 5
            = 17 + 5
            = 22

    Constraints:
        1 <= tokens.length <= 10^4
        tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].)" << endl;
    }

    static int evalRPN(const vector<string> &tokens) {
        assert(!tokens.empty());
        assert(tokens.size() <= pow(10, 4));
        if (1 == tokens.size()) {
            assert(isValidNumber(tokens[0]));
            return stoi(tokens[0]);
        }
        int result;
        stack<int> valueStack;
        for (auto token: tokens) {
            if ((token == "+") || (token == "-") || (token == "*") || (token == "/")) {
                int lVal;
                int rVal;
                switch (token.at(0)) {
                    case '+':
                        rVal = valueStack.top();
                        valueStack.pop();
                        lVal = valueStack.top();
                        valueStack.pop();
                        result = lVal + rVal;
                        valueStack.push(result);
                        break;
                    case '-':
                        rVal = valueStack.top();
                        valueStack.pop();
                        lVal = valueStack.top();
                        valueStack.pop();
                        result = lVal - rVal;
                        valueStack.push(result);
                        break;
                    case '*':
                        rVal = valueStack.top();
                        valueStack.pop();
                        lVal = valueStack.top();
                        valueStack.pop();
                        result = lVal * rVal;
                        valueStack.push(result);
                        break;
                    case '/':
                        rVal = valueStack.top();
                        valueStack.pop();
                        lVal = valueStack.top();
                        valueStack.pop();
                        result = lVal / rVal;
                        valueStack.push(result);
                        break;
                }
            } else {
                assert(isValidNumber(token));
                valueStack.push(stoi(token));
            }
        }
        return result;
    }

private:

    static bool isValidNumber(const string &token) {
        int index = 0;
        if ((token.at(0) == '+') || (token.at(0) == '-')) {
            index++;
        }
        for (; index < token.size(); index++) {
            if (!isdigit(token.at(index))) {
                return false;
            }
        }
        int number = stoi(token);
        assert(-200 <= number);
        assert(number <= 200);
        return true;
    }
};

#pragma clang diagnostic pop