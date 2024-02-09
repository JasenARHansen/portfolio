#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_CHECK_SUBTREE
#define CTCI_CH_4_TREES_AND_GRAPHS_CHECK_SUBTREE

#include <vector>

using namespace std;

class CheckSubtree {
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

    static bool isSubtreeByData(Node *tree1, Node *tree2);

    static bool isSubtreeByNode(Node *tree1, Node *tree2);

};

#endif
#pragma clang diagnostic pop