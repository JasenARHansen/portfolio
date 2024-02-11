#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_3_STACKS_AND_QUEUES_STACK_OF_PLATES
#define CTCI_CH_3_STACKS_AND_QUEUES_STACK_OF_PLATES

#include <vector>
#include <stack>

namespace ctci {
    class StackOfPlates {
    public:
        static void description();

        StackOfPlates();

        explicit StackOfPlates(int stackMaximum);

        void push(int value);

        void pop();

        void pop(int stack);

        [[nodiscard]] int top() const;

        [[nodiscard]] bool empty() const;

        [[nodiscard]] int size() const;

    private:
        int stackMax = 10;
        std::vector<std::stack<int>> stacks;
    };
}
#endif
#pragma clang diagnostic pop