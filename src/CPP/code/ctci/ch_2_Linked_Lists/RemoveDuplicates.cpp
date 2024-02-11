#include "RemoveDuplicates.h"
#include <iostream>
#include <set>

using namespace ctci;

void RemoveDuplicates::description() {
    std::cout << R"(Linked Lists: Remove Duplicates
    Write code to remove duplicates from an unsorted linked list.
    Follow Up:
        How would you solve this problem if a temporary buffer is not allowed?)" << std::endl;
}

RemoveDuplicates::Node *RemoveDuplicates::generateList(std::vector<int> data) {
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

void RemoveDuplicates::deleteList(Node **head) {
    auto current = *head;
    Node *next;
    while (current != nullptr) {
        next = current->next;
        delete current;
        current = next;
    }
    *head = nullptr;
}

std::vector<int> RemoveDuplicates::getList(Node *head) {
    std::vector<int> result;
    auto current = head;
    while (current != nullptr) {
        result.push_back(current->data);
        current = current->next;
    }
    return result;
}

void RemoveDuplicates::removeDuplicates(Node *head) {
    if (head != nullptr) {
        std::set<int> seen;
        auto current = head;
        seen.insert(current->data);
        while (current->next != nullptr) {
            if (seen.count(current->next->data)) {
                auto toRemove = current->next;
                current->next = toRemove->next;
                delete toRemove;
            } else {
                current = current->next;
                seen.insert(current->data);
            }
        }
    }
}

void RemoveDuplicates::removeDuplicatesBrute(Node *head) {
    if (head != nullptr) {
        auto current = head;
        while (current != nullptr) {
            auto working = current;
            while (working->next != nullptr) {
                if (current->data == working->next->data) {
                    auto toRemove = working->next;
                    working->next = toRemove->next;
                    delete toRemove;
                } else {
                    working = working->next;
                }
            }
            current = current->next;
        }
    }
}