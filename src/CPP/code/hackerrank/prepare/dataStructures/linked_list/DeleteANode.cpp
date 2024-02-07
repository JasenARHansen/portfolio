#pragma clang diagnostic push
#pragma ide diagnostic ignored "NullDereference"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>

using namespace std;

class DeleteANode {
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
    Delete the node at a given position in a linked list and return a reference to the head node.
    The head is at position 0.
    The list may be empty after you delete the node.
    In that case, return a null value.
    Example:
        list = 0 → 1 → 2 → 3
        position = 2
        After removing the node at position 2, list' = 0 → 1 → 3.
    Function Description:
        Complete the deleteNode function in the editor below.
        removeDuplicates has the following parameters:
            SinglyLinkedListNode pointer list: a reference to the head node in the list
            int position: the position of the node to remove
        Returns:
            SinglyLinkedListNode pointer: a reference to the head of the modified list
        Input Format:
            The first line of input contains an integer n, the number of elements in the linked list.
            Each of the next n lines contains an integer, the node data values in order.
            The last line contains an integer, position, the position of the node to delete.
    Constraints:
        1 ≤ n ≤ 1000
        1 ≤ list|i| ≤ 1000, where list|i| is the ith element of the linked list.
    Sample Input:
        8
        20
        6
        2
        19
        7
        4
        15
        9
        3
    Sample Output:
        20 6 2 7 4 15 9
    Explanation:
        The original list is 20 → 6 → 2 → 19 → 7 → 4 → 15 → 9.
        After deleting the node at position , the list is 20 → 6 → 2 → 7 → 4 → 15 → 9.)" << endl;
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

    static Node *deleteNode(Node *list, int position) {
        auto result = list;
        if (result == nullptr) {
            result = nullptr;
        } else if (position == 0) {
            result = result->next;
        } else {
            auto last = result;
            auto next = last->next;
            auto index = 1;
            while ((next != nullptr) and (index < position)) {
                last = next;
                next = last->next;
                index++;
            }
            if (index == position) {
                last->next = next->next;
                delete next;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop