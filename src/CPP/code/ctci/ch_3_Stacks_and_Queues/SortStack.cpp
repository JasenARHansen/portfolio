#include "SortStack.h"
#include <iostream>

using namespace ctci;

void SortStack::description() {
    std::cout << R"(Stacks and Queues: Sort Stack
    Write a program to sort a stack such that the smallest items are on the top.
    You can use an additional temporary stack, but you may not copy the elements into any other data
     structure (such as an array).
    The stack supports the following operations: push, pop, peek, and isEmpty.)" << std::endl;
}

SortStack::SortStack() = default;

void SortStack::push(int value) {
    while (!this->large.empty() and (this->large.top() < value)) {
        this->small.push(this->large.top());
        this->large.pop();
    }
    while (!this->small.empty() and (this->small.top() > value)) {
        this->large.push(this->small.top());
        this->small.pop();
    }
    this->large.push(value);
}

void SortStack::pop() {
    while (!this->small.empty()) {
        this->large.push(this->small.top());
        this->small.pop();
    }
    if (!this->large.empty()) {
        this->large.pop();
    }
}

int SortStack::peek() {
    auto result = 0;
    while (!this->small.empty()) {
        this->large.push(this->small.top());
        this->small.pop();
    }
    if (!this->large.empty()) {
        result = this->large.top();
    }
    return result;
}

bool SortStack::empty() const {
    return (this->small.empty() and this->large.empty());
}

int SortStack::size() const {
    return ((int) this->small.size() + (int) this->large.size());
}