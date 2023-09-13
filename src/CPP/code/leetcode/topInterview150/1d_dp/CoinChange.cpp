#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <unordered_map>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

class CoinChange {
public:
    static void description() {
        cout << R"(322. Coin Change
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
    Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
    You may assume that you have an infinite number of each kind of coin.

    Example 1:
        Input: coins = [1,2,5], amount = 11
        Output: 3
        Explanation:
            11 = 5 + 5 + 1

    Example 2:
        Input: coins = [2], amount = 3
        Output: -1

    Example 3:
        Input: coins = [1], amount = 0
        Output: 0

    Constraints:
        1 ≤ coins.length ≤ 12
        1 ≤ coins[i] ≤ 2^31 - 1
        0 ≤ amount ≤ 10^4)" << endl;
    }

    static int coinChange(vector<int> &coins, int amount) {
        assert (!coins.empty());
        assert (coins.size() <= 12);
        assert (0 <= amount);
        assert (amount <= pow(10, 4));
        if (amount == 0) {
            return 0;
        }
        sort(coins.begin(), coins.end(), [](int a, int b) { return a > b; });
        assert (0 < coins[coins.size() - 1]);
        unordered_map<int, int> amount_map;
        return coinChange(coins, amount, amount_map);
    }

private:
    static int coinChange(vector<int> &coins, int amount, unordered_map<int, int> &amount_map) {
        if (!amount_map.count(amount)) {
            vector<int> values;
            auto result = -1;
            for (auto index = 0; index < coins.size(); index++) {
                if (amount == coins[index]) {
                    values.push_back(0);
                    result = 1;
                    amount_map[amount] = result;
                    return result;
                } else if (amount > coins[index]) {
                    values.push_back(coinChange(coins, amount - coins[index], amount_map));
                } else {
                    values.push_back(-1);
                }
            }
            sort(values.begin(), values.end(), [](int a, int b) { return a < b; });
            for (auto value: values) {
                if (result < value) {
                    result = value + 1;
                    break;
                }
            }
            amount_map[amount] = result;
        }
        return amount_map.at(amount);
    }
};

#pragma clang diagnostic pop