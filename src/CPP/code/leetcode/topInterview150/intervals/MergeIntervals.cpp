#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <set>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

class MergeIntervals {
public:

    static void description() {
        cout << R"(56. Merge Intervals
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

    Example 1:
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

    Example 2:
        Input: intervals = [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.

    Constraints:
        1 <= intervals.length <= 10^4
        intervals[i].length == 2
        0 <= starti <= endi <= 10^4)" << endl;
    }

    static vector<vector<int>> merge(const vector<vector<int>> &intervals) {
        assert (!intervals.empty());
        assert (intervals.size() <= pow(10, 4));
        vector<vector<int>> result;
        for (const vector<int> interval: intervals) {
            assert (interval.size() == 2);
            assert (0 <= interval[0]);
            assert (interval[0] <= pow(10, 4));
            assert (0 <= interval[1]);
            assert (interval[1] <= pow(10, 4));
            assert (interval[0] <= interval[1]);
            vector<int> processing;
            copy(interval.begin(), interval.end(), back_inserter(processing));
            if (result.empty()) {
                result.push_back(processing);
            } else {
                bool process = true;
                while (process) {
                    process = false;
                    for (int index = 0; index < result.size(); index++) {
                        // case 1.  result[index][0] <= processing[0] <= result[index][1]
                        if ((result[index][0] <= processing[0]) &&
                            (processing[0] <= result[index][1])) {
                            process = true;
                        }
                            // case 2.  result[index][0] <= processing[1] <= result[index][1]
                        else if ((result[index][0] <= processing[1]) &&
                                 (processing[1] <= result[index][1])) {
                            process = true;
                        }
                            // case 3.  processing[0] <= result[index][0] <= processing[1]
                        else if ((processing[0] <= result[index][0]) &&
                                 (result[index][0] <= processing[1])) {
                            process = true;
                        }
                            // case 3.  processing[0] <= result[index][1] <= processing[1]
                        else if ((processing[0] <= result[index][1]) &&
                                 (result[index][1] <= processing[1])) {
                            process = true;
                        }
                        if (process) {
                            // merge
                            processing[0] = min(processing[0], result[index][0]);
                            processing[1] = max(processing[1], result[index][1]);
                            // remove
                            result.erase(result.begin() + index);
                            break;
                        }
                    }
                }
                result.push_back(processing);
            }
        }
        sort(result.begin(), result.end(), [](vector<int> &a, vector<int> &b) { return a[0] < b[0]; });
        return result;
    }
};

#pragma clang diagnostic pop