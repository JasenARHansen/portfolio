#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class EvaluateDivision {

public:

    static void description() {
        cout << R"(399. Evaluate Division
    You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
    You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
    Return the answers to all queries. If a single answer cannot be determined, return -1.0.
    Note:
        The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
    Note:
        The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.

    Example 1:
        Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
        Explanation:
            Given: a / b = 2.0, b / c = 3.0
            queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
            return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
            note: x is undefined => -1.0

    Example 2:
        Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
        Output: [3.75000,0.40000,5.00000,0.20000]

    Example 3:
        Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
        Output: [0.50000,2.00000,-1.00000,-1.00000]


    Constraints:
        1 <= equations.length <= 20
        equations[i].length == 2
        1 <= Ai.length, Bi.length <= 5
        values.length == equations.length
        0.0 < values[i] <= 20.0
        1 <= queries.length <= 20
        queries[i].length == 2
        1 <= Cj.length, Dj.length <= 5
        Ai, Bi, Cj, Dj consist of lower case English letters and digits.)" << endl;
    }

    static vector<double>
    calcEquation(vector<vector<string>> &equations, vector<double> &values, vector<vector<string>> &queries) {
        vector<double> result;
        unordered_map<string, vector<pair<string, double>>> variables;
        for (auto index = 0; index < equations.size(); index++) {
            // generate first variable
            auto variable = equations[index][0];
            if (!variables.count(variable)) {
                variables[variable] = vector<pair<string, double>>{};
            }
            variables[variable].emplace_back(equations[index][1], values[index]);
            // generate second variable
            variable = equations[index][1];
            if (!variables.count(variable)) {
                variables[variable] = vector<pair<string, double>>{};
            }
            variables[variable].emplace_back(equations[index][0], 1 / values[index]);
        }
        for (auto query: queries) {
            bool valid = true;
            // verify that all variables are defined at least 1 time
            for (const auto &variable: query) {
                if (!variables.count(variable)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                // if the 2 variables are equal X/X is 1  (except when X = 0)
                if (query[0] == query[1]) {
                    result.push_back(1);
                } else {
                    // find if valid substitutions exist, if not than invalid
                    result.push_back(findIntersection(variables, query[0], query[1]));
                }
            } else {
                // One or more of the variables are not defined so not valid
                result.push_back(-1);
            }
        }
        return result;
    }

private:

    static double
    findIntersection(unordered_map<string, vector<pair<string, double>>> &variables, const string &left,
                     const string &right) {
        // case 1: looking for overlap of 2 variables
        for (const auto &lValue: variables.at(left)) {
            for (const auto &rValue: variables.at(right)) {
                if (lValue.first == rValue.first) {
                    if (rValue.second == 0) {
                        return -1;
                    }
                    return lValue.second / rValue.second;
                }
            }
        }
        // Case 2: left is found in the set of right
        for (const auto &rightVariable: variables.at(right)) {
            if (left == rightVariable.first) {
                if (rightVariable.second == 0) {
                    return -1;
                }
                return 1 / rightVariable.second;
            }
        }
        // Case 3: right is found on the set of left
        for (const auto &leftVariable: variables.at(left)) {
            if (right == leftVariable.first) {
                return leftVariable.second;
            }
        }
        return -1;
    }

};

#pragma clang diagnostic pop