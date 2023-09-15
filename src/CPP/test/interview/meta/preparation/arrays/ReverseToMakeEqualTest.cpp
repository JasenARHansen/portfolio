#ifndef INTERVIEW_META_PREPARATION_REVERSE_TO_MAKE_EQUAL_TEST
#define INTERVIEW_META_PREPARATION_REVERSE_TO_MAKE_EQUAL_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/arrays/ReverseToMakeEqual.cpp"  // NOLINT : Ignore .cpp import

TEST(ReverseToMakeEqualTest, description) {
    testing::internal::CaptureStdout();
    ReverseToMakeEqual::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ReverseToMakeEqualTest, areTheyEqual_1) {
    bool expected = true;
    vector<int> arrayA{1, 2, 3, 4};
    vector<int> arrayB{1, 4, 3, 2};
    auto result = ReverseToMakeEqual::areTheyEqual(arrayA, arrayB);
    EXPECT_EQ(expected, result);
}

TEST(ReverseToMakeEqualTest, areTheyEqual_2) {
    bool expected = false;
    vector<int> arrayA{1, 2, 3, 4};
    vector<int> arrayB{1, 4, 3, 3};
    auto result = ReverseToMakeEqual::areTheyEqual(arrayA, arrayB);
    EXPECT_EQ(expected, result);
}

TEST(ReverseToMakeEqualTest, climbStairs_fail_1) {
    // All integers in array are in the range [0, 1,000,000,000].
    auto size = 0 - 1;
    vector<int> arrayA{size};
    vector<int> arrayB{1};
    EXPECT_EXIT(ReverseToMakeEqual::areTheyEqual(arrayA, arrayB), ::testing::ExitedWithCode(3), "");
}

TEST(ReverseToMakeEqualTest, climbStairs_fail_2) {
    // All integers in array are in the range [0, 1,000,000,000].
    auto size = (int) pow(10, 9) + 1;
    vector<int> arrayA{size};
    vector<int> arrayB{1};
    EXPECT_EXIT(ReverseToMakeEqual::areTheyEqual(arrayA, arrayB), ::testing::ExitedWithCode(3), "");
}

#endif