#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

struct Node {
    int data;
    Node *next;

    explicit Node(int x) : data(x), next(nullptr) {}
};

class PrintTheElementsOfALinkedList {
public:
    static void description() {
        cout << R"(Linked List: Print the Elements of a Linked List
    This challenge is part of a MyCodeSchool (https://www.youtube.com/mycodeschool) tutorial track and is
     accompanied by a video lesson (https://www.youtube.com/embed/vcQIFT79_50?theme=light).
    This is an to practice traversing a linked list.
    Given a pointer to the head node of a linked list, print each node's data element, one per line.
    If the head pointer is null (indicating the list is empty), there is nothing to print.
    Function Description:
        Complete the printLinkedList function in the editor below.
        printLinkedList has the following parameter(s):
            SinglyLinkedListNode head: a reference to the head of the list
    Print:
        For each node, print its data value on a new line (console.log in Javascript).
    Input Format:
        The first line of input contains n, the number of elements in the linked list.
        The next n lines contain one element each, the data values for each node.
    Note: Do not read any input from stdin/console.
        Complete the printLinkedList function in the editor below.
    Constraints:
        1 ≤ n ≤ 1000
        1 ≤ list[i] ≤ 1000, where list[i] is the ith element of the linked list.
    Sample Input:
        2
        16
        13
    Sample Output:
        16
        13
    Explanation:
        There are two elements in the linked list.
        They are represented as 16 -> 13 -> NULL.
        So, the printLinkedList function should print 16 and 13 each on a new line.)" << endl;
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

    static vector<int> getlist(Node *list) {
        vector<int> result;
        auto working = list;
        while (working != nullptr) {
            result.push_back(working->data);
            working = working->next;
        }
        return result;
    }

    static void printLinkedList(Node *head) {
        Node *working = head;
        while (working != nullptr) {
            working = working->next;
        }
    }
};

#pragma clang diagnostic pop