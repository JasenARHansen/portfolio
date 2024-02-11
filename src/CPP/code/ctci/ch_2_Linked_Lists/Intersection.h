#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_2_LINKED_LISTS_INTERSECTION
#define CTCI_CH_2_LINKED_LISTS_INTERSECTION

#include <vector>

namespace ctci {
    class Intersection {
    private:
        struct Node {
            int data = 0;
            Node *next = nullptr;

            explicit Node(int x) : data(x), next(nullptr) {}
        };

    public:
        static void description();

        static std::pair<Node *, Node *> generateList(std::vector<int> data1, std::vector<int> data2);

        static void deleteList(Node **head1, Node **head2);

        static Node *intersection(Node *head1, Node *head2);
    };
}
#endif
#pragma clang diagnostic pop