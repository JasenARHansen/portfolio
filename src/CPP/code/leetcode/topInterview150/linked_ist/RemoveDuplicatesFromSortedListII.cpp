#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <unordered_set>

using namespace std;

struct RemoveDuplicatesFromSortedListIINode {
    int val;
    RemoveDuplicatesFromSortedListIINode *next;

    RemoveDuplicatesFromSortedListIINode() : val(0), next(nullptr) {}

    explicit RemoveDuplicatesFromSortedListIINode(int x) : val(x), next(nullptr) {}

    RemoveDuplicatesFromSortedListIINode(int x, RemoveDuplicatesFromSortedListIINode *next) : val(x), next(next) {}
};

class RemoveDuplicatesFromSortedListII {
public:
    static void description() {
        cout << R"(82. Remove Duplicates from Sorted List II
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

    Example 1:
        Input: head = [1, 2, 3, 3, 4, 4, 5]
        Output: [1, 2, 5]

    Example 2:
        Input: head = [1, 1, 1, 2, 3]
        Output: [2, 3]

    Constraints:
        The number of nodes in the list is in the range [0, 300].
        -100 ≤ RemoveDuplicatesFromSortedListIINode.val ≤ 100
        The list is guaranteed to be sorted in ascending order.)" << endl;
    }

    static vector<int> serializeList(RemoveDuplicatesFromSortedListIINode *head) {
        vector<int> result;
        RemoveDuplicatesFromSortedListIINode *working = head;
        while (working != nullptr) {
            result.push_back(working->val);
            working = working->next;
        }
        return result;
    }

    static RemoveDuplicatesFromSortedListIINode *deserializeList(const vector<int> &numbers) {
        assert(numbers.size() <= 30);
        RemoveDuplicatesFromSortedListIINode *result = nullptr;
        if (!numbers.empty()) {
            assert(0 <= numbers[0]);
            assert(numbers[0] <= 100);
            result = new RemoveDuplicatesFromSortedListIINode(numbers[numbers.size() - 1]);
            for (int index = (int) numbers.size() - 2; index >= 0; index--) {
                assert(0 <= numbers[index]);
                assert(numbers[index] <= 100);
                auto node = new RemoveDuplicatesFromSortedListIINode(numbers[index], result);
                result = node;
            }
        }
        return result;
    }

    static void deleteList(RemoveDuplicatesFromSortedListIINode **head) {
        auto current = *head;
        if (current != nullptr) {
            RemoveDuplicatesFromSortedListIINode *next;
            while (current->next != nullptr) {
                next = current->next;
                delete current;
                current = next;
            }
            *head = nullptr;
        }
    }

    static RemoveDuplicatesFromSortedListIINode *deleteDuplicates(RemoveDuplicatesFromSortedListIINode *head) {
        // Prep for processing
        auto result = copyList(head);
        if (result == nullptr) {
            return result;
        }
        unordered_set<int> uniques;
        unordered_set<int> duplicated;
        auto working = result;
        while (working != nullptr) {
            if (!duplicated.count(working->val)) {
                if (uniques.count(working->val)) {
                    duplicated.insert(working->val);
                } else {
                    uniques.insert(working->val);
                }
            }
            working = working->next;
        }
        working = result;
        // Remove duplicates from front of the list
        while ((working != nullptr) && (duplicated.count(working->val))) {
            result = working->next;
            delete working;
            working = result;
        }
        while (working != nullptr) {
            if ((working->next != nullptr) && (duplicated.count(working->next->val))) {
                auto temp = working->next;
                working->next = temp->next;
                delete temp;
            } else {
                working = working->next;
            }
        }
        return result;
    }

private:
    static RemoveDuplicatesFromSortedListIINode *copyList(RemoveDuplicatesFromSortedListIINode *head) {
        RemoveDuplicatesFromSortedListIINode *result = nullptr;
        if (head != nullptr) {
            auto current = head;
            result = new RemoveDuplicatesFromSortedListIINode(current->val);
            auto working = result;
            while (current->next != nullptr) {
                current = current->next;
                working->next = new RemoveDuplicatesFromSortedListIINode(current->val);
                working = working->next;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop