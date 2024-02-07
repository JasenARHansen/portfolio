#pragma clang diagnostic push
#pragma ide diagnostic ignored "NullDereference"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class ReverseALinkedList {
private:
    struct Node {
        int data;
        Node *next;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Linked List: Reverse a linked list
    This challenge is part of a tutorial track by MyCodeSchool (https://www.youtube.com/mycodeschool) and is
     accompanied by a video lesson.
    Given the pointer to the head node of a linked list, change the next pointers of the nodes so that their
     order is reversed.
    The head pointer given may be null meaning that the initial list is empty.
    Example:
        head references the list 1 → 2 → 3 → NULL
        Manipulate the pointers of each node in place and return head, now referencing the head of the list
         3 → 2 → 1 → NULL
    Function Description:
        Complete the reverse function in the editor below.
        reverse has the following parameter:
            SinglyLinkedListNode pointer head: a reference to the head of a list
        Returns:
            SinglyLinkedListNode pointer: a reference to the head of the reversed list
    Input Format:
        The first line contains an integer t, the number of test cases.
        Each test case has the following format:
            The first line contains an integer n, the number of elements in the linked list.
            Each of the next n lines contains an integer, the data values of the elements in the linked list.
    Constraints:
        1 ≤ t ≤ 10
        1 ≤ n ≤ 1000
        1 ≤ list|i| ≤ 1000, where list|i| is the ith element of the list.
    Sample Input:
            1
            5
            1
            2
            3
            4
            5
    Sample Output:
        5 4 3 2 1
    Explanation:
        The initial linked list is:
            1 → 2 → 3 → 4 → 5 → NULL
        The reversed linked list is:
            5 → 4 → 3 → 2 → 1 → NULL.)" << endl;
    }

    static Node *createList(vector<int> data) {
        Node *result = nullptr;
        if (!data.empty()) {
            result = new Node(data.at(0));
            auto working = result;
            auto index = 1;
            while (index < (int) data.size()) {
                Node *next = new Node(data.at(index));
                working->next = next;
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
            stack<Node *> data;
            auto working = list;
            while (working != nullptr) {
                data.push(working);
                working = working->next;
            }
            result = data.top();
            working = result;
            data.pop();
            while (!data.empty()) {
                working->next = data.top();
                working = working->next;
                data.pop();
            }
            working->next = nullptr;
        }
        return result;
    }
};

#pragma clang diagnostic pop