#pragma clang diagnostic push
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
        Explanation:
            Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

    Example 2:
        Input: intervals = [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation:
            Intervals [1,4] and [4,5] are considered overlapping.

    Constraints:
        1 <= intervals.length <= 10^4
        intervals[i].length == 2
        0 <= starti <= endi <= 10^4)" << endl;
    }

    static vector<vector<int>> merge(const vector<vector<int>> &intervals) {
        assert (!intervals.empty());
        assert (intervals.size() <= pow(10, 4));
        // Generate new copy with deep copy so original data is not mutated
        vector<vector<int>> result;
        for (const auto &interval: intervals) {
            copyAndAdd(result, interval);
        }
        // Input being sorted is not a requirement, so sort for easy processing.
        sort(result.begin(), result.end(), [](vector<int> &a, vector<int> &b) { return a[0] < b[0]; });
        for (int index = result.size() - 2; index >= 0; index--) {
            // Based on index 0 of the 2 vectors, detect and merge
            if (detect(result[index], result[index + 1])) {
                mergeAndRemove(result, index);
                // If a merge happened, move up the vector checking based on the 1 index
                while (index < (result.size() - 1) && detect(result[index], result[index + 1])) {
                    mergeAndRemove(result, index);
                }
            }
        }
        return result;
    }

    static vector<vector<int>> mergeNoSort(const vector<vector<int>> &intervals) {
        assert (!intervals.empty());
        assert (intervals.size() <= pow(10, 4));
        // Generate new copy with deep copy so original data is not mutated
        vector<vector<int>> result;
        for (const vector<int> &interval: intervals) {
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
                auto process = true;
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
        // Input being sorted is not a requirement, so while ranges have been merged, the results are not in order.
        sort(result.begin(), result.end(), [](vector<int> &a, vector<int> &b) { return a[0] < b[0]; });
        return result;
    }

private:

    static void copyAndAdd(vector<vector<int>> &intervals, const vector<int> &interval) {
        assert (interval.size() == 2);
        assert (0 <= interval[0]);
        assert (interval[0] <= pow(10, 4));
        assert (0 <= interval[1]);
        assert (interval[1] <= pow(10, 4));
        assert (interval[0] <= interval[1]);
        vector<int> processing;
        copy(interval.begin(), interval.end(), back_inserter(processing));
        intervals.push_back(processing);
    }

    static bool detect(const vector<int> &interval1, const vector<int> &interval2) {
        auto overlap = false;
        // case 1.  result[index][0] <= processing[0] <= result[index][1]
        if ((interval1[0] <= interval2[0]) &&
            (interval2[0] <= interval1[1])) {
            overlap = true;
        }
            // case 2.  interval1[0] <= interval2[1] <= interval1[1]
        else if ((interval1[0] <= interval2[1]) &&
                 (interval2[1] <= interval1[1])) {
            overlap = true;
        }
            // case 3.  interval2[0] <= interval1[0] <= interval2[1]
        else if ((interval2[0] <= interval1[0]) &&
                 (interval1[0] <= interval2[1])) {
            overlap = true;
        }
            // case 3.  interval2[0] <= interval1[1] <= interval2[1]
        else if ((interval2[0] <= interval1[1]) &&
                 (interval1[1] <= interval2[1])) {
            overlap = true;
        }
        return overlap;
    }

    static void mergeAndRemove(vector<vector<int>> &intervals, const int leftIndex) {
        // merge element n and n+1, stores the value in element n, and removes n+1
        intervals[leftIndex][0] = min(intervals[leftIndex][0], intervals[leftIndex + 1][0]);
        intervals[leftIndex][1] = max(intervals[leftIndex][1], intervals[leftIndex + 1][1]);
        intervals.erase(intervals.begin() + leftIndex + 1);
    }
};

#pragma clang diagnostic pop