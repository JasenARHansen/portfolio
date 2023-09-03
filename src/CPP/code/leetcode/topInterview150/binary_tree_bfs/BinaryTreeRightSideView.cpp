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

class BinaryTreeRightSideView {

public:

    static void description() {
        cout << R"(199. Binary Tree Right Side View
    Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

    Example 1:
        Input: root = [1,2,3,null,5,null,4]
        Output: [1,3,4]

    Example 2:
        Input: root = [1,null,3]
        Output: [1,3]

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

    static vector<int> rightSideView(TreeNode *root) {
        vector<int> result{};
        if (root != nullptr) {
            vector<vector<int>> data{};
            queue<TreeNode *> levelA;
            queue<TreeNode *> levelB;
            levelA.push(root);
            TreeNode *processing;
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