#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class CountCompleteTreeNodes {
private:
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

public:
    static void description() {
        cout << R"(222: Count Complete Tree Nodes
    Given the root of a complete binary tree, return the number of the nodes in the tree.
    According to Wikipedia, every level, except possibly the last, is completely filled in a complete
     binary tree, and all nodes in the last level are as far left as possible.
    It can have between 1 and 2h nodes inclusive at the last level h.
    Design an algorithm that runs in less than O(n) time complexity.
    Example 1:
        Input: root = [1, 2, 3, 4, 5, 6]
        Output: 6
    Example 2:
        Input: root = []
        Output: 0
    Example 3:
        Input: root = [1]
        Output: 1
    Constraints:
        The number of nodes in the tree is in the range [0, 5 * 10^4].
        0 ≤ Node.val ≤ 5 * 10^4
        The tree is guaranteed to be complete.)" << endl;
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

    static int countNodes(Node *root) {
        int result = 0;
        if (root != nullptr) {
            result = 1;
            if (root->left != nullptr) {
                result += countNodes(root->left);
            }
            if (root->right != nullptr) {
                result += countNodes(root->right);
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop