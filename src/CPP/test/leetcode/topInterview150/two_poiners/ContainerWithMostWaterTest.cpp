#ifndef LEETCODE_TOP_INTERVIEW_150_CONTAINER_WITH_MOST_WATER_TEST
#define LEETCODE_TOP_INTERVIEW_150_CONTAINER_WITH_MOST_WATER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/two_poiners/ContainerWithMostWater.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_ContainerWithMostWaterTest, description) {
    testing::internal::CaptureStdout();
    ContainerWithMostWater::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_1) {
    auto expected = 49;
    vector<int> height{1, 8, 6, 2, 5, 4, 8, 3, 7};
    auto result = ContainerWithMostWater::maxArea(height);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_2) {
    auto expected = 1;
    vector<int> height{1, 1};
    auto result = ContainerWithMostWater::maxArea(height);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_fail_1) {
    // 2 ≤ height.length
    auto size = 2 - 1;
    vector<int> height(size);
    EXPECT_EXIT(ContainerWithMostWater::maxArea(height), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_fail_2) {
    // height.length ≤ 10^5
    auto size = (int) pow(10, 5) + 1;
    vector<int> height(size);
    EXPECT_EXIT(ContainerWithMostWater::maxArea(height), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_fail_3) {
    // 0 ≤ height[i]
    auto size = 0 - 1;
    vector<int> height{size++, size};
    EXPECT_EXIT(ContainerWithMostWater::maxArea(height), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_fail_4) {
    // height[i] ≤ 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<int> height{size--, size};
    EXPECT_EXIT(ContainerWithMostWater::maxArea(height), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_fail_5) {
    // 0 ≤ height[i]
    auto size = 0;
    vector<int> height{size--, size};
    EXPECT_EXIT(ContainerWithMostWater::maxArea(height), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_fail_6) {
    // height[i] ≤ 10^4
    auto size = (int) pow(10, 4);
    vector<int> height{size++, size};
    EXPECT_EXIT(ContainerWithMostWater::maxArea(height), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_2_1) {
    auto expected = 49;
    vector<int> height{1, 8, 6, 2, 5, 4, 8, 3, 7};
    auto result = ContainerWithMostWater::maxArea_2(height);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_2_2) {
    auto expected = 1;
    vector<int> height{1, 1};
    auto result = ContainerWithMostWater::maxArea_2(height);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_fail_2_1) {
    // 2 ≤ height.length
    auto size = 2 - 1;
    vector<int> height(size);
    EXPECT_EXIT(ContainerWithMostWater::maxArea_2(height), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_ContainerWithMostWaterTest, maxArea_fail_2_2) {
    // height.length ≤ 10^5
    auto size = (int) pow(10, 5) + 1;
    vector<int> height(size);
    EXPECT_EXIT(ContainerWithMostWater::maxArea_2(height), ::testing::ExitedWithCode(3), "");
}

#endif