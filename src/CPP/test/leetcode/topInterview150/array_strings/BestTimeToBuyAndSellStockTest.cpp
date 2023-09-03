#ifndef LEETCODE_TOP_INTERVIEW_150_BEST_TIME_TO_BUY_AND_SELL_STOCK_TEST
#define LEETCODE_TOP_INTERVIEW_150_BEST_TIME_TO_BUY_AND_SELL_STOCK_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/BestTimeToBuyAndSellStock.cpp"

TEST(BestTimeToBuyAndSellStockTest, description) {
    testing::internal::CaptureStdout();
    BestTimeToBuyAndSellStock::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_1) {
    auto expected = 5;
    vector<int> prices{7, 1, 5, 3, 6, 4};
    auto result = BestTimeToBuyAndSellStock::maxProfit(prices);
    EXPECT_EQ(expected, result);
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_2) {
    auto expected = 0;
    vector<int> prices{7, 6, 4, 3, 1};
    auto result = BestTimeToBuyAndSellStock::maxProfit(prices);
    EXPECT_EQ(expected, result);
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_fail_1) {
    // 1 <= prices.length
    auto size = 0;
    vector<int> prices(size);
    EXPECT_EXIT(BestTimeToBuyAndSellStock::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_fail_2) {
    // prices.length <= 10^5
    auto size = (int) pow(10, 5) + 1;
    vector<int> prices(size);
    EXPECT_EXIT(BestTimeToBuyAndSellStock::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_fail_3) {
    // 0 <= prices[i]
    auto value = -1;
    vector<int> prices{7, 6, value, 3, 1};
    EXPECT_EXIT(BestTimeToBuyAndSellStock::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_fail_4) {
    // prices[i] <= 10^4
    auto value = (int) pow(10, 4) + 1;
    vector<int> prices{7, 6, value, 3, 1};
    EXPECT_EXIT(BestTimeToBuyAndSellStock::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

#endif