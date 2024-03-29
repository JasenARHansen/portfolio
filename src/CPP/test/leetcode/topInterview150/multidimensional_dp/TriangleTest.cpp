#ifndef LEETCODE_TOP_INTERVIEW_150_TRIANGLE_TEST
#define LEETCODE_TOP_INTERVIEW_150_TRIANGLE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/multidimensional_dp/Triangle.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_TriangleTest, description) {
    testing::internal::CaptureStdout();
    Triangle::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_TriangleTest, minimumTotal_1) {
    auto expected = 11;
    vector<vector<int>> triangle{{2},
                                 {3, 4},
                                 {6, 5, 7},
                                 {4, 1, 8, 3}};
    auto result = Triangle::minimumTotal(triangle);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_TriangleTest, minimumTotal_2) {
    auto expected = -10;
    vector<vector<int>> triangle{{-10}};
    auto result = Triangle::minimumTotal(triangle);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_TriangleTest, minimumTotal_fail_1) {
    // 1 ≤ triangle.length
    auto size = 1 - 1;
    vector<vector<int>> triangle(size);
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_TriangleTest, minimumTotal_fail_2) {
    // triangle.length ≤ 200
    auto size = 200 + 1;
    vector<vector<int>> triangle(size);
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_TriangleTest, minimumTotal_fail_3) {
    // triangle[0].length == 1
    auto size = 1 + 1;
    vector<vector<int>> triangle{vector<int>(size)};
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_TriangleTest, minimumTotal_fail_4) {
    // triangle[i].length == triangle[i - 1].length + 1
    auto size = 1;
    vector<vector<int>> triangle{vector<int>(size), vector<int>(size + 2)};
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_TriangleTest, minimumTotal_fail_5) {
    // -10^4 ≤ triangle[i][j]
    auto size = (int) -pow(10, 4) - 1;
    vector<vector<int>> triangle{{size}};
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_TriangleTest, minimumTotal_fail_6) {
    // triangle[i][j] ≤ 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<vector<int>> triangle{{size}};
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

#endif