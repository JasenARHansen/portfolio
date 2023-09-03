#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class AverageOfLevelsInBinaryTree {

public:

    static void description() {
        cout << R"(637. Average of Levels in Binary Tree
    Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

    Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: [3.00000,14.50000,11.00000]
        Explanation:
            The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
            Hence return [3, 14.5, 11].

    Example 2:
        Input: root = [3,9,20,15,7]
        Output: [3.00000,14.50000,11.00000]

    Constraints:
        The number of nodes in the tree is in the range [1, 10^4].
        -2^31 <= Node.val <= 2^31 - 1)" << endl;
    }

    static TreeNode *generateTree(vector<string> values) {
        TreeNode *root = nullptr;
        if (!values.empty()) {
            auto index = 0;
            if (values[index] != "null") {
                queue<TreeNode *> nodes;
                root = new TreeNode(stoi(values[index]));
                index++;
                nodes.push(root);
                TreeNode *temp;
                while (!nodes.empty()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new TreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (values[index] != "null") {
                        temp->right = new TreeNode(stoi(values[index]));
                        nodes.push(temp->right);
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(TreeNode **head) {
        TreeNode *current = *head;
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

    static vector<double> averageOfLevels(TreeNode *root) {
        vector<double> result{};
        if (root != nullptr) {
            queue<TreeNode *> levelA;
            queue<TreeNode *> levelB;
            levelA.push(root);
            long long int sum;
            int count;
            TreeNode *processing;
            while (!levelA.empty() || !levelB.empty()) {
                sum = 0;
                count = 0;
                if (!levelA.empty()) {
                    while (!levelA.empty()) {
                        processing = levelA.front();
                        levelA.pop();
                        sum += processing->val;
                        count++;
                        if (processing->right != nullptr) {
                            levelB.push(processing->right);
                        }
                        if (processing->left != nullptr) {
                            levelB.push(processing->left);
                        }
                    }
                    result.push_back(sum / (double) count);
                } else {
                    while (!levelB.empty()) {
                        processing = levelB.front();
                        levelB.pop();
                        sum += processing->val;
                        count++;
                        if (processing->right != nullptr) {
                            levelA.push(processing->right);
                        }
                        if (processing->left != nullptr) {
                            levelA.push(processing->left);
                        }
                    }
                    result.push_back(sum / (double) count);
                }
            }
        }
        return result;
    }

};

#pragma clang diagnostic pop