#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <cmath>
#include <unordered_map>

using namespace std;

class RandomPointerNode {

public:

    int val;
    RandomPointerNode *next;
    RandomPointerNode *random;

    RandomPointerNode() : val(0), next(nullptr), random(nullptr) {}

    explicit RandomPointerNode(int val) : val(val), next(nullptr), random(nullptr) {}

    RandomPointerNode(int val, RandomPointerNode *next) : val(val), next(next), random(nullptr) {}
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
        0 ≤ n ≤ 1000
        -10^4 ≤ Node.val ≤ 10^4
        Node.random is null or is pointing to some node in the linked list.)" << endl;
    }

    static vector<pair<int, string>> serializeListRandomPointer(RandomPointerNode *head) {
        vector<pair<int, string>> result;
        if (head != nullptr) {
            int index = 0;
            auto current = head;
            unordered_map<RandomPointerNode *, int> indexes;
            while (current != nullptr) {
                indexes[current] = index;
                index++;
                current = current->next;
            }
            current = head;
            while (current != nullptr) {
                result.emplace_back(current->val,
                                    (current->random == nullptr) ? "null" : to_string(indexes.at(current->random)));
                current = current->next;
            }
            indexes.clear();
        }
        return result;
    }

    static RandomPointerNode *deserialize(const vector<pair<int, string>> &numbers) {
        assert(numbers.size() <= 500);
        vector<RandomPointerNode *> indexes;
        RandomPointerNode *head = nullptr;
        if (!numbers.empty()) {
            assert(-pow(10, 4) <= numbers[0].first);
            assert(numbers[0].first <= pow(10, 4));
            head = new RandomPointerNode(numbers[0].first);
            auto current = head;
            indexes.push_back(current);
            for (int index = 1; index < numbers.size(); index++) {
                assert(-pow(10, 4) <= numbers[index].first);
                assert(numbers[index].first <= pow(10, 4));
                current->next = new RandomPointerNode(numbers[index].first);
                current = current->next;
                indexes.push_back(current);
            }
            current = head;
            for (const auto &number: numbers) {
                if (number.second != "null") {
                    current->random = indexes[stoi(number.second)];
                }
                current = current->next;
            }
        }
        return head;
    }

    static void deleteList(RandomPointerNode **head) {
        auto current = *head;
        if (current != nullptr) {
            RandomPointerNode *next;
            while (current->next != nullptr) {
                next = current->next;
                delete current;
                current = next;
            }
            *head = nullptr;
        }
    }

    static RandomPointerNode *copyRandomList(RandomPointerNode *head) {
        RandomPointerNode *result = nullptr;
        if (head != nullptr) {
            auto source = head;
            unordered_map<RandomPointerNode *, int> pointerMap;
            vector<RandomPointerNode *> indexes;
            int index = 0;
            // generate node to index map
            while (source != nullptr) {
                pointerMap[source] = index;
                index++;
                source = source->next;
            }
            // Generate new list and auto data
            source = head;
            result = new RandomPointerNode(source->val);
            auto current = result;
            indexes.push_back(current);
            while (source->next != nullptr) {
                current->next = new RandomPointerNode(source->next->val);
                indexes.push_back(current->next);
                source = source->next;
                current = current->next;
            }
            // Populate random data
            source = head;
            current = result;
            while (source != nullptr) {
                if (source->random != nullptr) {
                    current->random = indexes[pointerMap.at(source->random)];
                }
                source = source->next;
                current = current->next;
            }
            indexes.clear();
            pointerMap.clear();
        }
        return result;
    }
};

#pragma clang diagnostic pop