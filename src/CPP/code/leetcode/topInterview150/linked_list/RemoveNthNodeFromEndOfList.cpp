#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <cmath>

using namespace std;

class RemoveNthNodeFromEndOfList {
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
        cout << R"(19: Remove Nth RemoveNthNodeFromEndOfListNode From End of List
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
    Example 1:
    Input: head = [1, 2, 3, 4, 5], n = 2
    Output: [1, 2, 3, 5]
    Example 2:
    Input: head = [1], n = 1
    Output: []
    Example 3:
    Input: head = [1, 2], n = 1
    Output: [1]
    Constraints:
        The number of nodes in the list is sz.
        1 ≤ sz ≤ 30
        0 ≤ Node.val ≤ 100
        1 ≤ n ≤ sz
    Follow up:
        Could you do this in one pass?)" << endl;
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
        assert(numbers.size() <= 30);
        Node *result = nullptr;
        if (!numbers.empty()) {
            assert(0 <= numbers[0]);
            assert(numbers[0] <= 100);
            result = new Node(numbers[numbers.size() - 1]);
            for (int index = (int) numbers.size() - 2; index >= 0; index--) {
                assert(0 <= numbers[index]);
                assert(numbers[index] <= 100);
                auto node = new Node(numbers[index], result);
                result = node;
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

    static Node *removeNthFromEnd(Node *head, int n) {
        // Prep for processing
        auto data = copyList(head);
        auto result = data.first;
        if (result == nullptr) {
            return result;
        }
        auto size = data.second;
        assert(1 <= n);
        assert(n <= size);
        auto working = result;
        Node *previous = nullptr;
        auto index = 0;
        while (index <= size - n) {
            if (size - n == index) {
                auto temp = working;
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