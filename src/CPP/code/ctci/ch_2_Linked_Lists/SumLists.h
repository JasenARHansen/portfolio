#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_2_LINKED_LISTS_SUM_LISTS
#define CTCI_CH_2_LINKED_LISTS_SUM_LISTS

#include <vector>

using namespace std;

class SumLists {
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

    static Node *sumReverseOrder(Node *addend1, Node *addend2);

    static Node *sumRForwardOrder(Node *addend1, Node *addend2);

private:
    static Node *reverse(Node *head);
};

#endif
#pragma clang diagnostic pop