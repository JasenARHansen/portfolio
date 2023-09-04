#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

struct FlattenBinaryTreeToLinkedListNode {
    int val;
    FlattenBinaryTreeToLinkedListNode *left;
    FlattenBinaryTreeToLinkedListNode *right;

    FlattenBinaryTreeToLinkedListNode() : val(0), left(nullptr), right(nullptr) {}

    explicit FlattenBinaryTreeToLinkedListNode(int x) : val(x), left(nullptr), right(nullptr) {}

    FlattenBinaryTreeToLinkedListNode(int x, FlattenBinaryTreeToLinkedListNode *left,
                                      FlattenBinaryTreeToLinkedListNode *right) : val(x), left(left), right(right) {}
};

class FlattenBinaryTreeToLinkedList {

public:

    static void description() {
        cout << R"(114. Flatten Binary Tree to Linked List
    Given the root of a binary tree, flatten the tree into a "linked list":
        The "linked list" should use the same TreeNode class where the right child pointer points to the next TreeNode in the list and the left child pointer is always null.
        The "linked list" should be in the same order as a pre-order traversal of the binary tree.

    Example 1:
        Input: root = [1,2,5,3,4,null,6]
        Output: [1,null,2,null,3,null,4,null,5,null,6]

    Example 2:
        Input: root = []
        Output: []

    Example 3:
        Input: root = [0]
        Output: [0]

    Constraints:
        The number of nodes in the tree is in the range [0, 2000].
        -100 <= ListNode.val <= 100

    Follow up:
        Can you flatten the tree in-place (with O(1) extra space)?)" << endl;
    }

    static FlattenBinaryTreeToLinkedListNode *deserialize(vector<string> values) {
        FlattenBinaryTreeToLinkedListNode *root = nullptr;
        if (!values.empty()) {
            queue<FlattenBinaryTreeToLinkedListNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new FlattenBinaryTreeToLinkedListNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new FlattenBinaryTreeToLinkedListNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new FlattenBinaryTreeToLinkedListNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                FlattenBinaryTreeToLinkedListNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new FlattenBinaryTreeToLinkedListNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new FlattenBinaryTreeToLinkedListNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static vector<string> serialize(FlattenBinaryTreeToLinkedListNode *head) {
        vector<string> data;
        if (head != nullptr) {
            queue<FlattenBinaryTreeToLinkedListNode *> nodes;
            auto current = head;
            queue<FlattenBinaryTreeToLinkedListNode *> levelA;
            queue<FlattenBinaryTreeToLinkedListNode *> levelB;
            levelA.push(current);
            while (!levelA.empty() || !levelB.empty()) {
                if (!levelA.empty()) {
                    while (!levelA.empty()) {
                        current = levelA.front();
                        levelA.pop();
                        if (current == nullptr) {
                            data.emplace_back("null");
                        } else {
                            data.push_back(to_string((current->val)));
                            if ((current->left != nullptr) || (current->right != nullptr)) {
                                levelB.push(current->left);
                                levelB.push(current->right);
                            }
                        }
                    }
                } else if (!levelB.empty()) {
                    while (!levelB.empty()) {
                        current = levelB.front();
                        levelB.pop();
                        if (current == nullptr) {
                            data.emplace_back("null");
                        } else {
                            data.push_back(to_string((current->val)));
                            if ((current->left != nullptr) || (current->right != nullptr)) {
                                levelA.push(current->left);
                                levelA.push(current->right);
                            }
                        }
                    }
                }
            }
        }
        return data;
    }

    static void deleteTree(FlattenBinaryTreeToLinkedListNode **head) {
        auto current = *head;
        if (current != nullptr) {
            if (current->left != nullptr) {
                deleteTree(&current->left);
            }
            if (current->right != nullptr) {
                deleteTree(&current->right);
            }
            delete current;
        }
        *head = nullptr;
    }

    static void flatten(FlattenBinaryTreeToLinkedListNode *root) {
        if (root != nullptr) {
            stack<FlattenBinaryTreeToLinkedListNode *> branches;
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