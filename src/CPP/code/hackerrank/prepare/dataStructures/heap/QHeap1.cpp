#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <set>
#include <sstream>
#include <stack>

using namespace std;

class QHeap1 {
public:
    static void description() {
        cout << R"(Heaps: QHeap1
    This question is designed to help you get a better understanding of basic heap operations.
    There are 3 types of query:
        "1 v" - Add an element v to the heap.
        "2 v" - Delete the element v from the heap.
        "3" - Print the minimum of all the elements in the heap.
    NOTE: It is guaranteed that the element to be deleted will be there in the heap.
           Also, at any instant, only distinct elements will be in the heap.
    Input Format:
        The first line contains the number of queries, Q.
        Each of the next Q lines contains one of the 3 types of query.
    Constraints:
        1 ≤ Q ≤ 10^5
        -10^6 ≤ v ≤ 10^6
Output Format:
    For each query of type 3, print the minimum value on a single line.
Sample Input:
    STDIN       Function
    -----       --------
    5           Q = 5
    1 4         insert 4
    1 9         insert 9
    3           print minimum
    2 4         delete 4
    3           print minimum
Sample Output:
    4
    9
Explanation:
    After the first 2 queries, the heap contains {4, 9}.
    Printing the minimum gives 4 as the output.
    Then, the 4th query deletes 4 from the heap, and the 5th query gives 9 as the output.)" << endl;
    }

    static vector<int> processQueries(const vector<string> &operations) {
        vector<int> result;
        set<int> minHeap;
        stack<int> swap;
        for (const auto &operation: operations) {
            vector<int> op;
            string line;
            stringstream ss(operation);
            while (getline(ss, line, ' ')) {
                op.push_back(stoi(line));
            }
            switch (op.at(0)) {
                case 1:
                    // "1 v" - Add an element v to the heap.
                    minHeap.insert(op.at(1));
                    break;
                case 2:
                    // "2 v" - Delete the element v from the heap.
                    minHeap.erase(op.at(1));

                    break;
                case 3:
                    // "3" - Print the minimum of all the elements in the heap.
                    if (!minHeap.empty()) {
                        result.push_back(*(minHeap.begin()));
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