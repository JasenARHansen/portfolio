#include "StackOfPlates.h"
#include <iostream>

using namespace ctci;

void StackOfPlates::description() {
    std::cout << R"(Stacks and Queues: Stack of Plates
    Imagine a (literal) stack of plates.
    If the stack gets too high, it might topple.
    Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
    Implement a data structure SetOfStacks that mimics this.
    SetOfStacks should be composed of several stacks and should create a new stack once the previous one
     exceeds capacity.
    SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop()
     should return the same values as it would if there were just a single stack).
    Follow up:
        Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.)" << std::endl;
}

StackOfPlates::StackOfPlates() = default;

StackOfPlates::StackOfPlates(int stackMaximum) {
    this->stackMax = stackMaximum;
}

void StackOfPlates::push(int value) {
    if (this->stacks.empty()) {
        this->stacks.emplace_back();
        this->stacks.at(0).push(value);
    } else {
        if (this->stacks.at((int) this->stacks.size() - 1).size() >= this->stackMax) {
            this->stacks.emplace_back();
        }
        this->stacks.at((int) this->stacks.size() - 1).push(value);
    }
}

void StackOfPlates::pop() {
    if (!this->stacks.empty()) {
        this->stacks.at((int) this->stacks.size() - 1).pop();
        while (this->stacks.at((int) this->stacks.size() - 1).empty()) {
            this->stacks.pop_back();
        }
    }
}

void StackOfPlates::pop(int stack) {
    if (!this->stacks.empty()) {
        if ((this->stacks.size() > stack) and (!this->stacks.at(stack).empty())) {
            this->stacks.at(stack).pop();
            while (this->stacks.at((int) this->stacks.size() - 1).empty()) {
                this->stacks.pop_back();
            }
        }
    }
}

int StackOfPlates::top() const {
    auto result = 0;
    if (!this->stacks.empty()) {
        result = this->stacks.at((int) this->stacks.size() - 1).top();
    }
    return result;
}

bool StackOfPlates::empty() const {
    return this->stacks.empty();
}

int StackOfPlates::size() const {
    auto result = 0;
    for (const auto &stack: this->stacks) {
        result += (int) stack.size();
    }
    return result;
}