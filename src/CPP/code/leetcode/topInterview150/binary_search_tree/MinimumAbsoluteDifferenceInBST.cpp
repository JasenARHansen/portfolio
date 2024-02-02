#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class MinimumAbsoluteDifferenceInBST {
private:
    struct Node {
        int val;
        Node *left;
        Node *right;

        Node() : val(0), left(nullptr), right(nullptr) {}

        explicit Node(int x) : val(x), left(nullptr), right(nullptr) {}

        Node(int x, Node *left, Node *right) : val(x), left(left), right(right) {}
    };

public:
    static void description() {
        cout << R"(530: Minimum Absolute Difference in BST
    Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the
     values of any two different nodes in the tree.
    Example 1:
        Input: root =[4, 2, 6, 1, 3]
        Output: 1
    Example 2:
        Input: root = [1, 0, 48, null, null, 12, 49]
        Output: 1
    Constraints:
        The number of nodes in the tree is in the range [2, 10^4].
        0 ≤ Node.val ≤ 10^5
    Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/)" << endl;
    }

    static Node *deserializeTree(vector<string> values) {
        Node *root = nullptr;
        if (!values.empty()) {
            queue<Node *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new Node(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new Node(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new Node(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                Node *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new Node(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new Node(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(Node **head) {
        auto current = *head;
        if (current != nullptr) {
            queue<Node *> working;
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

    static int getMinimumDifference(Node *root) {
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
    static void inorderTraversal(Node *root, vector<int> &inorder) {
        if (root->left != nullptr) {
            inorderTraversal(root->left, inorder);
        }
        inorder.push_back(root->val);
        if (root->right != nullptr) {
            inorderTraversal(root->right, inorder);
        }
    }

    static void insertNode(Node *head, int value) {
        if (value < head->val) {
            if (head->left == nullptr) {
                head->left = new Node(value);
            } else {
                insertNode(head->left, value);
            }
        } else {
            if (head->right == nullptr) {
                head->right = new Node(value);
            } else {
                insertNode(head->right, value);
            }
        }
    }
};

#pragma clang diagnostic pop