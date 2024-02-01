#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>
#include <map>

using namespace std;


class PrintTreeByColumn {
private:
    class Node {
    public:
        int val;
        Node *left;
        Node *right;

        Node() : val(0), left(nullptr), right(nullptr) {}

        explicit Node(int val) : val(val), left(nullptr), right(nullptr) {}

        Node(int val, Node *left, Node *right) : val(val), left(left), right(right) {}
    };

public:
    static void description() {
        cout << R"(Question 2:
    Given the root of a binary tree containing integers, print each column from left to right, and within each column print the values from top to bottom.
        6
       / \
      3   4
     /   / \
    5   1   0
     \     /
      2   8
     / \
    9   7
    Output:
            5, 9, 3, 2, 6, 1, 7, 4, 8, 0
        5
       / \
      1   8
     /   / \
    6   9   4
     \
      2
       \
        7
    Output:
        6, 1, 2, 5, 9, 7, 8, 4)" << endl;
    }

    static Node *deserialize(vector<string> values) {
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

    static vector<int> order(Node *input) {
        // pair<TreeNode*, col>
        map<int, vector<int>> myMap;
        queue<pair<Node *, int>> processing;
        auto column = 0;
        processing.emplace(input, column);
        while (!processing.empty()) {
            auto working = processing.front();
            processing.pop();
            if (!myMap.count(working.second)) {
                myMap[working.second] = vector<int>();
            }
            myMap.at(working.second).push_back(working.first->val);
            if (working.first->left != nullptr) {
                processing.emplace(working.first->left, working.second - 1);
            }
            if (working.first->right != nullptr) {
                processing.emplace(working.first->right, working.second + 1);
            }
        }
        vector<int> result;
        for (auto key: myMap) {
            // Copying vector by copy function
            copy(key.second.begin(), key.second.end(), back_inserter(result));
        }
        return result;
    }
};

#pragma clang diagnostic pop