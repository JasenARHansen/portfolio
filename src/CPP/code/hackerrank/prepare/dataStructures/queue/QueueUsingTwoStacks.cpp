#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class QueueUsingTwoStacks {
public:
    static void description() {
        cout << R"(Queues: Queue using Two Stacks
    A queue is an abstract data type that maintains the order in which elements were added to it, allowing
     the oldest elements to be removed from the front and new elements to be added to the rear.
    This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue
     (i.e., the one that has been waiting the longest) is always the first one to be removed.
    A basic queue has the following operations:\
        Enqueue: add a new element to the end of the queue.
        Dequeue: remove the element from the front of the queue and return it.
    In this challenge, you must first implement a queue using two stacks.
    Then process q queries, where each query is one of the following 3 types:
        1 x: Enqueue element x into the end of the queue.
        2: Dequeue the element at the front of the queue.
        3: Print the element at the front of the queue.
    For example, a series of queries might be as follows:
        Query type  Lifo        Fifo        Output
        1 35        {35}        {35}
        1 15        {35, 15}    {15, 35}
        3                                   35
        2           {15}        {15}
        3                                   15
    Function Description:
        Complete the put, pop, and peek methods in the editor below.
    They must perform the actions as described above.
    Input Format:
        The first line contains a single integer, q, the number of queries.
        Each of the next q lines contains a single query in the form described in the problem statement above.
        All queries start with an integer denoting the query type, but only query 1 is followed by an additional
         space-separated value, x, denoting the value to be enqueued.
    Constraints:
        1 ≤ q ≤ 10^5
        1 ≤ type ≤ 3
        1 ≤ |x| ≤ 10^9
        It is guaranteed that a valid answer always exists for each query of types 2 and 3.
    Output Format:
        For each query of type 3, return the value of the element at the front of the fifo queue on a new line.
    Sample Input:
        STDIN   Function
        -----   --------
        10      q = 10 (number of queries)
        1 42    1st query, enqueue 42
        2       dequeue front element
        1 14    enqueue 42
        3       print the front element
        1 28    enqueue 28
        3       print the front element
        1 60    enqueue 60
        1 78    enqueue 78
        2       dequeue front element
        2       dequeue front element
    Sample Output:
        14
        14
    Explanation:
    Perform the following sequence of actions:
        1. Enqueue 42; queue = {42}.
        2. Dequeue the value at the head of the queue, 42; queue = {}.
        3. Enqueue 14; queue = {14}.
        4. Print the value at the head of the queue, 14; queue = {14}.
        5. Enqueue 28; queue = {14, 28}.
        6. Print the value at the head of the queue, 14; queue = {14, 28}.
        7. Enqueue 60; queue = {14, 28, 60}.
        8. Enqueue 78; queue = {14, 28, 60, 78}.
        9. Dequeue the value at the head of the queue, 14; queue = {28, 60, 78}.
        10. Dequeue the value at the head of the queue, 28; queue = {60, 78}.
        Query type  Lifo                Fifo            Output
        1 42        {42}                {42}
        2           {}                  {}
        1 14        {14}                {14}
        3                                               14
        1 28        {14, 28}            {28, 14}
        3                                               14
        1 60        {14, 28, 60}        {60, 28, 14}
        1 78        {14, 28, 60, 78}    {78, 60, 28, 14}
        2           {28, 60, 78}        {78, 60, 28}
        2           {60, 78}            {78, 60})" << endl;
    }

    static vector<int> queueOperations(const vector<string> &operations) {
        vector<int> result;
        auto queue = MyQueue();
        for (const auto &operation: operations) {
            vector<int> op;
            string line;
            stringstream ss(operation);
            while (getline(ss, line, ' ')) {
                op.push_back(stoi(line));
            }
            switch (op.at(0)) {
                case 1:
                    // 1 x: Enqueue element x into the end of the queue.
                    queue.enqueue(op.at(1));
                    break;
                case 2:
                    // 2: Dequeue the element at the front of the queue.
                    queue.dequeue();
                    break;
                case 3:
                    // 3: Print the element at the front of the queue.
                    result.push_back(queue.front());
                    break;
                default:
                    break;
            }
        }
        return result;
    }

private:
    class MyQueue {

    private:
        stack<int> stack_newest_on_top, stack_oldest_on_top;

    public:

        void enqueue(int x) {
            this->stack_newest_on_top.push(x);
        }

        void dequeue() {
            if (this->stack_oldest_on_top.empty()) {
                while (!this->stack_newest_on_top.empty()) {
                    this->stack_oldest_on_top.push(this->stack_newest_on_top.top());
                    this->stack_newest_on_top.pop();
                }
            }
            this->stack_oldest_on_top.pop();
        }

        int front() {
            if (this->stack_oldest_on_top.empty()) {
                while (!this->stack_newest_on_top.empty()) {
                    this->stack_oldest_on_top.push(this->stack_newest_on_top.top());
                    this->stack_newest_on_top.pop();
                }
            }
            return this->stack_oldest_on_top.top();
        }
    };

};

#pragma clang diagnostic pop