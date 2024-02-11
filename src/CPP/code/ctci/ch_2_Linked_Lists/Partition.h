#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_2_LINKED_LISTS_PARTITION
#define CTCI_CH_2_LINKED_LISTS_PARTITION

#include <vector>

namespace ctci {
    class Partition {
    private:
        struct Node {
            int data = 0;
            Node *next = nullptr;

            explicit Node(int x) : data(x), next(nullptr) {}
        };

    public:
        static void description();

        static Node *generateList(std::vector<int> data);

        static std::vector<int> getList(Node *head);

        static void deleteList(Node **head);

        static void partition(Node **head, int value);
    };
}
#endif
#pragma clang diagnostic pop