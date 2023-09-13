#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <vector>

using namespace std;

class ScoreboardInference {
public:
    static void description() {
        cout << R"(Scoreboard Inference (Chapter 1)
    Note: Chapter 2 is a harder version of this puzzle. The only difference is a larger set of possible problem point values.
    You are spectating a programming contest with NN competitors, each trying to independently solve the same set of programming problems. Each problem has a point value, which is either 1 or 2.
    On the scoreboard, you observe that the Ith competitor has attained a score of Si, which is a positive integer equal to the sum of the point values of all the problems they have solved.
    The scoreboard does not display the number of problems in the contest, nor their point values. Using the information available, you would like to determine the minimum possible number of problems in the contest.

    Constraints
        1 ≤ N ≤ 500,000
        1 ≤ Si ≤ 1,000,000,000

    Sample test case #1
        N = 6
        S = [1, 2, 3, 4, 5, 6]
        Expected Return Value = 4

    Sample test case #2
        N = 4
        S = [4, 3, 3, 4]
        Expected Return Value = 3

    Sample test case #3
        N = 4
        S = [2, 4, 6, 8]
        Expected Return Value = 4

    Sample Explanation
        In the first case, it's possible that there are as few as 4 problems in the contest, for example with point values[1,1,2,2]. The 6 competitors could have solved the following subsets of problems:
            Problem 1 (1 point)
            Problem 3 (2 points)
            Problems 2 and 3 (1+2=3 points)
            Problems 1, 2, and 4 (1+1+2=4points)
            Problems 2, 3, and 4 (1+2+2=5points)
            All 4 problems (1+1+2+2=61+1+2+2=6 points)
        It is impossible for all 6 competitors to have achieved their scores if there are fewer than 4 problems.
        In the second case, one optimal set of point values is [1,1,2]].
        In the third case, one optimal set of point values is [2,2,2,2].)" << endl;
    }

    static int getMinProblemCount(int n, const vector<int> &s) {
        assert(1 <= n);
        assert(n <= 5 * pow(10, 5));
        int maximum = 0;
        bool odd = false;
        for (auto number: s) {
            assert(1 <= number);
            assert(number <= pow(10, 9));
            if (number % 2) {
                odd = true;
            }
            if (number > maximum) {
                maximum = number;
            }
        }
        auto result = 0;
        if (odd) {
            result++;
        }
        result += maximum / 2;
        return result;
    }
};

#pragma clang diagnostic pop