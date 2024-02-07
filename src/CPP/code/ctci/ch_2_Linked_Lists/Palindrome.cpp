#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"

#include "Palindrome.h"
#include <iostream>

void Palindrome::description() {
    cout << R"(Linked Lists: Palindrome
    Implement a function to check if a linked list is a palindrome.)" << endl;
}

Palindrome::Node *Palindrome::generateList(vector<char> data) {
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

void Palindrome::deleteList(Node **head) {
    auto current = *head;
    Node *next;
    while (current != nullptr) {
        next = current->next;
        delete current;
        current = next;
    }
    *head = nullptr;
}

bool Palindrome::isPalindrome(Node *head) {
    auto data = reverse(head);
    auto reversed = data.second;
    auto result = true;
    int foo = data.first / 2;
    for (auto index = 0; index < data.first / 2; index++) {
        if (head->data != reversed->data) {
            result = false;
            break;
        }
        head = head->next;
        reversed = reversed->next;
    }
    return result;
}

bool Palindrome::isPalindromeRecursive(Node *head) {
    return isPalindromeRecursive(head, nullptr);
}

bool Palindrome::isPalindromeRecursive(Node *left, Node *right) {
    auto result = false;
    auto working = left;
    while (working->next != right) {
        working = working->next;
    }
    if (left == working) {
        result = true;
    } else if (left->data == working->data) {
        if (left->next == working) {
            result = true;
        } else {
            result = isPalindromeRecursive(left->next, working);
        }
    }
    return result;
}

pair<int, Palindrome::Node *> Palindrome::reverse(Node *head) {
    auto current = head;
    Node *root = new Node(0);
    auto reversed = root;
    Node *next;
    auto count = 0;
    while (current != nullptr) {
        next = new Node(current->data);
        next->next = reversed->next;
        reversed->next = next;
        current = current->next;
        count++;
    }
    current = root->next;
    delete root;
    return {count, current};
}

#pragma clang diagnostic pop