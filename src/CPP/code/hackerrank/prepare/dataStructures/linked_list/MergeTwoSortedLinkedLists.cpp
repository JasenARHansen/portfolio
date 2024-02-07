#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <set>

using namespace std;

class MergeTwoSortedLinkedLists {
private:
    struct Node {
        int data;
        Node *next;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Linked List: Merge two sorted linked lists
    This challenge is part of a tutorial track by MyCodeSchool (https://www.youtube.com/mycodeschool) and is
     accompanied by a video lesson.
    Given pointers to the heads of two sorted linked lists, merge them into a single, sorted linked list.
    Either head pointer may be null meaning that the corresponding list is empty.
    Example:
        headA refers to 1 → 3 → 7 → NULL
        headB refers to 1 → 2 → NULL
        The new list is 1 → 1 → 2 → 3 → 7 → NULL
    Function Description:
        Complete the mergeLists function in the editor below.
        mergeLists has the following parameters:
            SinglyLinkedListNode pointer headA: a reference to the head of a list
            SinglyLinkedListNode pointer headB: a reference to the head of a list
    Returns:
        SinglyLinkedListNode pointer: a reference to the head of the merged list
    Input Format:
        The first line contains an integer t, the number of test cases.
        The format for each test case is as follows:
        The first line contains an integer n, the length of the first linked list.
        The next n lines contain an integer each, the elements of the linked list.
        The next line contains an integer m, the length of the second linked list.
        The next m lines contain an integer each, the elements of the second linked list.
    Constraints:
        1 ≤ t ≤ 10
        1 ≤ n. m ≤ 1000
        1 ≤ list1|i|, list2|i| ≤ 1000, where list|i| is the ith element of the linked list.
    Sample Input:
        1
        3
        1
        2
        3
        2
        3
        4
    Sample Output:
        1 2 3 3 4
    Explanation:
        The first linked list is: 1 → 2 → 3 → NULL
        The second linked list is: 3 → 4 → NULL
        Hence, the merged linked list is: 1 → 2 → 4 → 3 → 4 → NULL)" << endl;
    }

    static Node *createList(vector<int> data) {
        Node *result = nullptr;
        if (!data.empty()) {
            result = new Node(data.at(0));
            auto working = result;
            auto index = 1;
            while (index < (int) data.size()) {
                auto *next = new Node(data.at(index));
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

    static Node *mergeLists(Node *head1, Node *head2) {
        Node *result = nullptr;
        if ((head1 != nullptr) or (head2 != nullptr)) {
            auto working = result;
            auto working1 = head1;
            auto working2 = head2;
            while ((working1 != nullptr) and (working2 != nullptr)) {
                if (working1->data < working2->data) {
                    if (working == nullptr) {
                        working = working1;
                        result = working;
                    } else {
                        working->next = working1;
                        working = working->next;
                    }
                    working1 = working1->next;
                } else {
                    if (working == nullptr) {
                        working = working2;
                        result = working;
                    } else {
                        working->next = working2;
                        working = working->next;
                    }
                    working2 = working2->next;
                }
            }
            if (working1 == nullptr) {
                if (working == nullptr) {
                    working = working2;
                    result = working;
                } else {
                    working->next = working2;
                }
            } else if (working2 == nullptr) {
                if (working == nullptr) {
                    working = working1;
                    result = working;
                } else {
                    working->next = working1;
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop