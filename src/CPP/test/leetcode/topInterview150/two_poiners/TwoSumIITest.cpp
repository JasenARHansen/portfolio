#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_Two_Sum_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_Two_Sum_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150//two_poiners/TwoSumII.cpp"

TEST(TwoSumIITest, description) {
    testing::internal::CaptureStdout();
    TwoSumII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(TwoSumIITest, TwoSumII_1) {
    vector<int> expected{1, 2};
    vector<int> numbers{2, 7, 11, 15};
    int target = 9;
    vector<int> result = TwoSumII::twoSum(numbers, target);
    EXPECT_EQ(expected.size(), result.size());
    for (int index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(TwoSumIITest, TwoSumII_2) {
    vector<int> expected{1, 3};
    vector<int> numbers{2, 3, 4};
    int target = 6;
    vector<int> result = TwoSumII::twoSum(numbers, target);
    EXPECT_EQ(expected.size(), result.size());
    for (int index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(TwoSumIITest, TwoSumII_3) {
    vector<int> expected{1, 2};
    vector<int> numbers{-1, 0};
    int target = -1;
    vector<int> result = TwoSumII::twoSum(numbers, target);
    EXPECT_EQ(expected.size(), result.size());
    for (int index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(TwoSumIITest, TwoSumII_fail_1) {
    // 2 <= numbers.length
    int size = 2 - 1;
    vector<int> numbers(size);
    int target = 9;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumIITest, TwoSumII_fail_2) {
    // numbers.length <= 3 * 10^4
    int size = 3 * pow(10, 4) + 1;
    vector<int> numbers(size);
    int target = 9;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumIITest, TwoSumII_fail_3) {
    // -1000 <= numbers[i]
    int size = -1000 - 1;
    vector<int> numbers{size};
    int target = 9;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumIITest, TwoSumII_fail_4) {
    // numbers[i] <= 1000
    int size = 1000 + 1;
    vector<int> numbers{size};
    int target = 9;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumIITest, TwoSumII_fail_5) {
    // -1000 <= target
    vector<int> numbers{2, 7, 11, 15};
    int target = -1000 - 1;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

TEST(TwoSumIITest, TwoSumII_fail_6) {
    // target <= 1000
    vector<int> numbers{2, 7, 11, 15};
    int target = 1000 + 1;
    EXPECT_EXIT(TwoSumII::twoSum(numbers, target), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop