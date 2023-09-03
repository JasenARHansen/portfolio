#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
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

    static TreeNode *generateTree(vector<string> values) {
        TreeNode *root = nullptr;
        if (!values.empty()) {
            auto index = 0;
            if (values[index] != "null") {
                queue<TreeNode *> nodes;
                root = new TreeNode(stoi(values[index]));
                index++;
                nodes.push(root);
                TreeNode *temp;
                while (!nodes.empty()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new TreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (values[index] != "null") {
                        temp->right = new TreeNode(stoi(values[index]));
                        nodes.push(temp->right);
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(TreeNode **head) {
        TreeNode *current = *head;
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

    static vector<string> serialize(TreeNode *head) {
        vector<string> data;
        if (head != nullptr) {
            queue<TreeNode *> nodes;
            TreeNode *current = head;
            nodes.push(head);
            data.push_back(to_string(current->val));
            while (!nodes.empty()) {
                current = nodes.front();
                nodes.pop();
                if (current->left != nullptr) {
                    nodes.push(current->left);
                    data.push_back(to_string(current->left->val));
                } else {
                    data.emplace_back("null");
                }
                if (current->right != nullptr) {
                    nodes.push(current->right);
                    data.push_back(to_string(current->right->val));
                } else {
                    data.emplace_back("null");
                }
            }
        }
        return data;
    }

    static TreeNode *invertTree(TreeNode *root) {
        TreeNode *result = nullptr;
        if (root != nullptr) {
            result = new TreeNode(root->val);
            result->left = invertTree(root->right);
            result->right = invertTree(root->left);
        }
        return result;
    }

};

#pragma clang diagnostic pop