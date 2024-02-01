#pragma clang diagnostic push
#pragma ide diagnostic ignored "ConstantConditionsOC"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

class FlattenBinaryTreeToLinkedList {
private:
    struct Node {
        int val;
        Node *left;
        Node *right;

        Node() : val(0), left(nullptr), right(nullptr) {}

        explicit Node(int x) : val(x), left(nullptr), right(nullptr) {}

        Node(int x, Node *left,
             Node *right) : val(x), left(left),
                            right(right) {}
    };

public:
    static void description() {
        cout << R"(114: Flatten Binary Tree to Linked List
    Given the root of a binary tree, flatten the tree into a "linked list":
        The "linked list" should use the same TreeNode class where the right child pointer points to the next TreeNode in the list and the left child pointer is always null.
        The "linked list" should be in the same order as a pre-order traversal of the binary tree.
    Example 1:
        Input: root = [1, 2, 5, 3, 4, null, 6]
        Output: [1, null, 2, null, 3, null, 4, null, 5, null, 6]
    Example 2:
        Input: root = []
        Output: []
    Example 3:
        Input: root = [0]
        Output: [0]
    Constraints:
        The number of nodes in the tree is in the range [0, 2000].
        -100 ≤ AddTwoNumbersListNode.val ≤ 100
    Follow up:
        Can you flatten the tree in-place (with O(1) extra space)?)" << endl;
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

    static vector<string> serializeTree(Node *head) {
        vector<string> data;
        if (head != nullptr) {
            queue<Node *> nodes;
            vector<Node *> levelA;
            vector<Node *> levelB;
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

    static void flatten(Node *root) {
        if (root != nullptr) {
            stack<Node *> branches;
            if (root->right != nullptr) {
                branches.push(root->right);
            }
            root->right = root->left;
            root->left = nullptr;
            auto current = root;
            while ((current->right != nullptr) || (current->left != nullptr) || !branches.empty()) {
                if (current->right != nullptr) {
                    current = current->right;
                }
                if (current->right != nullptr) {
                    branches.push(current->right);
                }
                current->right = current->left;
                current->left = nullptr;
                if ((current->right == nullptr) && !branches.empty()) {
                    current->right = branches.top();
                    branches.pop();
                }
            }
        }
    }
};

#pragma clang diagnostic pop