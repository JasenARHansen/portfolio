#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <set>

using namespace std;

class CompareTwoLinkedLists {
private:
    struct Node {
        int data;
        Node *next;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Linked List: Compare two linked lists
    This challenge is part of a tutorial track by MyCodeSchool (https://www.youtube.com/mycodeschool) and is
     accompanied by a video lesson.
    You’re given the pointer to the head nodes of two linked lists.
    Compare the data in the nodes of the linked lists to check if they are equal.
    If all data attributes are equal and the lists are the same length, return 1.
    Otherwise, return 0.
    Example:
        list1 1 → 2 → 3 → NULL
        list2 1 → 2 → 3 → 4 → NULL
        The two lists have equal data attributes for the first 3 nodes.
        list2 is longer, though, so the lists are not equal.
        Return 0.
    Function Description:
        Complete the compare_lists function in the editor below.
        compare_lists has the following parameters:
            SinglyLinkedListNode list1: a reference to the head of a list
            SinglyLinkedListNode list2: a reference to the head of a list
        Returns:
            int: return 1 if the lists are equal, or 0 otherwise
    Input Format:
        The first line contains an integer t, the number of test cases.
        Each of the test cases has the following format:
        The first line contains an integer n, the number of nodes in the first linked list.
        Each of the next n lines contains an integer, each a value for a data attribute.
        The next line contains an integer m, the number of nodes in the second linked list.
        Each of the next m lines contains an integer, each a value for a data attribute.
    Constraints:
        1 ≤ t ≤ 10
        1 ≤ n. m ≤ 1000
        1 ≤ list1|i|, list2|i| ≤ 1000, where list|i| is the ith element of the linked list.
    Output Format:
        Compare the two linked lists and return 1 if the lists are equal.
        Otherwise, return 0.
        Do NOT print anything to stdout/console.
        The output is handled by the code in the editor and it is as follows:
        For each test case, in a new line, print 1 if the two lists are equal, else print 0.
    Sample Input:
        2
        2
        1
        2
        1
        1
        2
        1
        2
        2
        1
        2
    Sample Output:
        0
        1
    Explanation:
        There are 2 test cases, each with a pair of linked lists.
        In the first case, linked lists are: 1 → 2 → NULL and 1 → NULL
        In the second case, linked lists are: 1 → 2 → NULL and 1 → 2 → NULL)" << endl;
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

    static bool compare_lists(Node *head1, Node *head2) {
        auto result = true;
        if ((head1 == nullptr) or (head2 == nullptr)) {
            if ((head1 != nullptr) or (head2 != nullptr)) {
                result = false;
            }
        } else {
            auto working1 = head1;
            auto working2 = head2;
            while ((working1 != nullptr) and (working2 != nullptr)) {
                if (working1->data != working2->data) {
                    result = false;
                    break;
                }
                working1 = working1->next;
                working2 = working2->next;
            }
            if ((working1 == nullptr) or (working2 == nullptr)) {
                if ((working1 != nullptr) or (working2 != nullptr)) {
                    result = false;
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop