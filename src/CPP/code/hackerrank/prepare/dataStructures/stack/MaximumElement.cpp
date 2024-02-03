#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <stack>
#include <sstream>

using namespace std;

class MaximumElement {
public:
    static void description() {
        cout << R"(Stacks: Maximum Element
    You have an empty sequence, and you will be given N queries.
    Each query is one of these three types:
        1 x : Push the element x into the stack.
        2   : Delete the element present at the top of the stack.
        3   : Print the maximum element in the stack.
    Function Description:
        Complete the getMax function in the editor below.
        getMax has the following parameters:
            string operations[n]: operations as strings
        Returns:
            int[]: the answers to each type 3 query
    Input Format:
        The first line of input contains an integer, n.
        The next n lines each contain an above mentioned query.
    Constraints:
        1 ≤ n ≤ 10^5
        1 ≤ x ≤ 10^9
        1 ≤ type ≤ 3
        All queries are valid.
    Sample Input:
        STDIN   Function
        -----   --------
        10      operations[] size n = 10
        1 97    operations = ['1 97', '2', '1 20', ....]
        2
        1 20
        2
        1 26
        1 20
        2
        3
        1 91
        3
    Sample Output:
        26
        91)" << endl;
    }

    static vector<int> getMax(const vector<string> &operations) {
        vector<int> result;
        stack<pair<int, int>> data;
        for (const auto &operation: operations) {
            vector<int> op;
            string line;
            stringstream ss(operation);
            while (getline(ss, line, ' ')) {
                op.push_back(stoi(line));
            }
            switch (op.at(0)) {
                case 1:
                    // Push the element x into the stack.
                    if (data.empty()) {
                        data.emplace(op.at(1), op.at(1));
                    } else {
                        if (data.top().first > op.at(1)) {
                            data.emplace(data.top().first, op.at(1));
                        } else {
                            data.emplace(op.at(1), op.at(1));
                        }
                    }
                    break;
                case 2:
                    // Delete the element present at the top of the stack.
                    if (!data.empty()) {
                        data.pop();
                    }
                    break;
                case 3:
                    // Print the maximum element in the stack.
                    if (!data.empty()) {
                        result.push_back(data.top().first);
                    }
                    break;
                default:
                    break;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop