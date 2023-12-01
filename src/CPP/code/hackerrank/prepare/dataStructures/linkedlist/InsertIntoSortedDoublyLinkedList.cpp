#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

struct DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode *next;
    DoublyLinkedListNode *prev;

    explicit DoublyLinkedListNode(int x) : data(x), next(nullptr), prev(nullptr) {}
};

class InsertIntoSortedDoublyLinkedList {
public:
    static void description() {
        cout << R"(Inserting a Node Into a Sorted Doubly Linked List:
    Inserting a Node Into a Sorted Doubly Linked List:
    Given a reference to the head of a doubly-linked list and an integer, data, create a new
     DoublyLinkedListNode object having data value data and insert it at the proper location to maintain the sort.

    Example:
    head refers to the list 1 <-> 2 <-> 4 -> NULL
    data = 3

    Return a reference to the new list:
        1 <-> 2 <-> 3 <-> 4 -> NULL.

    Function Description:
        Complete the sortedInsert function in the editor below.
            sortedInsert has two parameters:
                DoublyLinkedListNode pointer head: a reference to the head of a doubly-linked list
                int data: An integer denoting the value of the data field for the DoublyLinkedListNode you must insert into the list.

    Returns:
        DoublyLinkedListNode pointer: a reference to the head of the list

    Note: Recall that an empty list (i.e., where head = NULL) and a list with one element are sorted lists.

    Input Format:
        The first line contains an integer t, the number of test cases.

    Each of the test case is in the following format:
        The first line contains an integer n, the number of elements in the linked list.
        Each of the next n lines contains an integer, the data for each node of the linked list.
        The last line contains an integer, data, which needs to be inserted into the sorted doubly-linked list.

    Constraints:
        1 ≤ t ≤ 10
        1 ≤ n ≤ 1000
        1 ≤ DoublyLinkedListNode.data ≤ 1000

    Sample Input:
        STDIN   Function
        -----   --------
        1       t = 1
        4       n = 4
        1       node data values = 1, 3, 4, 10
        3
        4
        10
        5       data = 5

    Sample Output:
        1 3 4 5 10

    Explanation:
        The initial doubly linked list is:
            1 <-> 3 <-> 4 <-> 10 -> NULL.
        The doubly linked list after insertion is:
            1 <-> 3 <-> 4 <-> 5 <-> 10 -> NULL)" << endl;
    }

    static DoublyLinkedListNode *createList(vector<int> data) {
        DoublyLinkedListNode *result = nullptr;
        if (!data.empty()) {
            result = new DoublyLinkedListNode(data.at(0));
            auto working = result;
            auto index = 1;
            while (index < data.size()) {
                DoublyLinkedListNode *next = new DoublyLinkedListNode(data.at(index));
                working->next = next;
                next->prev = working;
                working = next;
                index++;
            }
        }
        return result;
    }

    static vector<int> getlist(DoublyLinkedListNode *list) {
        vector<int> result;
        auto working = list;
        while (working != nullptr) {
            result.push_back(working->data);
            working = working->next;
        }
        return result;
    }

    static DoublyLinkedListNode *sortedInsert(DoublyLinkedListNode *list, int data) {
        DoublyLinkedListNode *result;
        // No data provided
        if (list == nullptr) {
            result = new DoublyLinkedListNode(data);
        } else {
            result = list;
            DoublyLinkedListNode *working = list;
            while ((working->next != nullptr) && (working->data < data)) {
                working = working->next;
            }
            DoublyLinkedListNode *insert = new DoublyLinkedListNode(data);
            // Path 1: working->data < data: end of list
            if (working->data < data) {
                working->next = insert;
                insert->prev = working;
            }
                // Path 2: working->data > data: not end of list
            else {
                insert->prev = working->prev;
                insert->next = working;
                if (working->prev == nullptr) {
                    result = insert;
                } else {
                    working->prev->next = insert;
                }
                working->prev = insert;
            }
        }
        return result;
    }

};

#pragma clang diagnostic pop