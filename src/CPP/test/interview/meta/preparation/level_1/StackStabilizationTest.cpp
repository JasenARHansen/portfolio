#ifndef INTERVIEW_META_PREPARATION_STACK_STABILIZATION_CHAPTER_1_TEST
#define INTERVIEW_META_PREPARATION_STACK_STABILIZATION_CHAPTER_1_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/level_1/StackStabilization.cpp"

TEST(StackStabilizationCh1Test, description) {
    testing::internal::CaptureStdout();
    StackStabilization::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(StackStabilizationCh1Test, getMinimumDeflatedDiscCount_1) {
    auto expected = 3;
    auto n = 5;
    vector<int> r{2, 5, 3, 6, 5};
    auto result = StackStabilization::getMinimumDeflatedDiscCount(n, r);
    EXPECT_EQ(expected, result);
}

TEST(StackStabilizationCh1Test, getMinimumDeflatedDiscCount_2) {
    auto expected = 2;
    auto n = 3;
    vector<int> r{100, 100, 100};
    auto result = StackStabilization::getMinimumDeflatedDiscCount(n, r);
    EXPECT_EQ(expected, result);
}

TEST(StackStabilizationCh1Test, getMinimumDeflatedDiscCount_3) {
    auto expected = -1;
    auto n = 4;
    vector<int> r{6, 5, 4, 3};
    auto result = StackStabilization::getMinimumDeflatedDiscCount(n, r);
    EXPECT_EQ(expected, result);
}

TEST(StackStabilizationCh1Test, getMinimumDeflatedDiscCount_fail_1) {
    // 1 ≤ n
    auto n = 1 - 1;
    vector<int> r{1, 2, 3, 4, 5, 6};
    EXPECT_EXIT(StackStabilization::getMinimumDeflatedDiscCount(n, r), ::testing::ExitedWithCode(3), "");
}

TEST(StackStabilizationCh1Test, getMinimumDeflatedDiscCount_fail_2) {
    // n ≤ 50
    auto n = 50 + 1;
    vector<int> r{1, 2, 3, 4, 5, 6};
    EXPECT_EXIT(StackStabilization::getMinimumDeflatedDiscCount(n, r), ::testing::ExitedWithCode(3), "");
}

TEST(StackStabilizationCh1Test, getMinimumDeflatedDiscCount_fail_3) {
    // 1 ≤ ri
    auto n = 10;
    auto size = 1 - 1;
    vector<int> r{1, 2, 3, 4, 5, size};
    EXPECT_EXIT(StackStabilization::getMinimumDeflatedDiscCount(n, r), ::testing::ExitedWithCode(3), "");
}

TEST(StackStabilizationCh1Test, getMinimumDeflatedDiscCount_fail_4) {
    // ri ≤ 1,000,000,000
    auto n = 10;
    auto size = (int) pow(10, 9) + 1;
    vector<int> r{1, 2, 3, 4, 5, size};
    EXPECT_EXIT(StackStabilization::getMinimumDeflatedDiscCount(n, r), ::testing::ExitedWithCode(3), "");
}

#endif