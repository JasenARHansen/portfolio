#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_TRIANGLE_TEST
#define LEETCODE_TOP_INTERVIEW_150_TRIANGLE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/multidimensional_dp/Triangle.cpp"

TEST(TriangleTest, description) {
    testing::internal::CaptureStdout();
    Triangle::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(TriangleTest, minimumTotal_1) {
    int expected = 11;
    vector<vector<int>> triangle{{2},
                                 {3, 4},
                                 {6, 5, 7},
                                 {4, 1, 8, 3}};
    int result = Triangle::minimumTotal(triangle);
    EXPECT_EQ(expected, result);
}

TEST(TriangleTest, minimumTotal_2) {
    int expected = -10;
    vector<vector<int>> triangle{{-10}};
    int result = Triangle::minimumTotal(triangle);
    EXPECT_EQ(expected, result);
}

TEST(TriangleTest, minimumTotal_fail_1) {
    // 1 <= triangle.length
    int size = 1 - 1;
    vector<vector<int>> triangle(size);
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

TEST(TriangleTest, minimumTotal_fail_2) {
    // triangle.length <= 200
    int size = 200 + 1;
    vector<vector<int>> triangle(size);
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

TEST(TriangleTest, minimumTotal_fail_3) {
    // triangle[0].length == 1
    int size = 1 + 1;
    vector<vector<int>> triangle{vector<int>(size)};
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

TEST(TriangleTest, minimumTotal_fail_4) {
    // triangle[i].length == triangle[i - 1].length + 1
    int size = 1;
    vector<vector<int>> triangle{vector<int>(size), vector<int>(size + 2)};
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

TEST(TriangleTest, minimumTotal_fail_5) {
    // -10^4 <= triangle[i][j]
    int size = -pow(10, 4) - 1;
    vector<vector<int>> triangle{{size}};
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

TEST(TriangleTest, minimumTotal_fail_6) {
    // triangle[i][j] <= 10^4
    int size = pow(10, 4) + 1;
    vector<vector<int>> triangle{{size}};
    EXPECT_EXIT(Triangle::minimumTotal(triangle), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop