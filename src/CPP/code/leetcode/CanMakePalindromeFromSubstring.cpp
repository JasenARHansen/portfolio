#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class CanMakePalindromeFromSubstring {
public:
    static void description() {
        cout << R"(1177: Can Make Palindrome from Substring
    You are given a string s and array queries where queries[i] = [lefti, righti, ki].
    We may rearrange the substring s[lefti...righti] for each query and then choose up to ki of them to replace with
     any lowercase English letter.
    If the substring is possible to be a palindrome string after the operations above, the result of the query is true.
    Otherwise, the result is false.
    Return a boolean array answer where answer[i] is the result of the ith query queries[i].
    Note that each letter is counted individually for replacement, so if, for example s[lefti...righti] = "aaa", and
     ki = 2, we can only replace two of the letters.
    Also, note that no query modifies the initial string s.
    Example 1:
        Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
        Output: [true,false,false,true,true]
    Explanation:
        queries[0]: substring = "d", is palidrome.
        queries[1]: substring = "bc", is not palidrome.
        queries[2]: substring = "abcd", is not palidrome after replacing only 1 character.
        queries[3]: substring = "abcd", could be changed to "abba" which is palidrome.
        Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
        queries[4]: substring = "abcda", could be changed to "abcba" which is palidrome.
    Example 2:
        Input: s = "lyb", queries = [[0,1,0],[2,2,1]]
        Output: [false,true]
    Constraints:
        1 ≤ s.length, queries.length ≤ 10^5
        0 ≤ lefti ≤ righti < s.length
        0 ≤ ki ≤ s.length
    Note:
        It is not in the constraints but I am coding this to only process a string of lower case letters)" << endl;
    }

    static vector<bool> canMakePaliQueries(const string &s, vector<vector<int>> &queries) {
        // Make a running total of characters at given index
        vector<bool> result;
        vector<vector<int>> totalsAtIndex;
        vector<int> totals(26, 0);
        // Since I am going to use subtraction to determine this I need a n-1 location
        totalsAtIndex.emplace_back(totals);
        // count characters and store them.  Due to the previously stored value, this will be 1 based not 0 based.
        for (auto character: s) {
            totals.at(character - 'a')++;
            totalsAtIndex.emplace_back(totals);
        }
        for (auto query: queries) {
            // algorithm (uses iterators): works with all sequence containers
            vector<int> working;
            // Subtract vectors to find number of specific characters in substring
            transform(totalsAtIndex.at(query.at(1) + 1).begin(), totalsAtIndex.at(query.at(1) + 1).end(),
                      totalsAtIndex.at(query.at(0)).begin(), back_inserter(working),
                      [](int a, int b) { return a - b; });
            // Remove even values since they do not need to be examined
            working.erase(remove_if(working.begin(), working.end(), [](int value) { return (value % 2) == 0; }),
                          working.end());
            // remove zeros to simplify
            working.erase(remove(working.begin(), working.end(), 0), working.end());
            // All that remains is a vector of odd numbers.
            // Since odd1 - 1 and odd2 + 1 make 2 even numbers (or a zero and an even) 1 edit will nullify 2 odds
            // If the string length is odd 1 value can remain
            // If the string is even there can be no values left to modify
            if ((query.at(1) - query.at(0) + 1) % 2) {
                // Odd length substring
                if ((working.size() - 1) <= (query.at(2) * 2)) {
                    result.push_back(true);
                } else {
                    result.push_back(false);
                }
            } else {
                // Even length substring
                if (working.size() <= (query.at(2) * 2)) {
                    result.push_back(true);
                } else {
                    result.push_back(false);
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop