#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class BinaryTreeLevelOrderTraversal {
private:
    struct Node {
        int val;
        Node *left;
        Node *right;

        Node() : val(0), left(nullptr), right(nullptr) {}

        explicit Node(int x) : val(x), left(nullptr), right(nullptr) {}

        Node(int x, Node *left, Node *right) : val(x), left(left), right(right) {}
    };

public:
    static void description() {
        cout << R"(102: Binary Tree Level Order Traversal
    Given the root of a binary tree, return the level order traversal of its nodes' values.
    (i.e., from left to right, level by level).
    Example 1:
        Input: root = [3, 9, 20, null, null, 15, 7]
        Output: [[3], [9, 20], [15, 7]]
    Example 2:
        Input: root = [1]
        Output: [[1]]
    Example 3:
        Input: root = []
        Output: []
    Constraints:
        The number of nodes in the tree is in the range [0, 2000].
        -1000 ≤ Node.val ≤ 1000)" << endl;
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

    static vector<vector<int>> levelOrder(Node *root) {
        vector<vector<int>> result{};
        if (root != nullptr) {
            queue<Node *> levelA;
            queue<Node *> levelB;
            levelA.push(root);
            Node *processing;
            while (!levelA.empty() || !levelB.empty()) {
                if (!levelA.empty()) {
                    result.emplace_back();
                    while (!levelA.empty()) {
                        processing = levelA.front();
                        result[result.size() - 1].push_back(processing->val);
                        levelA.pop();
                        if (processing->left != nullptr) {
                            levelB.push(processing->left);
                        }
                        if (processing->right != nullptr) {
                            levelB.push(processing->right);
                        }
                    }
                } else {
                    result.emplace_back();
                    while (!levelB.empty()) {
                        processing = levelB.front();
                        result[result.size() - 1].push_back(processing->val);
                        levelB.pop();
                        if (processing->left != nullptr) {
                            levelA.push(processing->left);
                        }
                        if (processing->right != nullptr) {
                            levelA.push(processing->right);
                        }
                    }
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop