#include "Intersection.h"
#include <iostream>
#include <set>

#pragma clang diagnostic push
#pragma ide diagnostic ignored "NullDereference"

void Intersection::description() {
    cout << R"(Linked Lists: Intersection
    Given two (singly) linked lists, determine if the two lists intersect.
    Return the intersecting node.
    Note that the intersection is defined based on reference, not value.
    That is, if the kth node of the first linked list is the exact same node (by reference) as the j t h
     node of the second linked list, then they are intersecting.)" << endl;
}

pair<Intersection::Node *, Intersection::Node *> Intersection::generateList(vector<int> data1, vector<int> data2) {
    Node *head1 = nullptr;
    Node *head2 = nullptr;
    if (!data1.empty() and !data2.empty()) {
        auto index = 0;
        head1 = new Node(data1.at(index));
        head2 = new Node(data2.at(index));
        auto current1 = head1;
        auto current2 = head2;
        index++;
        for (; index < min((int) data1.size(), (int) data2.size()); index++) {
            current1->next = new Node(data1.at(index));
            current2->next = new Node(data2.at(index));
            current1 = current1->next;
            current2 = current2->next;
        }
        if ((int) data1.size() > (int) data2.size()) {
            for (; index < (int) data1.size(); index++) {
                current1->next = new Node(data1.at(index));
                current2->next = current1->next;
                current1 = current1->next;
                current2 = current2->next;
            }
        } else if ((int) data2.size() > (int) data1.size()) {
            for (; index < (int) data2.size(); index++) {
                current2->next = new Node(data2.at(index));
                current1->next = current2->next;
                current1 = current1->next;
                current2 = current2->next;
            }
        }
    } else {
        if (!data1.empty()) {
            head1 = new Node(data1.at(0));
            auto current = head1;
            for (auto index = 1; index < (int) data1.size(); index++) {
                current->next = new Node(data1.at(index));
                current = current->next;
            }
        }
        if (!data2.empty()) {
            head2 = new Node(data2.at(0));
            auto current = head1;
            for (auto index = 1; index < (int) data2.size(); index++) {
                current->next = new Node(data2.at(index));
                current = current->next;
            }
        }
    }
    return {head1, head2};
}

void Intersection::deleteList(Node **head1, Node **head2) {
    set<Node *> seen;
    auto current = *head1;
    Node *next;
    while (current != nullptr) {
        seen.insert(current);
        next = current->next;
        delete current;
        current = next;
    }
    *head1 = nullptr;
    current = *head2;
    while (current != nullptr) {
        if (seen.count(current)) {
            break;
        }
        seen.insert(current);
        next = current->next;
        delete current;
        current = next;
    }
    *head2 = nullptr;
}

Intersection::Node *Intersection::intersection(Node *head1, Node *head2) {
    Node *result = nullptr;
    set<Node *> seen;
    auto current = head1;
    Node *next;
    while (current != nullptr) {
        seen.insert(current);
        next = current->next;
        current = next;
    }
    current = head2;
    while (current != nullptr) {
        if (seen.count(current)) {
            result = current;
            break;
        }
        seen.insert(current);
        next = current->next;
        current = next;
    }
    return result;
}

#pragma clang diagnostic pop