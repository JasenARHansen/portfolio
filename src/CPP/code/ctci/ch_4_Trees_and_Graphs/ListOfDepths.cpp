#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include "ListOfDepths.h"
#include <iostream>
#include <queue>

using namespace ctci;

void ListOfDepths::description() {
    std::cout << R"(Trees and Graphs: List of Depths
    Given a binary tree, design an algorithm which creates a linked list of all the nodes
     at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).)" << std::endl;
}

ListOfDepths::Node *ListOfDepths::generateBSTree(const std::vector<int> &data) {
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

void ListOfDepths::deleteTree(Node **node) {
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

std::vector<std::vector<int>> ListOfDepths::getListOfDepths(Node *node) {
    std::vector<std::vector<int>> result;
    if (node != nullptr) {
        std::queue<std::pair<int, Node *>> processing;
        processing.emplace(0, node);
        std::pair<int, Node *> working;
        while (!processing.empty()) {
            working = processing.front();
            processing.pop();
            if (result.size() < working.first + 1) {
                result.emplace_back();
            }
            result.at(working.first).push_back(working.second->data);
            if (working.second->leftChild != nullptr) {
                processing.emplace(working.first + 1, working.second->leftChild);
            }
            if (working.second->rightChild != nullptr) {
                processing.emplace(working.first + 1, working.second->rightChild);
            }
        }
    }
    return result;
}

#pragma clang diagnostic pop