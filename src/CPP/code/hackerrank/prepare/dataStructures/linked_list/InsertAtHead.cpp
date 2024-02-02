#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class InsertAtHead {
private:
    struct Node {
        int data;
        Node *next;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Linked List: Insert a node at the head of a linked list
    This challenge is part of a tutorial track by MyCodeSchool (https://www.youtube.com/mycodeschool) and is
     accompanied by a video lesson.
    Given a pointer to the head of a linked list, insert a new node before the head.
    The value in the new node should point to and the value should be replaced with a given value.
    Return a reference to the new head of the list.
    The head pointer given may be null meaning that the initial list is empty.
    Function Description:
        Complete the function insertNodeAtHead in the editor below.
        insertNodeAtHead has the following parameter(s):
            SinglyLinkedListNode list: a reference to the head of a list
            data: the value to insert in the data field of the new node
    Input Format:
        The first line contains an integer n, the number of elements to be inserted at the head of the list.
    The next n lines contain an integer each, the elements to be inserted, one per function call.
    Constraints:
        1 ≤ n ≤ 1000
        1 ≤ list|i| ≤ 1000
    Sample Input:
        5
        383
        484
        392
        975
        321
    Sample Output:
        321
        975
        392
        484
        383
    Explanation:
        Initially the list in NULL.
        After inserting 383, the list is 383 -> NULL.
        After inserting 484, the list is 484 -> 383 -> NULL.
        After inserting 392, the list is 392 -> 484 -> 383 -> NULL.
        After inserting 975, the list is 975 -> 392 -> 484 -> 383 -> NULL.
        After inserting 321, the list is 321 -> 975 -> 392 -> 484 -> 383 -> NULL. )" << endl;
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

    static Node *insertNodeAtHead(Node *list, int data) {
        auto *result = new Node(data);
        result->next = list;
        return result;
    }
};

#pragma clang diagnostic pop