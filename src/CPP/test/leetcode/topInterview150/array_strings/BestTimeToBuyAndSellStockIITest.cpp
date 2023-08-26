#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_BEST_TIME_TO_BUY_AND_SELL_STOCK_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_BEST_TIME_TO_BUY_AND_SELL_STOCK_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/BestTimeToBuyAndSellStockII.cpp"

TEST(BestTimeToBuyAndSellStockIITest, description) {
    testing::internal::CaptureStdout();
    BestTimeToBuyAndSellStockII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BestTimeToBuyAndSellStockIITest, maxProfit_1) {
    int expected = 7;
    vector<int> prices{7, 1, 5, 3, 6, 4};
    int result = BestTimeToBuyAndSellStockII::maxProfit(prices);
    EXPECT_EQ(expected, result);
}

TEST(BestTimeToBuyAndSellStockIITest, maxProfit_2) {
    int expected = 4;
    vector<int> prices{1, 2, 3, 4, 5};
    int result = BestTimeToBuyAndSellStockII::maxProfit(prices);
    EXPECT_EQ(expected, result);
}

TEST(BestTimeToBuyAndSellStockIITest, maxProfit_3) {
    int expected = 0;
    vector<int> prices{7, 6, 4, 3, 1};
    int result = BestTimeToBuyAndSellStockII::maxProfit(prices);
    EXPECT_EQ(expected, result);
}

TEST(BestTimeToBuyAndSellStockIITest, maxProfit_fail_1) {
    // 1 <= prices.length
    int size = 0;
    vector<int> prices(size);
    EXPECT_EXIT(BestTimeToBuyAndSellStockII::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(BestTimeToBuyAndSellStockIITest, maxProfit_fail_2) {
    // prices.length <= 3 * pow(10, 4)
    int size = 3 * pow(10, 4) + 1;
    vector<int> prices(size);
    EXPECT_EXIT(BestTimeToBuyAndSellStockII::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(BestTimeToBuyAndSellStockIITest, maxProfit_fail_3) {
    // 0 <= prices[i]
    int value = -1;
    vector<int> prices{7, 6, value, 3, 1};
    EXPECT_EXIT(BestTimeToBuyAndSellStockII::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(BestTimeToBuyAndSellStockIITest, maxProfit_fail_4) {
    // prices[i] <= 104
    int value = pow(10, 4) + 1;
    vector<int> prices{7, 6, value, 3, 1};
    EXPECT_EXIT(BestTimeToBuyAndSellStockII::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop