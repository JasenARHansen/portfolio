#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <queue>

using namespace std;

class GraphRequiresOffsets {


public:
    static void description() {
        cout << R"(Implementation with all offsets in main function.  Not what I would do.)" << endl;
    }

    class Graph {

    private:
        struct GraphNode {
            set<int> adjacent;

            explicit GraphNode() {}

            set<int> getAdjacent() const {
                return this->adjacent;
            }

            void insertAdjacent(int neighbour) {
                this->adjacent.insert(neighbour);
            }
        };

        map<int, GraphNode *> nodes;


    public:
        Graph(int n) {
            for (auto i = 0; i < n; i++) {
                GraphNode *node = new GraphNode();
                this->nodes[i] = node;
            }
        }

        void add_edge(int u, int v) {
            this->nodes.at(u)->insertAdjacent(v);
        }

        vector<int> shortest_reach(int start) {
            vector<int> result;
            map<int, int> visited;
            auto level = 0;
            queue<int> levelA;
            queue<int> levelB;
            for (auto element: this->nodes.at(start)->getAdjacent()) {
                levelA.push(element);
            }
            while (!levelA.empty() || !levelB.empty()) {
                level++;
                if (!levelA.empty()) {
                    while (!levelA.empty()) {
                        if (!visited.count(levelA.front())) {
                            visited[levelA.front()] = level * 6;
                            for (auto element: this->nodes.at(levelA.front())->getAdjacent()) {
                                if (!visited.count(element)) {
                                    levelB.push(element);
                                }
                            }
                        }
                        levelA.pop();
                    }
                } else {
                    while (!levelB.empty()) {
                        if (!visited.count(levelB.front())) {
                            visited[levelB.front()] = level * 6;
                            for (auto element: this->nodes.at(levelB.front())->getAdjacent()) {
                                if (!visited.count(element)) {
                                    levelA.push(element);
                                }
                            }
                        }
                        levelB.pop();
                    }
                }
            }
            vector<int> process{};
            for (auto i = 0; i < this->nodes.size(); i++) {
                process.push_back(i);
            }
            for (auto index: process) {
                if (visited.count(index)) {
                    result.push_back(visited.at(index));
                } else {
                    result.push_back(-1);
                }
            }
            return result;
        }
    };

};

class ShortestReachInAGraphUnidirectionalEdges {

public:
    static void description() {
        cout << R"(Consider an undirected graph consisting of n nodes where each node is labeled from 1 to n and the
     edge between any two nodes is always of length 6. We define node s to be the starting position for a BFS.
    Given a graph, determine the distances from the start node to each of its descendants and return the list
     in node number order, ascending. If a node is disconnected, it's distance should be -1.

    For example, there are n = 6 nodes in the graph with a starting node s = 1. The list of edges = [[1, 2], [2, 3],
     [3, 4], [1, 5]], and each has a weight of 6.

    Starting from node 1 and creating a list of distances, for nodes 2 through 6 we have distances = [6, 12, 18, 6, -1].

    Function Description:
        Define a Graph class with the required methods to return a list of distances.

    Input Format:
        The first line contains an integer, q, the number of queries.
        Each of the following q sets of lines is as follows:
            The first line contains two space-separated integers, n and m, the number of nodes and the number of edges.
        Each of the next m lines contains two space-separated integers, u and v, describing an edge connecting node
         u to v node.
        The last line contains a single integer, s, the index of the starting node.

    Constraints:
        1 ≤ q ≤ 10
        2 ≤ n ≤ 1000
        1 ≤ m ≤ n(n-1)/2
        1 ≤ u, v, s ≤ n

    Output Format:
        For each of the q queries, print a single line of n - 1 space-separated integers denoting the shortest
         distances to each of the other n - 1 nodes from starting position s.
        These distances should be listed sequentially by node number (i.e., 1, 2, ..., n), but should not
         include node s.
        If some node is unreachable from s , print -1 as the distance to that node.

    Sample Input:
        2
        4 2
        1 2
        1 3
        1
        3 1
        2 3
        2

    Sample Output
        6 6 -1
        -1 6

    Explanation:
        We perform the following two queries:
            The given graph can be represented as: [4 2], [1 2], [1 3] where our start node s, is node 1.
            The shortest distances from s to the other nodes are one edge to node 2, one edge to node 3,
             and there is no connection to node. (This looks like single direction connections)
            The given graph can be represented as: [3 1], [2 3] where our start node, s, is node 2.
            There is only one edge here, so node 1 is unreachable from node 2 and node 3 has one edge connecting
             it to node 2. We then print node 's distance to nodes and 3 (respectively) as a single line of
             space-separated integers: -1 6.
        Note: Recall that the actual length of each edge is 6, and we print -1 as the distance to any node
           that's unreachable from s.)" << endl;
    }

