#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include "PathsWithSum.h"
#include <iostream>
#include <queue>
#include<numeric>

using namespace ctci;

void PathsWithSum::description() {
    std::cout << R"(Trees and Graphs: Paths with Sum
    You are given a binary tree in which each node contains an integer value (which might be
     positive or negative).
    Design an algorithm to count the number of paths that sum to a given value.
    The path does not need to start or end at the root or a leaf, but it must go downwards
     (traveling only from parent nodes to child nodes).)" << std::endl;
}

PathsWithSum::Node *PathsWithSum::generateBSTree(const std::vector<int> &data) {
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

void PathsWithSum::deleteTree(Node **node) {
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

int PathsWithSum::pathsWithSum(Node *root, int target) {
    std::vector<int> path;
    return pathsWithSum(root, target, path);
}

int PathsWithSum::pathsWithSum(Node *node, int target, std::vector<int> path) {
    auto result = 0;
    if (node != nullptr) {
        path.push_back(node->data);
        auto sum = accumulate(path.begin(), path.end(), 0);
        while ((!path.empty()) and (sum > target)) {
            path.erase(path.begin());
            sum = accumulate(path.begin(), path.end(), 0);
        }
        if (sum == target) {
            result++;
        }
        if (node->leftChild != nullptr) {
            result += pathsWithSum(node->leftChild, target, path);
        }
        if (node->rightChild != nullptr) {
            result += pathsWithSum(node->rightChild, target, path);
        }
    }
    return result;
}

#pragma clang diagnostic pop