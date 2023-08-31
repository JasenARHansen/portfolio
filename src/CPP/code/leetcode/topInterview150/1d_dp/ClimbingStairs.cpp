#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <unordered_map>

using namespace std;

class ClimbingStairs {
public:

    static void description() {
        cout << R"(70. Climbing Stairs
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Example 1:
        Input: n = 2
        Output: 2
        Explanation: There are two ways to climb to the top.
            1. 1 step + 1 step
            2. 2 steps
    
    Example 2:
        Input: n = 3
        Output: 3
        Explanation: There are three ways to climb to the top.
            1. 1 step + 1 step + 1 step
            2. 1 step + 2 steps
            3. 2 steps + 1 step
    
    Constraints:
        1 <= n <= 45)" << endl;
    }

    static int climbStairs(int n) {
        assert (1 <= n);
        assert (n <= 45);
        unordered_map<int, int> stairs_map;
        return climbStairs(n, stairs_map);
    }

private:
    static int climbStairs(int n, unordered_map<int, int> &stairs_map) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        if (!stairs_map.count(n)) {
            int one = climbStairs(n - 1, stairs_map);
            int two = climbStairs(n - 2, stairs_map);
            stairs_map[n] = one + two;
        }
        return stairs_map.at(n);
    }
};

#pragma clang diagnostic pop