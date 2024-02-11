#include "LoopDetection.h"
#include <iostream>
#include <set>

using namespace ctci;

void LoopDetection::description() {
    std::cout << R"(Linked Lists: Loop Detection
    Given a circular linked list, implement an algorithm that returns the node at the beginning
     of the loop.
    Definition:
        Circular linked list: A (corrupt) linked list in which a node's next pointer points to an
         earlier node, so as to make a loop in the linked list.
    Example:
        Input: A → 8 → C → D → E → C [the same C as earlier]
        Output: C
        Result: nothing is returned, but the new linked list looks like a → b → d → e → f)" << std::endl;
}

LoopDetection::Node *LoopDetection::generateList(std::vector<int> data) {
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

void LoopDetection::generateCycle(Node *head, int value) {
    if (head != nullptr) {
        Node *cycle = nullptr;
        auto working = head;
        while ((working->next != nullptr) and (value > 0)) {
            working = working->next;
            value--;
        }
        if (value == 0) {
            cycle = working;
        }
        while (working->next != nullptr) {
            working = working->next;
        }
        working->next = cycle;
    }
}

void LoopDetection::breakCycle(Node *head) {
    if (head != nullptr) {
        auto current = head;
        Node *next;
        std::set<Node *> seen;
        while ((current->next != nullptr) and (!seen.count(current->next))) {
            seen.insert(current);
            next = current->next;
            current = next;
        }
        current->next = nullptr;
    }
}

void LoopDetection::deleteList(Node **head) {
    auto current = *head;
    Node *next;
    while (current != nullptr) {
        next = current->next;
        delete current;
        current = next;
    }
    *head = nullptr;
}

LoopDetection::Node *LoopDetection::detectCycle(Node *head) {
    Node *result = nullptr;
    if (head != nullptr) {
        auto current = head;
        Node *next;
        std::set<Node *> seen;
        while ((current->next != nullptr) and (!seen.count(current->next))) {
            seen.insert(current);
            next = current->next;
            current = next;
        }
        result = current->next;
    }
    return result;
}