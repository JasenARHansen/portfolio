#pragma clang diagnostic push
#pragma ide diagnostic ignored "NullDereference"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class DeleteDuplicateValueNodesFromASortedLinkedList {
private:
    struct Node {
        int data;
        Node *next;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Linked List: Delete a Node
    This challenge is part of a tutorial track by MyCodeSchool (https://www.youtube.com/mycodeschool) and is
     accompanied by a video lesson.
    You are given the pointer to the head node of a sorted linked list, where the data in the nodes is in
     ascending order.
    Delete nodes and return a sorted list with each distinct value in the original list.
    The given head pointer may be null indicating that the list is empty.
    Example:
        head refers to the first node in the list 1 -> 2 -> 2 -> 3 -> 3 -> 3 -> NULL
        Remove 1 of the 2 data values and return pointing to the revised list 1 -> 2 -> 3 -> NULL
    Function Description:
        Complete the removeDuplicates function in the editor below.
        removeDuplicates has the following parameter:
            SinglyLinkedListNode pointer head: a reference to the head of the list
        Returns:
            SinglyLinkedListNode pointer: a reference to the head of the revised list
        Input Format:
            The first line contains an integer T, the number of test cases.
            The format for each test case is as follows:
            the first line contains an integer n, the number of elements in the linked list.
            Each of the next N lines contains an integer, the data value for each of the elements of the linked list.
    Constraints:
        1 ≤ t ≤ 10
        1 ≤ n ≤ 1000
        1 ≤ list|i| ≤ 1000, where list|i| is the ith element of the linked list.
    Sample Input:
        STDIN   Function
        -----   --------
        1       t = 1
        5       n = 5
        1       data values = 1, 2, 2, 3, 4
        2
        2
        3
        4
    Sample Output:
        1 2 3 4
    Explanation:
        The initial linked list is:1 -> 2 -> 2 -> 3 -> 4 -> NULL
        The final linked list is: 1 -> 2 -> 3 -> 4 -> NULL)" << endl;
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

    static Node *removeDuplicates(Node *list) {
        auto result = list;
        if (result != nullptr) {
            auto working = result;
            while (true) {
                while ((working->next != nullptr) and (working->data == working->next->data)) {
                    auto temp = working->next;
                    working->next = working->next->next;
                    delete temp;
                }
                if (working->next != nullptr) {
                    working = working->next;
                } else {
                    break;
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop