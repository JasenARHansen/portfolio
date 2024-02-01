#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

class PlatesBetweenCandles {
public:
    static void description() {
        cout << R"(2055: Plates Between Candles
    There is a long table with a line of plates and candles arranged on top of it.
    You are given a 0-indexed string s consisting of characters '*' and '|' only, where a '*'
     represents a plate and a '|' represents a candle.
    You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti]
     denotes the substring s[lefti...righti] (inclusive).
    For each query, you need to find the number of plates between candles that are in the substring.
     A plate is considered between candles if there is at least one candle to its left and at least
     one candle to its right in the substring.
    For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|".
    The number of plates between candles in this substring is 2, as each of the two plates has at least
     one candle in the substring to its left and right.
    Return an integer array answer where answer[i] is the answer to the ith query.
    Example 1:
        Input: s = "**|**|***|", queries = [[2,5],[5,9]]
        Output: [2,3]
    Explanation:
        queries[0] has two plates between candles.
        queries[1] has three plates between candles.
    Example 2:
        Input: s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
        Output: [9,0,0,0,0]
    Explanation:
        queries[0] has nine plates between candles.
        The other queries have zero plates between candles.
    Constraints:
        1 ≤ n ≤ 45
        3 ≤ s.length ≤ 10^5
        s consists of '*' and '|' characters.
        1 ≤ queries.length ≤ 10^5
        queries[i].length == 2
        0 ≤ lefti ≤ righti < s.length)" << endl;
    }

    static vector<int> platesBetweenCandles1(const string &s, const vector<vector<int>> &queries) {
        vector<int> result;
        for (auto query: queries) {
            auto total = 0;
            auto startIndex = query.at(0);
            auto endIndex = query.at(1);
            // Increment startIndex until it points at a border
            while ((s.at(startIndex) != candle) and (startIndex < endIndex)) {
                startIndex++;
            }
            // Decrement endIndex until it points at a border
            while ((s.at(endIndex) != candle) and (startIndex < endIndex)) {
                endIndex--;
            }
            startIndex++;
            // Count all items between startIndex and endIndex
            while (startIndex < endIndex) {
                // If an item has been discovered increment current count
                if (s.at(startIndex) == plate) {
                    total++;
                }
                startIndex++;
            }
            // Store total between indices
            result.push_back(total);
        }
        return result;
    }

    static vector<int> platesBetweenCandles2(const string &s, const vector<vector<int>> &queries) {
        vector<int> result;
        map<int, pair<int, int>> totals;
        auto last = -1;
        auto count = 0;
        for (auto index = 0; index < s.size(); index++) {
            if (s.at(index) == candle) {
                if (last != -1) {
                    if (count > 0) {
                        totals[last] = {index, count};
                    }
                    count = 0;
                }
                last = index;
            } else if (last != -1) {
                count++;
            }
        }
        for (auto query: queries) {
            auto total = 0;
            auto lower = totals.lower_bound(query.at(0));
            auto upper = totals.lower_bound(query.at(1));
            for (auto i = lower; i != upper; i++) {
                if (i->second.first <= query.at(1)) {
                    total += i->second.second;
                }
            }
            result.push_back(total);
        }
        return result;
    }

    static vector<int> platesBetweenCandles3(const string &s, const vector<vector<int>> &queries) {
        // Make a running total of plates seen at candles and then based on query, find the
        // difference between the end points
        vector<int> result;
        map<int, int> totals;
        auto count = 0;
        for (auto index = 0; index < s.size(); index++) {
            if (s.at(index) == candle) {
                totals[index] = count;
            } else {
                count++;
            }
        }
        for (auto query: queries) {
            count = 0;
            if ((query.at(0) < query.at(1)) and (totals.size() >= 2)) {
                // Find first candle
                auto lower = totals.lower_bound(query.at(0));
                // find second candle.  Upper bound returns value AFTER query item so prev() is needed
                auto upper = prev(totals.upper_bound(query.at(1)));
                count = max(0, upper->second - lower->second);
            }
            result.push_back(count);
        }
        return result;
    }

private:
    static char const candle = '|';
    static char const plate = '*';
};

#pragma clang diagnostic pop