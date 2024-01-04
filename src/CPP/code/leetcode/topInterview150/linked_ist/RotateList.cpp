#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <cmath>

using namespace std;

struct RotateListNode {
    int val;
    RotateListNode *next;

    RotateListNode() : val(0), next(nullptr) {}

    explicit RotateListNode(int x) : val(x), next(nullptr) {}

    RotateListNode(int x, RotateListNode *next) : val(x), next(next) {}
};

class RotateList {
public:
    static void description() {
        cout << R"(61: Rotate List
    Given the head of a linked list, rotate the list to the right by k places.
    Example 1:
        Input: head = [1, 2, 3, 4, 5], k = 2
        Output: [4, 5, 1, 2, 3]
    Example 2:
        Input: head = [0, 1, 2], k = 4
        Output: [2, 0, 1]
    Constraints:
        The number of nodes in the list is in the range [0, 500].
        -100 ≤ RotateListNode.val ≤ 100
        0 ≤ k ≤ 2 * 10^9)" << endl;
    }

    static vector<int> serializeList(RotateListNode *head) {
        vector<int> result;
        RotateListNode *working = head;
        while (working != nullptr) {
            result.push_back(working->val);
            working = working->next;
        }
        return result;
    }

    static RotateListNode *deserializeList(const vector<int> &numbers) {
        assert(numbers.size() <= 500);
        RotateListNode *result = nullptr;
        if (!numbers.empty()) {
            assert(-100 <= numbers[0]);
            assert(numbers[0] <= 100);
            auto current = new RotateListNode(numbers[0]);
            result = current;
            for (int index = 1; index < numbers.size(); index++) {
                assert(-100 <= numbers[index]);
                assert(numbers[index] <= 100);
                current->next = new RotateListNode(numbers[index]);
                current = current->next;
            }
        }
        return result;
    }

    static void deleteList(RotateListNode **head) {
        auto current = *head;
        if (current != nullptr) {
            RotateListNode *next;
            while (current->next != nullptr) {
                next = current->next;
                delete current;
                current = next;
            }
            *head = nullptr;
        }
    }

    static RotateListNode *rotateRight(RotateListNode *head, int k) {
        RotateListNode *result = nullptr;
        if (head != nullptr) {
            assert(0 <= k);
            assert(k <= 2 * pow(10, 9));
            // Prep for processing
            auto data = copyList(head);
            result = data.first;
            if ((k == 0) || (result == nullptr)) {
                return result;
            }
            auto size = data.second;
            auto rotate = k % size;
            auto working = result;
            vector<RotateListNode *> pointerList;
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
        }
        return result;
    }

private:
    static pair<RotateListNode *, int> copyList(RotateListNode *head) {
        RotateListNode *result = nullptr;
        auto count = 0;
        if (head != nullptr) {
            auto current = head;
            result = new RotateListNode(current->val);
            count++;
            auto working = result;
            while (current->next != nullptr) {
                current = current->next;
                working->next = new RotateListNode(current->val);
                count++;
                working = working->next;
            }
        }
        return make_pair(result, count);
    }
};

#pragma clang diagnostic pop