#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_THREE_SUM_TEST
#define LEETCODE_TOP_INTERVIEW_150_THREE_SUM_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150//two_poiners/ThreeSum.cpp"

TEST(ThreeSumTest, description) {
    testing::internal::CaptureStdout();
    ThreeSum::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ThreeSumTest, threeSum_1) {
    vector<vector<int>> expected{{-1, -1, 2},
                                 {-1, 0,  1}};
    vector<int> numbers{-1, 0, 1, 2, -1, -4};
    vector<vector<int>> result = ThreeSum::threeSum(numbers);
    EXPECT_EQ(expected.size(), result.size());
    for (int index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(ThreeSumTest, threeSum_2) {
    vector<vector<int>> expected{};
    vector<int> numbers{-0, 1, 1};
    vector<vector<int>> result = ThreeSum::threeSum(numbers);
    EXPECT_EQ(expected.size(), result.size());
    for (int index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(ThreeSumTest, threeSum_3) {
    vector<vector<int>> expected{{0, 0, 0}};
    vector<int> numbers{0, 0, 0};
    vector<vector<int>> result = ThreeSum::threeSum(numbers);
    EXPECT_EQ(expected.size(), result.size());
    for (int index = 0; index < expected.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(ThreeSumTest, threeSum_fail_1) {
    // 3 <= nums.length
    int size = 3 - 1;
    vector<int> numbers(size);
    EXPECT_EXIT(ThreeSum::threeSum(numbers), ::testing::ExitedWithCode(3), "");
}

TEST(ThreeSumTest, threeSum_fail_2) {
    // nums.length <= 3000
    int size = 3000 + 1;
    vector<int> numbers(size);
    EXPECT_EXIT(ThreeSum::threeSum(numbers), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop