#include "Partition.h"
#include <iostream>

#pragma clang diagnostic push
#pragma ide diagnostic ignored "NullDereference"

void Partition::description() {
    cout << R"(Linked Lists: Partition
    Write code to partition a linked list around a value x, such that all nodes less than x come
     before all nodes greater than or equal to x.
    If x is contained within the list, the values of x only need to be after the elements less
     than x (see below).
    The partition element x can appear anywhere in the "right partition"; it does not need to
     appear between the left and right partitions.
    Example:
        Input: 3 → 5 → 8 → 5 → 10 → 2 → 1 [partition = 5]
        Output: 3 → 1 → 2 → 10 → 5 → 5 → 8)" << endl;
}

Partition::Node *Partition::generateList(vector<int> data) {
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

void Partition::deleteList(Node **head) {
    auto current = *head;
    Node *next;
    while (current != nullptr) {
        next = current->next;
        delete current;
        current = next;
    }
    *head = nullptr;
}

vector<int> Partition::getList(Node *head) {
    vector<int> result;
    auto current = head;
    while (current != nullptr) {
        result.push_back(current->data);
        current = current->next;
    }
    return result;
}

void Partition::partition(Node **head, int value) {
    auto current = *head;
    Node *left = nullptr;
    auto leftCurrent = left;
    Node *right = nullptr;
    auto rightCurrent = right;
    while (current != nullptr) {
        if (current->data < value) {
            if (left == nullptr) {
                left = current;
                leftCurrent = left;
            } else {
                leftCurrent->next = current;
                leftCurrent = leftCurrent->next;
            }
        } else {
            if (right == nullptr) {
                right = current;
                rightCurrent = right;
            } else {
                rightCurrent->next = current;
                rightCurrent = rightCurrent->next;
            }
        }
        current = current->next;
    }
    if (left == nullptr) {
        *head = right;
    } else {
        *head = left;
        leftCurrent->next = right;
        rightCurrent->next = nullptr;
    }
}

#pragma clang diagnostic pop