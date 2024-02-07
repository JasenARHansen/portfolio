#pragma clang diagnostic push
#pragma ide diagnostic ignored "readability-container-size-empty"

#include "StackMin.h"
#include <iostream>

using namespace std;

void StackMin::description() {
    cout << R"(Stacks and Queues: Three in One
    Describe how you could use a single array to implement three stacks.)" << endl;
}

StackMin::StackMin() = default;

void StackMin::push(int value) {
    if (stack.empty()) {
        stack.emplace(value, value);
    } else {
        stack.emplace(min(stack.top().first, value), value);
    }
}

void StackMin::pop() {
    stack.pop();
}

int StackMin::top() const {
    if (stack.empty()) {
        return 0;
    }
    return stack.top().second;
}

int StackMin::minimum() const {
    if (stack.empty()) {
        return 0;
    }
    return stack.top().first;
}

bool StackMin::empty() const {
    return stack.empty();
}

bool StackMin::size() const {
    return stack.size();
}

#pragma clang diagnostic pop