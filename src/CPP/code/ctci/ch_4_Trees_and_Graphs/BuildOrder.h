#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_BUILD_ORDER
#define CTCI_CH_4_TREES_AND_GRAPHS_BUILD_ORDER

#include <set>
#include <vector>
#include <map>

class BuildOrder {
private:
    struct Node {
        char data;
        std::set<Node *> dependencies;

        explicit Node() = default;

        explicit Node(char c) : data(c) {}

        void insertDependency(Node *dependency) {
            this->dependencies.insert(dependency);
        }
    };

    class GraphDirected {
    public:
        // This graph does not allow for duplicate data values
        explicit GraphDirected() = default;

        std::map<char, Node *> nodes;
    };

public:
    static void description();

    static GraphDirected *
    generateGraph(const std::vector<char> &data, const std::vector<std::pair<char, char>> &dependencies);

    static void deleteGraph(GraphDirected **graph);

    static std::vector<char> buildOrder(GraphDirected *graph);
};

#endif
#pragma clang diagnostic pop