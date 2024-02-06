#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <map>
#include <set>
#include <queue>
#include <vector>

using namespace std;

class WordPathFinder {
public:
    static void description() {
        cout << R"(WordPathFinder:
    Given a list of words construct WordPathFinder.
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
        cat → bat
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
        cat → cot → dot → dog
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
        // Process words set to create WordPathFinder object
        init(words);
    };

    explicit WordPathFinder(const vector<string> &words) {
        // Convert words vector to set to eliminate duplicates and then process set to create WordPathFinder object
        init(set<string>(words.begin(), words.end()));
    };

    bool isPathExists(const string &a, const string &b) {
        // Check is words are the same
        if (a == b) { return false; }
        // Check length equality
        if (a.length() != b.length()) { return false; }
        // Processed set: Words processed so to prevent reprocessing
        set<string> processed;
        // Push initial word into processed, so it will not be processed an extra time
        processed.insert(a);
        // Candidates stack: Words that might be part of the path to the target
        queue<string> candidates;
        // Push initial word into candidates for processing
        candidates.push(a);
        // While candidates is not empty, process subsequent candidates
        while (!candidates.empty()) {
            // True is returned if the target word is found in the candidate list processing
            if (processCandidate(b, &candidates, &processed)) { return true; }
        }
        // No path found
        return false;
    }

private:
    // map to store all words in dataset. Key = Number of characters in word.  Value = A set of words of the key length
    map<int, set<string>> data;

    void init(const set<string> &words) {
        // Populate data Map
        for (const string &word: words) {
            auto length = (int) word.length();
            data[length].insert(word);
        }
    };

    static bool oneEdit(string left, string right) {
        int index = 0;
        // Advance index as long as the characters at the index are the same.
        while ((index < left.length()) && (left.at(index) == right.at(index))) {
            index++;
        }
        // Advance index to account for different character.
        index++;
        // Advance index as long as the characters at the index are the same.
        while ((index < left.length()) && (left.at(index) == right.at(index))) {
            index++;
        }
        // Verify that all characters were examined
        if (index != left.length()) { return false; }
        // The words have 1 character that is different
        return true;
    }

    bool processCandidate(const string &target, queue<string> *candidates, set<string> *processed) {
        auto candidate = candidates->front();
        candidates->pop();
        // Iterate over all words that have the same length as the candidate
        for (const string &word: data.at((int) candidate.length())) {
            // Verify that the word has not been examined
            if (!processed->count(word)) {
                // Find all unprocessed words that are single edits from the source
                if (oneEdit(candidate, word)) {
                    // Test to see if target found
                    if (word == target) { return true; }
                    // Add word to candidates so it will be evaluated
                    candidates->push(word);
                    // Add word to processed so it does not get reprocessed
                    processed->insert(candidate);
                }
            }
        }
        // Target not found
        return false;
    }
};

#pragma clang diagnostic pop