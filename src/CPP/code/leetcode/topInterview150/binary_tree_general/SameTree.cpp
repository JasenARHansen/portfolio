#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct SameTreeNode {
    int val;
    SameTreeNode *left;
    SameTreeNode *right;

    SameTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit SameTreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    SameTreeNode(int x, SameTreeNode *left, SameTreeNode *right) : val(x), left(left), right(right) {}
};

class SameTree {
public:
    static void description() {
        cout << R"(100: Same Tree
    Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
    Example 1:
        Input: p = [1, 2, 3], q = [1, 2, 3]
        Output: true
    Example 2:
        Input: p = [1, 2], q = [1, null, 2]
        Output: false
    Example 3:
        Input: p = [1, 2, 1], q = [1, 1, 2]
        Output: false
    Constraints:
        The number of nodes in both trees is in the range [0, 100].
        -10^4 ≤ AddTwoNumbersListNode.val ≤ 10^4)" << endl;
    }

    static SameTreeNode *deserializeTree(vector<string> values) {
        SameTreeNode *root = nullptr;
        if (!values.empty()) {
            queue<SameTreeNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new SameTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new SameTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new SameTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                SameTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new SameTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new SameTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(SameTreeNode **head) {
        auto current = *head;
        if (current != nullptr) {
            queue<SameTreeNode *> working;
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

    static bool isSameTree(SameTreeNode *p, SameTreeNode *q) {
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