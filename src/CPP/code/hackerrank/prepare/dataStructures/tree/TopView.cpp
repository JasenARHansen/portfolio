#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <map>
#include <set>
#include <queue>

using namespace std;

class TopView {
private:
    class Node {
    public:
        int data;
        Node *left;
        Node *right;

        explicit Node(int d) : data(d), left(nullptr), right(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Tree: Inorder Traversal
    Given a pointer to the root of a binary tree, print the top view of the binary tree.
    The tree as seen from the top the nodes, is called the top view of the tree.
    For example:
         1
          \
           2
            \
             5
            /  \
           3    6
            \
             4
    Top View: 1 → 2 → 5 → 6
    Complete the function topView and print the resulting values on a single line separated by space.
    Input Format:
        Our test code passes the root node of a binary tree to the inOrder function.
    Constraints:
        1 ≤ nodes in tree ≤ 500
    Output Format:
        Print the tree's inorder traversal as a single line of space-separated values.
    Sample Input:
         1
          \
           2
            \
             5
            /  \
           3    6
            \
             4
    Sample Output:
        1 2 3 4 5 6
    Explanation:
        The tree's inorder traversal results in 1 2 3 4 5 6 as the required result.)" << endl;
    }

    static Node *deserializeTree(vector<int> values) {
        Node *root = nullptr;
        if (!values.empty()) {
            root = new Node(values[0]);
            for (auto index = 1; index < values.size(); index++) {
                insert(root, values[index]);
            }
        }
        return root;
    }

    static void insert(Node *node, int value) {
        if (value <= node->data) {
            if (node->left == nullptr) {
                node->left = new Node(value);
            } else {
                insert(node->left, value);
            }
        } else {
            if (node->right == nullptr) {
                node->right = new Node(value);
            } else {
                insert(node->right, value);
            }
        }
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

    static void topView(Node *root) {
        map<int, int> seen;
        queue<pair<Node *, int>> process;
        process.emplace(root, 0);
        while (!process.empty()) {
            if (!seen.count(process.front().second)) {
                seen[process.front().second] = process.front().first->data;
            }
            if (process.front().first->left != nullptr) {
                process.emplace(process.front().first->left, process.front().second - 1);
            }
            if (process.front().first->right != nullptr) {
                process.emplace(process.front().first->right, process.front().second + 1);
            }
            process.pop();
        }
        string output;
        for (auto element: seen) {
            output.append(to_string(element.second)).append(" ");
        }
        output.erase(output.find_last_not_of(" \n\r\t") + 1);
        cout << output << endl;
    }
};

#pragma clang diagnostic pop