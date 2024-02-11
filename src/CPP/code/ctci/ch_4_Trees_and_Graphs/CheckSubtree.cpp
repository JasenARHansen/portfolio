#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include "CheckSubtree.h"
#include <iostream>
#include <queue>

using namespace ctci;

void CheckSubtree::description() {
    std::cout << R"(Trees and Graphs: Check Subtree
    T1 and T2 are two very large binary trees, with T1 much bigger than T2.
    Create an algorithm to determine if T2 is a subtree of T1.
    A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
    That is, if you cut off the tree at node n, the two trees would be identical.)" << std::endl;
}

CheckSubtree::Node *CheckSubtree::generateBSTree(const std::vector<int> &data) {
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

void CheckSubtree::deleteTree(Node **node) {
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

bool CheckSubtree::isSubtreeByData(Node *tree1, Node *tree2) {
    auto result = false;
    if (tree1 != nullptr) {
        if (tree2 == nullptr) {
            result = true;
        } else {
            std::queue<Node *> queueTree1;
            queueTree1.push(tree1);
            Node *nodeTree1;
            while (!queueTree1.empty()) {
                nodeTree1 = queueTree1.front();
                queueTree1.pop();
                if (nodeTree1->data == tree2->data) {
                    result = true;
                    std::queue<Node *> queueBase;
                    queueBase.push(nodeTree1);
                    std::queue<Node *> queueTree2;
                    queueTree2.push(tree2);
                    Node *nodeBase;
                    Node *nodeTree2;
                    while (!queueTree2.empty()) {
                        if (queueBase.empty() or (queueBase.front()->data != queueTree2.front()->data)) {
                            result = false;
                            break;
                        } else {
                            nodeBase = queueBase.front();
                            queueBase.pop();
                            if (nodeBase->leftChild != nullptr) {
                                queueBase.push(nodeBase->leftChild);
                            }
                            if (nodeBase->rightChild != nullptr) {
                                queueBase.push(nodeBase->rightChild);
                            }
                            nodeTree2 = queueTree2.front();
                            queueTree2.pop();
                            if (nodeTree2->leftChild != nullptr) {
                                queueTree2.push(nodeTree2->leftChild);
                            }
                            if (nodeTree2->rightChild != nullptr) {
                                queueTree2.push(nodeTree2->rightChild);
                            }
                        }
                    }
                } else {
                    if (nodeTree1->leftChild != nullptr) {
                        queueTree1.push(nodeTree1->leftChild);
                    }
                    if (nodeTree1->rightChild != nullptr) {
                        queueTree1.push(nodeTree1->rightChild);
                    }
                }
            }
        }
    }
    return result;
}

bool CheckSubtree::isSubtreeByNode(Node *tree1, Node *tree2) {
    auto result = false;
    if (tree1 != nullptr) {
        if (tree2 == nullptr) {
            result = true;
        } else {
            std::queue<Node *> queue;
            queue.push(tree1);
            Node *node;
            while (!queue.empty()) {
                node = queue.front();
                queue.pop();
                if (node == tree2) {
                    result = true;
                    break;
                } else {
                    if (node->leftChild != nullptr) {
                        queue.push(node->leftChild);
                    }
                    if (node->rightChild != nullptr) {
                        queue.push(node->rightChild);
                    }
                }
            }
        }
    }
    return result;
}

#pragma clang diagnostic pop