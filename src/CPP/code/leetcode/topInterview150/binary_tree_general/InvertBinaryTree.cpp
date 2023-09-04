#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct InvertBinaryTreeNode {
    int val;
    InvertBinaryTreeNode *left;
    InvertBinaryTreeNode *right;

    InvertBinaryTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit InvertBinaryTreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    InvertBinaryTreeNode(int x, InvertBinaryTreeNode *left, InvertBinaryTreeNode *right) : val(x), left(left),
                                                                                           right(right) {}
};

class InvertBinaryTree {

public:

    static void description() {
        cout << R"(226. Invert Binary Tree
    Given the root of a binary tree, invert the tree, and return its root.

    Example 1:
        Input: root = [4,2,7,1,3,6,9]
        Output: [4,7,2,9,6,3,1]

    Example 2:
        Input: root = [2,1,3]
        Output: [2,3,1]

    Example 3:
        Input: root = []
        Output: []

    Constraints:
        The number of nodes in the tree is in the range [0, 100].
        -100 <= Node.val <= 100)" << endl;
    }

    static InvertBinaryTreeNode *deserialize(vector<string> values) {
        InvertBinaryTreeNode *root = nullptr;
        if (!values.empty()) {
            queue<InvertBinaryTreeNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new InvertBinaryTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new InvertBinaryTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new InvertBinaryTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                InvertBinaryTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new InvertBinaryTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new InvertBinaryTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static vector<string> serialize(InvertBinaryTreeNode *head) {
        vector<string> data;
        if (head != nullptr) {
            queue<InvertBinaryTreeNode *> nodes;
            auto current = head;
            queue<InvertBinaryTreeNode *> levelA;
            queue<InvertBinaryTreeNode *> levelB;
            levelA.push(current);
            while (!levelA.empty() || !levelB.empty()) {
                if (!levelA.empty()) {
                    while (!levelA.empty()) {
                        current = levelA.front();
                        levelA.pop();
                        if (current == nullptr) {
                            data.emplace_back("null");
                        } else {
                            data.push_back(to_string((current->val)));
                            if ((current->left != nullptr) || (current->right != nullptr)) {
                                levelB.push(current->left);
                                levelB.push(current->right);
                            }
                        }
                    }
                } else if (!levelB.empty()) {
                    while (!levelB.empty()) {
                        current = levelB.front();
                        levelB.pop();
                        if (current == nullptr) {
                            data.emplace_back("null");
                        } else {
                            data.push_back(to_string((current->val)));
                            if ((current->left != nullptr) || (current->right != nullptr)) {
                                levelA.push(current->left);
                                levelA.push(current->right);
                            }
                        }
                    }
                }
            }
        }
        return data;
    }

    static void deleteTree(InvertBinaryTreeNode **head) {
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

    static InvertBinaryTreeNode *invertTree(InvertBinaryTreeNode *root) {
        InvertBinaryTreeNode *result = nullptr;
        if (root != nullptr) {
            result = new InvertBinaryTreeNode(root->val);
            result->left = invertTree(root->right);
            result->right = invertTree(root->left);
        }
        return result;
    }

};

#pragma clang diagnostic pop