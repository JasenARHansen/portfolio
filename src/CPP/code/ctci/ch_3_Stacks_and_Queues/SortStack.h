#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_3_STACKS_AND_QUEUES_SORT_STACK
#define CTCI_CH_3_STACKS_AND_QUEUES_SORT_STACK

#include <stack>

namespace ctci {
    class SortStack {
    public:
        static void description();

        SortStack();

        void push(int value);

        void pop();

        [[nodiscard]] int peek();

        [[nodiscard]] bool empty() const;

        [[nodiscard]] int size() const;

    private:
        std::stack<int> small;
        std::stack<int> large;
    };
}
#endif
#pragma clang diagnostic pop