#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class InsertAtTail {
private:
    struct Node {
        int data;
        Node *next;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Linked List: Insert a Node at the Tail of a Linked List
    This challenge is part of a tutorial track by MyCodeSchool (https://www.youtube.com/mycodeschool) and is
     accompanied by a video lesson.
    You are given the pointer to the head node of a linked list and an integer to add to the list.
    Create a new node with the given integer.
    Insert this node at the tail of the linked list and return the head node of the linked list formed after
     inserting this new node.
    The given head pointer may be null, meaning that the initial list is empty.
    Function Description:
        Complete the insertNodeAtTail function in the editor below.
        insertNodeAtTail has the following parameters:
            SinglyLinkedListNode pointer head: a reference to the head of a list
            int data: the data value for the node to insert
        Returns:
            SinglyLinkedListNode pointer: reference to the head of the modified linked list
        Input Format:
            The first line contains an integer n, the number of elements in the linked list.
            The next n lines contain an integer each, the value that needs to be inserted at tail.
    Constraints:
        1 ≤ n ≤ 1000
        1 ≤ listi ≤ 1000
    Sample Input:
        n = 5
        sequential data values = 141 302 164 530 474
    Sample Output:
        141
        302
        164
        530
        474
    Explanation:
        First the linked list is NULL.
        After inserting 141, the list is 141 -> NULL.
        After inserting 302, the list is 141 -> 302 -> NULL.
        After inserting 164, the list is 141 -> 302 -> 164 -> NULL.
        After inserting 530, the list is 141 -> 302 -> 164 -> 530 -> NULL.
        After inserting 474, the list is 141 -> 302 -> 164 -> 530 -> 474 -> NULL, which is the final list.)" << endl;
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

    static Node *insertNodeAtTail(Node *head, int data) {
        auto result = head;
        if (head == nullptr) {
            result = new Node(data);
        } else {
            auto working = result;
            while (working->next != nullptr) {
                working = working->next;
            }
            working->next = new Node(data);
        }
        return result;
    }
};

#pragma clang diagnostic pop