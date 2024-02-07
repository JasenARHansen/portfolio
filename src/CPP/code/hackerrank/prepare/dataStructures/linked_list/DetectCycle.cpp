#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <set>

using namespace std;

class DetectCycle {
private:
    struct Node {
        int data;
        Node *next;

        explicit Node(int x) : data(x), next(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Linked Lists: Detect a Cycle
    A linked list is said to contain a cycle if any node is visited more than once while traversing the list.
    For example, in the following graph there is a cycle formed when node 5 points back to node 3:
     1 → 2 → 3 → 4 → 5 → 3.
Function Description:
    Complete the function has_cycle in the editor below.
        It must return a boolean true if the graph contains a cycle, or false.
        has_cycle has the following parameter(s):
            head: a pointer to a Node object that points to the head of a linked list.
        Returns:
            boolean: True if there is a cycle, False if there is not
        Note: If the list is empty, head will be null.
    Input Format:
        There is no input for this challenge.
        A random linked list is generated at runtime and passed to your function.
    Constraints:
            1 ≤ list size ≤ 100
    Sample Input:
        The following linked lists are passed as arguments to your function:
            1 → null.
            1 → 2 → 3 → 2.
    Sample Output:
        0
        1
    Explanation:
        The first list has no cycle, so we return false and the hidden code checker prints 0 to stdout.
        The second list has a cycle, so we return true and the hidden code checker prints 1 to stdout.)" << endl;
    }

    static Node *createList(vector<int> data) {
        Node *result = nullptr;
        if (!data.empty()) {
            result = new Node(data.at(0));
            auto working = result;
            auto index = 1;
            while (index < (int) data.size()) {
                auto *next = new Node(data.at(index));
                working->next = next;
                working = next;
                index++;
            }
        }
        return result;
    }

    static void deleteList(Node **head) {
        auto current = *head;
        Node *next;
        set<Node *> seen;
        while ((current != nullptr) and (!seen.count(current))) {
            seen.insert(current);
            next = current->next;
            current = next;
        }
        for (auto node: seen) {
            delete node;
        }
        *head = nullptr;
    }

    static bool has_cycle(Node *head) {
        set<Node *> seen;
        bool result = false;
        auto working = head;
        while (working != nullptr) {
            if (seen.count(working)) {
                result = true;
                break;
            }
            seen.insert(working);
            working = working->next;
        }
        return result;
    }
};

#pragma clang diagnostic pop