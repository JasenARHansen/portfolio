#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <map>
#include <set>
#include <queue>

using namespace std;

class LevelOrderTraversal {
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
        cout << R"(Tree: Level Order Traversal
    Given a pointer to the root of a binary tree, you need to print the level order traversal of this tree.
    In level-order traversal, nodes are visited level by level from left to right.
    Complete the function levelOrder and print the values in a single line separated by a space.
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
    For the above tree, the level order traversal is 1 → 2 → 5 → 3 → 6 → 4.
    Input Format:
        You are given a function,
            void levelOrder(Node * root) {}
    Constraints:
        1 ≤ nodes in tree ≤ 500
    Output Format:
            Print the values in a single line separated by a space.
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
        1 2 5 3 6 4
    Explanation:
        We need to print the nodes level by level.
        We process each level from left to right.
        Level Order Traversal: 1 → 2 → 5 → 3 → 6 → 4.)" << endl;
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

    static void levelOrder(Node *root) {
        queue<Node *> order;
        order.push(root);
        string out;
        while (!order.empty()) {
            out.append(to_string(order.front()->data)).append(" ");
            if (order.front()->left != nullptr) {
                order.push(order.front()->left);
            }
            if (order.front()->right != nullptr) {
                order.push(order.front()->right);
            }
            order.pop();
        }
        out.erase(out.find_last_not_of(" \n\r\t") + 1);
        cout << out << endl;
    }
};

#pragma clang diagnostic pop