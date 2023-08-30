#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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
    string expected = "/home";
    string path = "/home/";
    string result = SimplifyPath::simplifyPath(path);
    EXPECT_EQ(expected, result);
}

TEST(SimplifyPathTest, simplifyPath_2) {
    string expected = "/";
    string path = "/../";
    string result = SimplifyPath::simplifyPath(path);
    EXPECT_EQ(expected, result);
}

TEST(SimplifyPathTest, simplifyPath_3) {
    string expected = "/home/foo";
    string path = "/home//foo/";
    string result = SimplifyPath::simplifyPath(path);
    EXPECT_EQ(expected, result);
}

TEST(SimplifyPathTest, simplifyPath_4) {
    string expected = "/home/foo";
    string path = "/home//foo";
    string result = SimplifyPath::simplifyPath(path);
    EXPECT_EQ(expected, result);
}

TEST(SimplifyPathTest, simplifyPath_fail_1) {
    // 1 <= path.length
    int size = 1 - 1;
    string path(size, ' ');
    EXPECT_EXIT(SimplifyPath::simplifyPath(path), ::testing::ExitedWithCode(3), "");
}

TEST(SimplifyPathTest, simplifyPath_fail_2) {
    // path.length <= 3000
    int size = 3000 + 1;
    string path(size, ' ');
    EXPECT_EXIT(SimplifyPath::simplifyPath(path), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop