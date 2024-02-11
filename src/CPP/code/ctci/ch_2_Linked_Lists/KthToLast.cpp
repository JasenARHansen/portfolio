#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"

#include "KthToLast.h"
#include <iostream>

using namespace ctci;

void KthToLast::description() {
    std::cout << R"(Linked Lists: Return Kth to Last:
    Implement an algorithm to find the kth to last element of a singly linked list.
    Note: Assume the list is long enough to return a valid value)" << std::endl;
}

KthToLast::Node *KthToLast::generateList(std::vector<int> data) {
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

void KthToLast::deleteList(Node **head) {
    auto current = *head;
    Node *next;
    while (current != nullptr) {
        next = current->next;
        delete current;
        current = next;
    }
    *head = nullptr;
}

int KthToLast::kthToLast(Node *head, int k) {
    auto front = head;
    auto back = head;
    for (auto step = 0; step < k; step++) {
        back = back->next;
    }
    while (back->next != nullptr) {
        front = front->next;
        back = back->next;
    }
    return front->data;
}

int KthToLast::kthToLastRecursive(Node *head, int k) {
    return kthToLastRecursiveHelper(head, k).first;
}

std::pair<int, int> KthToLast::kthToLastRecursiveHelper(Node *node, int k) {
    auto result = std::make_pair(0, 0);
    if (node->next == nullptr) {
        result.first = 0;
    } else {
        result = kthToLastRecursiveHelper(node->next, k);
        if (result.first != k) {
            if (result.first == k - 1) {
                result.first = k;
                result.first = node->data;
            } else {
                result.first++;
            }
        }
    }
    return result;
}

#pragma clang diagnostic pop