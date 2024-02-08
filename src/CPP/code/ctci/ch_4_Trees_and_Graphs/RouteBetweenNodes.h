#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_4_TREES_AND_GRAPHS_ROUTE_BETWEEN_NODES
#define CTCI_CH_4_TREES_AND_GRAPHS_ROUTE_BETWEEN_NODES

#include <set>
#include <vector>
#include <map>

using namespace std;

class RouteBetweenNodes {
private:
    struct Node {
        int data;
        set<Node *> adjacent;

        explicit Node() = default;

        explicit Node(int x) : data(x) {}

        void insertAdjacent(Node *neighbour) {
            this->adjacent.insert(neighbour);
        }
    };

    class GraphDirected {
    public:
        // This graph does not allow for duplicate data values
        explicit GraphDirected() = default;

        map<int, Node *> nodes;
    };

public:
    static void description();

    static GraphDirected *generateGraph(const vector<int> &data, const vector<pair<int, int>> &edges);

    static void deleteGraph(GraphDirected **graph);

    static bool routeBetweenNodes(GraphDirected *graph, int value1, int value2);

    static bool routeBetweenNodes(GraphDirected *graph, Node *node1, Node *node2);
};

#endif
#pragma clang diagnostic pop