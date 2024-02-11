#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#pragma ide diagnostic ignored "misc-no-recursion"

#include "ValidateBST.h"
#include <iostream>
#include <queue>

using namespace ctci;

void ValidateBST::description() {
    std::cout << R"(Trees and Graphs: Check Balanced
    Implement a function to check if a binary tree is balanced.
    For the purposes of this question, a balanced tree is defined to be a tree such that the heights of
     the two subtrees of any node never differ by more than one.)" << std::endl;
}

ValidateBST::Node *ValidateBST::generateMinimalTree(const std::vector<int> &data) {
    Node *head = nullptr;
    if (!data.empty()) {
        auto middle = ((int) data.size()) / 2;
        head = new Node(data.at(middle));
        std::vector<int> left = {data.begin(), data.begin() + middle};
        if (!left.empty()) {
            head->leftChild = generateMinimalTree(left);
        }
        std::vector<int> right = {data.begin() + middle + 1, data.end()};
        if (!right.empty()) {
            head->rightChild = generateMinimalTree(right);
        }
    }
    return head;
}

ValidateBST::Node *ValidateBST::generateBSTree(const std::vector<int> &data) {
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

void ValidateBST::deleteTree(Node **node) {
    if (*node != nullptr) {
        std::queue<Node *> nodes;
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

bool ValidateBST::validateBST(Node *node) {
    return validateBSTHelper(node);
}

bool ValidateBST::validateBSTHelper(Node *node) {
    bool left = false;
    bool right = false;
    if (node->leftChild == nullptr) {
        left = true;
    } else {
        if (node->leftChild->data < node->data) {
            left = validateBSTHelper(node->leftChild);
        }
    }
    if (left) {
        if (node->rightChild == nullptr) {
            right = true;
        } else {
            if (node->rightChild->data >= node->data) {
                right = validateBSTHelper(node->rightChild);
            }
        }
    }
    return left and right;
}

#pragma clang diagnostic pop