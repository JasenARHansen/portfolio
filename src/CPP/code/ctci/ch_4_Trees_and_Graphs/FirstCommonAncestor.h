#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_FIRST_COMMON_ANCESTOR
#define CTCI_CH_4_TREES_AND_GRAPHS_FIRST_COMMON_ANCESTOR

#include <vector>

using namespace std;

class FirstCommonAncestor {
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

    static Node *firstCommonAncestor(Node *head, Node *node1, Node *node2);

private:
    static bool treeContains(Node *head, Node *target);
};

#endif
#pragma clang diagnostic pop