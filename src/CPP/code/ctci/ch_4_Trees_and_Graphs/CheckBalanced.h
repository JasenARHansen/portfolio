#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_CHECK_BALANCED
#define CTCI_CH_4_TREES_AND_GRAPHS_CHECK_BALANCED

#include <set>
#include <vector>
#include <map>

using namespace std;

class CheckBalanced {
private:
    struct Node {
        int data;
        Node *leftChild;
        Node *rightChild;

        explicit Node(int x) : data(x), leftChild(nullptr), rightChild(nullptr) {}
    };

public:
    static void description();

    static Node *generateBSTree(const vector<int> &data);

    static void deleteTree(Node **head);

    static bool checkBalanced(Node *node);

private:
    static pair<bool, int> checkBalancedHelper(Node *node);
};

#endif
#pragma clang diagnostic pop