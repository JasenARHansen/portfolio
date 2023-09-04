#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;

struct SumRootToLeafNumbersTreeNode {
    int val;
    SumRootToLeafNumbersTreeNode *left;
    SumRootToLeafNumbersTreeNode *right;

    SumRootToLeafNumbersTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit SumRootToLeafNumbersTreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    SumRootToLeafNumbersTreeNode(int x, SumRootToLeafNumbersTreeNode *left, SumRootToLeafNumbersTreeNode *right) : val(
            x), left(left), right(right) {}
};

class SumRootToLeafNumbers {

public:

    static void description() {
        cout << R"(129. Sum Root to Leaf Numbers
    You are given the root of a binary tree containing digits from 0 to 9 only.
    Each root-to-leaf path in the tree represents a number.
        For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
    Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
    A leaf node is a node with no children.

    Example 1:
        Input: root = [1,2,3]
        Output: 25
        Explanation:
            The root-to-leaf path 1->2 represents the number 12.
            The root-to-leaf path 1->3 represents the number 13.
            Therefore, sum = 12 + 13 = 25.

    Example 2:
        Input: root = [4,9,0,5,1]
        Output: 1026
        Explanation:
            The root-to-leaf path 4->9->5 represents the number 495.
            The root-to-leaf path 4->9->1 represents the number 491.
            The root-to-leaf path 4->0 represents the number 40.
            Therefore, sum = 495 + 491 + 40 = 1026.

    Constraints:
        The number of nodes in the tree is in the range [1, 1000].
        0 <= Node.val <= 9
        The depth of the tree will not exceed 10.)" << endl;
    }

    static SumRootToLeafNumbersTreeNode *deserialize(vector<string> values) {
        SumRootToLeafNumbersTreeNode *root = nullptr;
        if (!values.empty()) {
            queue < SumRootToLeafNumbersTreeNode * > nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new SumRootToLeafNumbersTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new SumRootToLeafNumbersTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new SumRootToLeafNumbersTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                SumRootToLeafNumbersTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new SumRootToLeafNumbersTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new SumRootToLeafNumbersTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static void deleteTree(SumRootToLeafNumbersTreeNode **head) {
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

    static int sumNumbers(SumRootToLeafNumbersTreeNode *root) {
        int result = 0;
        auto numbers = traverseTree(root);
        for (auto digits: numbers) {
            int sum = 0;
            for (int index = 0; index < digits.size(); index++) {
                sum += digits[index] * (int) pow(10, index);
            }
            result += sum;
        }
        return result;
    }

private:
    static vector<vector<int>> traverseTree(SumRootToLeafNumbersTreeNode *node) {
        vector <vector<int>> result;
        if (node != nullptr) {
            if ((node->left == nullptr) && (node->right == nullptr)) {
                result.push_back(vector < int > {node->val});
            } else {
                vector <vector<int>> left = traverseTree(node->left);
                vector <vector<int>> right = traverseTree(node->right);
                for (auto digits: left) {
                    digits.push_back(node->val);
                    result.push_back(digits);
                }
                for (auto digits: right) {
                    digits.push_back(node->val);
                    result.push_back(digits);
                }
            }
        }
        return result;
    }

};

#pragma clang diagnostic pop