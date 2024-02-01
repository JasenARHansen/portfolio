#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <map>

using namespace std;

class ItemsInContainers {
public:
    static void description() {
        cout << R"(Items In Containers:
    Amazon would like to know how much inventory exists in their closed inventory compartments.
    Given a string s consisting of items as "*" and closed compartments as an open and close "|",
     an array of starting indices startIndices, and an array of ending indices endIndices, determine
     the number of items in closed compartments within the substring between the two indices, inclusive.
	An item is represented as an asterisk ('*' = ascii decimal 42)
	A compartment is represented as a pair of pipes that may or may not have items between them ('|' = ascii decimal 124).
    Example:
        s = '|**|*|*'
        startIndices = [1, 1]
        endIndices = [5, 6]
        The string has a total of 2 closed compartments, one with 2 items and one with 1 item.
        For the first pair of indices, (1, 5), the substring is '|**|*'.
        There are 2 items in a compartment.
        For the second pair of indices, (1, 6), the substring is '|**|*|' and there are 2 + 1 = 3 items in compartments.
        Both of the answers are returned in an array,  [2, 3].
    Function Description:
        Complete the numberOfItems function in the editor below.
        The function must return an integer array that contains the results for each of the startIndices[i]
         and endIndices[i] pairs.
        numberOfItems has three parameters:
            s: A string to evaluate
            startIndices: An integer array, the starting indices.
            endIndices: An integer array, the ending indices.
        Constraints:
            1 ≤ m, n ≤ 10^5
            1 ≤ startIndices[i]  ≤ endIndices[i] ≤ n
            Each character of s is either '*' or '|'
        Input Format For Custom Testing:
            The first line contains a string, s.
            The next line contains an integer, n, the number of elements in startIndices.
            Each line i of the n subsequent lines (where 1 ≤ i ≤ n) contains an integer, startIndices[i].
            The next line repeats the integer, n, the number of elements in endIndices.
            Each line i of the n subsequent lines (where 1 ≤ i ≤ n) contains an integer, endIndices[i].
    Sample Case 0:
        Sample Input For Custom Testing
            STDIN         Function
            -----         --------
            *|*|      →   s = "*|*|"
            1         →   startIndices[] size n = 1
            1         →   startIndices = 1
            1         →   endIndices[] size n = 1
            3         →   endIndices = 3
        Sample Output:
            0
        Explanation:
            s = *|*|
            n = 1
            startIndices = [1]
            n = 1
            startIndices = [3]
            The substring from index = 1 to index = 3 is '*|*'.
            There is no compartments in this string.
    Sample Case 1:
        Sample Input For Custom Testing
            STDIN         Function
            -----         --------
            *|*|*|    →   s = "*|*|*|"
            1         →   startIndices[] size n = 1 
            1         →   startIndices = 1
            1         →   endIndices[] size n = 1
            6         →   endIndices = 6
        Sample Output:
            2
        Explanation:
            s = '*|*|*|'
            n = 1
            startIndices = [1]
            n = 1
            endIndices = [6]
            The string from index = 1 to index = 6 is '*|*|*|'.
            There are two compartments in this string at (index = 2, index = 4) and (index = 4, index = 6).
            There are 2 items between these compartments.)" << endl;
    }

    static vector<int> numberOfItems1(const string &s, const vector<int> &startIndices, const vector<int> &endIndices) {
        vector<int> result;
        // Verify that the number of start indices matches the number of end indices
        if (startIndices.size() == endIndices.size()) {
            // Iterate over each pair of indices
            for (auto index = 0; index < startIndices.size(); index++) {
                auto total = 0;
                auto count = 0;
                auto first = false;
                auto innerIndex = startIndices.at(index) - 1;
                if (endIndices.at(index) <= s.size()) {
                    // Process all characters until end index
                    while (innerIndex < endIndices.at(index)) {
                        // When border is detected, determine action
                        if (s.at(innerIndex) == border) {
                            // If a previous start border has been detected, store the current count
                            if (first) {
                                total += count;
                            }
                            // Indicate that we have found a start border
                            first = true;
                            // Reset current  count to 0
                            count = 0;
                        } else if ((s.at(innerIndex) == item) and first) {
                            // If a start index has been discovered increment current count
                            count++;
                        }
                        innerIndex++;
                    }
                }
                // Store total between indices
                result.push_back(total);
            }
        }
        return result;
    }

    static vector<int> numberOfItems2(const string &s, const vector<int> &startIndices, const vector<int> &endIndices) {
        // Make a running total of items seen at borders and then based on query, find the
        // difference between the end points
        vector<int> result;
        map<int, int> totals;
        auto count = 0;
        for (auto index = 0; index < s.size(); index++) {
            if (s.at(index) == border) {
                totals[index] = count;
            } else {
                count++;
            }
        }
        for (auto index = 0; index < startIndices.size(); index++) {
            count = 0;
            if ((startIndices.at(index) < endIndices.at(index)) and (totals.size() >= 2)) {
                // Find first candle
                auto lower = totals.lower_bound(startIndices.at(index) - 1);
                // find second candle.  Upper bound returns value AFTER query item so prev() is needed
                auto upper = prev(totals.upper_bound(endIndices.at(index) - 1));
                count = max(0, upper->second - lower->second);
            }
            result.push_back(count);
        }
        return result;
    }

private:
    static char const border = '|';
    static char const item = '*';
};

#pragma clang diagnostic pop