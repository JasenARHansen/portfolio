#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_2_LINKED_LISTS_PALINDROME
#define CTCI_CH_2_LINKED_LISTS_PALINDROME

#include <vector>

using namespace std;

class Palindrome {
private:
    struct Node {
        char data = 0;
        Node *next = nullptr;

        explicit Node(char c) : data(c), next(nullptr) {}
    };

public:
    static void description();

    static Node *generateList(vector<char> data);

    static void deleteList(Node **head);

    static bool isPalindrome(Node *head);

    static bool isPalindromeRecursive(Node *head);

private:
    static pair<int, Palindrome::Node *> reverse(Node *head);

    static bool isPalindromeRecursive(Node *left, Node *right);
};

#endif
#pragma clang diagnostic pop