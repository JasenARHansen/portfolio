#include "ThreeInOne.h"
#include <iostream>

void ThreeInOne::description() {
    cout << R"(Stacks and Queues: Three in One
    Describe how you could use a single array to implement three stacks.)" << endl;
}

ThreeInOne::ThreeInOne() {
    this->stacks = vector<int>();
    this->elementsInUse = vector<int>(3, 0);
}

void ThreeInOne::push(int stack, int value) {
    if (stack < this->numOfStack) {
        auto index = 0;
        auto total = 0;
        while (index <= stack) {
            total += this->elementsInUse.at(index);
            index++;
        }
        this->stacks.insert(this->stacks.begin() + total, value);
        this->elementsInUse[stack]++;
    }
}

int ThreeInOne::top(int stack) const {
    auto result = 0;
    if (stack < this->numOfStack) {
        auto index = 0;
        auto total = 0;
        while (index <= stack) {
            total += this->elementsInUse.at(index);
            index++;
        }
        result = this->stacks.at(total - 1);
    }
    return result;
}

void ThreeInOne::pop(int stack) {
    if ((stack < this->numOfStack) and (this->elementsInUse[stack] > 0)) {
        auto index = 0;
        auto total = 0;
        while (index <= stack) {
            total += this->elementsInUse.at(index);
            index++;
        }
        this->stacks.erase(this->stacks.begin() + total - 1);
        this->elementsInUse[stack]--;
    }
}

bool ThreeInOne::empty(int stack) const {
    auto result = false;
    if (stack < this->numOfStack) {
        result = this->elementsInUse.at(stack) == 0;
    }
    return result;
};
