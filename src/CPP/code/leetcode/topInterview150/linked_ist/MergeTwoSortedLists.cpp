#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

struct MergeTwoSortedListsNode {
    int val;
    MergeTwoSortedListsNode *next;

    MergeTwoSortedListsNode() : val(0), next(nullptr) {}

    explicit MergeTwoSortedListsNode(int x) : val(x), next(nullptr) {}

    MergeTwoSortedListsNode(int x, MergeTwoSortedListsNode *next) : val(x), next(next) {}
};

class MergeTwoSortedLists {
public:
    static void description() {
        cout << R"(21. Merge Two Sorted Lists
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.

    Example 1:
        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]

    Example 2:
        Input: list1 = [], list2 = []
        Output: []

    Example 3:
        Input: list1 = [], list2 = [0]
        Output: [0]

    Constraints:
        The number of nodes in both lists is in the range [0, 50].
        -100 ≤ MergeTwoSortedListsNode.val ≤ 100
        Both list1 and list2 are sorted in non-decreasing order.)" << endl;
    }

    static vector<int> serializeList(MergeTwoSortedListsNode *head) {
        vector<int> result;
        MergeTwoSortedListsNode *working = head;
        while (working != nullptr) {
            result.push_back(working->val);
            working = working->next;
        }
        return result;
    }

    static MergeTwoSortedListsNode *deserializeList(const vector<int> &numbers) {
        assert(numbers.size() <= 50);
        MergeTwoSortedListsNode *current = nullptr;
        if (!numbers.empty()) {
            assert(-100 <= numbers[0]);
            assert(numbers[0] <= 100);
            current = new MergeTwoSortedListsNode(numbers[numbers.size() - 1]);
            for (int index = (int) numbers.size() - 2; index >= 0; index--) {
                assert(-100 <= numbers[index]);
                assert(numbers[index] <= 100);
                auto node = new MergeTwoSortedListsNode(numbers[index], current);
                current = node;
            }
        }
        return current;
    }

    static void deleteList(MergeTwoSortedListsNode **head) {
        auto current = *head;
        if (current != nullptr) {
            MergeTwoSortedListsNode *next;
            while (current->next != nullptr) {
                next = current->next;
                delete current;
                current = next;
            }
            *head = nullptr;
        }
    }

    static MergeTwoSortedListsNode *
    mergeTwoLists_splice(MergeTwoSortedListsNode *list1, MergeTwoSortedListsNode *list2) {
        // This version makes a new list using the pieces of the original lists, it will mutate the source data.
        MergeTwoSortedListsNode *result = nullptr;
        if ((list1 == nullptr) && (list2 == nullptr)) {
            return result;
        }
        auto lVal = list1;
        auto rVal = list2;
        if (lVal == nullptr) {
            result = rVal;
            rVal = rVal->next;
        } else if (rVal == nullptr) {
            result = lVal;
            lVal = lVal->next;
        } else if (lVal->val < rVal->val) {
            result = lVal;
            lVal = lVal->next;
        } else {
            result = rVal;
            rVal = rVal->next;
        }
        auto current = result;
        while ((lVal != nullptr) && ((rVal != nullptr))) {
            if (lVal->val < rVal->val) {
                current->next = lVal;
                lVal = lVal->next;
            } else {
                current->next = rVal;
                rVal = rVal->next;
            }
            current = current->next;
        }
        // process if lVal has remaining digits
        while (lVal != nullptr) {
            current->next = lVal;
            current = current->next;
            lVal = lVal->next;
        }
        // process if rVal has remaining digits
        while (rVal != nullptr) {
            current->next = rVal;
            current = current->next;
            rVal = rVal->next;
        }
        return result;
    }

    static MergeTwoSortedListsNode *mergeTwoLists_new(MergeTwoSortedListsNode *list1, MergeTwoSortedListsNode *list2) {
        // This version makes a new list with the values.  It does not mutate the source data.
        MergeTwoSortedListsNode *result = nullptr;
        if ((list1 == nullptr) && (list2 == nullptr)) {
            return result;
        }
        auto lVal = list1;
        auto rVal = list2;
        if (lVal == nullptr) {
            result = new MergeTwoSortedListsNode(rVal->val);
            rVal = rVal->next;
        } else if (rVal == nullptr) {
            result = new MergeTwoSortedListsNode(lVal->val);
            lVal = lVal->next;
        } else if (lVal->val < rVal->val) {
            result = new MergeTwoSortedListsNode(lVal->val);
            lVal = lVal->next;
        } else {
            result = new MergeTwoSortedListsNode(rVal->val);
            rVal = rVal->next;
        }
        auto current = result;
        while ((lVal != nullptr) && ((rVal != nullptr))) {
            MergeTwoSortedListsNode *working;
            if (lVal->val < rVal->val) {
                working = new MergeTwoSortedListsNode(lVal->val);
                lVal = lVal->next;
            } else {
                working = new MergeTwoSortedListsNode(rVal->val);
                rVal = rVal->next;
            }
            current->next = working;
            current = working;
        }
        // process if lVal has remaining digits
        while (lVal != nullptr) {
            auto working = new MergeTwoSortedListsNode(lVal->val);
            current->next = working;
            current = working;
            lVal = lVal->next;
        }
        // process if rVal has remaining digits
        while (rVal != nullptr) {
            auto working = new MergeTwoSortedListsNode(rVal->val);
            current->next = working;
            current = working;
            rVal = rVal->next;
        }
        return result;
    }
};

#pragma clang diagnostic pop