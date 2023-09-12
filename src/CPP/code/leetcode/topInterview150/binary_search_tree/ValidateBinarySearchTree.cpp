#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct ValidateBinarySearchTreeNode {
    int val;
    ValidateBinarySearchTreeNode *left;
    ValidateBinarySearchTreeNode *right;

    ValidateBinarySearchTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit ValidateBinarySearchTreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    ValidateBinarySearchTreeNode(int x, ValidateBinarySearchTreeNode *left, ValidateBinarySearchTreeNode *right) : val(
            x), left(left), right(right) {}
};

class ValidateBinarySearchTree {

public:

    static void description() {
        cout << R"(98. Validate Binary Search Tree
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).
    A valid BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.

    Example 1:
        Input: root = [2,1,3]
        Output: true

    Example 2:
        Input: root = [5,1,4,null,null,3,6]
        Output: false
        Explanation:
            The root node's value is 5 but its right child's value is 4.

    Constraints:
        The number of nodes in the tree is in the range [1, 10^4].
        -2^31 ≤ AddTwoNumbersListNode.val ≤ 2^31 - 1)" << endl;
    }


    static ValidateBinarySearchTreeNode *deserializeTree(vector<string> values) {
        ValidateBinarySearchTreeNode *root = nullptr;
        if (!values.empty()) {
            queue<ValidateBinarySearchTreeNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new ValidateBinarySearchTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new ValidateBinarySearchTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new ValidateBinarySearchTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                ValidateBinarySearchTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new ValidateBinarySearchTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new ValidateBinarySearchTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(ValidateBinarySearchTreeNode **head) {
        if ((*head)->left != nullptr) {
            deleteTree(&(*head)->left);
        }
        if ((*head)->right != nullptr) {
            deleteTree(&(*head)->right);
        }
        delete *head;
        *head = nullptr;
    }

    static bool isValidBST(ValidateBinarySearchTreeNode *root) {
        auto result = true;
        if (root != nullptr) {
            auto range = validNode(root);
            if ((range.first == LLONG_MIN) || (range.second == LLONG_MAX)) {
                result = false;
            }
        }
        return result;
    }

private:

    static pair<long long, long long> validNode(ValidateBinarySearchTreeNode *node) {
        pair<long long int, long long> fail = make_pair(LLONG_MIN, LLONG_MAX);
        if (node != nullptr) {
            pair<long long, long long> left;
            pair<long long, long long> right;
            pair<long long, long long> result = make_pair(LLONG_MIN, LLONG_MAX);
            if (node->left != nullptr) {
                left = validNode(node->left);
                if ((node->val <= left.first) || (node->val <= left.second)) {
                    return fail;
                }
                result.first = left.first;
            } else {
                result.first = node->val;
            }
            if (node->right != nullptr) {
                right = validNode(node->right);
                if ((node->val >= right.first) || (node->val >= right.second)) {
                    return fail;
                }
                result.second = right.second;
            } else {
                result.second = node->val;
            }
            return result;
        }
        return fail;
    }

    static void insertNode(ValidateBinarySearchTreeNode *head, int value) {
        if (value < head->val) {
            if (head->left == nullptr) {
                head->left = new ValidateBinarySearchTreeNode(value);
            } else {
                insertNode(head->left, value);
            }
        } else {
            if (head->right == nullptr) {
                head->right = new ValidateBinarySearchTreeNode(value);
            } else {
                insertNode(head->right, value);
            }
        }
    }

};

#pragma clang diagnostic pop