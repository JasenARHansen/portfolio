#include "StackMin.h"
#include <iostream>

void StackMin::description() {
    cout << R"(Stacks and Queues: Three in One
    Describe how you could use a single array to implement three stacks.)" << endl;
}

StackMin::StackMin() = default;

void StackMin::push(int value) {
    if (this->stack.empty()) {
        this->stack.emplace(value, value);
    } else {
        this->stack.emplace(min(this->stack.top().first, value), value);
    }
}

void StackMin::pop() {
    this->stack.pop();
}

int StackMin::top() const {
    if (this->stack.empty()) {
        return 0;
    }
    return this->stack.top().second;
}

int StackMin::minimum() const {
    if (this->stack.empty()) {
        return 0;
    }
    return this->stack.top().first;
}

bool StackMin::empty() const {
    return this->stack.empty();
}

bool StackMin::size() const {
    return this->stack.size();
}