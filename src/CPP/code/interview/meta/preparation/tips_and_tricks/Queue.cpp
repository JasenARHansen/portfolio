#pragma clang diagnostic push
#pragma ide diagnostic ignored "modernize-use-nodiscard"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class Queue {
private:
    struct Node {
        int data;
        int min;
        int max;
        Node *next;

        explicit Node(int data) : data(data), next(nullptr), min(0), max(0) {}
    };

    Node *frontPointer;
    Node *backPointer;
    int queueSize;
public:
    explicit Queue() : frontPointer(nullptr), backPointer(nullptr), queueSize(0) {}

    static void description() {
        cout << R"(Question: Queue
    Generate a stack with the following methods:
        enqueue(data) : Adds the element ‘data’ at the end of the queue.
        dequeue() : Deletes the first element of the queue.
        front() : Returns a reference to the first element of the queue.\
        back() :Returns a reference to the last element of the queue.
        size(): Returns the size of the queue.
        empty() : Returns whether the queue is empty.
        It return true if the queue is empty otherwise returns false.)" << endl;
    }

    void enqueue(int data) {
        auto *entry = new Node(data);
        if (this->empty()) {
            this->frontPointer = entry;
            this->backPointer = entry;
        } else {
            this->backPointer->next = entry;
            this->backPointer = entry;
        }
        this->queueSize++;
    }

    void dequeue() {
        if (!this->empty()) {
            auto *entry = this->frontPointer;
            this->frontPointer = entry->next;
            delete entry;
            this->queueSize--;
            if (this->empty()) {
                this->frontPointer = nullptr;
                this->backPointer = nullptr;
            }
        } else {
            throw runtime_error("Error: Queue is empty");
        }
    }

    int front() const {
        int result;
        if (!this->empty()) {
            result = this->frontPointer->data;
        } else {
            throw runtime_error("Error: Queue is empty");
        }
        return result;
    }

    int back() const {
        int result;
        if (!this->empty()) {
            result = this->backPointer->data;
        } else {
            throw runtime_error("Error: Queue is empty");
        }
        return result;
    }

    [[nodiscard]] int size() const {
        return this->queueSize;
    }

    [[nodiscard]] bool empty() const {
        bool result;
        if (this->size() == 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    string toString() {
        string result = "{";
        if (!this->empty()) {
            auto working = this->frontPointer;
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