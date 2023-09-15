#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct SymmetricTreeNode {
    int val;
    SymmetricTreeNode *left;
    SymmetricTreeNode *right;

    SymmetricTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit SymmetricTreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    SymmetricTreeNode(int x, SymmetricTreeNode *left, SymmetricTreeNode *right) : val(x), left(left), right(right) {}
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
        -100 ≤ AddTwoNumbersListNode.val ≤ 100

    Follow up:
        Could you solve it both recursively and iteratively?)" << endl;
    }

    static SymmetricTreeNode *deserializeTree(vector<string> values) {
        SymmetricTreeNode *root = nullptr;
        if (!values.empty()) {
            queue<SymmetricTreeNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new SymmetricTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new SymmetricTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new SymmetricTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                SymmetricTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new SymmetricTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new SymmetricTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(SymmetricTreeNode **head) {
        auto current = *head;
        if (current != nullptr) {
            queue<SymmetricTreeNode *> working;
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

    static bool isSymmetric(SymmetricTreeNode *root) {
        if (root == nullptr) {
            return true;
        }
        return isSymmetric(root->left, root->right);
    }

private:
    static bool isSymmetric(SymmetricTreeNode *treeA, SymmetricTreeNode *treeB) {
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