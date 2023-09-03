#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>
#include <cmath>

using namespace std;

class GasStation {

public:

    static void description() {
        cout << R"(134. Gas Station
    There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
    Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

    Example 1:
        Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        Output: 3
        Explanation:
            Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
            Travel to station 4. Your tank = 4 - 1 + 5 = 8
            Travel to station 0. Your tank = 8 - 2 + 1 = 7
            Travel to station 1. Your tank = 7 - 3 + 2 = 6
            Travel to station 2. Your tank = 6 - 4 + 3 = 5
            Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
            Therefore, return 3 as the starting index.

    Example 2:
        Input: gas = [2,3,4], cost = [3,4,3]
        Output: -1
        Explanation:
            You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
            Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
            Travel to station 0. Your tank = 4 - 3 + 2 = 3
            Travel to station 1. Your tank = 3 - 3 + 3 = 3
            You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
            Therefore, you can't travel around the circuit once no matter where you start.

    Constraints:
        n == gas.length == cost.length
        1 <= n <= 10^5
        0 <= gas[i], cost[i] <= 10^4)" << endl;
    }

    static int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
        assert (gas.size() == cost.size());
        assert (!gas.empty());
        assert (gas.size() <= pow(10, 5));
        vector<bool> valid(gas.size(), true);
        // Try to short circuit operation by identifying invalid start points
        auto total_gas = 0;
        auto total_cost = 0;
        for (int i = 0; i < gas.size(); i++) {
            assert (0 <= gas[i]);
            assert (gas[i] <= pow(10, 4));
            assert (0 <= cost[i]);
            assert (cost[i] <= pow(10, 4));
            total_gas += gas[i];
            total_cost += cost[i];
            // A spot that costs more gas to move from than it generates can not be a start
            if (gas[i] <= cost[i]) {
                valid[i] = false;
            }
            // Sequential shortcut
            if (i < gas.size() - 1) {
                if ((gas[i] == gas[i + 1]) && (cost[i] == cost[i + 1])) {
                    auto sum1 = gas[i] - cost[i];
                    auto sum2 = gas[i + 1] - cost[i + 1];
                    if ((sum1 >= 0) && (sum2 >= 0)) {
                        // If both are increasing, then n+1 can not be te start point
                        valid[i + 1] = false;
                    } else if ((sum1 <= 0) && (sum2 <= 0)) {
                        // If both are decreasing, then n can not be te start point
                        valid[i] = false;
                    }
                }
            }
        }
        // If insufficient fuel for trip exit
        if (total_cost > total_gas) {
            return -1;
        }
        // 1 entry
        if (gas.size() == 1) {
            if (gas[0] >= cost[0]) {
                return 0;
            }
        }
        for (int start = 0; start < gas.size(); start++) {
            if (valid[start]) {
                auto gasTank = 0;
                for (int offset = 1; offset <= cost.size(); offset++) {
                    auto current = (start + offset - 1) % cost.size();
                    // Fill tank
                    gasTank += gas[current];
                    auto used = cost[current];
                    if (gasTank >= used) {
                        auto next = (start + offset) % cost.size();
                        if (next == start) {
                            return start;
                        }
                        // Use the fuel
                        gasTank -= used;
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;
    }
};

#pragma clang diagnostic pop