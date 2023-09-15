#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>
#include <bits/stdc++.h>

using namespace std;

struct LowestCommonAncestorOfABinaryTreeTreeNode {
    int val;
    LowestCommonAncestorOfABinaryTreeTreeNode *left;
    LowestCommonAncestorOfABinaryTreeTreeNode *right;

    LowestCommonAncestorOfABinaryTreeTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit LowestCommonAncestorOfABinaryTreeTreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    LowestCommonAncestorOfABinaryTreeTreeNode(int x, LowestCommonAncestorOfABinaryTreeTreeNode *left,
                                              LowestCommonAncestorOfABinaryTreeTreeNode *right) : val(
            x), left(left), right(right) {}
};

class LowestCommonAncestorOfABinaryTree {
public:
    static void description() {
        cout << R"(236. Lowest Common Ancestor of a Binary Tree
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

    Example 1:
        Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        Output: 3
        Explanation:
            The LCA of nodes 5 and 1 is 3.

    Example 2:
        Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        Output: 5
        Explanation:
            The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

    Example 3:
        Input: root = [1,2], p = 1, q = 2
        Output: 1

    Constraints:
        The number of nodes in the tree is in the range [2, 10^5].
        -109 ≤ AddTwoNumbersListNode.val ≤ 10^9
        All AddTwoNumbersListNode.val are unique.
        p != q
        p and q will exist in the tree.)" << endl;
    }

    static LowestCommonAncestorOfABinaryTreeTreeNode *deserializeTree(vector<string> values) {
        LowestCommonAncestorOfABinaryTreeTreeNode *root = nullptr;
        if (!values.empty()) {
            queue<LowestCommonAncestorOfABinaryTreeTreeNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new LowestCommonAncestorOfABinaryTreeTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new LowestCommonAncestorOfABinaryTreeTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new LowestCommonAncestorOfABinaryTreeTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                LowestCommonAncestorOfABinaryTreeTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new LowestCommonAncestorOfABinaryTreeTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new LowestCommonAncestorOfABinaryTreeTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(LowestCommonAncestorOfABinaryTreeTreeNode **head) {
        auto current = *head;
        if (current != nullptr) {
            queue<LowestCommonAncestorOfABinaryTreeTreeNode *> working;
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

    static LowestCommonAncestorOfABinaryTreeTreeNode *
    findNode(LowestCommonAncestorOfABinaryTreeTreeNode *node, int target) {
        LowestCommonAncestorOfABinaryTreeTreeNode *result = nullptr;
        if (node != nullptr) {
            if (node->val == target) {
                result = node;
            } else {
                result = findNode(node->left, target);
                if (result == nullptr) {
                    result = findNode(node->right, target);
                }
            }
        }
        return result;
    }

    static LowestCommonAncestorOfABinaryTreeTreeNode *
    lowestCommonAncestor(LowestCommonAncestorOfABinaryTreeTreeNode *root, LowestCommonAncestorOfABinaryTreeTreeNode *p,
                         LowestCommonAncestorOfABinaryTreeTreeNode *q) {
        LowestCommonAncestorOfABinaryTreeTreeNode *result = nullptr;
        if (root != nullptr) {
            auto pathP = findPath(root, p);
            reverse(pathP.begin(), pathP.end());
            auto pathQ = findPath(root, q);
            reverse(pathQ.begin(), pathQ.end());
            int index = 0;
            result = pathP[index];
            index++;
            while ((index < min(pathP.size(), pathQ.size())) && (pathP[index]->val == pathQ[index]->val)) {
                result = pathP[index];
                index++;
            }
        }
        return result;
    }

private:
    static vector<LowestCommonAncestorOfABinaryTreeTreeNode *>
    findPath(LowestCommonAncestorOfABinaryTreeTreeNode *node, LowestCommonAncestorOfABinaryTreeTreeNode *target) {
        vector<LowestCommonAncestorOfABinaryTreeTreeNode *> result;
        if (node != nullptr) {
            if (node->val == target->val) {
                result.push_back(target);
            } else {
                result = findPath(node->left, target);
                if (result.empty()) {
                    result = findPath(node->right, target);
                }
                if (!result.empty()) {
                    result.push_back(node);
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop