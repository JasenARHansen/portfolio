#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <unordered_map>
#include <vector>
#include <queue>
#include <bits/stdc++.h>

using namespace std;

class CloneGraph {
private:
    class Node {
    public:
        int val;
        vector<Node *> neighbors;

        Node() : val(0), neighbors(vector<Node *>()) {}

        explicit Node(int val) : val(val), neighbors(vector<Node *>()) {}

        Node(int val, vector<Node *> neighbors) : val(val), neighbors(std::move(neighbors)) {}
    };

public:
    static void description() {
        cout << R"(133: Clone Graph
    Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.
    Each node in the graph contains a value (int) and a list (List[CloneGraphNode]) of its neighbors.
        class CloneGraphNode {
            public int val;
            public List<CloneGraphNode> neighbors;
        }
    Test case format:
        For simplicity, each node's value is the same as the node's index (1-indexed).
        For example, the first node with val == 1, the second node with val == 2, and so on.
        The graph is represented in the test case using an adjacency list.
        An adjacency list is a collection of unordered lists used to represent a finite graph.
        Each list describes the set of neighbors of a node in the graph.
        The given node will always be the first node with val = 1.
        You must return the copy of the given node as a reference to the cloned graph.
    Example 1:
        Input: adjList = [[2, 4], [1, 3], [2, 4], [1, 3]]
        Output: [[2, 4], [1, 3], [2, 4], [1, 3]]
        Explanation:
            There are 4 nodes in the graph.
            1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
            2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
            3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
            4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
    Example 2:
        Input: adjList = [[]]
        Output: [[]]
        Explanation:
            Note that the input contains one empty list.
            The graph consists of only one node with val = 1 and it does not have any neighbors.
    Example 3:
        Input: adjList = []
        Output: []
        Explanation:
            This an empty graph, it does not have any nodes.
    Constraints:
        The number of nodes in the graph is in the range [0, 100].
        1 ≤ Node.val ≤ 100
        Node.val is unique for each node.
        There are no repeated edges and no self-loops in the graph.
        The Graph is connected and all nodes can be visited starting from the given node.)" << endl;
    }

    static Node *deserializeGraph(const vector<vector<int>> &values) {
        Node *result = nullptr;
        if (!values.empty()) {
            vector<Node *> graph;
            graph.reserve(values.size());
            auto index = 1;
            for (auto node: values) {
                graph.push_back(new Node(index++));
            }
            index = 0;
            for (const auto &node: values) {
                for (auto neighbor: node) {
                    graph[index]->neighbors.push_back(graph[neighbor - 1]);
                }
                index++;
            }
            result = graph[0];
        }
        return result;
    }

    static vector<vector<int>> serializeGraph(Node *head) {
        vector<vector<int>> data;
        if (head != nullptr) {
            unordered_map<int, vector<Node *>> graph;
            queue<Node *> processing;
            processing.push(head);
            graph[head->val] = head->neighbors;
            Node *working;
            while (!processing.empty()) {
                working = processing.front();
                processing.pop();
                for (auto neighbor: working->neighbors) {
                    if (!graph.count(neighbor->val)) {
                        graph[neighbor->val] = neighbor->neighbors;
                        processing.push(neighbor);
                    }
                }
            }
            vector<long> keys;
            keys.reserve(graph.size());
            for (const auto &key: graph) {
                keys.push_back(key.first);
            }
            sort(keys.begin(), keys.end(), less<>());
            for (auto key: keys) {
                vector<int> neighbors;
                for (auto neighbor: graph.at(key)) {
                    neighbors.push_back(neighbor->val);
                }
                data.push_back(neighbors);
            }
        }
        return data;
    }

    static void deleteGraph(Node **head) {
        auto current = *head;
        if (current != nullptr) {
            unordered_set<Node *> toDelete;
            queue<Node *> processing;
            processing.push(current);
            toDelete.insert(current);
            Node *working;
            while (!processing.empty()) {
                working = processing.front();
                processing.pop();
                for (auto neighbor: working->neighbors) {
                    if (!toDelete.count(neighbor)) {
                        processing.push(neighbor);
                        toDelete.insert(neighbor);
                    }
                }
                delete working;
            }
        }
        *head = nullptr;
    }

    static Node *cloneGraph(Node *node) {
        Node *result = nullptr;
        if (node != nullptr) {
            unordered_map<int, Node *> graph;
            unordered_map<int, vector<Node *>> graphNeighbors;
            queue<Node *> processing;
            processing.push(node);
            Node *working;
            while (!processing.empty()) {
                working = processing.front();
                processing.pop();
                graph[working->val] = new Node(working->val);
                graphNeighbors[working->val] = working->neighbors;
                for (auto neighbor: working->neighbors) {
                    if (!graphNeighbors.count(neighbor->val)) {
                        graphNeighbors[neighbor->val] = neighbor->neighbors;
                        processing.push(neighbor);
                    }
                }
            }
            vector<long> keys;
            keys.reserve(graph.size());
            for (const auto &key: graph) {
                keys.push_back(key.first);
            }
            for (auto key: keys) {
                for (auto neighbor: graphNeighbors.at(key)) {
                    graph[key]->neighbors.push_back(graph[neighbor->val]);
                }
            }
            result = graph[node->val];
        }
        return result;
    }
};

#pragma clang diagnostic pop