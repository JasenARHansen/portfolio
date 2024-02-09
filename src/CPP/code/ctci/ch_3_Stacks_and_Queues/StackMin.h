#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_3_STACKS_AND_QUEUES_STACK_MIN
#define CTCI_CH_3_STACKS_AND_QUEUES_STACK_MIN

#include <stack>

using namespace std;

class StackMin {
public:
    static void description();

    StackMin();

    void push(int value);

    void pop();

    [[nodiscard]] int top() const;

    [[nodiscard]] int minimum() const;

    [[nodiscard]] bool empty() const;

    [[nodiscard]] bool size() const;

private:
    stack<pair<int, int>> stack;
};

#endif
#pragma clang diagnostic pop