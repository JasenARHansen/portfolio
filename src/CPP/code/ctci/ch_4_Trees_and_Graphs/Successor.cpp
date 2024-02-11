#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include "Successor.h"
#include <iostream>
#include <queue>

using namespace ctci;

void Successor::description() {
    std::cout << R"(Trees and Graphs: Successor
    Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
     binary search tree.
    You may assume that each node has a link to its parent.)" << std::endl;
}

Successor::Node *Successor::generateBSTree(const std::vector<int> &data) {
    Node *head = nullptr;
    if (!data.empty()) {
        head = new Node(data.at(0));
        for (auto index = 1; index < (int) data.size(); index++) {
            Node *working = head;
            while (true) {
                if (data.at(index) < working->data) {
                    if (working->leftChild == nullptr) {
                        working->leftChild = new Node(data.at(index));
                        working->leftChild->parent = working;
                        break;
                    } else {
                        working = working->leftChild;
                    }
                } else {
                    if (working->rightChild == nullptr) {
                        working->rightChild = new Node(data.at(index));
                        working->rightChild->parent = working;
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

void Successor::deleteTree(Node **node) {
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

Successor::Node *Successor::inorderSuccessor(Node *node) {
    // The inorder successor would be the left most node of the right child or the parent if there is no left child
    Node *result;
    if (node->rightChild != nullptr) {
        result = node->rightChild;
        while (result->leftChild != nullptr) {
            result = result->leftChild;
        }
    } else {
        result = node->parent;
    }
    return result;
}

Successor::Node *Successor::inorderSuccessor(Node *root, int data) {
    Node *working = root;
    while ((working != nullptr) and (working->data != data)) {
        if (working->data > data) {
            working = working->leftChild;
        } else {
            working = working->rightChild;
        }
    }
    return inorderSuccessor(working);
}

#pragma clang diagnostic pop