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

class RotateList {

public:

    static void description() {
        cout << R"(61. Rotate List
    Given the head of a linked list, rotate the list to the right by k places.

    Example 1:
        Input: head = [1,2,3,4,5], k = 2
        Output: [4,5,1,2,3]

    Example 2:
        Input: head = [0,1,2], k = 4
        Output: [2,0,1]

    Constraints:
        The number of nodes in the list is in the range [0, 500].
        -100 <= Node.val <= 100
        0 <= k <= 2 * 10^9)" << endl;
    }

    static ListNode *generateList(const vector<int> &numbers) {
        assert(numbers.size() <= 500);
        ListNode *result = nullptr;
        if (!numbers.empty()) {
            assert(-100 <= numbers[0]);
            assert(numbers[0] <= 100);
            result = new ListNode(numbers[numbers.size() - 1]);
            for (int index = numbers.size() - 2; index >= 0; index--) {
                assert(-100 <= numbers[index]);
                assert(numbers[index] <= 100);
                auto node = new ListNode(numbers[index], result);
                result = node;
            }
        }
        return result;
    }

    static void deleteList(const unsigned long int size, ListNode **head) {
        auto index = size;
        auto current = *head;
        ListNode *next;
        while (index > 0) {
            next = current->next;
            delete current;
            current = next;
            index--;
        }
        *head = nullptr;
    }

    static ListNode *rotateRight(ListNode *head, int k) {
        assert(0 <= k);
        assert(k <= 2 * pow(10, 9));
        // Prep for processing
        auto data = copyList(head);
        auto result = data.first;
        if ((k == 0) || (result == nullptr)) {
            return result;
        }
        auto size = data.second;
        auto rotate = k % size;
        auto working = result;
        vector<ListNode *> pointerList;
        auto index = 0;
        while (index < size) {
            if (size - index - 1 == rotate) {
                auto temp = working;
                working = working->next;
                temp->next = nullptr;
                index++;
                continue;
            } else if (size - index <= rotate) {
                pointerList.push_back(working);
            }
            index++;
            working = working->next;
        }
        if (!pointerList.empty()) {
            pointerList[pointerList.size() - 1]->next = result;
            result = pointerList[0];
        }
        return result;
    }

private:

    static pair<ListNode *, int> copyList(ListNode *head) {
        ListNode *result = nullptr;
        auto count = 0;
        if (head != nullptr) {
            auto current = head;
            result = new ListNode(current->val);
            count++;
            auto working = result;
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