#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class Stack {
private:
    struct Node {
        int data;
        int min;
        int max;
        Node *next;

        explicit Node(int data) : data(data), next(nullptr), min(0), max(0) {}
    };

    Node *top;
    int stackSize;
public:
    explicit Stack() : top(nullptr), stackSize(0) {}

    static void description() {
        cout << R"(Question: Stack
    Generate a stack with the following methods:
        push(data)
        pop()
        peek()
        size()
        min()
        max())" << endl;
    }

    void push(int data) {
        auto *entry = new Node(data);
        if (this->stackSize == 0) {
            entry->min = data;
            entry->max = data;
        } else {
            if (data < this->top->min) {
                entry->min = data;
            } else {
                entry->min = this->top->min;
            }
            if (data > this->top->max) {
                entry->max = data;
            } else {
                entry->max = this->top->max;
            }
        }
        entry->next = this->top;
        this->top = entry;
        this->stackSize++;
    }

    void pop() {
        if (this->top != nullptr) {
            auto working = this->top;
            this->top = working->next;
            delete working;
            this->stackSize--;
        } else {
            throw runtime_error("Error: Stack is empty");
        }
    }

    int peek() {
        if (this->top != nullptr) {
            return this->top->data;
        } else {
            throw runtime_error("Error: Stack is empty");
        }
    }

    int min() {
        if (this->top != nullptr) {
            return this->top->min;
        } else {
            throw runtime_error("Error: Stack is empty");
        }
    }

    int max() {
        if (this->top != nullptr) {
            return this->top->max;
        } else {
            throw runtime_error("Error: Stack is empty");
        }
    }

    [[nodiscard]] int size() const {
        return this->stackSize;
    }

    string toString() {
        string result = "{";
        if (this->top != nullptr) {
            auto working = this->top;
            while (working != nullptr) {
                result.append(to_string(working->data));
                result.append(", ");
                working = working->next;
            }
            if (result.size() > 1) {
                result.pop_back();
                result.pop_back();
            }
        }
        result.append("}");
        return result;
    }
};

#pragma clang diagnostic pop