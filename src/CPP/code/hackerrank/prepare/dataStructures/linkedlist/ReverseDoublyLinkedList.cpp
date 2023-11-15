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

class ReverseDoublyLinkedList {
public:
    static void description() {
        cout << R"(Reverse a doubly linked list:
    Given the pointer to the head node of a doubly linked list, reverse the order of the nodes in place.
    That is, change the next and prev pointers of the nodes so that the direction of the list is reversed.
    Return a reference to the head node of the reversed list.

    Note: The head node might be NULL to indicate that the list is empty.

    Function Description:
        Complete the reverse function in the editor below.
            reverse has the following parameter(s):
                DoublyLinkedListNode head: a reference to the head of a DoublyLinkedList

    Returns:
        DoublyLinkedListNode: a reference to the head of the reversed list

    Input Format:
        The first line contains an integer t, the number of test cases.
        Each test case is of the following format:
            The first line contains an integer n, the number of elements in the linked list.
            The next n lines contain an integer each denoting an element of the linked list.

    Constraints:
        1 ≤ t ≤ 10
        0 ≤ n ≤ 1000
        0 ≤ DoublyLinkedListNode.data ≤ 1000

    Output Format:
        Return a reference to the head of your reversed list.
        The provided code will print the reverse array as a one line of space-separated integers for each test case.

    Sample Input:
        1
        4
        1
        2
        3
        4

    Sample Output:
        4 3 2 1

    Explanation:
        The initial doubly linked list is:
            1 <-> 2 <-> 3 <-> 4 -> NULL.
        The reversed doubly linked list is:
            4 <-> 3 <-> 2 <-> 1 -> NULL.)" << endl;
    }

    static DoublyLinkedListNode *createList(vector<int> data) {
        DoublyLinkedListNode *result = nullptr;
        if (!data.empty()) {
            result = new DoublyLinkedListNode(data.at(0));
            auto working = result;
            auto index = 1;
            while (index < data.size()) {
                auto *next = new DoublyLinkedListNode(data.at(index));
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

    static DoublyLinkedListNode *reverse(DoublyLinkedListNode *list) {
        DoublyLinkedListNode *result = nullptr;
        if (list != nullptr) {
            DoublyLinkedListNode *swap;
            bool process = true;
            auto working = list;
            while (process) {
                process = false;
                swap = working->next;
                working->next = working->prev;
                working->prev = swap;
                if (swap != nullptr) {
                    process = true;
                    working = swap;
                }
            }
            result = working;
        }
        return result;
    }

};

#pragma clang diagnostic pop