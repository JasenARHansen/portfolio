#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_2_LINKED_LISTS_PARTITION
#define CTCI_CH_2_LINKED_LISTS_PARTITION

#include <vector>

using namespace std;

class Partition {
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

    static void partition(Node **head, int value);
};

#endif
#pragma clang diagnostic pop