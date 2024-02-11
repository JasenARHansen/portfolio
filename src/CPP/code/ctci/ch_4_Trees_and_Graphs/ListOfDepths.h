#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_LIST_OF_DEPTHS
#define CTCI_CH_4_TREES_AND_GRAPHS_LIST_OF_DEPTHS

#include <vector>

namespace ctci {
    class ListOfDepths {
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

        static std::vector<std::vector<int>> getListOfDepths(Node *node);
    };
}
#endif
#pragma clang diagnostic pop