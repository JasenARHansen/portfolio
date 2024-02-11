#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#pragma ide diagnostic ignored "misc-no-recursion"

#include "FirstCommonAncestor.h"
#include <iostream>
#include <map>
#include <queue>

using namespace ctci;

void FirstCommonAncestor::description() {
    std::cout << R"(Trees and Graphs: First Common Ancestor
    Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
    Avoid storing additional nodes in a data structure.
    Note: This is not necessarily a binary search tree.)" << std::endl;
}

FirstCommonAncestor::Node *FirstCommonAncestor::generateBSTree(const std::vector<int> &data) {
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

void FirstCommonAncestor::deleteTree(Node **node) {
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

FirstCommonAncestor::Node *FirstCommonAncestor::firstCommonAncestor(Node *head, Node *node1, Node *node2) {
    Node *result = nullptr;
    if (head != nullptr) {
        if (((head == node1) and (treeContains(head, node2))) or ((head == node2) and (treeContains(head, node1)))) {
            result = head;
        } else {
            auto leftContainsNode1 = treeContains(head->leftChild, node1);
            auto leftContainsNode2 = treeContains(head->leftChild, node2);
            if (leftContainsNode1 and leftContainsNode2) {
                result = firstCommonAncestor(head->leftChild, node1, node2);
            } else {
                auto rightContainsNode2 = treeContains(head->rightChild, node2);
                if (leftContainsNode1 and rightContainsNode2) {
                    result = head;
                } else {
                    auto rightContainsNode1 = treeContains(head->rightChild, node1);
                    if (leftContainsNode2 and rightContainsNode1) {
                        result = head;
                    } else if ((rightContainsNode1 and rightContainsNode2)) {
                        result = firstCommonAncestor(head->rightChild, node1, node2);
                    }
                }
            }
        }
    }
    return result;
}

bool FirstCommonAncestor::treeContains(Node *head, Node *target) {
    bool result = false;
    if ((head != nullptr) and (target != nullptr)) {
        Node *working = head;
        std::queue<Node *> processing;
        processing.push(working);
        while (!processing.empty()) {
            working = processing.front();
            processing.pop();
            if (working == target) {
                result = true;
                break;
            }
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