#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_SUCCESSOR
#define CTCI_CH_4_TREES_AND_GRAPHS_SUCCESSOR

#include <vector>

namespace ctci {
    class Successor {
    private:
        struct Node {
            int data;
            Node *parent;
            Node *leftChild;
            Node *rightChild;

            explicit Node(int x) : data(x), parent(nullptr), leftChild(nullptr), rightChild(nullptr) {}
        };

    public:
        static void description();

        static Node *generateBSTree(const std::vector<int> &data);

        static void deleteTree(Node **head);

        static Node *inorderSuccessor(Node *node);

        static Node *inorderSuccessor(Node *root, int data);
    };
}
#endif
#pragma clang diagnostic pop