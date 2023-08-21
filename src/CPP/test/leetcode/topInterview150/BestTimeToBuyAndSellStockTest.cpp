#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_BEST_TIME_TO_BUY_AND_SELL_STOCK_TEST
#define LEETCODE_TOP_INTERVIEW_150_BEST_TIME_TO_BUY_AND_SELL_STOCK_TEST

#include "gtest/gtest.h"
#include "../../../code/leetcode/topInterview150/BestTimeToBuyAndSellStock.cpp"

TEST(BestTimeToBuyAndSellStockTest, description) {
    testing::internal::CaptureStdout();
    BestTimeToBuyAndSellStock::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_1) {
    int expected = 5;
    vector<int> prices{7, 1, 5, 3, 6, 4};
    int result = BestTimeToBuyAndSellStock::maxProfit(prices);
    EXPECT_EQ(expected, result);
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_2) {
    int expected = 0;
    vector<int> prices{7, 6, 4, 3, 1};
    int result = BestTimeToBuyAndSellStock::maxProfit(prices);
    EXPECT_EQ(expected, result);
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_fail_1) {
    // 1 <= prices.length
    int size = 0;
    vector<int> prices(size);
    EXPECT_EXIT(BestTimeToBuyAndSellStock::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_fail_2) {
    // prices.length <= 10^5
    int size = pow(10, 5) + 1;
    vector<int> prices(size);
    EXPECT_EXIT(BestTimeToBuyAndSellStock::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_fail_3) {
    // prices[i] <= 104
    int value = -1;
    vector<int> prices{7, 6, value, 3, 1};
    EXPECT_EXIT(BestTimeToBuyAndSellStock::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(BestTimeToBuyAndSellStockTest, maxProfit_fail_4) {
    // prices[i] <= 104
    int value = pow(10, 4) + 1;
    vector<int> prices{7, 6, value, 3, 1};
    EXPECT_EXIT(BestTimeToBuyAndSellStock::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}


#endif
#pragma clang diagnostic pop