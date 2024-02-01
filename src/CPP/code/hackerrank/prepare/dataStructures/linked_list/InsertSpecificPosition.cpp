#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class InsertSpecificPosition {
private:
    struct Node {
        int data;
        Node *next;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Linked List: Insert a node at a specific position in a linked list
    Given the pointer to the head node of a linked list and an integer to insert at a certain position,
     create a new node with the given integer as its data attribute, insert this node at the desired position
     and return the head node.
    A position of 0 indicates head, a position of 1 indicates one node away from the head and so on.
    The head pointer given may be null meaning that the initial list is empty.
    Example:
        head refers to the first node in the list 1 -> 2 -> 3
        data = 4
        position = 2
        Insert a node at position 2 with data = 4.
        The new list is 1 -> 2 -> 4 -> 3
    Function Description:
        Complete the function insertNodeAtPosition in the editor below.
        It must return a reference to the head node of your finished list.
        insertNodeAtPosition has the following parameters:
            head: a SinglyLinkedListNode pointer to the head of the list
            data: an integer value to insert as data in your new node
            position: an integer position to insert the new node, zero based indexing
    Returns:
        SinglyLinkedListNode pointer: a reference to the head of the revised list
    Input Format:
        The first line contains an integer n, the number of elements in the linked list.
        Each of the next n lines contains an integer SinglyLinkedListNode[i].data.
        The next line contains an integer data, the data of the node that is to be inserted.
        The last line contains an integer position.
    Constraints:
        1 ≤ n ≤ 1000
        1 ≤ SinglyLinkedListNode[i].data ≤ 1000, where SinglyLinkedListNode[i].data is the ith element of the linked list.
        1 ≤ position ≤ n.
    Sample Input:
        3
        16
        13
        7
        1
        2
    Sample Output:
        16 13 1 7
    Explanation:
        The initial linked list is 16 -> 13 -> 7.
        Insert at the position 2 which currently has 7 in it.
        The updated linked list is 16 -> 13 -> 1 -> 7.)" << endl;
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

    static Node *insertNodeAtPosition(Node *list, int data, int position) {
        Node *result;
        if (list == nullptr) {
            result = new Node(data);
        } else if (position == 0) {
            result = new Node(data);
            result->next = list;
        } else {
            result = list;
            auto current = 1;
            Node *working = list;
            while (current < position) {
                current++;
                working = working->next;
            }
            Node *insert = new Node(data);
            insert->next = working->next;
            working->next = insert;
        }
        return result;
    }
};

#pragma clang diagnostic pop