#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_MINIMAL_TREE
#define CTCI_CH_4_TREES_AND_GRAPHS_MINIMAL_TREE

#include <set>
#include <vector>
#include <map>

using namespace std;

class MinimalTree {
private:
    struct Node {
        int data;
        Node *leftChild;
        Node *rightChild;

        explicit Node(int x) : data(x), leftChild(nullptr), rightChild(nullptr) {}
    };

public:
    static void description();

    static Node *generateMinimalTree(const vector<int> &data);

    static void deleteTree(Node **head);

    static vector<int> getLevelOrder(Node *node);
};

#endif
#pragma clang diagnostic pop