#pragma clang diagnostic push
#pragma ide diagnostic ignored "ConstantConditionsOC"
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct InvertBinaryTreeNode {
    int val;
    InvertBinaryTreeNode *left;
    InvertBinaryTreeNode *right;

    InvertBinaryTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit InvertBinaryTreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    InvertBinaryTreeNode(int x, InvertBinaryTreeNode *left, InvertBinaryTreeNode *right) : val(x), left(left),
                                                                                           right(right) {}
};

class InvertBinaryTree {
public:
    static void description() {
        cout << R"(226. Invert Binary Tree
    Given the root of a binary tree, invert the tree, and return its root.

    Example 1:
        Input: root = [4,2,7,1,3,6,9]
        Output: [4,7,2,9,6,3,1]

    Example 2:
        Input: root = [2,1,3]
        Output: [2,3,1]

    Example 3:
        Input: root = []
        Output: []

    Constraints:
        The number of nodes in the tree is in the range [0, 100].
        -100 ≤ AddTwoNumbersListNode.val ≤ 100)" << endl;
    }

    static InvertBinaryTreeNode *deserializeTree(vector<string> values) {
        InvertBinaryTreeNode *root = nullptr;
        if (!values.empty()) {
            queue<InvertBinaryTreeNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new InvertBinaryTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new InvertBinaryTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new InvertBinaryTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                InvertBinaryTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new InvertBinaryTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new InvertBinaryTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static vector<string> serializeTree(InvertBinaryTreeNode *head) {
        vector<string> data;
        if (head != nullptr) {
            queue<InvertBinaryTreeNode *> nodes;
            vector<InvertBinaryTreeNode *> levelA;
            vector<InvertBinaryTreeNode *> levelB;
            levelA.push_back(head);
            if (levelA[0]->left != nullptr) {
                levelB.push_back(levelA[0]->left);
            }
            if (levelA[0]->right != nullptr) {
                levelB.push_back(levelA[0]->right);
            }
            data.emplace_back(to_string((levelA[0]->val)));
            bool odd = true;
            while (!levelA.empty() || !levelB.empty()) {
                if (odd) {
                    int indexA = 0;
                    for (int i = 0; i < levelB.size();) {
                        while ((indexA < levelA.size()) && (levelA[indexA]->left != levelB[i]) &&
                               (levelA[indexA]->right != levelB[i])) {
                            data.emplace_back("null");
                            data.emplace_back("null");
                            indexA++;
                        }
                        if (i < levelB.size()) {
                            if (levelA[indexA]->left == levelB[i]) {
                                data.emplace_back(to_string((levelB[i]->val)));
                                i++;
                            } else {
                                data.emplace_back("null");
                            }
                        }
                        if (i < levelB.size()) {
                            if (levelA[indexA]->right == levelB[i]) {
                                data.emplace_back(to_string((levelB[i]->val)));
                                i++;
                            } else {
                                data.emplace_back("null");
                            }
                        }
                        indexA++;
                    }
                    levelA.clear();
                    for (auto &i: levelB) {
                        if (i->left != nullptr) {
                            levelA.push_back(i->left);
                        }
                        if (i->right != nullptr) {
                            levelA.push_back(i->right);
                        }
                    }
                    odd = !odd;
                } else {
                    int indexB = 0;
                    for (int i = 0; i < levelA.size();) {
                        while ((indexB < levelB.size()) && (levelB[indexB]->left != levelA[i]) &&
                               (levelB[indexB]->right != levelA[i])) {
                            data.emplace_back("null");
                            data.emplace_back("null");
                            indexB++;
                        }
                        if (i < levelA.size()) {
                            if (levelB[indexB]->left == levelA[i]) {
                                data.emplace_back(to_string((levelA[i]->val)));
                                i++;
                            } else {
                                data.emplace_back("null");
                            }
                        }
                        if (i < levelA.size()) {
                            if (levelB[indexB]->right == levelA[i]) {
                                data.emplace_back(to_string((levelA[i]->val)));
                                i++;
                            } else {
                                data.emplace_back("null");
                            }
                        }
                        indexB++;
                    }
                    levelB.clear();
                    for (auto &i: levelA) {
                        if (i->left != nullptr) {
                            levelB.push_back(i->left);
                        }
                        if (i->right != nullptr) {
                            levelB.push_back(i->right);
                        }
                    }
                    odd = !odd;
                }
            }
        }
        return data;
    }

    static void deleteTree(InvertBinaryTreeNode **head) {
        auto current = *head;
        if (current != nullptr) {
            queue<InvertBinaryTreeNode *> working;
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

    static InvertBinaryTreeNode *invertTree(InvertBinaryTreeNode *root) {
        InvertBinaryTreeNode *result = nullptr;
        if (root != nullptr) {
            result = new InvertBinaryTreeNode(root->val);
            result->left = invertTree(root->right);
            result->right = invertTree(root->left);
        }
        return result;
    }
};

#pragma clang diagnostic pop