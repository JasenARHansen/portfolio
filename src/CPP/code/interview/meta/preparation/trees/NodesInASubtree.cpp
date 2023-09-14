#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <utility>
#include <vector>
#include <queue>

using namespace std;

class Node {
public:
    int val;
    vector<Node *> children;

    Node() : val(0), children(vector<Node *>()) {}

    explicit Node(int val) : val(val), children(vector<Node *>()) {}

    Node(int val, vector<Node *> children) : val(val), children(std::move(children)) {}
};

struct Query {
    int u;
    char c;
};

class NodesInASubtree {
public:
    static void description() {
        cout << R"(Nodes in a Subtree
    You are given a tree that contains N nodes, each containing an integer u which corresponds to a lowercase character c in the string s using 1-based indexing.
    You are required to answer Q queries of type [u, c], where u is an integer and c is a lowercase letter. The query result is the number of nodes in the subtree of node u containing c.

    Signature
        int[] countOfNodes(Node root, ArrayList<Query> queries, String s)

    Input
        A pointer to the root node, an array list containing Q queries of type [u, c], and a string s

    Constraints
        N and Q are the integers between 1 and 1,000,000
        u is a unique integer between 1 and N
        s is of the length of N, containing only lowercase letters
        c is a lowercase letter contained in string s
        Node 1 is the root of the tree

    Output
        An integer array containing the response to each query

    Example

            1(a)
            /   \
          2(b)  3(a)

        s = "aba"
        RootNode = 1
        queries = [[1, 'a']]
        Note: Node 1 corresponds to first letter 'a', Node 2 corresponds to second letter of the string 'b', Node 3 corresponds to third letter of the string 'a'.
        output = [2]
        Both Node 1 and Node 3 contain 'a', so the number of nodes within the subtree of Node 1 containing 'a' is 2.)"
             << endl;
    }

    static void deleteTree(Node **head) {
        auto current = *head;
        if (current != nullptr) {
            queue<Node *> working;
            working.push(current);
            while (!working.empty()) {
                current = working.front();
                working.pop();
                for (auto child: current->children) {
                    working.push(child);
                }
                delete current;
            }
        }
        *head = nullptr;
    }

    static vector<int> countOfNodes(Node *root, const vector<Query> &queries, const string &s) {
        vector<int> result{};
        for (auto query: queries) {
            auto working = findNode(root, query.u);
            result.push_back(getCount(working, query.c, s));
        }
        return result;
    }

private:
    static Node *findNode(Node *root, int value) {
        Node *result = nullptr;
        if (root != nullptr) {
            queue<Node *> processing;
            processing.push(root);
            while (!processing.empty()) {
                if (processing.front()->val == value) {
                    result = processing.front();
                    break;
                }
                for (auto child: processing.front()->children) {
                    processing.push(child);
                }
                processing.pop();
            }
        }
        return result;
    }

    static int getCount(Node *node, char value, const string &s) {
        auto result = 0;
        if (node != nullptr) {
            queue<Node *> processing;
            processing.push(node);
            int index;
            while (!processing.empty()) {
                index = processing.front()->val - 1;
                if (s.at(index) == value) {
                    result++;
                }
                for (auto child: processing.front()->children) {
                    processing.push(child);
                }
                processing.pop();
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop