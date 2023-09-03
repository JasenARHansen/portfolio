#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <cmath>
#include <unordered_map>

using namespace std;

class Node {

public:

    int val;
    Node *next;
    Node *random;

    explicit Node(int _val) {
        val = _val;
        next = nullptr;
        random = nullptr;
    }
};

class CopyListWithRandomPointer {

public:

    static void description() {
        cout << R"(138. Copy List with Random Pointer
    A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
    Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
    For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
    Return the head of the copied linked list.
    The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
        val: an integer representing Node.val
        random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
    Your code will only be given the head of the original linked list.

    Example 1:
        Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

    Example 2:
        Input: head = [[1,1],[2,1]]
        Output: [[1,1],[2,1]]

    Example 3:
        Input: head = [[3,null],[3,0],[3,null]]
        Output: [[3,null],[3,0],[3,null]]

    Constraints:
        0 <= n <= 1000
        -10^4 <= Node.val <= 10^4
        Node.random is null or is pointing to some node in the linked list.)" << endl;
    }

    static Node *generateList(const vector<int> &numbers) {
        assert(numbers.size() <= 1000);
        Node *root = nullptr;
        if (!numbers.empty()) {
            assert(-pow(10, 4) <= numbers[0]);
            assert(numbers[0] <= pow(10, 4));
            root = new Node(numbers[0]);
            Node *last = root;
            for (int index = 1; index < numbers.size(); index++) {
                assert(-pow(10, 4) <= numbers[index]);
                assert(numbers[index] <= pow(10, 4));
                auto *node = new Node(numbers[index]);
                last->next = node;
                last = node;
            }
        }
        return root;
    }

    static void deleteList(const unsigned long int size, Node **head) {
        auto index = size;
        Node *current = *head;
        Node *next;
        while (index > 0) {
            next = current->next;
            delete current;
            current = next;
            index--;
        }
        *head = nullptr;
    }

    static Node *copyRandomList(Node *head) {
        Node *result = nullptr;
        if (head != nullptr) {
            auto index = 0;
            vector<Node *> indexes;
            unordered_map<Node *, int> pointerMap;
            result = new Node(head->val);
            Node *copyHead = head;
            pointerMap[copyHead] = index;
            Node *current = result;
            indexes.push_back(current);
            while (copyHead->next != nullptr) {
                index++;
                copyHead = copyHead->next;
                pointerMap[copyHead] = index;
                auto *node = new Node(copyHead->val);
                current->next = node;
                current = current->next;
                indexes.push_back(current);
            }
            // assign random pointer
            copyHead = head;
            index = 0;
            while (copyHead != nullptr) {
                if (copyHead->random != nullptr) {
                    indexes[index]->random = indexes[pointerMap.at(copyHead->random)];
                }
                copyHead = copyHead->next;
                index++;
            }

        }
        return result;
    }
};

#pragma clang diagnostic pop