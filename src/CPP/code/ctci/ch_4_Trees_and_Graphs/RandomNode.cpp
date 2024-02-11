#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#pragma ide diagnostic ignored "cert-msc50-cpp"
#pragma ide diagnostic ignored "cert-msc51-cpp"

#include "RandomNode.h"
#include <iostream>
#include <queue>
#include <ctime>

using namespace ctci;

void RandomNode::description() {
    std::cout << R"(Trees and Graphs: Random Node
    You are implementing a binary tree class from scratch which, in addition to insert, find,
     and delete, has a method getRandomNode() which returns a random node from the tree.
    All nodes should be equally likely to be chosen.
    Design and implement an algorithm for getRandomNode, and explain how you would implement
     the rest of the methods.)" << std::endl;
}

void RandomNode::generateBSTree(const std::vector<int> &data) {
    this->root = nullptr;
    if (!data.empty()) {
        for (auto element: data) {
            this->insert(element);
        }
    }
}

void RandomNode::insert(int data) {
    if (this->root == nullptr) {
        this->root = new Node(data);
    } else {
        Node *working = this->root;
        while (true) {
            working->size++;
            if (data < working->data) {
                if (working->leftChild == nullptr) {
                    working->leftChild = new Node(data);
                    break;
                } else {
                    working = working->leftChild;
                }
            } else {
                if (working->rightChild == nullptr) {
                    working->rightChild = new Node(data);
                    break;
                } else {
                    working = working->rightChild;
                }
            }
        }
    }
}

void RandomNode::deleteTree() {
    if (this->root != nullptr) {
        std::queue<Node *> nodes;
        nodes.emplace(this->root);
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
        this->root = nullptr;
    }
}

RandomNode::Node *RandomNode::getRandomNode() {
    Node *result = nullptr;
    srand(time(nullptr));
    auto randomValue = rand() % this->root->size + 1;
    bool notAdvanced;
    Node *working = this->root;
    while (working != nullptr) {
        notAdvanced = true;
        if (randomValue != working->size) {
            if (working->leftChild != nullptr) {
                if (randomValue <= working->leftChild->size) {
                    working = working->leftChild;
                    notAdvanced = false;
                } else {
                    randomValue -= working->leftChild->size;
                }
            }
            if (notAdvanced and (working->rightChild != nullptr)) {
                working = working->rightChild;
            }
        } else {
            result = working;
            break;
        }
    }
    return result;
}

#pragma clang diagnostic pop