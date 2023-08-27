#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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
    int expected = 3;
    vector<int> coins = {1, 2, 5};
    int amount = 11;
    int result = CoinChange::coinChange(coins, amount);
    EXPECT_EQ(expected, result);
}

TEST(CoinChangeTest, coinChange_2) {
    int expected = -1;
    vector<int> coins = {2};
    int amount = 3;
    int result = CoinChange::coinChange(coins, amount);
    EXPECT_EQ(expected, result);
}

TEST(CoinChangeTest, coinChange_3) {
    int expected = 0;
    vector<int> coins = {1};
    int amount = 0;
    int result = CoinChange::coinChange(coins, amount);
    EXPECT_EQ(expected, result);
}

TEST(CoinChangeTest, coinChange_4) {
    int expected = 20;
    vector<int> coins = {186, 419, 83, 408};
    int amount = 6249;
    int result = CoinChange::coinChange(coins, amount);
    EXPECT_EQ(expected, result);
}

TEST(CoinChangeTest, coinChange_fail_1) {
    // 1 <= coins.length
    int size = 1 - 1;
    vector<int> coins(size);
    int amount = 11;
    EXPECT_EXIT(CoinChange::coinChange(coins, amount), ::testing::ExitedWithCode(3), "");
}

TEST(CoinChangeTest, coinChange_fail_2) {
    // coins.length <= 12
    int size = 12 + 1;
    vector<int> coins(size);
    int amount = 11;
    EXPECT_EXIT(CoinChange::coinChange(coins, amount), ::testing::ExitedWithCode(3), "");
}

TEST(CoinChangeTest, coinChange_fail_3) {
    // 1 <= coins[i]
    int size = 1 - 1;
    vector<int> coins{size};
    int amount = 11;
    EXPECT_EXIT(CoinChange::coinChange(coins, amount), ::testing::ExitedWithCode(3), "");
}

TEST(CoinChangeTest, coinChange_fail_4) {
    // 0 <= amount
    vector<int> coins = {1, 2, 5};
    int amount = -1;
    EXPECT_EXIT(CoinChange::coinChange(coins, amount), ::testing::ExitedWithCode(3), "");
}

TEST(CoinChangeTest, coinChange_fail_5) {
    // amount <= 10^4
    vector<int> coins = {1, 2, 5};
    int amount = pow(10, 4) + 1;
    EXPECT_EXIT(CoinChange::coinChange(coins, amount), ::testing::ExitedWithCode(3), "");
}


#endif
#pragma clang diagnostic pop