#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>
#include <map>

using namespace std;

class LowestCommonAncestor {
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
        cout << R"(Binary Search Tree : Lowest Common Ancestor
    You are given pointer to the root of the binary search tree and two values v1 and v2.
    You need to return the lowest common ancestor (LCA) of v1 and v2 in the binary search tree.
    Function Description:
        Complete the function lca in the editor below.
        It should return a pointer to the lowest common ancestor node of the two values given.
        lca has the following parameters:
            root: a pointer to the root node of a binary search tree
            v1: a node.data value
            v2: a node.data value
    Input Format:
        The first line contains an integer, n, the number of nodes in the tree.
        The second line contains n space-separated integers representing node.data values.
        The third line contains two space-separated integers, v1 and v2.
        To use the test data, you will have to create the binary search tree yourself.
        Here on the platform, the tree will be created for you.
    Constraints:
        1 ≤ node.data[i] ≤ 25
        1 ≤ v1, v2 ≤ 25
        v1 ≠ v2
        The tree will contain nodes with data equal to v1 and v2.
    Output Format:
        Return the a pointer to the node that is the lowest common ancestor of v1 and v2.
    Sample Input:
        6
        4 2 3 1 7 6
        1 7
              4
            /   \
           2     7
          / \   /
         1   3 6
        v1 = 1 and v2 = 7
    Sample Output:
        [reference to node 4]
    Explanation:
        LCA of 1 and 7 is 4, the root in this case.
        Return a pointer to the node.)" << endl;
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

    static vector<Node *> search(Node *node, int value) {
        vector<Node *> result;
        while (node->data != value) {
            result.push_back(node);
            if (value < node->data) {
                node = node->left;
            } else {
                node = node->right;
            }
        }
        if (node->data == value) {
            result.push_back(node);
        }
        return result;
    }

    static Node *lca(Node *root, int v1, int v2) {
        vector<Node *> v1path = search(root, v1);
        vector<Node *> v2path = search(root, v2);
        auto minimum = min(v1path.size(), v2path.size());
        auto index = 0;
        while ((index < minimum) and (v1path.at(index) == v2path.at(index))) {
            index++;
        }
        return v1path.at(index - 1);
    }

private:
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
};

#pragma clang diagnostic pop