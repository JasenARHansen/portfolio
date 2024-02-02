#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <map>
#include <set>
#include <queue>

using namespace std;

class InOrderTraversal {
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
    In this challenge, you are required to implement inorder traversal of a tree.
    Complete the inOrder function in the editor below, which has 1 parameter: a pointer to the root of a binary tree.
    It must print the values in the tree's inorder traversal as a single line of space-separated values.
    Input Format:
        You are given a function, void topView(node * root) {}
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
       1 2 5 6
    Explanation:
        From the top, only nodes 1, 2, 5, 6 are visible.)" << endl;
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

    static void inOrder(Node *root) {
        string output;
        inOrder(root, &output);
        output.erase(output.find_last_not_of(" \n\r\t") + 1);
        cout << output << endl;
    }

    static void inOrder(Node *node, string *output) {
        if (node->left != nullptr) {
            inOrder(node->left, output);
        }
        output->append(to_string(node->data));
        output->append(" ");
        if (node->right != nullptr) {
            inOrder(node->right, output);
        }
    }
};

#pragma clang diagnostic pop