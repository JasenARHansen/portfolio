#include "ThreeInOne.h"
#include <iostream>

void ThreeInOne::description() {
    cout << R"(Stacks and Queues: Three in One
    Describe how you could use a single array to implement three stacks.)" << endl;
}

ThreeInOne::ThreeInOne() {
    stacks = vector<int>();
    elementsInUse = vector<int>(3, 0);
}

void ThreeInOne::push(int stack, int value) {
    if (stack < numOfStack) {
        auto index = 0;
        auto total = 0;
        while (index <= stack) {
            total += elementsInUse.at(index);
            index++;
        }
        stacks.insert(stacks.begin() + total, value);
        elementsInUse[stack]++;
    }
}

int ThreeInOne::top(int stack) const {
    auto result = 0;
    if (stack < numOfStack) {
        auto index = 0;
        auto total = 0;
        while (index <= stack) {
            total += elementsInUse.at(index);
            index++;
        }
        result = stacks.at(total - 1);
    }
    return result;
}

void ThreeInOne::pop(int stack) {
    if ((stack < numOfStack) and (elementsInUse[stack] > 0)) {
        auto index = 0;
        auto total = 0;
        while (index <= stack) {
            total += elementsInUse.at(index);
            index++;
        }
        stacks.erase(stacks.begin() + total - 1);
        elementsInUse[stack]--;
    }
}

bool ThreeInOne::empty(int stack) const {
    auto result = false;
    if (stack < numOfStack) {
        result = elementsInUse.at(stack) == 0;
    }
    return result;
};
