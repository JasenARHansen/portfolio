#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class GenerateParentheses {

public:

    static void description() {
        cout << R"(22. Generate Parentheses
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    Example 1:
        Input: n = 3
        Output: ['((()))','(()())','(())()','()(())','()()()']

    Example 2:
        Input: n = 1
        Output: ['()']

    Constraints:
        1 <= n <= 8)" << endl;
    }

    static vector<string> generateParenthesis(int n) {
        assert(1 <= n);
        assert(n <= 8);
        vector<string> result{};
        auto openParenthesis = n;
        auto closedParenthesis = n;
        auto base = "";
        generateParenthesis(base, openParenthesis, closedParenthesis, result);
        return result;
    }


private:
    static void
    generateParenthesis(const string &base, int openParenthesis, int closedParenthesis, vector<string> &result) {
        // if there are no open or closed parenthesis, add string to result
        if ((openParenthesis == 0) && (closedParenthesis == 0)) {
            result.push_back(base);
        }
        // if  there are still open parenthesis
        if (openParenthesis > 0) {
            generateParenthesis(base + "(", openParenthesis - 1, closedParenthesis, result);
        }
        // if there are more closed parenthesis than open parenthesis
        if (openParenthesis < closedParenthesis) {
            generateParenthesis(base + ")", openParenthesis, closedParenthesis - 1, result);
        }
    }

};

#pragma clang diagnostic pop