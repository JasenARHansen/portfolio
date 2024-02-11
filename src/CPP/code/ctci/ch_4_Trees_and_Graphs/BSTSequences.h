#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_BST_SEQUENCES
#define CTCI_CH_4_TREES_AND_GRAPHS_BST_SEQUENCES

#include <vector>

class BSTSequences {
private:
    struct Node {
        int data;
        Node *leftChild;
        Node *rightChild;

        explicit Node(int x) : data(x), leftChild(nullptr), rightChild(nullptr) {}
    };

public:
    static void description();

    static Node *generateBSTree(const std::vector<int> &data);

    static void deleteTree(Node **head);

    static std::vector<std::vector<int>> findAllSequences(Node *node);

private:
    static std::vector<std::vector<int>> generatePermutations(std::vector<int> first, std::vector<int> second);
};

#endif
#pragma clang diagnostic pop