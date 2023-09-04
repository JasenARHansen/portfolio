#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cmath>
#include <cassert>
#include <queue>

using namespace std;

struct KthSmallestElementInABSTNode {
    int val;
    KthSmallestElementInABSTNode *left;
    KthSmallestElementInABSTNode *right;

    KthSmallestElementInABSTNode() : val(0), left(nullptr), right(nullptr) {}

    explicit KthSmallestElementInABSTNode(int x) : val(x), left(nullptr), right(nullptr) {}

    KthSmallestElementInABSTNode(int x, KthSmallestElementInABSTNode *left, KthSmallestElementInABSTNode *right) : val(
            x), left(left), right(right) {}
};

class KthSmallestElementInABST {

public:

    static void description() {
        cout << R"(230. Kth Smallest Element in a BST
    Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

    Example 1:
        Input: root = [3,1,4,null,2], k = 1
        Output: 1

    Example 2:
        Input: root = [5,3,6,2,4,null,null,1], k = 3
        Output: 3

    Constraints:
        The number of nodes in the tree is n.
        1 <= k <= n <= 10^4
        0 <= Node.val <= 10^4

    Follow up:
        If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?)"
             << endl;
    }

    static KthSmallestElementInABSTNode *deserialize(vector<string> values) {
        KthSmallestElementInABSTNode *root = nullptr;
        if (!values.empty()) {
            queue<KthSmallestElementInABSTNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new KthSmallestElementInABSTNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new KthSmallestElementInABSTNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new KthSmallestElementInABSTNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                KthSmallestElementInABSTNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new KthSmallestElementInABSTNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new KthSmallestElementInABSTNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(KthSmallestElementInABSTNode **head) {
        if ((*head)->left != nullptr) {
            deleteTree(&(*head)->left);
        }
        if ((*head)->right != nullptr) {
            deleteTree(&(*head)->right);
        }
        delete *head;
        *head = nullptr;
    }

    static int kthSmallest(KthSmallestElementInABSTNode *root, int k) {
        assert(1 <= k);
        assert(k <= pow(10, 4));
        auto result = INT_MAX;
        if (root != nullptr) {
            vector<int> inorder;
            inorderTraversal(root, inorder);
            result = inorder[k - 1];
        }
        return result;
    }

private:

    static void inorderTraversal(KthSmallestElementInABSTNode *root, vector<int> &inorder) {
        if (root->left != nullptr) {
            inorderTraversal(root->left, inorder);
        }
        inorder.push_back(root->val);
        if (root->right != nullptr) {
            inorderTraversal(root->right, inorder);
        }
    }

    static void insertNode(KthSmallestElementInABSTNode *head, int value) {
        if (value < head->val) {
            if (head->left == nullptr) {
                head->left = new KthSmallestElementInABSTNode(value);
            } else {
                insertNode(head->left, value);
            }
        } else {
            if (head->right == nullptr) {
                head->right = new KthSmallestElementInABSTNode(value);
            } else {
                insertNode(head->right, value);
            }
        }
    }

};

#pragma clang diagnostic pop