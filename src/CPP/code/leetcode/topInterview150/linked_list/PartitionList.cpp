#pragma clang diagnostic push
#pragma ide diagnostic ignored "NullDereference"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class PartitionList {
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
        cout << R"(86: Partition List
    Given the head of a linked list and a value x, partition it such that all nodes less than x come
     before nodes greater than or equal to x.
    You should preserve the original relative order of the nodes in each of the two partitions.
    Example 1:
        Input: head = [1, 4, 3, 2, 5, 2], x = 3
        Output: [1, 2, 2, 4, 3, 5]
    Example 2:
        Input: head = [2, 1], x = 2
        Output: [1, 2]
    Constraints:
        The number of nodes in the list is in the range [0, 200].
        -100 ≤ Node.val ≤ 100
        -200 ≤ x ≤ 200)" << endl;
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
        assert(numbers.size() <= 200);
        Node *result = nullptr;
        if (!numbers.empty()) {
            assert(-100 <= numbers[0]);
            assert(numbers[0] <= 100);
            result = new Node(numbers[numbers.size() - 1]);
            for (int index = (int) numbers.size() - 2; index >= 0; index--) {
                assert(-100 <= numbers[index]);
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

    static Node *partition(Node *head, int x) {
        assert(-200 <= x);
        assert(x <= 200);
        // Prep for processing
        auto result = copyList(head);
        if (result == nullptr) {
            return result;
        }
        auto working = result;
        Node *last = nullptr;
        while ((working != nullptr) && (working->val >= x)) {
            last = working;
            working = working->next;
        }
        if (working == nullptr) {
            return result;
        }
        auto partition = working;
        if (last != nullptr) {
            last->next = partition->next;
            partition->next = result;
            result = partition;
            working = last->next;
        } else {
            partition = working;
            last = working;
            working = working->next;
        }
        while (working != nullptr) {
            if (working->val < x) {
                // if the current is the node after the partition, move the partition pointer
                if (partition->next != working) {
                    // remove node from list
                    auto temp = working;
                    last->next = working->next;
                    // insert node at end of partition
                    temp->next = partition->next;
                    partition->next = temp;
                    working = last;
                }
                partition = partition->next;
            }
            last = working;
            working = working->next;
        }
        return result;
    }

private:
    static Node *copyList(Node *head) {
        Node *result = nullptr;
        if (head != nullptr) {
            auto current = head;
            result = new Node(current->val);
            auto working = result;
            while (current->next != nullptr) {
                current = current->next;
                working->next = new Node(current->val);
                working = working->next;
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop