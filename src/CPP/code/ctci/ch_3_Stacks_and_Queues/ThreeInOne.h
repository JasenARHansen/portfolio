#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_3_STACKS_AND_QUEUES_THREE_IN_ONE
#define CTCI_CH_3_STACKS_AND_QUEUES_THREE_IN_ONE

#include <vector>

namespace ctci {
    class ThreeInOne {
    public:
        static void description();

        ThreeInOne();

        void push(int stack, int value);

        void pop(int stack);

        [[nodiscard]] int top(int stack) const;

        [[nodiscard]] bool empty(int stack) const;

    private:
        const int numOfStack = 3;
        std::vector<int> stacks;
        std::vector<int> elementsInUse;
    };
}
#endif
#pragma clang diagnostic pop