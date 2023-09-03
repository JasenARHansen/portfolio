#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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

class MaximumDepthOfBinaryTree {

public:

    static void description() {
        cout << R"(104. Maximum Depth of Binary Tree
    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: 3

    Example 2:
        Input: root = [1,null,2]
        Output: 2

    Constraints:
        The number of nodes in the tree is in the range [0, 10^4].
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

    static int maxDepth(TreeNode *root) {
        auto result = 0;
        if (root != nullptr) {
            result = 1;
            auto left = 0;
            if (root->left != nullptr) {
                left = maxDepth(root->left);
            }
            auto right = 0;
            if (root->right != nullptr) {
                right = maxDepth(root->right);
            }
            result += max(left, right);
        }
        return result;
    }

};

#pragma clang diagnostic pop