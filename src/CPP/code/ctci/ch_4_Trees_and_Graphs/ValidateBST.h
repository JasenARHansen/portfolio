#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_VALIDATE_BST
#define CTCI_CH_4_TREES_AND_GRAPHS_VALIDATE_BST

#include <vector>

using namespace std;

class ValidateBST {
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

    static Node *generateBSTree(const vector<int> &data);

    static void deleteTree(Node **head);

    static bool validateBST(Node *node);

private:
    static bool validateBSTHelper(Node *node);
};

#endif
#pragma clang diagnostic pop