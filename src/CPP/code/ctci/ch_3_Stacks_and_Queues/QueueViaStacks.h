#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_3_STACKS_AND_QUEUES_QUEUE_VIA_STACKS
#define CTCI_CH_3_STACKS_AND_QUEUES_QUEUE_VIA_STACKS

#include <stack>

using namespace std;

class MyQueue {
public:
    static void description();

    MyQueue();

    void push(int value);

    void pop();

    [[nodiscard]] int front() ;

    [[nodiscard]] bool empty() const;

    [[nodiscard]] int size() const;

private:
    stack<int> small;
    stack<int> large;
};

#endif
#pragma clang diagnostic pop