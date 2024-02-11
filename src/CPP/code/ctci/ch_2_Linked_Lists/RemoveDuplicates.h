#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_2_LINKED_LISTS_REMOVE_DUPLICATES
#define CTCI_CH_2_LINKED_LISTS_REMOVE_DUPLICATES

#include <vector>

namespace ctci {
    class RemoveDuplicates {
    private:
        struct Node {
            int data = 0;
            Node *next = nullptr;

            explicit Node(int x) : data(x), next(nullptr) {}
        };

    public:
        static void description();

        static Node *generateList(std::vector<int> data);

        static void deleteList(Node **head);

        static std::vector<int> getList(Node *head);

        static void removeDuplicates(Node *head);

        static void removeDuplicatesBrute(Node *head);
    };
}
#endif
#pragma clang diagnostic pop