#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <map>
#include <queue>
#include <set>

using namespace std;

class ComponentsInAGraph {
public:
    static void description() {
        cout << R"(Disjoint Set: Components in a graph
    There are 2 * N nodes in an undirected graph, and a number of edges connecting some nodes.
    In each edge, the first value will be between 1 and N, inclusive.
    The second node will be between N and 2 * N, inclusive.
    Given a list of edges, determine the size of the smallest and largest connected components that
     have 2 or more nodes. A node can have any number of connections.
    The highest node value will always be connected to at least 1 other node.
    Note: Single nodes should not be considered in the answer.
    Example:
        bg = [[1, 5], [1, 6], [2,4]]
        (3)     (2) - (4)       (1) - (5)
                                    \ (6)
    The smaller component contains 2 nodes and the larger contains 3.
        Return the array [2, 3].
    Function Description:
        Complete the connectedComponents function in the editor below.
        connectedComponents has the following parameter(s):
            int bg[n][2]: a 2-d array of integers that represent node ends of graph edges
        Returns:
            int[2]: an array with 2 integers, the smallest and largest component sizes
    Input Format:
        The first line contains an integer n, the size of bg.
        Each of the next n lines contain two space-separated integers, bg[i][0] and bg[i][1].
    Constraints:
        1 ≤ numberOfNodesN ≤ 15,000
        1 ≤ bg[i][0] ≤ N
        N + 1 ≤ bg[i][1 ≤ 2N
Sample Input:
    STDIN   Function
    -----   --------
    5       bg[] size n = 5
    1 6     bg = [[1, 6],[2, 7], [3, 8], [4,9], [2, 6]]
    2 7
    3 8
    4 9
    2 6
Sample Output:
    2 4
    Explanation:
        (5)   (4) - (9)   (3) - (8)   (1) - (5)
                                         /
                                      (2) - (7)
    Since the component with node 5 contains only one node, it is not considered.
    The number of vertices in the smallest connected component in the graph is 2 based on either (3, 8) or (4, 9).
    The number of vertices in the largest connected component in the graph is 4 i.e. 1 - 2 - 6- 7.)" << endl;
    }

    static vector<int> componentsInGraph(const vector<vector<int>> &gb) {
        vector<int> result;
        map<int, vector<int>> connections;
        map<int, int> totals;
        for (auto edge: gb) {
            if (!connections.count(edge.at(0))) {
                connections[edge.at(0)] = {};
            }
            connections.at(edge.at(0)).push_back(edge.at(1));
            if (!connections.count(edge.at(1))) {
                connections[edge.at(1)] = {};
            }
            connections.at(edge.at(1)).push_back(edge.at(0));
        }
        queue<vector<int>> working;
        set<int> visited;
        int count;
        while (!connections.empty()) {
            count = 1;
            visited.clear();
            working.push(connections.begin()->second);
            visited.insert(connections.begin()->first);
            connections.erase(connections.begin());
            while (!working.empty()) {
                for (auto element: working.front()) {
                    // I need to increment count based on what is new
                    if (connections.count(element)) {
                        count++;
                        visited.insert(element);
                        working.push(connections.at(element));
                        connections.erase(element);
                    }
                }
                working.pop();
            }
            totals[count]++;
        }
        result.push_back(totals.begin()->first);
        result.push_back(prev(totals.end())->first);
        return result;
    }

};

#pragma clang diagnostic pop