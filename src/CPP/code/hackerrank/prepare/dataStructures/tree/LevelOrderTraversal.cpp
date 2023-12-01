#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <map>
#include <set>
#include <queue>

using namespace std;


class LevelOrderTraversal {

public:
    static void description() {
        cout << R"(Given a pointer to the root of a binary tree, you need to print the level order
     traversal of this tree.
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

    For the above tree, the level order traversal is 1 -> 2 -> 5 -> 3 -> 6 -> 4.

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
        We need to print the nodes level by level. We process each level from left to right.
        Level Order Traversal: 1 -> 2 -> 5 -> 3 -> 6 -> 4.)" << endl;
    }

    class Node {
    public:
        int data;
        Node *left;
        Node *right;

        explicit Node(int d) {
            data = d;
            left = nullptr;
            right = nullptr;
        }
    };

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