#include "QueueViaStacks.h"
#include <iostream>

using namespace ctci;

void MyQueue::description() {
    std::cout << R"(Stacks and Queues: Queue via Stacks
    Implement a MyQueue class which implements a queue using two stacks.)" << std::endl;
}

MyQueue::MyQueue() = default;

void MyQueue::push(int value) {
    while (!this->large.empty()) {
        this->small.push(this->large.top());
        this->large.pop();
    }
    this->large.push(value);
}

void MyQueue::pop() {
    while (!this->small.empty()) {
        this->large.push(this->small.top());
        this->small.pop();
    }
    if (!this->large.empty()) {
        this->large.pop();
    }
}

int MyQueue::front() {
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

bool MyQueue::empty() const {
    return (this->small.empty() and this->large.empty());
}

int MyQueue::size() const {
    return ((int) this->small.size() + (int) this->large.size());
}