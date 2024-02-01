#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class QueueFromStack {
private:
    struct Node {
        int data;
        Node *next;

        explicit Node(int data) : data(data), next(nullptr) {}
    };

    Node *topNode;
    int stackSize;
public:
    explicit QueueFromStack() : topNode(nullptr), stackSize(0) {}

    void push(int data) {
        auto *entry = new Node(data);
        entry->next = this->topNode;
        this->topNode = entry;
        this->stackSize++;
    }

    void pop() {
        if (this->topNode != nullptr) {
            auto working = this->topNode;
            this->topNode = working->next;
            delete working;
            this->stackSize--;
        } else {
            throw runtime_error("Error: Stack is empty");
        }
    }

    Node *popNode() {
        Node *result;
        if (this->topNode != nullptr) {
            result = this->topNode;
            this->topNode = result->next;
            result->next = nullptr;
            this->stackSize--;
        } else {
            throw runtime_error("Error: Stack is empty");
        }
        return result;
    }

    void pushNode(Node *data) {
        if (data != nullptr) {
            data->next = this->topNode;
            this->topNode = data;
            this->stackSize++;
        } else {
            throw runtime_error("Error: Stack is empty");
        }
    }

    int peek() {
        if (this->topNode != nullptr) {
            return this->topNode->data;
        } else {
            throw runtime_error("Error: Stack is empty");
        }
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

    [[nodiscard]] int size() const {
        return this->stackSize;
    }

    string toString() {
        string result = "{";
        if (this->topNode != nullptr) {
            auto working = this->topNode;
            while (working != nullptr) {
                result.append(to_string(working->data));
                result.append(", ");
                working = working->next;
            }
        }
        if (result.size() > 1) {
            result.pop_back();
            result.pop_back();
        }
        result.append("}");
        return result;
    }
};

class QueueFromStackSlowPop {
private:
    QueueFromStack storage;
    QueueFromStack bucketStorage;
public:
    static void description() {
        cout << R"(Question: Queue from Stack
    Note: Version 1 is quick to insert but slow to pop or view at the front
    Generate a queue using a stack as its base, with the following methods:
        push(data) : inserts an element at the back of the queue
        pop() : removes an element from the front of the queue
        front() : returns the first element of the queue
        back() : returns the last element of the queue
        size() : returns the number of elements in the queue
        empty() : returns true if the queue is empty)" << endl;
    }

    explicit QueueFromStackSlowPop() = default;

    void push(int data) {
        this->storage.push(data);
    }

    void pop() {
        while (this->storage.size() > 1) {
            this->bucketStorage.pushNode(this->storage.popNode());
        }
        this->storage.pop();
        while (!bucketStorage.empty()) {
            this->storage.pushNode(bucketStorage.popNode());
        }
    }

    int front() {
        while (this->storage.size() > 1) {
            this->bucketStorage.pushNode(this->storage.popNode());
        }
        auto result = this->storage.peek();
        while (!this->bucketStorage.empty()) {
            this->storage.pushNode(this->bucketStorage.popNode());
        }
        return result;
    }

    int back() {
        return this->storage.peek();
    }

    [[nodiscard]] int size() const {
        return this->storage.size();
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
        return this->storage.toString();
    }
};

class QueueFromStackSlowInsert {
private:
    QueueFromStack storage;
    QueueFromStack bucketStorage;
public:
    static void description() {
        cout << R"(Question: Queue from Stack
    Note: Version 2 is slow to insert but quick to pop or view at the front
    Generate a queue using a stack as its base, with the following methods:
        push(data) : inserts an element at the back of the queue
        pop() : removes an element from the front of the queue
        front() : returns the first element of the queue
        back() : returns the last element of the queue
        size() : returns the number of elements in the queue
        empty() : returns true if the queue is empty)" << endl;
    }

    explicit QueueFromStackSlowInsert() = default;

    void push(int data) {
        while (!this->storage.empty()) {
            this->bucketStorage.pushNode(this->storage.popNode());
        }
        this->storage.push(data);
        while (!bucketStorage.empty()) {
            this->storage.pushNode(bucketStorage.popNode());
        }
    }

    void pop() {
        this->storage.pop();
    }

    int front() {
        return this->storage.peek();
    }

    int back() {
        while (this->storage.size() > 1) {
            this->bucketStorage.pushNode(this->storage.popNode());
        }
        auto result = this->storage.peek();
        while (!bucketStorage.empty()) {
            this->storage.pushNode(bucketStorage.popNode());
        }
        return result;
    }

    [[nodiscard]] int size() const {
        return this->storage.size();
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
        return this->storage.toString();
    }
};

#pragma clang diagnostic pop