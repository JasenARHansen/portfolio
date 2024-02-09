#include "BuildOrder.h"
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

void BuildOrder::description() {
    cout << R"(Trees and Graphs: Build Order
    You are given a list of projects and a list of dependencies (which is a list of pairs of
     projects, where the second project is dependent on the first project).
    All of a project's dependencies must be built before the project is.
    Find a build order that will allow the projects to be built.
    If there is no valid build order, return an error.
    Example:
        Input:
            projects: a, b, c, d, e, f
            dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
            Output: f, e, a, b, d, c
            Explanation:
                a is a dependency of d
                f is a dependency of b
                b is a dependency of d
                f is a dependency of a
                d is a dependency of c
                Derived information
                e has no dependency
                f is a dependency of d
                f is a dependency of c
                e
                f  b
                   b  d
                f  a
                   a  d
                      d  c

    )" << endl;
}

BuildOrder::GraphDirected *
BuildOrder::generateGraph(const vector<char> &data, const vector<pair<char, char>> &dependencies) {
    auto *graph = new GraphDirected();
    if (!data.empty()) {
        Node *working;
        for (char character: data) {
            working = new Node(character);
            graph->nodes.emplace(character, working);
        }
        for (auto dependency: dependencies) {
            // Directed graphs have edges going 1 way
            graph->nodes.at(dependency.second)->insertDependency(graph->nodes.at(dependency.first));
        }
    }
    return graph;
}

void BuildOrder::deleteGraph(GraphDirected **graph) {
    if (*graph != nullptr) {
        for (auto element: (*graph)->nodes) {
            delete element.second;
        }
        *graph = nullptr;
    }
}

vector<char> BuildOrder::buildOrder(GraphDirected *graph) {
    vector<char> result;
    map<char, vector<char>> dependencies;
    queue<char> process;
    for (auto node: graph->nodes) {
        dependencies[node.first] = {};
        for (auto dependency: node.second->dependencies) {
            dependencies.at(node.first).push_back(dependency->data);
        }
    }
    auto continueProcessing = true;
    while (continueProcessing) {
        continueProcessing = false;
        for (const auto& node: dependencies) {
            if (node.second.empty()) {
                process.push(node.first);
            }
        }
        if (!process.empty()) {
            continueProcessing = true;
            while (!process.empty()) {
                result.push_back(process.front());
                for (const auto& node: dependencies) {
                    dependencies.at(node.first).erase(
                            remove(dependencies.at(node.first).begin(), dependencies.at(node.first).end(),
                                   process.front()), dependencies.at(node.first).end());
                }
                dependencies.erase(process.front());
                process.pop();
            }
        }
    }
    if (!dependencies.empty()) {
        result.clear();
        result = {'e', 'r', 'r', 'o', 'r'};
    }
    return result;
}