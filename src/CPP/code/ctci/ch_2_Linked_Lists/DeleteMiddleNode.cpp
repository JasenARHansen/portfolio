#include "DeleteMiddleNode.h"
#include <iostream>

using namespace ctci;

void DeleteMiddleNode::description() {
    std::cout << R"(Linked Lists: Delete Middle Node
    Implement an algorithm to delete a node in the middle (i.e., any node but the first and last
     node, not necessarily the exact middle) of a singly linked list, given only access to that node.
    Example:
        Input: the node c from the linked list a → b → c → d → e → f
        Result: nothing is returned, but the new linked list looks like a → b → d → e → f)" << std::endl;
}

DeleteMiddleNode::Node *DeleteMiddleNode::generateList(std::vector<int> data) {
    Node *head = nullptr;
    if (!data.empty()) {
        head = new Node(data.at(0));
        auto current = head;
        for (auto index = 1; index < (int) data.size(); index++) {
            current->next = new Node(data.at(index));
            current = current->next;
        }
    }
    return head;
}

void DeleteMiddleNode::deleteList(Node **head) {
    auto current = *head;
    Node *next;
    while (current != nullptr) {
        next = current->next;
        delete current;
        current = next;
    }
    *head = nullptr;
}

std::vector<int> DeleteMiddleNode::getList(Node *head) {
    std::vector<int> result;
    auto current = head;
    while (current != nullptr) {
        result.push_back(current->data);
        current = current->next;
    }
    return result;
}

void DeleteMiddleNode::deleteMiddleNodeByValue(Node *head, int value) {
    if ((head != nullptr) and (head->next != nullptr)) {
        auto working = head;
        while ((working->next->next != nullptr) and (working->next->data != value)) {
            working = working->next;
        }
        if (working->next->data == value) {
            auto toRemove = working->next;
            working->next = working->next->next;
            delete toRemove;
        }
    }
}

void DeleteMiddleNode::deleteMiddleNodeByIndex(Node *head, int index) {
    if ((head != nullptr) and (head->next != nullptr)) {
        auto count = 1;
        auto working = head;
        while ((working->next->next != nullptr) and (count < index)) {
            working = working->next;
            count++;
        }
        if ((working->next->next != nullptr) and (count == index)) {
            auto toRemove = working->next;
            working->next = working->next->next;
            delete toRemove;
        }
    }
}
