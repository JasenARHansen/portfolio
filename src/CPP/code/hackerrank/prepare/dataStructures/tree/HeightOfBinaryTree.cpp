#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>
#include <map>

using namespace std;

class HeightOfBinaryTree {
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
        cout << R"(Tree: Height of a Binary Tree
    The height of a binary tree is the number of edges between the tree's root and its furthest leaf.
    For example, the following binary tree is of height 2:
              4
            /   \
           2     6
          / \   / \
         1   3 5   7
    Function Description:
        Complete the getHeight or height function in the editor.
        It must return the height of a binary tree as an integer.
        getHeight or height has the following parameter(s):
            root: a reference to the root of a binary tree.
        Note: The Height of binary tree with single node is taken as zero.
    Input Format:
        The first line contains an integer n, the number of nodes in the tree.
        Next line contains n space separated integer where ith integer denotes node[i].data.
        Note: Node values are inserted into a binary search tree before a reference to the tree's root node is
         passed to your function.
        In a binary search tree, all nodes on the left branch of a node are less than the node value.
        All values on the right branch are greater than the node value.
    Constraints:
        1 ≤ node.data[i] ≤ 20
        1 ≤ n ≤ 20
    Output Format:
        Your function should return a single integer denoting the height of the binary tree.
    Sample Input:
          3
        /   \
       2     5
      /     / \
     1     4   6
                \
                 7
    Sample Output:
        3
    Explanation:
        The longest root-to-leaf path is shown below:
              3
            /   \\
           2     5
          /     / \\
         1     4   6
                    \\
                     7
    There are 4 nodes in this path that are connected by 3 edges, meaning our binary tree's height = 3.)" << endl;
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

    static int height(Node *root) {
        auto left = 0;
        auto right = 0;
        if (root->left != nullptr) {
            left = 1 + height(root->left);
        }
        if (root->right != nullptr) {
            right = 1 + height(root->right);
        }
        return max(left, right);
    }
};

#pragma clang diagnostic pop