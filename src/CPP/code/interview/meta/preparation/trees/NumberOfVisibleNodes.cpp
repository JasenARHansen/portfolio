#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class NumberOfVisibleNodes {
private:
    class Node {
    public:
        int data;
        Node *left;
        Node *right;

        Node() : data(0), left(nullptr), right(nullptr) {}

        explicit Node(int data) : data(data), left(nullptr), right(nullptr) {}

        Node(int data, Node *left,
             Node *right) : data(data),
                            left(left),
                            right(right) {}
    };

public:
    static void description() {
        cout << R"(Number of Visible Nodes
    There is a binary tree with N nodes.
    You are viewing the tree from its left side and can see only the leftmost nodes at each level.
    Return the number of visible nodes.
    Note: You can see only the leftmost nodes, but that doesn't mean they have to be left nodes.
    The leftmost node at a level could be a right node.
    Signature:
        int visibleNodes(Node root) {
    Input:
        The root node of a tree, where the number of nodes is between 1 and 1000, and the value of each node
         is between 0 and 1, 000, 000, 000
    Output:
        An int representing the number of visible nodes.
    Example:
            8  <------ root
           / \
         3    10
        / \     \
       1   6     14
          / \    /
         4   7  13
    output = 4)" << endl;
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

    static int visibleNodes(Node *root) {
        int result = 0;
        if (root != nullptr) {
            queue<Node *> oddLevel;
            queue<Node *> evenLevel;
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