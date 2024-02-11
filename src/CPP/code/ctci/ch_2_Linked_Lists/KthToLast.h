#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_2_LINKED_LISTS_KTH_TO_LAST
#define CTCI_CH_2_LINKED_LISTS_KTH_TO_LAST

#include <vector>

namespace ctci {
    class KthToLast {
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

        static int kthToLast(Node *head, int k);

        static int kthToLastRecursive(Node *head, int k);

    private:
        static std::pair<int, int> kthToLastRecursiveHelper(Node *node, int k);
    };
}
#endif
#pragma clang diagnostic pop