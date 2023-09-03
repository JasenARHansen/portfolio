#ifndef LEETCODE_TOP_INTERVIEW_150_COIN_CHANGE_TEST
#define LEETCODE_TOP_INTERVIEW_150_COIN_CHANGE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/1d_dp/CoinChange.cpp"

TEST(CoinChangeTest, description) {
    testing::internal::CaptureStdout();
    CoinChange::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CoinChangeTest, coinChange_1) {
    auto expected = 3;
    vector<int> coins{1, 2, 5};
    auto amount = 11;
    auto result = CoinChange::coinChange(coins, amount);
    EXPECT_EQ(expected, result);
}

TEST(CoinChangeTest, coinChange_2) {
    auto expected = -1;
    vector<int> coins{2};
    auto amount = 3;
    auto result = CoinChange::coinChange(coins, amount);
    EXPECT_EQ(expected, result);
}

TEST(CoinChangeTest, coinChange_3) {
    auto expected = 0;
    vector<int> coins{1};
    auto amount = 0;
    auto result = CoinChange::coinChange(coins, amount);
    EXPECT_EQ(expected, result);
}

TEST(CoinChangeTest, coinChange_4) {
    auto expected = 20;
    vector<int> coins{186, 419, 83, 408};
    auto amount = 6249;
    auto result = CoinChange::coinChange(coins, amount);
    EXPECT_EQ(expected, result);
}

TEST(CoinChangeTest, coinChange_fail_1) {
    // 1 <= coins.length
    auto size = 1 - 1;
    vector<int> coins(size);
    auto amount = 11;
    EXPECT_EXIT(CoinChange::coinChange(coins, amount), ::testing::ExitedWithCode(3), "");
}

TEST(CoinChangeTest, coinChange_fail_2) {
    // coins.length <= 12
    auto size = 12 + 1;
    vector<int> coins(size);
    auto amount = 11;
    EXPECT_EXIT(CoinChange::coinChange(coins, amount), ::testing::ExitedWithCode(3), "");
}

TEST(CoinChangeTest, coinChange_fail_3) {
    // 1 <= coins[i]
    auto size = 1 - 1;
    vector<int> coins{size};
    auto amount = 11;
    EXPECT_EXIT(CoinChange::coinChange(coins, amount), ::testing::ExitedWithCode(3), "");
}

TEST(CoinChangeTest, coinChange_fail_4) {
    // 0 <= amount
    vector<int> coins{1, 2, 5};
    auto amount = -1;
    EXPECT_EXIT(CoinChange::coinChange(coins, amount), ::testing::ExitedWithCode(3), "");
}

TEST(CoinChangeTest, coinChange_fail_5) {
    // amount <= 10^4
    vector<int> coins{1, 2, 5};
    auto amount = (int) pow(10, 4) + 1;
    EXPECT_EXIT(CoinChange::coinChange(coins, amount), ::testing::ExitedWithCode(3), "");
}

#endif