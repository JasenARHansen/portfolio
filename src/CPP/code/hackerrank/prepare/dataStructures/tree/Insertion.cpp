#pragma clang diagnostic push
#pragma ide diagnostic ignored "ConstantConditionsOC"
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <map>
#include <set>
#include <queue>

using namespace std;

class Insertion {
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
        cout << R"(Binary Search Tree: Insertion
    You are given a pointer to the root of a binary search tree and values to be inserted into the tree.
    Insert the values into their appropriate position in the binary search tree and return the root of the
     updated binary tree.
    You just have to complete the function.
    Input Format:
        You are given a function, Node * insert (Node * root ,int data) {}
    Constraints:
        1 ≤ nodes in tree ≤ 500
    Output Format:
        Return the root of the binary search tree after inserting the value into the tree.
    Sample Input:
            4
           / \
          2   7
         / \
        1   3
        The value to be inserted is 6.
        Sample Output:
             4
           /   \
          2     7
         / \   /
        1   3 6)" << endl;
    }

    static vector<string> serializeTree(Node *head) {
        vector<string> data;
        if (head != nullptr) {
            queue<Node *> nodes;
            vector<Node *> levelA;
            vector<Node *> levelB;
            levelA.push_back(head);
            if (levelA[0]->left != nullptr) {
                levelB.push_back(levelA[0]->left);
            }
            if (levelA[0]->right != nullptr) {
                levelB.push_back(levelA[0]->right);
            }
            data.emplace_back(to_string((levelA[0]->data)));
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
                                data.emplace_back(to_string((levelB[i]->data)));
                                i++;
                            } else {
                                data.emplace_back("null");
                            }
                        }
                        if (i < levelB.size()) {
                            if (levelA[indexA]->right == levelB[i]) {
                                data.emplace_back(to_string((levelB[i]->data)));
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
                                data.emplace_back(to_string((levelA[i]->data)));
                                i++;
                            } else {
                                data.emplace_back("null");
                            }
                        }
                        if (i < levelA.size()) {
                            if (levelB[indexB]->right == levelA[i]) {
                                data.emplace_back(to_string((levelA[i]->data)));
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

    static Node *insert(Node *root, int data) {
        auto result = root;
        if (root == nullptr) {
            result = new Node(data);
        } else {
            if (data <= root->data) {
                if (root->left == nullptr) {
                    root->left = new Node(data);
                } else {
                    insert(root->left, data);
                }
            } else {
                if (root->right == nullptr) {
                    root->right = new Node(data);
                } else {
                    insert(root->right, data);
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop