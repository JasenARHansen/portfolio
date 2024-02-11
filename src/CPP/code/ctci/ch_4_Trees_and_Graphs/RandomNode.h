#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_RANDOM_NODE
#define CTCI_CH_4_TREES_AND_GRAPHS_RANDOM_NODE

#include <vector>

namespace ctci {
    class RandomNode {
    private:
        struct Node {
            int data;
            int size;
            Node *leftChild;
            Node *rightChild;

            explicit Node(int x) : data(x), size(1), leftChild(nullptr), rightChild(nullptr) {}
        };

    public:
        static void description();

        void generateBSTree(const std::vector<int> &data);

        void insert(int data);

        void deleteTree();

        Node *getRandomNode();

    private:
        Node *root;
    };
}
#endif
#pragma clang diagnostic pop