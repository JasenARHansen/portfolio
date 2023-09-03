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

class SameTree {

public:

    static void description() {
        cout << R"(100. Same Tree
    Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

    Example 1:
        Input: p = [1,2,3], q = [1,2,3]
        Output: true

    Example 2:
        Input: p = [1,2], q = [1,null,2]
        Output: false

    Example 3:
        Input: p = [1,2,1], q = [1,1,2]
        Output: false

    Constraints:
        The number of nodes in both trees is in the range [0, 100].
        -10^4 <= Node.val <= 10^4)" << endl;
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

    static bool isSameTree(TreeNode *p, TreeNode *q) {
        auto result = false;
        if ((p == nullptr) && (q == nullptr)) {
            result = true;
        } else if ((p != nullptr) && (q != nullptr)) {
            if (p->val != q->val) {
                return false;
            }
            auto left = false;
            if ((p->left == nullptr) && ((q->left == nullptr))) {
                left = true;
            } else if ((p->left != nullptr) && ((q->left != nullptr))) {
                left = isSameTree(p->left, q->left);
            }
            auto right = false;
            if ((p->right == nullptr) && ((q->right == nullptr))) {
                right = true;
            } else if ((p->right != nullptr) && ((q->right != nullptr))) {
                right = isSameTree(p->right, q->right);
            }
            result = left && right;
        }
        return result;
    }

};

#pragma clang diagnostic pop