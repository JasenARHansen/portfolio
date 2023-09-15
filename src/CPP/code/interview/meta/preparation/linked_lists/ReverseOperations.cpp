#pragma clang diagnostic push
#pragma ide diagnostic ignored "NullDereference"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <stack>
#include <vector>

using namespace std;

struct AddTwoNumbersListNode {
    int data;
    AddTwoNumbersListNode *next;

    explicit AddTwoNumbersListNode(int x) : data(x), next(nullptr) {}
};

class ReverseOperations {
public:
    static void description() {
        cout << R"(Reverse Operations
    You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even elements, bordered either by either end of the list or an odd element. For example, if the list is [1, 2, 8, 9, 12, 16], the sub-parts of the list are [2, 8] and [12, 16].
    Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
    The goal of this question is: given a resulting list, determine the original order of the elements.

    Implementation detail:
        You must use the following definition for elements in the linked list:
            class AddTwoNumbersListNode {
                int data;
                AddTwoNumbersListNode next;
            }
    Signature
        AddTwoNumbersListNode reverse(AddTwoNumbersListNode head)

    Constraints
        1 <= N <= 1000, where N is the size of the list
        1 <= Li <= 10^9, where Li is the ith element of the list

    Example
        Input:
            N = 6
            list = [1, 2, 8, 9, 12, 16]
        Output:
            [1, 8, 2, 9, 16, 12])" << endl;
    }

    static vector<int> serializeList(AddTwoNumbersListNode *head) {
        vector<int> result;
        AddTwoNumbersListNode *working = head;
        while (working != nullptr) {
            result.push_back(working->data);
            working = working->next;
        }
        return result;
    }

    static AddTwoNumbersListNode *deserializeList(const vector<int> &numbers) {
        assert(numbers.size() <= 500);
        AddTwoNumbersListNode *result = nullptr;
        if (!numbers.empty()) {
            assert(-100 <= numbers[0]);
            assert(numbers[0] <= 100);
            auto current = new AddTwoNumbersListNode(numbers[0]);
            result = current;
            for (int index = 1; index < numbers.size(); index++) {
                assert(-100 <= numbers[index]);
                assert(numbers[index] <= 100);
                current->next = new AddTwoNumbersListNode(numbers[index]);
                current = current->next;
            }
        }
        return result;
    }

    static void deleteList(AddTwoNumbersListNode **head) {
        auto current = *head;
        if (current != nullptr) {
            AddTwoNumbersListNode *next;
            while (current->next != nullptr) {
                next = current->next;
                delete current;
                current = next;
            }
            *head = nullptr;
        }
    }

    static AddTwoNumbersListNode *reverse(AddTwoNumbersListNode *head) {
        AddTwoNumbersListNode *result = copyList(head);
        stack<AddTwoNumbersListNode *> evens;
        AddTwoNumbersListNode *working = result;
        AddTwoNumbersListNode *last = nullptr;
        while (working != nullptr) {
            // Odd value found, advance list
            if (working->data % 2) {
                last = working;
                working = working->next;
            } else {
                // Even value found, store all consecutive evens
                while ((working != nullptr) && !(working->data % 2)) {
                    evens.push(working);
                    working = working->next;
                }
                // Process even values
                processesEvens(&result, &working, &last, evens);
            }
        }
        // If the list ended in evens values, the ven stack is still populated and needs to be processed
        if (!evens.empty()) {
            processesEvens(&result, &working, &last, evens);
        }
        return result;
    }

private:
    static void
    processesEvens(AddTwoNumbersListNode **result, AddTwoNumbersListNode **working, AddTwoNumbersListNode **last,
                   stack<AddTwoNumbersListNode *> &evens) {
        // working is either nullptr or odd, so reverse evens section
        while (!evens.empty()) {
            // if the last was never set the list begins with evens values and the start point will be reset
            if (*last == nullptr) {
                *last = evens.top();
                *result = *last;
                evens.pop();
            } else {
                (*last)->next = evens.top();
                evens.pop();
                *last = (*last)->next;
            }
        }
        // Connect last to working
        (*last)->next = *working;
        if (*working != nullptr) {
            *last = *working;
            *working = (*working)->next;
        }
    }

    static AddTwoNumbersListNode *copyList(AddTwoNumbersListNode *head) {
        AddTwoNumbersListNode *working = head;
        AddTwoNumbersListNode *result = nullptr;
        if (head != nullptr) {
            result = new AddTwoNumbersListNode(working->data);
        }
        AddTwoNumbersListNode *copy = result;
        while (working->next != nullptr) {
            copy->next = new AddTwoNumbersListNode(working->next->data);
            working = working->next;
            copy = copy->next;
        }
        return result;
    }
};

#pragma clang diagnostic pop