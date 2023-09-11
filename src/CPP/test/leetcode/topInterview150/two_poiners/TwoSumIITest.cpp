#ifndef LEETCODE_TOP_INTERVIEW_150_TWO_SUM_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_TWO_SUM_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/two_poiners/TwoSumII.cpp"

TEST(TwoSumIITest, description) {
    testing::internal::CaptureStdout();
    TwoSumII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(TwoSumIITest, TwoSumII_1) {
    vector<int> expected{1, 2};
    vector<int> numbers{2, 7, 11, 15};
    auto target = 9;
    auto result = TwoSumII::twoSum(numbers, target);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(TwoSumIITest, TwoSumII_2) {
    vector<int> expected{1, 3};
    vector<int> numbers{2, 3, 4};
    auto target = 6;
    auto result = TwoSumII::twoSum(numbers, target);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(TwoSumIITest, TwoSumII_3) {
    vector<int> expected{1, 2};
    vector<int> numbers{-1, 0};
    auto target = -1;
    auto result = TwoSumII::twoSum(numbers, target);
    EXPECT_EQ(expected.size(), result.size());
    for (auto index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(TwoSumIITest, TwoSumII_fail_1) {
    // 2 ≤ numbers.length
    auto size = 2 - 1;
    vector<int> numbers(size);
    auto target = 9;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumIITest, TwoSumII_fail_2) {
    // numbers.length ≤ 3 * 10^4
    auto size = 3 * (int) pow(10, 4) + 1;
    vector<int> numbers(size);
    auto target = 9;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumIITest, TwoSumII_fail_3) {
    // -1000 ≤ numbers[i]
    auto size = -1000 - 1;
    vector<int> numbers{size};
    auto target = 9;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumIITest, TwoSumII_fail_4) {
    // numbers[i] ≤ 1000
    auto size = 1000 + 1;
    vector<int> numbers{size};
    auto target = 9;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumIITest, TwoSumII_fail_5) {
    // -1000 ≤ target
    vector<int> numbers{2, 7, 11, 15};
    auto target = -1000 - 1;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumIITest, TwoSumII_fail_6) {
    // target ≤ 1000
    vector<int> numbers{2, 7, 11, 15};
    auto target = 1000 + 1;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

#endif