#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class AddTwoNumbers {
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
        cout << R"(2: Add Two Numbers
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Example 1:
        Input: l1 = [2, 4, 3], l2 = [5, 6, 4]
        Output: [7, 0, 8]
        Explanation:
            342 + 465 = 807.
    Example 2:
        Input: l1 = [0], l2 = [0]
        Output: [0]
    Example 3:
        Input: l1 = [9, 9, 9, 9, 9, 9, 9], l2 = [9, 9, 9, 9]
        Output: [8, 9, 9, 9, 0, 0, 0, 1]
    Constraints:
        The number of nodes in each linked list is in the range [1, 100].
        0 ≤ AddTwoNumbersListNode.val ≤ 9
        It is guaranteed that the list represents a number that does not have leading zeros.)" << endl;
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
        assert(numbers.size() <= 100);
        assert(0 <= numbers[0]);
        assert(numbers[0] <= 9);
        auto current = new Node(numbers[numbers.size() - 1]);
        for (int index = (int) numbers.size() - 2; index >= 0; index--) {
            assert(0 <= numbers[index]);
            assert(numbers[index] <= 9);
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

    static Node *addTwoNumbers(Node *l1, Node *l2) {
        Node *result = nullptr;
        if ((l1 == nullptr) || (l2 == nullptr)) {
            return result;
        }
        auto lVal = l1;
        auto rVal = l2;
        auto sum = (lVal->val + rVal->val) % 10;
        auto carry = (lVal->val + rVal->val) / 10;
        result = new Node(sum);
        auto current = result;
        while ((lVal->next != nullptr) && ((rVal->next != nullptr))) {
            lVal = lVal->next;
            rVal = rVal->next;
            sum = (lVal->val + rVal->val + carry) % 10;
            carry = (lVal->val + rVal->val + carry) / 10;
            auto working = new Node(sum);
            current->next = working;
            current = working;
        }
        // process if lVal has remaining digits
        while (lVal->next != nullptr) {
            lVal = lVal->next;
            sum = (lVal->val + carry) % 10;
            carry = (lVal->val + carry) / 10;
            auto working = new Node(sum);
            current->next = working;
            current = working;
        }
        // process if rVal has remaining digits
        while (rVal->next != nullptr) {
            rVal = rVal->next;
            sum = (rVal->val + carry) % 10;
            carry = (rVal->val + carry) / 10;
            auto working = new Node(sum);
            current->next = working;
            current = working;
        }
        // if there is still a carry
        if (carry) {
            auto working = new Node(carry);
            current->next = working;
        }
        return result;
    }
};

#pragma clang diagnostic pop