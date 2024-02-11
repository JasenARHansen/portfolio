#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_2_LINKED_LISTS_LOOP_DETECTION
#define CTCI_CH_2_LINKED_LISTS_LOOP_DETECTION

#include <vector>

namespace ctci {
    class LoopDetection {
    private:
        struct Node {
            int data = 0;
            Node *next = nullptr;

            explicit Node(int x) : data(x), next(nullptr) {}
        };

    public:
        static void description();

        static Node *generateList(std::vector<int> data);

        static void generateCycle(Node *head, int value);

        static void breakCycle(Node *head);

        static void deleteList(Node **head);

        static Node *detectCycle(Node *head);
    };
}
#endif
#pragma clang diagnostic pop