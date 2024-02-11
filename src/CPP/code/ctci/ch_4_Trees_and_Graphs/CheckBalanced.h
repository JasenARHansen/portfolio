#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_CHECK_BALANCED
#define CTCI_CH_4_TREES_AND_GRAPHS_CHECK_BALANCED

#include <vector>

namespace ctci {
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

        static Node *generateBSTree(const std::vector<int> &data);

        static void deleteTree(Node **head);

        static bool checkBalanced(Node *node);

    private:
        static std::pair<bool, int> checkBalancedHelper(Node *node);
    };
}
#endif
#pragma clang diagnostic pop