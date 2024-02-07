#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <queue>
#include <map>
#include <unordered_set>

using namespace std;

class HuffmanDecoding {
private:
    class Node {
    public:
        int freq;
        char data;
        Node *left;
        Node *right;

        explicit Node(int d) : freq(d), data('\0'), left(nullptr), right(nullptr) {}

        Node(int d, char data) : freq(d), data(data), left(nullptr), right(nullptr) {}
    };

public:
    static void description() {
        cout << R"(Tree: Huffman Decoding
    Huffman coding (https://en.wikipedia.org/wiki/Huffman_coding) assigns variable length codewords to fixed
     length input characters based on their frequencies.
    More frequent characters are assigned shorter codewords and less frequent characters are assigned longer
     codewords.
    All edges along the path to a character contain a code digit.
    If they are on the left side of the tree, they will be a 0 (zero).
    If on the right, they'll be a 1 (one).
    Only the leaves will contain a letter and its frequency count.
    All other nodes will contain a null instead of a character, and the count of the frequency of all of
     it and its descendant characters.
    For instance, consider the string ABRACADABRA.
    There are a total of 11 characters in the string.
    This number should match the count in the ultimately determined root of the tree.
    Our frequencies are A = 5, B = 2, R = 2, C = 1, and D = 1.
    The two smallest frequencies are for C and D, both equal to 1, so we'll create a tree with them.
    The root node will contain the sum of the counts of its descendants, in this case 1 + 1 = 2.
    The left node will be the first character encountered, C, and the right will contain D.
    Next we have 3 items with a character count of 2: the tree we just created, the character B and the character R.
    The tree came first, so it will go on the left of our new root node.
    B will go on the right.
    Repeat until the tree is complete, then fill in the 1's and 0's for the edges.
    The finished graph looks like:
                 φ.11
               0/   \1
              A.5    φ.6
                   0/   \1
                  R.2    φ.4
                      0/   \1
                           φ.4
                          0/  \1
                        φ.2     B.2
                      0/   \1
                     C.1    D.1
    Input characters are only present in the leaves.
    Internal nodes have a character value of ϕ (NULL).
    We can determine that our values for characters are:
        A - 0
        B - 111
        C - 1100
        D - 1101
        R - 10
    Our Huffman encoded string is:
        A B    R  A C     A D     A B    R  A
        0 111 10 0 1100 0 1101 0 111 10 0
        or
        01111001100011010111100
    To avoid ambiguity, Huffman encoding is a prefix free encoding technique.
    No codeword appears as a prefix of any other codeword.
    To decode the encoded string, follow the zeros and ones to a leaf and return the character there.
    You are given pointer to the root of the Huffman tree and a binary coded string to decode.
    You need to print the decoded string.
    Function Description:
        Complete the function decode_huff in the editor below.
        It must return the decoded string.
        decode_huff has the following parameters:
            root: a reference to the root node of the Huffman tree
            s: a Huffman encoded string
    Input Format:
        There is one line of input containing the plain string, s.
        Background code creates the Huffman tree then passes the head node and the encoded string to the function.
    Constraints:
        1 ≤ [s] ≤ 25
    Output Format:
        Output the decoded string on a single line.
    Sample Input:
                 φ.5
               0/   \1
              φ.2    A.3
            0/   \1
           B.1    C.1
        s="1001011"
    Sample Output:
        ABACA
Explanation:
    S="1001011"
    Processing the string from left to right.
    S[0]='1' : we move to the right child of the root.
    We encounter a leaf node with value 'A'.
    We add 'A' to the decoded string.
    We move back to the root.
    S[1]='0' : we move to the left child.
    S[2]='0' : we move to the left child. We encounter a leaf node with value 'B'.
    We add 'B' to the decoded string.
    We move back to the root.
    S[3] = '1' : we move to the right child of the root.
    We encounter a leaf node with value 'A'.
    We add 'A' to the decoded string.
    We move back to the root.
    S[4]='0' : we move to the left child.
    S[5]='1' : we move to the right child.
    We encounter a leaf node with value C'.
    We add 'C' to the decoded string.
    We move back to the root.
    S[6] = '1' : we move to the right child of the root.
    We encounter a leaf node with value 'A'.
    We add 'A' to the decoded string.
    We move back to the root.
    Decoded String = "ABACA"
    Note: I went to a variety of online sources and they all generated a different tree.
          I coded based on my understanding but it may not match other peoples work.)" << endl;
    }

