#include "RouteBetweenNodes.h"
#include <iostream>
#include <queue>

using namespace std;

void RouteBetweenNodes::description() {
    cout << R"(Trees and Graphs: Route Between Nodes
    Given a directed graph, design an algorithm to find out whether there is a route between two nodes.)" << endl;
}

RouteBetweenNodes::GraphDirected *
RouteBetweenNodes::generateGraph(const vector<int> &data, const vector<pair<int, int>> &edges) {
    auto *graph = new GraphDirected();
    if (!data.empty()) {
        Node *working;
        for (int index: data) {
            working = new Node(index);
            graph->nodes.emplace(index, working);
        }
        for (auto edge: edges) {
            // Directed graphs have edges going 1 way
            graph->nodes.at(edge.first)->insertAdjacent(graph->nodes.at(edge.second));
        }
    }
    return graph;
}

void RouteBetweenNodes::deleteGraph(GraphDirected **graph) {
    if (*graph != nullptr) {
        for (auto element: (*graph)->nodes) {
            delete element.second;
        }
        *graph = nullptr;
    }
}

bool RouteBetweenNodes::routeBetweenNodes(GraphDirected *graph, int value1, int value2) {
    auto result = false;
    queue<Node *> traverse;
    set<Node *> seen;
    // A directed graph has 1 way edges, that means the path from node1 → node2 is different from node2 → node1
    // path: node1 → node2
    traverse.emplace(graph->nodes.at(value1));
    Node *working;
    while (!traverse.empty()) {
        working = traverse.front();
        traverse.pop();
        if (working->data == value2) {
            result = true;
            break;
        }
        seen.insert(working);
        for (auto element: working->adjacent) {
            if (!seen.count(element)) {
                traverse.emplace(element);
            }
        }
    }
    return result;
}

bool RouteBetweenNodes::routeBetweenNodes(GraphDirected *graph, Node *node1, Node *node2) {
    auto result = false;
    queue<Node *> traverse;
    set<Node *> seen;
    // A directed graph has 1 way edges, that means the path from node1 → node2 is different from node2 → node1
    // path: node1 → node2
    traverse.emplace(graph->nodes.at(node1->data));
    Node *working;
    while (!traverse.empty()) {
        working = traverse.front();
        traverse.pop();
        if (working == node2) {
            result = true;
            break;
        }
        seen.insert(working);
        for (auto element: working->adjacent) {
            if (!seen.count(element)) {
                traverse.emplace(element);
            }
        }
    }
    return result;
}