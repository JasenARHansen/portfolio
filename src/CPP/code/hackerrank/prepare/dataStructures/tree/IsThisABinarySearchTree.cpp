#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <map>
#include <set>
#include <queue>

using namespace std;

class IsThisABinarySearchTree {
private:
    class Node {
    public:
        int data;
        Node *left;
        Node *right;

        explicit Node(int d) : data(d), left(nullptr), right(nullptr) {}
    };

    class Result {
    public:
        bool valid;
        int max;
        int min;

        explicit Result(bool valid) : valid(valid), max(INT_MIN), min(INT_MAX) {}
    };

public:
    static void description() {
        cout << R"(Tree: Is This a Binary Search Tree?
    For the purposes of this challenge, we define a binary tree (https://en.wikipedia.org/wiki/Binary_tree) to be
     a binary search tree (https://en.wikipedia.org/wiki/Binary_search_tree) with the following ordering requirements:
    The data value of every node in a node's left subtree is less than the data value of that node.
    The data value of every node in a node's right subtree is greater than the data value of that node.
    Given the root node of a binary tree, can you determine if it's also a binary search tree?
    Complete the function in your editor below, which has 1 parameter: a pointer to the root of a binary tree.
    It must return a boolean denoting whether or not the binary tree is a binary search tree.
    You may have to write one or more helper functions to complete this challenge.
    Input Format:
        You are not responsible for reading any input from stdin.
        Hidden code stubs will assemble a binary tree and pass its root node to your function as an argument.
    Constraints:
        0 ≤ data ≤ 10^4
    Output Format:
        You are not responsible for printing any output to stdout.
        Your function must return true if the tree is a binary search tree; otherwise, it must return false.
        Hidden code stubs will print this result as a Yes or No answer on a new line.
    Sample Input:
              3
            /   \
           5     2
          / \   /
         1   4 6
    Sample Output:
        No)" << endl;
    }

    static Node *deserializeTree(vector<string> values) {
        Node *root = nullptr;
        if (!values.empty()) {
            queue<Node *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new Node(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new Node(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new Node(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                Node *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new Node(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new Node(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(Node **head) {
        auto current = *head;
        if (current != nullptr) {
            queue<Node *> working;
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

    static bool checkBST(Node *root) {
        auto result = validate(root);
        auto valid = result->valid;
        delete result;
        return valid;
    }

private:
    static Result *validate(Node *node) {
        auto *result = new Result(true);
        result->min = node->data;
        result->max = node->data;
        Result *left = nullptr;
        Result *right = nullptr;
        if (node->left != nullptr) {
            left = validate(node->left);
        }
        if (node->right != nullptr) {
            right = validate(node->right);
        }
        if (left != nullptr) {
            if ((!left->valid) or (left->min >= node->data) or (left->max >= node->data)) {
                result->valid = false;
            } else {
                result->min = left->min;
            }
            delete left;
        }
        if (right != nullptr) {
            if ((!right->valid) or (right->min <= node->data) or (right->max <= node->data)) {
                result->valid = false;
            } else {
                result->max = right->max;
            }
            delete right;
        }
        return result;
    }
};

#pragma clang diagnostic pop