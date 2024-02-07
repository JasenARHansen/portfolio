#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_2_LINKED_LISTS_REMOVE_DUPLICATES
#define CTCI_CH_2_LINKED_LISTS_REMOVE_DUPLICATES

#include <vector>

using namespace std;

class RemoveDuplicates {
private:
    struct Node {
        int data = 0;
        Node *next = nullptr;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description();

    static Node *generateList(vector<int> data);

    static void deleteList(Node **head);

    static vector<int> getList(Node *head);

    static void removeDuplicates(Node *head);

    static void removeDuplicatesBrute(Node *head);
};

#endif
#pragma clang diagnostic pop