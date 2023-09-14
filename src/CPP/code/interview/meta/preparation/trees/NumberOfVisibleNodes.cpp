#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class NumberOfVisibleNodesNode {
public:
    int data;
    NumberOfVisibleNodesNode *left;
    NumberOfVisibleNodesNode *right;

    NumberOfVisibleNodesNode() : data(0), left(nullptr), right(nullptr) {}

    explicit NumberOfVisibleNodesNode(int data) : data(data), left(nullptr), right(nullptr) {}

    NumberOfVisibleNodesNode(int data, NumberOfVisibleNodesNode *left,
                             NumberOfVisibleNodesNode *right) : data(data),
                                                                left(left),
                                                                right(right) {}
};

class NumberOfVisibleNodes {
public:
    static void description() {
        cout << R"(Number of Visible Nodes
    There is a binary tree with N nodes. You are viewing the tree from its left side and can see only the leftmost nodes at each level. Return the number of visible nodes.
    Note: You can see only the leftmost nodes, but that doesn't mean they have to be left nodes. The leftmost node at a level could be a right node.

    Signature
        int visibleNodes(Node root) {

    Input
        The root node of a tree, where the number of nodes is between 1 and 1000, and the value of each node is between 0 and 1,000,000,000

    Output
        An int representing the number of visible nodes.

    Example
            8  <------ root
           / \
         3    10
        / \     \
       1   6     14
          / \    /
         4   7  13
    output = 4)" << endl;
    }

    static NumberOfVisibleNodesNode *deserializeTree(vector<string> values) {
        NumberOfVisibleNodesNode *root = nullptr;
        if (!values.empty()) {
            queue<NumberOfVisibleNodesNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new NumberOfVisibleNodesNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new NumberOfVisibleNodesNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new NumberOfVisibleNodesNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                NumberOfVisibleNodesNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new NumberOfVisibleNodesNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new NumberOfVisibleNodesNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(NumberOfVisibleNodesNode **head) {
        auto current = *head;
        if (current != nullptr) {
            if (current->left != nullptr) {
                deleteTree(&current->left);
            }
            if (current->right != nullptr) {
                deleteTree(&current->right);
            }
            delete current;
        }
        *head = nullptr;
    }

    static int visibleNodes(NumberOfVisibleNodesNode *root) {
        int result = 0;
        if (root != nullptr) {
            queue<NumberOfVisibleNodesNode *> oddLevel;
            queue<NumberOfVisibleNodesNode *> evenLevel;
            oddLevel.push(root);
            while (!oddLevel.empty() || !evenLevel.empty()) {
                if (oddLevel.empty()) {
                    result++;
                    while (!evenLevel.empty()) {
                        if (evenLevel.front()->left != nullptr) {
                            oddLevel.push(evenLevel.front()->left);
                        }
                        if (evenLevel.front()->right != nullptr) {
                            oddLevel.push(evenLevel.front()->right);
                        }
                        evenLevel.pop();
                    }
                } else {
                    result++;
                    while (!oddLevel.empty()) {
                        if (oddLevel.front()->left != nullptr) {
                            evenLevel.push(oddLevel.front()->left);
                        }
                        if (oddLevel.front()->right != nullptr) {
                            evenLevel.push(oddLevel.front()->right);
                        }
                        oddLevel.pop();
                    }
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop