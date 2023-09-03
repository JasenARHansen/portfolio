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

class BinaryTreeLevelOrderTraversal {

public:

    static void description() {
        cout << R"(102. Binary Tree Level Order Traversal
    Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

    Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: [[3],[9,20],[15,7]]

    Example 2:
        Input: root = [1]
        Output: [[1]]

    Example 3:
        Input: root = []
        Output: []

    Constraints:
        The number of nodes in the tree is in the range [0, 2000].
        -1000 <= Node.val <= 1000)" << endl;
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

    static vector<vector<int>> levelOrder(TreeNode *root) {
        vector<vector<int>> result{};
        if (root != nullptr) {
            queue<TreeNode *> levelA;
            queue<TreeNode *> levelB;
            levelA.push(root);
            TreeNode *processing;
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