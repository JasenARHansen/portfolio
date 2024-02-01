#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;


class PopulatingNextRightPointersInEachNodeII {
public:
    class Node {
    public:
        int val;
        Node *left;
        Node *right;
        Node *next;

        Node() : val(0), left(nullptr), right(nullptr), next(nullptr) {}

        explicit Node(int val) : val(val), left(nullptr), right(nullptr), next(nullptr) {}

        Node(int val, Node *left, Node *right, Node *next) : val(val), left(left), right(right), next(next) {}
    };

    static void description() {
        cout << R"(117: Populating Next Right Pointers in Each AddTwoNumbersListNode II
    Given a binary tree
        struct AddTwoNumbersListNode {
          int val;
          AddTwoNumbersListNode *left;
          AddTwoNumbersListNode *right;
          AddTwoNumbersListNode *next;
        }
    Populate each next pointer to point to its next right node.
    If there is no next right node, the next pointer should be set to NULL.
    Initially, all next pointers are set to NULL.
    Example 1:
        Input: root = [1, 2, 3, 4, 5, null, 7]
        Output: [1, #, 2, 3, #, 4, 5, 7, #]
        Explanation:
            Given the above binary tree (Figure A), your function should populate each next pointer
             to point to its next right node, just like in Figure B.
            The serialized output is in level order as connected by the next pointers, with '#'
             signifying the end of each level.
    Example 2:
        Input: root = []
        Output: []
    Constraints:
        The number of nodes in the tree is in the range [0, 6000].
        -100 ≤ AddTwoNumbersListNode.val ≤ 100
    Follow-up:
        You may only use constant extra space.
        The recursive approach is fine.
        You may assume implicit stack space does not count as extra space for this problem.)" << endl;
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

    static Node *
    connect(Node *root) {
        Node *result = nullptr;
        if (root != nullptr) {
            result = copyTree(root);
            vector<Node *> oddRow;
            vector<Node *> evenRow;
            oddRow.push_back(result);
            while (!oddRow.empty() || !evenRow.empty()) {
                if (!oddRow.empty()) {
                    for (auto node: oddRow) {
                        if (node->left != nullptr) {
                            evenRow.push_back(node->left);
                        }
                        if (node->right != nullptr) {
                            evenRow.push_back(node->right);
                        }
                    }
                    if (oddRow.size() > 1) {
                        for (auto index = 0; index <= oddRow.size() - 2; index++) {
                            oddRow[index]->next = oddRow[index + 1];
                        }
                    }
                    oddRow.clear();
                } else if (!evenRow.empty()) {
                    for (auto node: evenRow) {
                        if (node->left != nullptr) {
                            oddRow.push_back(node->left);
                        }
                        if (node->right != nullptr) {
                            oddRow.push_back(node->right);
                        }
                    }
                    if (evenRow.size() > 1) {
                        for (auto index = 0; index <= evenRow.size() - 2; index++) {
                            evenRow[index]->next = evenRow[index + 1];
                        }
                    }
                    evenRow.clear();
                }
            }
        }
        return result;
    }

private:
    static Node *
    copyTree(Node *node) {
        Node *result = nullptr;
        if (node != nullptr) {
            result = new Node(node->val);
            result->left = copyTree(node->left);
            result->right = copyTree(node->right);
        }
        return result;
    }
};

#pragma clang diagnostic pop