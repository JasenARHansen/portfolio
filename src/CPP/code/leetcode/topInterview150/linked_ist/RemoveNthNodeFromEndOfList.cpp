#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <cmath>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    explicit ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class RemoveNthNodeFromEndOfList {

public:

    static void description() {
        cout << R"(19. Remove Nth Node From End of List
    Given the head of a linked list, remove the nth node from the end of the list and return its head.

    Example 1:
    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]

    Example 2:
    Input: head = [1], n = 1
    Output: []

    Example 3:
    Input: head = [1,2], n = 1
    Output: [1]

    Constraints:
        The number of nodes in the list is sz.
        1 <= sz <= 30
        0 <= Node.val <= 100
        1 <= n <= sz

    Follow up:
        Could you do this in one pass?)" << endl;
    }

    static ListNode *generateList(const vector<int> &numbers) {
        assert(numbers.size() <= 30);
        ListNode *result = nullptr;
        if (!numbers.empty()) {
            assert(0 <= numbers[0]);
            assert(numbers[0] <= 100);
            result = new ListNode(numbers[numbers.size() - 1]);
            for (int index = numbers.size() - 2; index >= 0; index--) {
                assert(0 <= numbers[index]);
                assert(numbers[index] <= 100);
                auto *node = new ListNode(numbers[index], result);
                result = node;
            }
        }
        return result;
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

    static ListNode *removeNthFromEnd(ListNode *head, int n) {
        // Prep for processing
        auto data = copyList(head);
        ListNode *result = data.first;
        if (result == nullptr) {
            return result;
        }
        int size = data.second;
        assert(1 <= n);
        assert(n <= size);
        ListNode *working = result;
        ListNode *previous = nullptr;
        int index = 0;
        while (index <= size - n) {
            if (size - n == index) {
                ListNode *temp = working;
                if (previous == nullptr) {
                    result = temp->next;
                } else {
                    previous->next = temp->next;
                }
                delete temp;
                break;
            } else if (size - n - 1 == index) {
                previous = working;
            }
            index++;
            working = working->next;
        }

        return result;
    }

private:

    static pair<ListNode *, int> copyList(ListNode *head) {
        ListNode *result = nullptr;
        int count = 0;
        if (head != nullptr) {
            ListNode *current = head;
            result = new ListNode(current->val);
            count++;
            ListNode *working = result;
            while (current->next != nullptr) {
                current = current->next;
                working->next = new ListNode(current->val);
                count++;
                working = working->next;
            }
        }
        return make_pair(result, count);
    }

};

#pragma clang diagnostic pop