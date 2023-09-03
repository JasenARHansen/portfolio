#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <unordered_set>
#include <cmath>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;

    explicit ListNode(int x) : val(x), next(nullptr) {}
};

class LinkedListCycle {

public:

    static void description() {
        cout << R"(141. Linked List Cycle
    Given head, the head of a linked list, determine if the linked list has a cycle in it.
    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
    Return true if there is a cycle in the linked list. Otherwise, return false.

    Example 1:
        Input: head = [3,2,0,-4], pos = 1
        Output: true
        Explanation:
            There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

    Example 2:
        Input: head = [1,2], pos = 0
        Output: true
        Explanation:
            There is a cycle in the linked list, where the tail connects to the 0th node.

    Example 3:
        Input: head = [1], pos = -1
        Output: false
        Explanation:
            There is no cycle in the linked list.

    Constraints:
        The number of the nodes in the list is in the range [0, 10^4].
        -10^5 <= Node.val <= 10^5
        pos is -1 or a valid index in the linked-list.

    Follow up:
        Can you solve it using O(1) (i.e. constant) memory?)" << endl;
    }

    static ListNode *generateListWithCycle(const int pos, const vector<int> &numbers) {
        assert(numbers.size() <= pow(10, 4));
        ListNode *root = nullptr;
        if (!numbers.empty()) {
            assert(-pow(10, 5) <= numbers[0]);
            assert(numbers[0] <= pow(10, 5));
            root = new ListNode(numbers[0]);
            ListNode *last = root;
            for (int index = 1; index < numbers.size(); index++) {
                assert(-pow(10, 5) <= numbers[index]);
                assert(numbers[index] <= pow(10, 5));
                auto *node = new ListNode(numbers[index]);
                last->next = node;
                last = node;
            }
            if ((0 <= pos) && (pos < numbers.size())) {
                int index = pos;
                ListNode *cycleTarget = root;
                while (index > 0) {
                    cycleTarget = cycleTarget->next;
                    index--;
                }
                last->next = cycleTarget;
            }
        }
        return root;
    }

    static void deleteList(const int size, ListNode **head) {
        int index = size;
        ListNode *current = *head;
        ListNode *next;
        while (index > 0) {
            next = current->next;
            delete current;
            current = next;
            index--;
        }
        *head = nullptr;
    }

    static bool hasCycle(ListNode *head) {
        if (head == nullptr) {
            return false;
        }
        unordered_set<ListNode *> pointers;
        ListNode *current = head;
        while ((!pointers.count(current)) && (current->next != nullptr)) {
            pointers.insert(current);
            current = current->next;
        }
        if (current->next != nullptr) {
            return true;
        }
        return false;
    }
};

#pragma clang diagnostic pop