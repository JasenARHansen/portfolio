#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class ReverseDoublyLinkedList {
private:
    struct Node {
        int data;
        Node *next;
        Node *prev;

        explicit Node(int x) : data(x), next(nullptr), prev(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Linked List: Reverse a doubly linked list
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

    static Node *createList(vector<int> data) {
        Node *result = nullptr;
        if (!data.empty()) {
            result = new Node(data.at(0));
            auto working = result;
            auto index = 1;
            while (index < data.size()) {
                auto *next = new Node(data.at(index));
                working->next = next;
                next->prev = working;
                working = next;
                index++;
            }
        }
        return result;
    }

    static void deleteList(Node **head) {
        auto current = *head;
        Node *next;
        while (current != nullptr) {
            next = current->next;
            delete current;
            current = next;
        }
        *head = nullptr;
    }

    static vector<int> getlist(Node *list) {
        vector<int> result;
        auto working = list;
        while (working != nullptr) {
            result.push_back(working->data);
            working = working->next;
        }
        return result;
    }

    static Node *reverse(Node *list) {
        Node *result = nullptr;
        if (list != nullptr) {
            Node *swap;
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