#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>
#include <map>

using namespace std;

class PrintAverageByLevelTreeNode {
public:
    int val;
    PrintAverageByLevelTreeNode *left;
    PrintAverageByLevelTreeNode *right;

    PrintAverageByLevelTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit PrintAverageByLevelTreeNode(int val) : val(val), left(nullptr), right(nullptr) {}

    PrintAverageByLevelTreeNode(int val, PrintAverageByLevelTreeNode *left,
                                PrintAverageByLevelTreeNode *right) : val(val),
                                                                      left(left),
                                                                      right(right) {}
};

class PrintAverageByLevel {
public:
    static void description() {
        cout << R"(Question 3:
    Given a binary tree containing integers, print the average value at each level of the tree.
    Input:
        4
       / \
      7   9
     / \   \
    10  2   6
         \
          6
         /
        2
    Output:
            [4, 8, 6, 6, 2])" << endl;
    }

    static PrintAverageByLevelTreeNode *deserialize(vector<string> values) {
        PrintAverageByLevelTreeNode *root = nullptr;
        if (!values.empty()) {
            queue<PrintAverageByLevelTreeNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new PrintAverageByLevelTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new PrintAverageByLevelTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new PrintAverageByLevelTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                PrintAverageByLevelTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new PrintAverageByLevelTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new PrintAverageByLevelTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(PrintAverageByLevelTreeNode **head) {
        auto current = *head;
        if (current != nullptr) {
            queue<PrintAverageByLevelTreeNode *> working;
            working.push(current);
            while (!working.empty()) {
                current = working.front();
                working.pop();
                if (current->left != nullptr) {
                    working.push(current->left);
                }
                if (current->right != nullptr) {
                    working.push(current->right);
                }
                delete current;
            }
        }
        *head = nullptr;
    }

    static vector<int> averageByLevel(PrintAverageByLevelTreeNode *input) {
        vector<int> result;
        if (input != nullptr) {
            queue<PrintAverageByLevelTreeNode *> evenLevel;
            queue<PrintAverageByLevelTreeNode *> oddLevel;
            auto odd = true;
            int sum;
            int count;
            oddLevel.emplace(input);
            while (!oddLevel.empty() || !evenLevel.empty()) {
                if (odd) {
                    sum = 0;
                    count = 0;
                    while (!oddLevel.empty()) {
                        count++;
                        sum += oddLevel.front()->val;
                        if (oddLevel.front()->left != nullptr) {
                            evenLevel.push(oddLevel.front()->left);
                        }
                        if (oddLevel.front()->right != nullptr) {
                            evenLevel.push(oddLevel.front()->right);
                        }
                        oddLevel.pop();
                    }
                    result.push_back(sum / count);
                } else {
                    sum = 0;
                    count = 0;
                    while (!evenLevel.empty()) {
                        count++;
                        sum += evenLevel.front()->val;
                        if (evenLevel.front()->left != nullptr) {
                            oddLevel.push(evenLevel.front()->left);
                        }
                        if (evenLevel.front()->right != nullptr) {
                            oddLevel.push(evenLevel.front()->right);
                        }
                        evenLevel.pop();
                    }
                    result.push_back(sum / count);
                }
                odd = !odd;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop