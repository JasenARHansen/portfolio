#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_2_LINKED_LISTS_DELETE_MIDDLE_NODE
#define CTCI_CH_2_LINKED_LISTS_DELETE_MIDDLE_NODE

#include <vector>

using namespace std;

class DeleteMiddleNode {
private:
    struct Node {
        int data = 0;
        Node *next = nullptr;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description();

    static Node *generateList(vector<int> data);

    static vector<int> getList(Node *head);

    static void deleteList(Node **head);

    static void deleteMiddleNodeByValue(Node *head, int value);

    static void deleteMiddleNodeByIndex(Node *head, int index);
};

#endif
#pragma clang diagnostic pop