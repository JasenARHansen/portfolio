#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#pragma ide diagnostic ignored "misc-no-recursion"

#include "CheckBalanced.h"
#include <iostream>
#include <map>
#include <queue>

using namespace std;

void CheckBalanced::description() {
    cout << R"(Trees and Graphs: Check Balanced
    Implement a function to check if a binary tree is balanced.
    For the purposes of this question, a balanced tree is defined to be a tree such that the heights of
     the two subtrees of any node never differ by more than one.)" << endl;
}

CheckBalanced::Node *CheckBalanced::generateBSTree(const vector<int> &data) {
    Node *head = nullptr;
    if (!data.empty()) {
        head = new Node(data.at(0));
        for (auto index = 1; index < (int) data.size(); index++) {
            Node *working = head;
            while (true) {
                if (data.at(index) < working->data) {
                    if (working->leftChild == nullptr) {
                        working->leftChild = new Node(data.at(index));
                        break;
                    } else {
                        working = working->leftChild;
                    }
                } else {
                    if (working->rightChild == nullptr) {
                        working->rightChild = new Node(data.at(index));
                        break;
                    } else {
                        working = working->rightChild;
                    }
                }
            }
        }
    }
    return head;
}

void CheckBalanced::deleteTree(Node **node) {
    if (*node != nullptr) {
        queue<Node *> nodes;
        nodes.emplace(*node);
        Node *working;
        while (!nodes.empty()) {
            working = nodes.front();
            nodes.pop();
            if (working->leftChild != nullptr) {
                nodes.emplace(working->leftChild);
            }
            if (working->rightChild != nullptr) {
                nodes.emplace(working->rightChild);
            }
            delete working;
        }
        *node = nullptr;
    }
}

bool CheckBalanced::checkBalanced(Node *node) {
    return checkBalancedHelper(node).first;
}

pair<bool, int> CheckBalanced::checkBalancedHelper(Node *node) {
    pair<bool, int> result = {false, 0};
    if (node == nullptr) {
        result.first = true;
    } else {
        auto left = checkBalancedHelper(node->leftChild);
        if (left.first) {
            auto right = checkBalancedHelper(node->rightChild);
            if (right.first and (abs(left.second - right.second) < 2)) {
                result = {true, max(left.second, right.second) + 1};
            }
        }
    }
    return result;
}

#pragma clang diagnostic pop