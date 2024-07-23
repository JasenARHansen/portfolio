#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <unordered_map>

using namespace std;

class Trie {
public:
    static void description() {
        cout << R"(208: Implement Trie (Prefix Tree)
    A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store
     and retrieve keys in a dataset of strings.
    There are various applications of this data structure, such as autocomplete and spellchecker.
    Implement the Trie class:
        Trie() Initializes the trie object.
        void insert(String word) Inserts the string word into the trie.
        boolean search(String word) Returns true if the string word is in the trie (i.e., was
     inserted before), and false otherwise.
        boolean startsWith(String prefix) Returns true if there is a previously inserted string
     word that has the prefix prefix, and false otherwise.
    Example 1:
        Input:
            ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
            [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
        Output:
            [null, null, true, false, true, null, true]
        Explanation:
            Trie trie = new Trie();
            trie.insert("apple");
            trie.search("apple");   // return True
            trie.search("app");     // return False
            trie.startsWith("app"); // return True
            trie.insert("app");
            trie.search("app");     // return True
    Constraints:
        1 ≤ word.length, prefix.length ≤ 2000
        word and prefix consist only of lowercase English letters.
        At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.)" << endl;
    }

    Trie() = default;

    explicit Trie(string word) {
        this->insert(std::move(word));
    }

    void insert(string word) {
        if (word.empty()) {
            this->endpoint = true;
        } else {
            if (!this->children.count(word.at(0))) {
                this->children[word.at(0)] = new Trie();
            }
            this->children[word.at(0)]->insert(word.substr(1, word.size() - 1));
        }
    }

    bool search(string word) {
        bool result = false;
        if (word.empty()) {
            if (this->endpoint) {
                result = true;
            }
        } else {
            if (children.count(word.at(0))) {
                result = this->children[word.at(0)]->search(word.substr(1, word.size() - 1));
            }
        }
        return result;
    }

    bool startsWith(string prefix) {
        bool result = false;
        if (prefix.empty()) {
            result = true;
        } else {
            if (children.count(prefix.at(0))) {
                result = this->children[prefix.at(0)]->startsWith(prefix.substr(1, prefix.size() - 1));
            }
        }
        return result;
    }

private:
    bool endpoint = false;
    unordered_map<char, Trie *> children;
};

#pragma clang diagnostic pop