    class Graph {
    public:
        Graph(int n) : weight(6) {
            for (auto i = 0; i < n; i++) {
                GraphNode *node = new GraphNode();
                this->nodes[i + 1] = node;
            }
        }

        void setWeight(int input) {
            this->weight = input;
        }

        void add_edge(int u, int v) {
            this->nodes.at(u)->insertAdjacent(v);
        }

        vector<int> shortest_reach(int start) {
            vector<int> result;
            map<int, int> visited;
            auto level = 0;
            queue<int> levelA;
            queue<int> levelB;
            for (auto element: this->nodes.at(start)->getAdjacent()) {
                levelA.push(element);
            }
            while (!levelA.empty() || !levelB.empty()) {
                level++;
                if (!levelA.empty()) {
                    while (!levelA.empty()) {
                        if (!visited.count(levelA.front())) {
                            visited[levelA.front()] = level * this->weight;
                            for (auto element: this->nodes.at(levelA.front())->getAdjacent()) {
                                if (!visited.count(element)) {
                                    levelB.push(element);
                                }
                            }
                        }
                        levelA.pop();
                    }
                } else {
                    while (!levelB.empty()) {
                        if (!visited.count(levelB.front())) {
                            visited[levelB.front()] = level * this->weight;
                            for (auto element: this->nodes.at(levelB.front())->getAdjacent()) {
                                if (!visited.count(element)) {
                                    levelA.push(element);
                                }
                            }
                        }
                        levelB.pop();
                    }
                }
            }
            vector<int> process{};
            for (auto i = 0; i < this->nodes.size(); i++) {
                if ((i + 1) != start) {
                    process.push_back(i + 1);
                }
            }
            for (auto index: process) {
                if (visited.count(index)) {
                    result.push_back(visited.at(index));
                } else {
                    result.push_back(-1);
                }
            }
            return result;
        }

    private:
        struct GraphNode {
            set<int> adjacent;

            explicit GraphNode() {}

            set<int> getAdjacent() const {
                return this->adjacent;
            }

            void insertAdjacent(int neighbour) {
                this->adjacent.insert(neighbour);
            }
        };

        int weight;
        map<int, GraphNode *> nodes;
    };

};

