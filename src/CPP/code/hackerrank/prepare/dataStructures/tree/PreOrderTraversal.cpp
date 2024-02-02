#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <map>
#include <set>
#include <queue>

using namespace std;

class PreOrderTraversal {
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
        cout << R"(Tree: Preorder Traversal
    Complete the preOrder function in the editor below, which has 1 parameter: a pointer to the root of a binary tree.
    It must print the values in the tree's preorder traversal as a single line of space-separated values.
    Input Format:
        Our test code passes the root node of a binary tree to the preOrder function.
    Constraints:
        1 ≤ nodes in tree ≤ 500
    Output Format:
        Print the tree's preorder traversal as a single line of space-separated values.
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
        1 2 5 3 4 6
    Explanation:
        The preorder traversal of the binary tree is printed.)" << endl;
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

    static void preOrder(Node *root) {
        string output;
        preOrder(root, &output);
        output.erase(output.find_last_not_of(" \n\r\t") + 1);
        cout << output << endl;
    }

    static void preOrder(Node *node, string *output) {
        output->append(to_string(node->data));
        output->append(" ");
        if (node->left != nullptr) {
            preOrder(node->left, output);
        }
        if (node->right != nullptr) {
            preOrder(node->right, output);
        }
    }
};

#pragma clang diagnostic pop