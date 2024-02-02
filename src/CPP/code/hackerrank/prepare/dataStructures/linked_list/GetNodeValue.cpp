#pragma clang diagnostic push
#pragma ide diagnostic ignored "NullDereference"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class GetNodeValue {
private:
    struct Node {
        int data;
        Node *next;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Linked List: Get Node Value
    This challenge is part of a tutorial track by MyCodeSchool (https://www.youtube.com/mycodeschool) and is
     accompanied by a video lesson.
    Given a pointer to the head of a linked list and a specific position, determine the data value at that position.
    Count backwards from the tail node.
    The tail is at position 0, its parent is at 1 and so on.
    Example:
        head refers to 3 -> 2 -> 1 -> 0 -> NULL
        positionFromTail = 2
        Each of the data values matches its distance from the tail.
        The value 2 is at the desired position.
    Function Description:
        Complete the getNode function in the editor below.
        getNode has the following parameters:
            SinglyLinkedListNode pointer head: refers to the head of the list
            int positionFromTail: the item to retrieve
        Returns:
            int: the value at the desired position
        Input Format:
            The first line contains an integer T, the number of test cases.
            Each test case has the following format:
            The first line contains an integer N, the number of elements in the linked list.
            The next N lines contains an integer, the data value for an element of the linked list.
            The last line contains an integer positionFromTail, the position from the tail to retrieve the value of.
    Constraints:
        1 ≤ t ≤ 10
        1 ≤ n ≤ 1000
        1 ≤ list|i| ≤ 1000, where list|i| is the ith element of the linked list.
    Sample Input:
        2
        1
        1
        0
        3
        3
        2
        1
        2
    Sample Output:
        1
        3
    Explanation:
        In the first case, there is one element in linked list with a value of 1.
        The last (only) element contains 1.
        In the second case, the list is 3 -> 2 -> 1 -> NULL
        The element with position of 2 from tail contains 3.)" << endl;
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

    static int getNode(Node *list, int positionFromTail) {
        auto result = 0;
        if (list != nullptr) {
            stack<Node *> data;
            auto working = list;
            while (working != nullptr) {
                data.push(working);
                working = working->next;
            }
            auto count = 0;
            while ((count < positionFromTail) and (!data.empty())) {
                data.pop();
                count++;
            }
            if (!data.empty()) {
                result = data.top()->data;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop