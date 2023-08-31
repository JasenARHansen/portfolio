#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

class InsertInterval {
public:

    static void description() {
        cout << R"(57. Insert Interval
    You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
    Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
    Return intervals after the insertion.

    Example 1:
        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        Output: [[1,5],[6,9]]

    Example 2:
        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        Output: [[1,2],[3,10],[12,16]]
        Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

    Constraints:
        0 <= intervals.length <= 10^4
        intervals[i].length == 2
        0 <= starti <= endi <= 10^5
        intervals is sorted by starti in ascending order.
        newInterval.length == 2
        0 <= start <= end <= 10^5)" << endl;
    }

    static vector<vector<int>> insert(const vector<vector<int>> &intervals, const vector<int> &newInterval) {
        assert (intervals.size() <= pow(10, 4));
        // Generate new copy with deep copy so original data is not mutated
        vector<vector<int>> result;
        if (intervals.empty()) {
            copyAndAdd(result, newInterval);
        } else {
            bool insert = true;
            for (const auto &interval: intervals) {
                if (insert && (newInterval[0] <= interval[0])) {
                    copyAndAdd(result, newInterval);
                    insert = false;
                }
                copyAndAdd(result, interval);
            }
            if (insert) {
                copyAndAdd(result, newInterval);
            }
        }
        // Process vector am make all necessary merges
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

private:

    static void copyAndAdd(vector<vector<int>> &intervals, const vector<int> &interval) {
        assert (interval.size() == 2);
        assert (0 <= interval[0]);
        assert (interval[0] <= pow(10, 5));
        assert (0 <= interval[1]);
        assert (interval[1] <= pow(10, 5));
        assert (interval[0] <= interval[1]);
        vector<int> processing;
        copy(interval.begin(), interval.end(), back_inserter(processing));
        intervals.push_back(processing);
    }

    static bool detect(const vector<int> &interval1, const vector<int> &interval2) {
        bool overlap = false;
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