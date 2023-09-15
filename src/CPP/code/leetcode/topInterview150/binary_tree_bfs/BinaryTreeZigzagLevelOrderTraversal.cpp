#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct BinaryTreeZigzagLevelOrderTraversalTreeNode {
    int val;
    BinaryTreeZigzagLevelOrderTraversalTreeNode *left;
    BinaryTreeZigzagLevelOrderTraversalTreeNode *right;

    BinaryTreeZigzagLevelOrderTraversalTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit BinaryTreeZigzagLevelOrderTraversalTreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    BinaryTreeZigzagLevelOrderTraversalTreeNode(int x, BinaryTreeZigzagLevelOrderTraversalTreeNode *left,
                                                BinaryTreeZigzagLevelOrderTraversalTreeNode *right) : val(x),
                                                                                                      left(left),
                                                                                                      right(right) {}
};

class BinaryTreeZigzagLevelOrderTraversal {
public:
    static void description() {
        cout << R"(103. Binary Tree Zigzag Level Order Traversal
    Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

    Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: [[3],[20,9],[15,7]]

    Example 2:
        Input: root = [1]
        Output: [[1]]

    Example 3:
        Input: root = []
        Output: []

    Constraints:
        The number of nodes in the tree is in the range [0, 2000].
        -100 ≤ AddTwoNumbersListNode.val ≤ 100)" << endl;
    }

    static BinaryTreeZigzagLevelOrderTraversalTreeNode *deserializeTree(vector<string> values) {
        BinaryTreeZigzagLevelOrderTraversalTreeNode *root = nullptr;
        if (!values.empty()) {
            queue<BinaryTreeZigzagLevelOrderTraversalTreeNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new BinaryTreeZigzagLevelOrderTraversalTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new BinaryTreeZigzagLevelOrderTraversalTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new BinaryTreeZigzagLevelOrderTraversalTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                BinaryTreeZigzagLevelOrderTraversalTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new BinaryTreeZigzagLevelOrderTraversalTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new BinaryTreeZigzagLevelOrderTraversalTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(BinaryTreeZigzagLevelOrderTraversalTreeNode **head) {
        auto current = *head;
        if (current != nullptr) {
            queue<BinaryTreeZigzagLevelOrderTraversalTreeNode *> working;
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

    static vector<vector<int>> zigzagLevelOrder(BinaryTreeZigzagLevelOrderTraversalTreeNode *root) {
        vector<vector<int>> result{};
        if (root != nullptr) {
            queue<BinaryTreeZigzagLevelOrderTraversalTreeNode *> levelA;
            queue<BinaryTreeZigzagLevelOrderTraversalTreeNode *> levelB;
            levelA.push(root);
            BinaryTreeZigzagLevelOrderTraversalTreeNode *processing;
            while (!levelA.empty() || !levelB.empty()) {
                if (!levelA.empty()) {
                    result.emplace_back();
                    while (!levelA.empty()) {
                        processing = levelA.front();
                        result[result.size() - 1].push_back(processing->val);
                        levelA.pop();
                        if (processing->left != nullptr) {
                            levelB.push(processing->left);
                        }
                        if (processing->right != nullptr) {
                            levelB.push(processing->right);
                        }
                    }
                } else {
                    result.emplace_back();
                    while (!levelB.empty()) {
                        processing = levelB.front();
                        result[result.size() - 1].insert(result[result.size() - 1].begin(), processing->val);
                        levelB.pop();
                        if (processing->left != nullptr) {
                            levelA.push(processing->left);
                        }
                        if (processing->right != nullptr) {
                            levelA.push(processing->right);
                        }
                    }
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop