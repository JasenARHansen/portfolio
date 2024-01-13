#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <map>
#include <set>
#include <stack>
#include <vector>

using namespace std;

class WordPathFinder {
public:

    static void description() {
        cout << R"(WordPathFinder:
    Given a list of words construct WordPathFinder
    Using the WordPathFinder instance, call isPathExists( a, b ) to determine if there is a sequence of
     single transformations (with words found in the data set) that will transform word 'a' into word 'b'.
    Note: an edit is a change in the character value, not an insert or delete.
    Note: sequential edits are possible.
    Example 1:
        words = {car, cat, cot, dog, bat, bee, card, care, far, ear, cot, dot}
        a = cat
        b = bat
        result: true
    Explanation:
        cat -> bat
    Example 2:
        words = {car, cat, cot, dog, bat, bee, card, care, far, ear, cot, dot}
        a = cat
        b = care
        result: false
    Explanation:
        The words 'cat' and 'care' are different length
    Example 3:
        words = {car, cat, cot, dog, bat, bee, card, care, far, ear, cot, dot}
        a = cat
        b = dog
        result: true
    Explanation:
        cat -> cot -> dot -> dog
    Example 4:
        words = {car, cat, cot, dog, bat, bee, card, care, far, ear, cot, dot}
        a = cat
        b = cab
        result: false
    Explanation:
        While the word 'cab' is only a single edit away from the word 'cat', the word 'cab' is not in the data set.

    Tester: Vijayakumar Santha Manoharan (vijay@snapchat.com))" << endl;
    }

    explicit WordPathFinder(const set<string> &words) {
        init(words);
    };

    explicit WordPathFinder(const vector<string> &words) {
        init(set<string>(words.begin(), words.end()));
    };

    bool isPathExists(const string &a, const string &b) {
        // Check is words are the same
        if (a == b) {
            return false;
        }
        // Check length equality
        if (a.length() != b.length()) {
            return false;
        }
        // Processed list: Words processed so there is no infinite loop
        stack<string> candidates;
        set<string> processed = {a};
        // Make candidates list
        // True is returned if the target word is found in the initial candidate list processing
        if (processCandidates(a, b, &candidates, &processed)) { return true; }
        // While candidates is not empty, process subsequent candidates
        while (!candidates.empty()) {
            auto candidate = candidates.top();
            candidates.pop();
            // True is returned if the target word is found in the subsequent candidate list processing
            if (processCandidates(candidate, b, &candidates, &processed)) { return true; }
        }
        return false;
    }

private:
    map<int, set<string>> data;

    void init(const set<string> &words) {
        // Populate a Map,  Key = Number of characters in word.  Value = A list of words of the key length
        for (const string &word: words) {
            auto length = (int) word.length();
            if (!data.count(length)) {
                data[length] = {};
            }
            data[length].insert(word);
        }
    };

    static bool oneEdit(string left, string right) {
        int index = 0;
        while ((index < left.length()) && (left.at(index) == right.at(index))) {
            index++;
        }
        index++;
        for (int i = index; i < left.length(); i++) {
            if (left.at(i) != right.at(i)) {
                return false;
            }
        }
        return true;
    }

    bool processCandidates(const string &source, const string &target, stack<string> *candidates,
                           set<string> *processed) {
        for (const string &word: data.at((int) source.length())) {
            // Verify that the word has not been examined
            if (!processed->count(word)) {
                // Find all unprocessed words that are single edits from the source
                if (oneEdit(source, word)) {
                    if (word == target) {
                        return true;
                    }
                    processed->insert(word);
                    candidates->push(word);
                }
            }
        }
        return false;
    }
};

#pragma clang diagnostic pop