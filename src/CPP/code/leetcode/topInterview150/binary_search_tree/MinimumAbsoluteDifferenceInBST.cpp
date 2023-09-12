#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct MinimumAbsoluteDifferenceInBSTNode {
    int val;
    MinimumAbsoluteDifferenceInBSTNode *left;
    MinimumAbsoluteDifferenceInBSTNode *right;

    MinimumAbsoluteDifferenceInBSTNode() : val(0), left(nullptr), right(nullptr) {}

    explicit MinimumAbsoluteDifferenceInBSTNode(int x) : val(x), left(nullptr), right(nullptr) {}

    MinimumAbsoluteDifferenceInBSTNode(int x, MinimumAbsoluteDifferenceInBSTNode *left,
                                       MinimumAbsoluteDifferenceInBSTNode *right) : val(x), left(left), right(right) {}
};

class MinimumAbsoluteDifferenceInBST {

public:

    static void description() {
        cout << R"(530. Minimum Absolute Difference in BST
    Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

    Example 1:
        Input: root =[4,2,6,1,3]
        Output: 1

    Example 2:
        Input: root = [1,0,48,null,null,12,49]
        Output: 1

    Constraints:
        The number of nodes in the tree is in the range [2, 10^4].
        0 ≤ AddTwoNumbersListNode.val ≤ 10^5

    Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/)" << endl;
    }

    static MinimumAbsoluteDifferenceInBSTNode *deserializeTree(vector<string> values) {
        MinimumAbsoluteDifferenceInBSTNode *root = nullptr;
        if (!values.empty()) {
            queue<MinimumAbsoluteDifferenceInBSTNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new MinimumAbsoluteDifferenceInBSTNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new MinimumAbsoluteDifferenceInBSTNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new MinimumAbsoluteDifferenceInBSTNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                MinimumAbsoluteDifferenceInBSTNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new MinimumAbsoluteDifferenceInBSTNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new MinimumAbsoluteDifferenceInBSTNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(MinimumAbsoluteDifferenceInBSTNode **head) {
        if ((*head)->left != nullptr) {
            deleteTree(&(*head)->left);
        }
        if ((*head)->right != nullptr) {
            deleteTree(&(*head)->right);
        }
        delete *head;
        *head = nullptr;
    }

    static int getMinimumDifference(MinimumAbsoluteDifferenceInBSTNode *root) {
        auto result = INT_MAX;
        if (root != nullptr) {
            vector<int> inorder;
            inorderTraversal(root, inorder);
            for (auto index = 1; index < inorder.size(); index++) {
                result = min(result, inorder[index] - inorder[index - 1]);
            }
        }
        return result;
    }

private:

    static void inorderTraversal(MinimumAbsoluteDifferenceInBSTNode *root, vector<int> &inorder) {
        if (root->left != nullptr) {
            inorderTraversal(root->left, inorder);
        }
        inorder.push_back(root->val);
        if (root->right != nullptr) {
            inorderTraversal(root->right, inorder);
        }
    }

    static void insertNode(MinimumAbsoluteDifferenceInBSTNode *head, int value) {
        if (value < head->val) {
            if (head->left == nullptr) {
                head->left = new MinimumAbsoluteDifferenceInBSTNode(value);
            } else {
                insertNode(head->left, value);
            }
        } else {
            if (head->right == nullptr) {
                head->right = new MinimumAbsoluteDifferenceInBSTNode(value);
            } else {
                insertNode(head->right, value);
            }
        }
    }

};

#pragma clang diagnostic pop