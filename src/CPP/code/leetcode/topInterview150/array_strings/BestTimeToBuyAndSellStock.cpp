#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <vector>
#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class BestTimeToBuyAndSellStock {
public:

    static void description() {
        cout << R"(121. Best Time to Buy and Sell Stock
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.

    Constraints:
        1 <= prices.length <= 10^5
        0 <= prices[i] <= 10^4)" << endl;
    }

    static int maxProfit(vector<int> &prices) {
        assert (!prices.empty());
        assert (prices.size() <= pow(10, 5));
        int profit = 0;
        int buy = INT_MAX;
        int sell = INT_MIN;
        for (int price: prices) {
            assert (0 <= price);
            assert (price <= pow(10, 4));
            if (price < buy) {
                buy = price;
                sell = INT_MIN;
            }
            if (price > sell) {
                sell = price;
            }
            if (profit < sell - buy) {
                profit = sell - buy;
            }
        }
        return max(profit, 0);
    }
};

#pragma clang diagnostic pop