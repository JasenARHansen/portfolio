#include "SumLists.h"
#include <iostream>

void SumLists::description() {
    cout << R"(Linked Lists: Sum Lists
    You have two numbers represented by a linked list, where each node contains a single digit.
    The digits are stored in reverse order, such that the Vs digit is at the head of the list.
    Write a function that adds the two numbers and returns the sum as a linked list.
    Example:
        Input: (7 → 1 → 6) + (5 → 9 → 2).
                That is, 617 + 295.
        Output: 2 → 1 → 9
                That is, 912.
    Follow up:
        Suppose the digits are stored in forward order.
        Repeat the above problem.
    Example:
        Input: (6 → 1 → 7) + (2 → 9 → 5).
                That is, 617 + 295.
        Output: 9 → 1 → 2
                That is, 912)" << endl;
}

SumLists::Node *SumLists::generateList(vector<int> data) {
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

void SumLists::deleteList(Node **head) {
    auto current = *head;
    Node *next;
    while (current != nullptr) {
        next = current->next;
        delete current;
        current = next;
    }
    *head = nullptr;
}

vector<int> SumLists::getList(Node *head) {
    vector<int> result;
    auto current = head;
    while (current != nullptr) {
        result.push_back(current->data);
        current = current->next;
    }
    return result;
}

SumLists::Node *SumLists::sumReverseOrder(Node *addend1, Node *addend2) {
    Node *placeHolder = new Node(0);
    if ((addend1 != nullptr) and (addend2 != nullptr)) {
        auto current = placeHolder;
        auto carry = 0;
        auto addend1Current = addend1;
        auto addend2Current = addend2;
        while ((addend1Current != nullptr) and (addend2Current != nullptr)) {
            auto total = carry + addend1Current->data + addend2Current->data;
            carry = total / 10;
            current->next = new Node(total % 10);
            addend1Current = addend1Current->next;
            addend2Current = addend2Current->next;
            current = current->next;
        }
        if (addend1Current != nullptr) {
            while (addend1Current != nullptr) {
                auto total = carry + addend1Current->data;
                carry = total / 10;
                current->next = new Node(total % 10);
                addend1Current = addend1Current->next;
                current = current->next;
            }
        } else if (addend2Current != nullptr) {
            while (addend2Current != nullptr) {
                auto total = carry + addend2Current->data;
                carry = total / 10;
                current->next = new Node(total % 10);
                addend2Current = addend2Current->next;
                current = current->next;
            }
        }
        if (carry) {
            current->next = new Node(carry);
        }
    }
    auto result = placeHolder->next;
    delete placeHolder;
    return result;
}

SumLists::Node *SumLists::sumRForwardOrder(Node *addend1, Node *addend2) {
    auto addend1New = reverse(addend1);
    auto addend2New = reverse(addend2);
    auto sum = sumReverseOrder(addend1New, addend2New);
    auto result = reverse(sum);
    deleteList(&addend1New);
    deleteList(&addend2New);
    deleteList(&sum);
    return result;
}

SumLists::Node *SumLists::reverse(Node *head) {
    auto current = head;
    Node *root = new Node(0);
    auto reversed = root;
    Node *next;
    while (current != nullptr) {
        next = new Node(current->data);
        next->next = reversed->next;
        reversed->next = next;
        current = current->next;
    }
    current = root->next;
    delete root;
    return current;
}