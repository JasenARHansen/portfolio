#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_PATHS_WITH_SUM
#define CTCI_CH_4_TREES_AND_GRAPHS_PATHS_WITH_SUM

#include <vector>

namespace ctci {
    class PathsWithSum {
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

        static int pathsWithSum(Node *root, int data);

    private:
        static int pathsWithSum(Node *root, int data, std::vector<int> path);
    };
}
#endif
#pragma clang diagnostic pop