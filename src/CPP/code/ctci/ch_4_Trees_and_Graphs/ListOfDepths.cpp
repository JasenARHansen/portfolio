#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#pragma ide diagnostic ignored "misc-no-recursion"

#include "ListOfDepths.h"
#include <iostream>
#include <map>
#include <queue>

using namespace std;

void ListOfDepths::description() {
    cout << R"(Trees and Graphs: List of Depths
    Given a binary tree, design an algorithm which creates a linked list of all the nodes
     at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).)" << endl;
}

ListOfDepths::Node *ListOfDepths::generateBSTree(const vector<int> &data) {
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

vector<vector<int>> ListOfDepths::getListOfDepths(Node *node) {
    vector<vector<int>> result;
    if (node != nullptr) {
        queue<pair<int, Node *>> processing;
        processing.emplace(0, node);
        pair<int, Node *> working;
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