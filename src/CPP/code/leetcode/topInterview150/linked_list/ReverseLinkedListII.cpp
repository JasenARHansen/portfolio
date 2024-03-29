#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class ReverseLinkedListII {
private:
    struct Node {
        int val;
        Node *next;

        Node() : val(0), next(nullptr) {}

        explicit Node(int x) : val(x), next(nullptr) {}

        Node(int x, Node *next) : val(x), next(next) {}
    };

public:
    static void description() {
        cout << R"(92: Reverse Linked List II
    Given the head of a singly linked list and two integers left and right where left ≤ right, reverse the
     nodes of the list from position left to position right, and return the reversed list.
    Example 1:
        Input: head = [1, 2, 3, 4, 5], left = 2, right = 4
        Output: [1, 4, 3, 2, 5]
    Example 2:
        Input: head = [5], left = 1, right = 1
        Output: [5]
    Constraints:
        The number of nodes in the list is n.
        1 ≤ n ≤ 500
        -500 ≤ Node.val ≤ 500
        1 ≤ left ≤ right ≤ n)" << endl;
    }

    static vector<int> serializeList(Node *head) {
        vector<int> result;
        Node *working = head;
        while (working != nullptr) {
            result.push_back(working->val);
            working = working->next;
        }
        return result;
    }

    static Node *deserializeList(const vector<int> &numbers) {
        assert(!numbers.empty());
        assert(numbers.size() <= 500);
        assert(-500 <= numbers[0]);
        assert(numbers[0] <= 500);
        auto current = new Node(numbers[numbers.size() - 1]);
        for (int index = (int) numbers.size() - 2; index >= 0; index--) {
            assert(-500 <= numbers[index]);
            assert(numbers[index] <= 500);
            auto node = new Node(numbers[index], current);
            current = node;
        }
        return current;
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

    static Node *reverseBetween(Node *head, int left, int right) {
        assert(1 <= left);
        assert(1 <= right);
        assert(left <= right);
        // Prep for processing
        auto data = copyList(head);
        auto result = data.first;
        assert(data.second <= 500);
        Node *before = nullptr;
        Node *after = nullptr;
        auto working = result;
        vector<Node *> pointerList;
        auto index = 0;
        while ((working != nullptr) && (index <= right + 1)) {
            index++;
            if (index == left - 1) {
                before = working;
            } else if (index == right + 1) {
                after = working;
                break;
            } else {
                if ((index >= left) && (index <= right)) {
                    pointerList.push_back(working);
                }
            }
            working = working->next;
        }
        // reverse values
        for (index = (int) pointerList.size() - 1; index >= 1; index--) {
            pointerList[index]->next = pointerList[index - 1];
        }
        // Process edge point
        if (before != nullptr) {
            before->next = pointerList[pointerList.size() - 1];
        } else {
            result = pointerList[pointerList.size() - 1];
        }
        if (after != nullptr) {
            pointerList[0]->next = after;
        } else {
            pointerList[0]->next = nullptr;
        }
        return result;
    }

private:
    static pair<Node *, int> copyList(Node *head) {
        Node *result = nullptr;
        auto count = 0;
        if (head != nullptr) {
            auto current = head;
            result = new Node(current->val);
            count++;
            auto working = result;
            while (current->next != nullptr) {
                current = current->next;
                working->next = new Node(current->val);
                count++;
                working = working->next;
            }
        }
        return make_pair(result, count);
    }
};

#pragma clang diagnostic pop