class ShortestReachInAGraphBidirectionalEdges {

public:
    static void description() {
        cout << R"(Consider an undirected graph consisting of n nodes where each node is labeled from 1 to n and the
     edge between any two nodes is always of length 6. We define node s to be the starting position for a BFS.
    Given a graph, determine the distances from the start node to each of its descendants and return the list
     in node number order, ascending. If a node is disconnected, it's distance should be -1.

    For example, there are n = 6 nodes in the graph with a starting node s = 1. The list of edges = [[1, 2], [2, 3],
     [3, 4], [1, 5]], and each has a weight of 6.

    Starting from node 1 and creating a list of distances, for nodes 2 through 6 we have distances = [6, 12, 18, 6, -1].

    Function Description:
        Define a Graph class with the required methods to return a list of distances.

    Input Format:
        The first line contains an integer, q, the number of queries.
        Each of the following q sets of lines is as follows:
            The first line contains two space-separated integers, n and m, the number of nodes and the number of edges.
        Each of the next m lines contains two space-separated integers, u and v, describing an edge connecting node
         u to v node.
        The last line contains a single integer, s, the index of the starting node.

    Constraints:
        1 ≤ q ≤ 10
        2 ≤ n ≤ 1000
        1 ≤ m ≤ n(n-1)/2
        1 ≤ u, v, s ≤ n

    Output Format:
        For each of the q queries, print a single line of n - 1 space-separated integers denoting the shortest
         distances to each of the other n - 1 nodes from starting position s.
        These distances should be listed sequentially by node number (i.e., 1, 2, ..., n), but should not
         include node s.
        If some node is unreachable from s , print -1 as the distance to that node.

    Sample Input:
        2
        4 2
        1 2
        1 3
        1
        3 1
        2 3
        2

    Sample Output
        6 6 -1
        -1 6

    Explanation:
        We perform the following two queries:
            The given graph can be represented as: [4 2], [1 2], [1 3] where our start node s, is node 1.
            The shortest distances from s to the other nodes are one edge to node 2, one edge to node 3,
             and there is no connection to node. (This looks like single direction connections)
            The given graph can be represented as: [3 1], [2 3] where our start node, s, is node 2.
            There is only one edge here, so node 1 is unreachable from node 2 and node 3 has one edge connecting
             it to node 2. We then print node 's distance to nodes and 3 (respectively) as a single line of
             space-separated integers: -1 6.
        Note: Recall that the actual length of each edge is 6, and we print -1 as the distance to any node
           that's unreachable from s.)" << endl;
    }

    class Graph {
    public:
        Graph(int n) : weight(6) {
            for (auto i = 0; i < n; i++) {
                GraphNode *node = new GraphNode();
                this->nodes[i + 1] = node;
            }
        }

        void setWeight(int input) {
            this->weight = input;
        }

        void add_edge(int u, int v) {
            this->nodes.at(u)->insertAdjacent(v);
            this->nodes.at(v)->insertAdjacent(u);
        }

        vector<int> shortest_reach(int start) {
            vector<int> result;
            map<int, int> visited;
            auto level = 0;
            queue<int> levelA;
            queue<int> levelB;
            for (auto element: this->nodes.at(start)->getAdjacent()) {
                levelA.push(element);
            }
            while (!levelA.empty() || !levelB.empty()) {
                level++;
                if (!levelA.empty()) {
                    while (!levelA.empty()) {
                        if (!visited.count(levelA.front())) {
                            visited[levelA.front()] = level * this->weight;
                            for (auto element: this->nodes.at(levelA.front())->getAdjacent()) {
                                if (!visited.count(element)) {
                                    levelB.push(element);
                                }
                            }
                        }
                        levelA.pop();
                    }
                } else {
                    while (!levelB.empty()) {
                        if (!visited.count(levelB.front())) {
                            visited[levelB.front()] = level * this->weight;
                            for (auto element: this->nodes.at(levelB.front())->getAdjacent()) {
                                if (!visited.count(element)) {
                                    levelA.push(element);
                                }
                            }
                        }
                        levelB.pop();
                    }
                }
            }
            vector<int> process{};
            for (auto i = 0; i < this->nodes.size(); i++) {
                if ((i + 1) != start) {
                    process.push_back(i + 1);
                }
            }
            for (auto index: process) {
                if (visited.count(index)) {
                    result.push_back(visited.at(index));
                } else {
                    result.push_back(-1);
                }
            }
            return result;
        }

    private:
        struct GraphNode {
            set<int> adjacent;

            explicit GraphNode() {}

            set<int> getAdjacent() const {
                return this->adjacent;
            }

            void insertAdjacent(int neighbour) {
                this->adjacent.insert(neighbour);
            }
        };

        int weight;
        map<int, GraphNode *> nodes;
    };

};

#pragma clang diagnostic pop