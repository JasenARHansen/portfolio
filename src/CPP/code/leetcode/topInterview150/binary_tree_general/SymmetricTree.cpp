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

class SymmetricTree {

public:

    static void description() {
        cout << R"(101. Symmetric Tree
    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

    Example 1:
        Input: root = [1,2,2,3,4,4,3]
        Output: true

    Example 2:
        Input: root = [1,2,2,null,3,null,3]
        Output: false

    Constraints:
        The number of nodes in the tree is in the range [1, 1000].
        -100 <= Node.val <= 100

    Follow up:
        Could you solve it both recursively and iteratively?)" << endl;
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

    static bool isSymmetric(TreeNode *root) {
        if (root == nullptr) {
            return true;
        }
        return isSymmetric(root->left, root->right);
    }

private:

    static bool isSymmetric(TreeNode *treeA, TreeNode *treeB) {
        if ((treeA == nullptr) && (treeB == nullptr)) {
            return true;
        } else if ((treeA == nullptr) || (treeB == nullptr)) {
            return false;
        }
        if (treeA->val == treeB->val) {
            auto outer = isSymmetric(treeA->left, treeB->right);
            auto inner = isSymmetric(treeA->right, treeB->left);
            return outer && inner;
        }
        return false;
    }
};

#pragma clang diagnostic pop