#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

class MinimumNumberOfArrowsToBurstBalloons {

public:

    static void description() {
        cout << R"(452. Minimum Number of Arrows to Burst Balloons
    There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
    Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
    Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

    Example 1:
        Input: points = [[10,16],[2,8],[1,6],[7,12]]
        Output: 2
        Explanation:
            The balloons can be burst by 2 arrows:
            - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
            - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

    Example 2:
        Input: points = [[1,2],[3,4],[5,6],[7,8]]
        Output: 4
        Explanation:
            One arrow needs to be shot for each balloon for a total of 4 arrows.

    Example 3:
        Input: points = [[1,2],[2,3],[3,4],[4,5]]
        Output: 2
        Explanation:
            The balloons can be burst by 2 arrows:
            - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
            - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].

    Constraints:
        1 <= points.length <= 10^5
        points[i].length == 2
        -2^31 <= xStart < xEnd <= 2^31 - 1)" << endl;
    }

    static int findMinArrowShots(vector<vector<int>> points) {
        assert (!points.empty());
        assert (points.size() <= pow(10, 5));
        sort(points.begin(), points.end(),
             [&](vector<int> &a, vector<int> &b) {
                 return a[0] < b[0] || (a[0] == b[0]) && a[1] < b[1];
             });
        auto result = 1;
        auto xEnd = points[0][1];
        bool verify = true;
        for (auto index = 0; index < points.size();) {
            if (verify) {
                verify = false;
                int test = index;
                while ((test < points.size()) && (points[test][0] < xEnd)) {
                    if (points[test][1] < xEnd) {
                        xEnd = points[test][1];
                    }
                    test++;
                }
            }
            while ((index < points.size()) && points[index][0] <= xEnd) {
                index++;
            }
            if (index < points.size()) {
                xEnd = points[index][1];
                verify = true;
                result++;
            }
        }
        return result;
    }

};

#pragma clang diagnostic pop