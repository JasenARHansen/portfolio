#pragma clang diagnostic push
#pragma ide diagnostic ignored "NullDereference"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class PrintInReverse {
private:
    struct Node {
        int data;
        Node *next;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Linked List: Print in Reverse
    This challenge is part of a tutorial track by MyCodeSchool (https://www.youtube.com/mycodeschool) and is
     accompanied by a video lesson.
    Given a pointer to the head of a singly-linked list, print each data value from the reversed list.
    If the given list is empty, do not print anything.
    Example:
        head* refers to the linked list with data values
        1 -> 2 -> 3 -> NULL
    Print the following:
        3
        2
        1
    Function Description:
        Complete the reversePrint function in the editor below.
        reversePrint has the following parameters:
            SinglyLinkedListNode pointer head: a reference to the head of the list
        Prints:
            The data values of each node in the reversed list.
        Input Format:
            The first line of input contains t, the number of test cases.
            The input of each test case is as follows:
                The first line contains an integer n, the number of elements in the list.
                Each of the next n lines contains a data element for a list node.
    Constraints:
        1 ≤ n ≤ 1000
        1 ≤ list|i| ≤ 1000, where list|i| is the ith element of the list.
    Sample Input:
        3
        5
        16
        12
        4
        2
        5
        3
        7
        3
        9
        5
        5
        1
        18
        3
        13
    Sample Output:
        5
        2
        4
        12
        16
        9
        3
        7
        13
        3
        18
        1
        5
    Explanation:
    There are three test cases.
    There are no blank lines between test case output.
    The first linked list has 5 elements:
        16 -> 12 -> 4 -> 2 -> 5 -> NULL
    Printing this in reverse order produces:
        5
        2
        4
        12
        16
    The second linked list has 3 elements:
        7 -> 3 -> 9 -> NULL
    Printing this in reverse order produces:
        9
        3
        7
    The third linked list has 5 elements:
        5 -> 1 -> 18 -> 3 -> 13 -> NULL
    Printing this in reverse order produces:
        13
        3
        18
        1
        5)" << endl;
    }

    static Node *createList(vector<int> data) {
        Node *result = nullptr;
        if (!data.empty()) {
            result = new Node(data.at(0));
            auto working = result;
            auto index = 1;
            while (index < data.size()) {
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

    static void reversePrint(Node *list) {
        stack<int> data;
        auto working = list;
        while (working != nullptr) {
            data.push(working->data);
            working = working->next;
        }
        while (!data.empty()) {
            cout << data.top() << endl;
            data.pop();
        }
    }
};

#pragma clang diagnostic pop