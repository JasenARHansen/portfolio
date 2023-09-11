#ifndef LEETCODE_TOP_INTERVIEW_150_SIMPLIFY_PATH_TEST
#define LEETCODE_TOP_INTERVIEW_150_SIMPLIFY_PATH_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/stack/SimplifyPath.cpp"

TEST(SimplifyPathTest, description) {
    testing::internal::CaptureStdout();
    SimplifyPath::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SimplifyPathTest, simplifyPath_1) {
    auto expected = "/home";
    auto path = "/home/";
    auto result = SimplifyPath::simplifyPath(path);
    EXPECT_EQ(expected, result);
}

TEST(SimplifyPathTest, simplifyPath_2) {
    auto expected = "/";
    auto path = "/../";
    auto result = SimplifyPath::simplifyPath(path);
    EXPECT_EQ(expected, result);
}

TEST(SimplifyPathTest, simplifyPath_3) {
    auto expected = "/home/foo";
    auto path = "/home//foo/";
    auto result = SimplifyPath::simplifyPath(path);
    EXPECT_EQ(expected, result);
}

TEST(SimplifyPathTest, simplifyPath_4) {
    auto expected = "/home/foo";
    auto path = "/home//foo";
    auto result = SimplifyPath::simplifyPath(path);
    EXPECT_EQ(expected, result);
}

TEST(SimplifyPathTest, simplifyPath_fail_1) {
    // 1 ≤ path.length
    auto size = 1 - 1;
    string path(size, ' ');
    EXPECT_EXIT(SimplifyPath::simplifyPath(path), ::testing::ExitedWithCode(3), "");
}

TEST(SimplifyPathTest, simplifyPath_fail_2) {
    // path.length ≤ 3000
    auto size = 3000 + 1;
    string path(size, ' ');
    EXPECT_EXIT(SimplifyPath::simplifyPath(path), ::testing::ExitedWithCode(3), "");
}

#endif