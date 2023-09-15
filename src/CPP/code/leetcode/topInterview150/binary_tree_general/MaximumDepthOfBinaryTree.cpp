#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct MaximumDepthOfBinaryTreeNode {
    int val;
    MaximumDepthOfBinaryTreeNode *left;
    MaximumDepthOfBinaryTreeNode *right;

    MaximumDepthOfBinaryTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit MaximumDepthOfBinaryTreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    MaximumDepthOfBinaryTreeNode(int x, MaximumDepthOfBinaryTreeNode *left, MaximumDepthOfBinaryTreeNode *right) : val(
            x), left(left), right(right) {}
};

class MaximumDepthOfBinaryTree {
public:
    static void description() {
        cout << R"(104. Maximum Depth of Binary Tree
    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: 3

    Example 2:
        Input: root = [1,null,2]
        Output: 2

    Constraints:
        The number of nodes in the tree is in the range [0, 10^4].
        -100 ≤ AddTwoNumbersListNode.val ≤ 100)" << endl;
    }

    static MaximumDepthOfBinaryTreeNode *deserializeTree(vector<string> values) {
        MaximumDepthOfBinaryTreeNode *root = nullptr;
        if (!values.empty()) {
            queue<MaximumDepthOfBinaryTreeNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new MaximumDepthOfBinaryTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new MaximumDepthOfBinaryTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new MaximumDepthOfBinaryTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                MaximumDepthOfBinaryTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new MaximumDepthOfBinaryTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new MaximumDepthOfBinaryTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(MaximumDepthOfBinaryTreeNode **head) {
        auto current = *head;
        if (current != nullptr) {
            queue<MaximumDepthOfBinaryTreeNode *> working;
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

    static int maxDepth(MaximumDepthOfBinaryTreeNode *root) {
        auto result = 0;
        if (root != nullptr) {
            result = 1;
            auto left = 0;
            if (root->left != nullptr) {
                left = maxDepth(root->left);
            }
            auto right = 0;
            if (root->right != nullptr) {
                right = maxDepth(root->right);
            }
            result += max(left, right);
        }
        return result;
    }
};

#pragma clang diagnostic pop