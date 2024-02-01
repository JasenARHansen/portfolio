#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;


class BinaryTreeRightSideView {
private:
    struct Node {
        int val;
        Node *left;
        Node *right;

        Node() : val(0), left(nullptr), right(nullptr) {}

        explicit Node(int x) : val(x), left(nullptr), right(nullptr) {}

        Node(int x, Node *left,
             Node *right) : val(x),
                            left(left),
                            right(right) {}
    };

public:
    static void description() {
        cout << R"(199: Binary Tree Right Side View
    Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
    Example 1:
        Input: root = [1, 2, 3, null, 5, null, 4]
        Output: [1, 3, 4]
    Example 2:
        Input: root = [1, null, 3]
        Output: [1, 3]
    Example 3:
        Input: root = []
        Output: []
    Constraints:
        The number of nodes in the tree is in the range [0, 100].
        -100 ≤ AddTwoNumbersListNode.val ≤ 100)" << endl;
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

    static vector<int> rightSideView(Node *root) {
        vector<int> result{};
        if (root != nullptr) {
            vector<vector<int>> data{};
            queue<Node *> levelA;
            queue<Node *> levelB;
            levelA.push(root);
            Node *processing;
            while (!levelA.empty() || !levelB.empty()) {
                if (!levelA.empty()) {
                    data.emplace_back();
                    while (!levelA.empty()) {
                        processing = levelA.front();
                        data[data.size() - 1].push_back(processing->val);
                        levelA.pop();
                        if (processing->left != nullptr) {
                            levelB.push(processing->left);
                        }
                        if (processing->right != nullptr) {
                            levelB.push(processing->right);
                        }
                    }
                } else {
                    data.emplace_back();
                    while (!levelB.empty()) {
                        processing = levelB.front();
                        data[data.size() - 1].push_back(processing->val);
                        levelB.pop();
                        if (processing->left != nullptr) {
                            levelA.push(processing->left);
                        }
                        if (processing->right != nullptr) {
                            levelA.push(processing->right);
                        }
                    }
                }
                result.push_back(data[data.size() - 1][data[data.size() - 1].size() - 1]);
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop