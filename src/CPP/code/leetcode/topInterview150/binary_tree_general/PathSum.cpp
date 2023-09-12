#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct PathSumTreeNode {
    int val;
    PathSumTreeNode *left;
    PathSumTreeNode *right;

    PathSumTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit PathSumTreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    PathSumTreeNode(int x, PathSumTreeNode *left, PathSumTreeNode *right) : val(x), left(left), right(right) {}
};

class PathSum {

public:

    static void description() {
        cout << R"(112. Path Sum
    Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
    A leaf is a node with no children.

    Example 1:
        Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        Output: true
        Explanation:
            The root-to-leaf path with the target sum is shown.

    Example 2:
        Input: root = [1,2,3], targetSum = 5
        Output: false
        Explanation:
            There two root-to-leaf paths in the tree:
            (1 --> 2): The sum is 3.
            (1 --> 3): The sum is 4.
            There is no root-to-leaf path with sum = 5.

    Example 3:
        Input: root = [], targetSum = 0
        Output: false
        Explanation:
            Since the tree is empty, there are no root-to-leaf paths.


    Constraints:
        The number of nodes in the tree is in the range [0, 5000].
        -1000 ≤ AddTwoNumbersListNode.val ≤ 1000
        -1000 ≤ targetSum ≤ 1000)" << endl;
    }

    static PathSumTreeNode *deserializeTree(vector<string> values) {
        PathSumTreeNode *root = nullptr;
        if (!values.empty()) {
            queue<PathSumTreeNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new PathSumTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new PathSumTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new PathSumTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                PathSumTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new PathSumTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new PathSumTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(PathSumTreeNode **head) {
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

    static bool hasPathSum(PathSumTreeNode *root, int targetSum) {
        bool result = false;
        bool left = false;
        bool right = false;
        if (root != nullptr) {
            if (root->left != nullptr) {
                left = hasPathSum(root->left, targetSum - root->val);
            }
            if (root->right != nullptr) {
                right = hasPathSum(root->right, targetSum - root->val);
            }
            if ((root->left == nullptr) && (root->right == nullptr)) {
                result = targetSum == root->val;
            }
        }
        return result || left || right;
    }

};

#pragma clang diagnostic pop