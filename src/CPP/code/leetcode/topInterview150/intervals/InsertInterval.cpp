#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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

    static vector<vector<int>> insert(vector<vector<int>> &intervals, const vector<int> &newInterval) {
        assert (intervals.size() <= pow(10, 4));
        vector<vector<int>> result;
        bool detected;
        bool processed;
        vector<int> processing;
        copy(newInterval.begin(), newInterval.end(), back_inserter(processing));
        for (int index = 0; index < intervals.size(); index++) {
            if (!detected && !processed && !detect(intervals[index], newInterval)) {
                copyAndAdd(result, intervals[index]);
            } else if (!detected && !processed && detect(intervals[index], newInterval)) {
                processing[0] = min(processing[0], intervals[index][0]);
                processing[1] = max(processing[1], intervals[index][1]);
                detected = true;
            } else if (detected && !processed && detect(intervals[index], newInterval)) {
                processing[0] = min(processing[0], intervals[index][0]);
                processing[1] = max(processing[1], intervals[index][1]);
            } else if (detected && !processed && !detect(intervals[index], newInterval)) {
                copyAndAdd(result, processing);
                processed = true;
                index--;
            } else {
                copyAndAdd(result, intervals[index]);
            }
        }
        if ((!detected && !processed) || (detected && !processed)){
            copyAndAdd(result, processing);
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

    static bool detect(const vector<int> interval1, const vector<int> interval2) {
        bool process = false;
        // case 1.  result[index][0] <= processing[0] <= result[index][1]
        if ((interval1[0] <= interval2[0]) &&
            (interval2[0] <= interval1[1])) {
            process = true;
        }
            // case 2.  interval1[0] <= interval2[1] <= interval1[1]
        else if ((interval1[0] <= interval2[1]) &&
                 (interval2[1] <= interval1[1])) {
            process = true;
        }
            // case 3.  interval2[0] <= interval1[0] <= interval2[1]
        else if ((interval2[0] <= interval1[0]) &&
                 (interval1[0] <= interval2[1])) {
            process = true;
        }
            // case 3.  interval2[0] <= interval1[1] <= interval2[1]
        else if ((interval2[0] <= interval1[1]) &&
                 (interval1[1] <= interval2[1])) {
            process = true;
        }
        return process;
    }
};

#pragma clang diagnostic pop