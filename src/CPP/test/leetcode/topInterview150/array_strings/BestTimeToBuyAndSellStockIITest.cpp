#ifndef LEETCODE_TOP_INTERVIEW_150_BEST_TIME_TO_BUY_AND_SELL_STOCK_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_BEST_TIME_TO_BUY_AND_SELL_STOCK_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/BestTimeToBuyAndSellStockII.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_BestTimeToBuyAndSellStockIITest, description) {
    testing::internal::CaptureStdout();
    BestTimeToBuyAndSellStockII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_BestTimeToBuyAndSellStockIITest, maxProfit_1) {
    auto expected = 7;
    vector<int> prices{7, 1, 5, 3, 6, 4};
    auto result = BestTimeToBuyAndSellStockII::maxProfit(prices);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_BestTimeToBuyAndSellStockIITest, maxProfit_2) {
    auto expected = 4;
    vector<int> prices{1, 2, 3, 4, 5};
    auto result = BestTimeToBuyAndSellStockII::maxProfit(prices);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_BestTimeToBuyAndSellStockIITest, maxProfit_3) {
    auto expected = 0;
    vector<int> prices{7, 6, 4, 3, 1};
    auto result = BestTimeToBuyAndSellStockII::maxProfit(prices);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_BestTimeToBuyAndSellStockIITest, maxProfit_fail_1) {
    // 1 ≤ prices.length
    auto size = 0;
    vector<int> prices(size);
    EXPECT_EXIT(BestTimeToBuyAndSellStockII::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_BestTimeToBuyAndSellStockIITest, maxProfit_fail_2) {
    // prices.length ≤ 3 * (int)pow(10, 4)
    auto size = 3 * (int) pow(10, 4) + 1;
    vector<int> prices(size);
    EXPECT_EXIT(BestTimeToBuyAndSellStockII::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_BestTimeToBuyAndSellStockIITest, maxProfit_fail_3) {
    // 0 ≤ prices[i]
    auto value = -1;
    vector<int> prices{7, 6, value, 3, 1};
    EXPECT_EXIT(BestTimeToBuyAndSellStockII::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_BestTimeToBuyAndSellStockIITest, maxProfit_fail_4) {
    // prices[i] ≤ 10^4
    auto value = (int) pow(10, 4) + 1;
    vector<int> prices{7, 6, value, 3, 1};
    EXPECT_EXIT(BestTimeToBuyAndSellStockII::maxProfit(prices), ::testing::ExitedWithCode(3), "");
}

#endif