    static void deleteTree(Node **head) {
        auto current = *head;
        if (current != nullptr) {
            queue<Node *> working;
            working.push(current);
            while (!working.empty()) {
                current = working.front();
                working.pop();
                if (current->left != nullptr) {
                    working.push(current->left);
                }
                if (current->right != nullptr) {
                    working.push(current->right);
                }
                delete current;
            }
        }
        *head = nullptr;
    }

    static Node *generateTree(const string &s) {
        Node *result = nullptr;
        map<int, map<char, Node *>> encoding_data;
        // Make an ordering map for easy access
        map<char, int> order;
        // Creating scope to have temporary variables not stay in stack frame
        {
            map<char, int> count;
            unordered_set<char> precedence;
            for (auto character: s) {
                precedence.insert(character);
                count[character]++;
            }
            auto index = (int) precedence.size();
            for (auto element: precedence) {
                order[element] = index;
                index--;
            }
            // process initial nodes to be used as leafs
            for (auto element: count) {
                if (!encoding_data.count(element.second)) {
                    encoding_data[element.second] = {};
                }
                encoding_data.at(element.second).insert({element.first, new Node(element.second, element.first)});
            }
        }
        // Process encoding_data to make a tree
        while (!encoding_data.empty()) {
            // Find 2 nodes to make a parent node
            // Find left node
            auto left = getFirst(&encoding_data, order);
            // find right node
            auto right = getFirst(&encoding_data, order);
            Node *newData = new Node(left.second->freq + right.second->freq);
            newData->left = left.second;
            newData->right = right.second;
            if (encoding_data.empty()) {
                result = newData;
            } else {
                encoding_data[newData->freq].insert({left.first, newData});
            }
        }
        return result;
    }

    static string encode_huff(Node *root, const string &input) {
        string result;
        // Generate a map of characters to strings to only traverse the tree 1 time.
        map<char, string> data;
        traverse("", &data, root);
        for (auto character: input) {
            result.append(data.at(character));
        }
        return result;
    }

    static void decode_huff(Node *root, const string &s) {
        string result;
        auto working = root;
        for (auto character: s) {
            if (character == '0') {
                working = working->left;
                if (working->data != '\0') {
                    result += working->data;
                    working = root;
                }
            } else {
                working = working->right;
                if (working->data != '\0') {
                    result += working->data;
                    working = root;
                }
            }
        }
        cout << result << endl;
    }

private:
    static pair<char, Node *> getFirst(map<int, map<char, Node *>> *encoding_data, map<char, int> order) {
        Node *result;
        char key = encoding_data->begin()->second.begin()->first;
        if (encoding_data->begin()->second.size() == 1) {
            result = encoding_data->begin()->second.begin()->second;
            encoding_data->erase(encoding_data->begin());
        } else {
            for (auto entry: encoding_data->begin()->second) {
                if (order.at(entry.first) < order.at(key)) {
                    key = entry.first;
                }
            }
            result = encoding_data->begin()->second.at(key);
            encoding_data->begin()->second.erase(key);
        }
        return {key, result};
    }

    static void traverse(const string &input, map<char, string> *data, Node *node) {
        if (node->data != '\0') {
            (*data)[node->data] = input;
        } else {
            if (node->left != nullptr) {
                traverse(input + "0", data, node->left);
            }
            if (node->right != nullptr) {
                traverse(input + "1", data, node->right);
            }
        }
    }
};

#pragma clang diagnostic pop