#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#pragma ide diagnostic ignored "misc-no-recursion"

#include "BSTSequences.h"
#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

void BSTSequences::description() {
    cout << R"(Trees and Graphs: BST Sequences
    A binary search tree was created by traversing through an array from left to right and
     inserting each element.
    Given a binary search tree with distinct elements, print all possible arrays that could
     have led to this tree.
    Example:    2
               / \
              1   3
    Input:
    Output: {2, 1, 3},{2, 3, 1})" << endl;
}

BSTSequences::Node *BSTSequences::generateBSTree(const vector<int> &data) {
    Node *head = nullptr;
    if (!data.empty()) {
        head = new Node(data.at(0));
        for (auto index = 1; index < (int) data.size(); index++) {
            Node *working = head;
            while (true) {
                if (data.at(index) < working->data) {
                    if (working->leftChild == nullptr) {
                        working->leftChild = new Node(data.at(index));
                        break;
                    } else {
                        working = working->leftChild;
                    }
                } else {
                    if (working->rightChild == nullptr) {
                        working->rightChild = new Node(data.at(index));
                        break;
                    } else {
                        working = working->rightChild;
                    }
                }
            }
        }
    }
    return head;
}

void BSTSequences::deleteTree(Node **node) {
    if (*node != nullptr) {
        queue<Node *> nodes;
        nodes.emplace(*node);
        Node *working;
        while (!nodes.empty()) {
            working = nodes.front();
            nodes.pop();
            if (working->leftChild != nullptr) {
                nodes.emplace(working->leftChild);
            }
            if (working->rightChild != nullptr) {
                nodes.emplace(working->rightChild);
            }
            delete working;
        }
        *node = nullptr;
    }
}

vector<vector<int>> BSTSequences::findAllSequences(Node *node) {
    vector<vector<int>> result{{}};
    if (node != nullptr) {
        result.clear();
        auto left = findAllSequences(node->leftChild);
        auto right = findAllSequences(node->rightChild);
        for (const auto &leftPermutation: left) {
            for (const auto &rightPermutation: right) {
                auto full = generatePermutations(leftPermutation, rightPermutation);
                for (auto individual: full) {
                    individual.insert(individual.begin(), node->data);
                    result.push_back(individual);
                }
            }
        }
    }
    return result;
}

vector<vector<int>> BSTSequences::generatePermutations(vector<int> first, vector<int> second) {
    // Vector of all permutations generated
    vector<vector<int>> permutations;
    // Indicators of what strings are in the spot
    vector<int> counters(first.size(), 0);
    counters.insert(counters.end(), second.size(), 1);
    do {
        size_t index1 = 0;
        size_t index2 = 0;
        vector<int> permutation;
        permutation.reserve(counters.size());
        for (int index: counters) {
            permutation.push_back((index == 0) ? first[index1++] : second[index2++]);
        }
        permutations.push_back(permutation);
    } while (next_permutation(counters.begin(), counters.end()));
    return permutations;
}

#pragma clang diagnostic pop