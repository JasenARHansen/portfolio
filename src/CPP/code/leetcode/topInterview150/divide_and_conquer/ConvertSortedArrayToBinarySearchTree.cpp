#pragma clang diagnostic push
#pragma ide diagnostic ignored "ConstantConditionsOC"
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <cmath>
#include <queue>

using namespace std;

class ConvertSortedArrayToBinarySearchTreeNode {
public:
    int val;
    ConvertSortedArrayToBinarySearchTreeNode *left;
    ConvertSortedArrayToBinarySearchTreeNode *right;

    ConvertSortedArrayToBinarySearchTreeNode() : val(0), left(nullptr), right(nullptr) {}

    explicit ConvertSortedArrayToBinarySearchTreeNode(int val) : val(val), left(nullptr), right(nullptr) {}

    ConvertSortedArrayToBinarySearchTreeNode(int val, ConvertSortedArrayToBinarySearchTreeNode *left,
                                             ConvertSortedArrayToBinarySearchTreeNode *right) : val(val),
                                                                                                left(left),
                                                                                                right(right) {}
};

class ConvertSortedArrayToBinarySearchTree {

public:

    static void description() {
        cout << R"(108. Convert Sorted Array to Binary Search Tree
    Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

    Example 1:
        Input: nums = [-10,-3,0,5,9]
        Output: [0,-3,9,-10,null,5]
        Explanation:
            [0,-10,5,null,-3,null,9] is also accepted:

    Example 2:
        Input: nums = [1,3]
        Output: [3,1]
        Explanation:
            [1,null,3] and [3,1] are both height-balanced BSTs.

    Constraints:
        1 <= nums.length <= 10^4
        -10^4 <= nums[i] <= 10^4
        nums is sorted in a strictly increasing order.)" << endl;
    }

    static ConvertSortedArrayToBinarySearchTreeNode *deserialize(vector<string> values) {
        ConvertSortedArrayToBinarySearchTreeNode *root = nullptr;
        if (!values.empty()) {
            queue<ConvertSortedArrayToBinarySearchTreeNode *> nodes;
            auto index = 0;
            if (values[index] != "null") {
                root = new ConvertSortedArrayToBinarySearchTreeNode(stoi(values[index]));
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->left = new ConvertSortedArrayToBinarySearchTreeNode(stoi(values[index]));
                        nodes.push(root->left);
                    }
                }
                index++;
                if (index < values.size()) {
                    if (values[index] != "null") {
                        root->right = new ConvertSortedArrayToBinarySearchTreeNode(stoi(values[index]));
                        nodes.push(root->right);
                    }
                }
                index++;
                ConvertSortedArrayToBinarySearchTreeNode *temp;
                while (index < values.size()) {
                    temp = nodes.front();
                    nodes.pop();
                    if (values[index] != "null") {
                        temp->left = new ConvertSortedArrayToBinarySearchTreeNode(stoi(values[index]));
                        nodes.push(temp->left);
                    }
                    index++;
                    if (index < values.size()) {
                        if (values[index] != "null") {
                            temp->right = new ConvertSortedArrayToBinarySearchTreeNode(stoi(values[index]));
                            nodes.push(temp->right);
                        }
                    }
                    index++;
                }
            }
        }
        return root;
    }

    static vector<string> serializeTree(ConvertSortedArrayToBinarySearchTreeNode *head) {
        vector<string> data;
        if (head != nullptr) {
            queue<ConvertSortedArrayToBinarySearchTreeNode *> nodes;
            vector<ConvertSortedArrayToBinarySearchTreeNode *> levelA;
            vector<ConvertSortedArrayToBinarySearchTreeNode *> levelB;
            levelA.push_back(head);
            if (levelA[0]->left != nullptr) {
                levelB.push_back(levelA[0]->left);

            }
            if (levelA[0]->right != nullptr) {
                levelB.push_back(levelA[0]->right);
            }
            data.emplace_back(to_string((levelA[0]->val)));
            bool odd = true;
            while (!levelA.empty() || !levelB.empty()) {
                if (odd) {
                    int indexA = 0;
                    for (int i = 0; i < levelB.size();) {
                        while ((indexA < levelA.size()) && (levelA[indexA]->left != levelB[i]) &&
                               (levelA[indexA]->right != levelB[i])) {
                            data.emplace_back("null");
                            data.emplace_back("null");
                            indexA++;
                        }
                        if (i < levelB.size()) {
                            if (levelA[indexA]->left == levelB[i]) {
                                data.emplace_back(to_string((levelB[i]->val)));
                                i++;
                            } else {
                                data.emplace_back("null");
                            }
                        }
                        if (i < levelB.size()) {
                            if (levelA[indexA]->right == levelB[i]) {
                                data.emplace_back(to_string((levelB[i]->val)));
                                i++;
                            } else {
                                data.emplace_back("null");
                            }
                        }
                        indexA++;
                    }
                    levelA.clear();
                    for (auto &i: levelB) {
                        if (i->left != nullptr) {
                            levelA.push_back(i->left);
                        }
                        if (i->right != nullptr) {
                            levelA.push_back(i->right);
                        }
                    }
                    odd = !odd;
                } else {
                    int indexB = 0;
                    for (int i = 0; i < levelA.size();) {
                        while ((indexB < levelB.size()) && (levelB[indexB]->left != levelA[i]) &&
                               (levelB[indexB]->right != levelA[i])) {
                            data.emplace_back("null");
                            data.emplace_back("null");
                            indexB++;
                        }
                        if (i < levelA.size()) {
                            if (levelB[indexB]->left == levelA[i]) {
                                data.emplace_back(to_string((levelA[i]->val)));
                                i++;
                            } else {
                                data.emplace_back("null");
                            }
                        }
                        if (i < levelA.size()) {
                            if (levelB[indexB]->right == levelA[i]) {
                                data.emplace_back(to_string((levelA[i]->val)));
                                i++;
                            } else {
                                data.emplace_back("null");
                            }
                        }
                        indexB++;
                    }
                    levelB.clear();
                    for (auto &i: levelA) {
                        if (i->left != nullptr) {
                            levelB.push_back(i->left);
                        }
                        if (i->right != nullptr) {
                            levelB.push_back(i->right);
                        }
                    }
                    odd = !odd;
                }
            }
        }
        return data;
    }

    static void deleteTree(ConvertSortedArrayToBinarySearchTreeNode **head) {
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

    static ConvertSortedArrayToBinarySearchTreeNode *sortedArrayToBST(vector<int> &nums) {
        assert (!nums.empty());
        assert (nums.size() <= pow(10, 4));
        ConvertSortedArrayToBinarySearchTreeNode *result = sortedArrayToBST(nums, 0, (int) nums.size() - 1);
        return result;
    }

private:

    static ConvertSortedArrayToBinarySearchTreeNode *
    sortedArrayToBST(vector<int> &nums, int leftIndex, int rightIndex) {
        ConvertSortedArrayToBinarySearchTreeNode *result = nullptr;
        if (0 <= (rightIndex - leftIndex)) {
            int midpoint = leftIndex + (rightIndex - leftIndex + 1) / 2;
            assert(-pow(10, 4) <= nums.at(midpoint));
            assert(nums.at(midpoint) <= pow(10, 4));
            result = new ConvertSortedArrayToBinarySearchTreeNode(nums.at(midpoint));
            result->left = sortedArrayToBST(nums, leftIndex, midpoint - 1);
            result->right = sortedArrayToBST(nums, midpoint + 1, rightIndex);
        }
        return result;
    }
};

#pragma clang diagnostic pop