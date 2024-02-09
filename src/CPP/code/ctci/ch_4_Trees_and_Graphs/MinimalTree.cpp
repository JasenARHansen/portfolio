#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"

#include "MinimalTree.h"
#include <iostream>
#include <queue>

using namespace std;

void MinimalTree::description() {
    cout << R"(Trees and Graphs: Minimal Tree
    Given a sorted (increasing order) array with unique integer elements, write an algorithm to create
     a binary search tree with minimal height.)" << endl;
}

MinimalTree::Node *MinimalTree::generateMinimalTree(const vector<int> &data) {
    Node *head = nullptr;
    if (!data.empty()) {
        auto middle = ((int) data.size()) / 2;
        head = new Node(data.at(middle));
        vector<int> left = {data.begin(), data.begin() + middle};
        if (!left.empty()) {
            head->leftChild = generateMinimalTree(left);
        }
        vector<int> right = {data.begin() + middle + 1, data.end()};
        if (!right.empty()) {
            head->rightChild = generateMinimalTree(right);
        }
    }
    return head;
}

void MinimalTree::deleteTree(Node **node) {
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

vector<int> MinimalTree::getLevelOrder(Node *node) {
    vector<int> result;
    if (node != nullptr) {
        queue<Node *> processing;
        processing.push(node);
        Node *working;
        while (!processing.empty()) {
            working = processing.front();
            processing.pop();
            result.push_back(working->data);
            if (working->leftChild != nullptr) {
                processing.push(working->leftChild);
            }
            if (working->rightChild != nullptr) {
                processing.push(working->rightChild);
            }
        }
    }
    return result;
}

#pragma clang diagnostic pop