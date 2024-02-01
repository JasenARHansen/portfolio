#pragma clang diagnostic push
#pragma ide diagnostic ignored "ConstantConditionsOC"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class BinaryTree {
private:
    struct Node {
        int data;
        Node *left;
        Node *right;

        explicit Node(int data) : data(data), left(nullptr), right(nullptr) {}
    };

    Node *root;
    int treeSize;
public:
    explicit BinaryTree() : root(nullptr), treeSize(0) {}

    static void description() {
        cout << R"(Question: Binary Tree
    Generate a binary tree with the following methods:
        insert(data)
        print_inorder()
        contains()
        size()
        min()
        max())" << endl;
    }

    void insert(int data) {
        if (this->root == nullptr) {
            this->root = new Node(data);
        } else {
            // TODO: finish
            auto working = this->root;
            if (true) {
            }
        }
    }

    vector<string> serializeTree() {
        vector<string> data;
        if (this->root != nullptr) {
            queue<Node *> nodes;
            vector<Node *> levelA;
            vector<Node *> levelB;
            levelA.push_back(this->root);
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

    void deleteTree() {
        auto current = this->root;
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
        this->root = nullptr;
    }

    [[nodiscard]] int size() const {
        return this->treeSize;
    }
};

#pragma clang diagnostic pop