#ifndef INTERVIEW_META_PREPARATION_ROTARY_LOCK_CHAPTER_1_TEST
#define INTERVIEW_META_PREPARATION_ROTARY_LOCK_CHAPTER_1_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/level_1/RotaryLock.cpp"  // NOLINT : Ignore .cpp import

TEST(RotaryLockCh1Test, description) {
    testing::internal::CaptureStdout();
    RotaryLock::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RotaryLockCh1Test, getMinCodeEntryTime_1) {
    auto expected = 2;
    auto n = 3;
    auto m = 3;
    vector<int> c{1, 2, 3};
    auto result = RotaryLock::getMinCodeEntryTime(n, m, c);
    EXPECT_EQ(expected, result);
}

TEST(RotaryLockCh1Test, getMinCodeEntryTime_2) {
    auto expected = 11;
    auto n = 10;
    auto m = 4;
    vector<int> c{9, 4, 4, 8};
    auto result = RotaryLock::getMinCodeEntryTime(n, m, c);
    EXPECT_EQ(expected, result);
}

TEST(RotaryLockCh1Test, getMinCodeEntryTime_fail_1) {
    // 3 ≤ n
    auto n = 3 - 1;
    auto m = 3;
    vector<int> c{1, 2, 3};
    EXPECT_EXIT(RotaryLock::getMinCodeEntryTime(n, m, c), ::testing::ExitedWithCode(3), "");
}

TEST(RotaryLockCh1Test, getMinCodeEntryTime_fail_2) {
    // n ≤ 50,000,000
    auto n = 5 * (int) pow(10, 7) + 1;
    auto m = 3;
    vector<int> c{1, 2, 3};
    EXPECT_EXIT(RotaryLock::getMinCodeEntryTime(n, m, c), ::testing::ExitedWithCode(3), "");
}

TEST(RotaryLockCh1Test, getMinCodeEntryTime_fail_3) {
    // 1 ≤ m
    auto n = 3;
    auto m = 1 - 1;
    vector<int> c{1, 2, 3};
    EXPECT_EXIT(RotaryLock::getMinCodeEntryTime(n, m, c), ::testing::ExitedWithCode(3), "");
}

TEST(RotaryLockCh1Test, getMinCodeEntryTime_fail_4) {
    // m ≤ 1000
    auto n = 3;
    auto m = (int) pow(10, 3) + 1;
    vector<int> c{1, 2, 3};
    EXPECT_EXIT(RotaryLock::getMinCodeEntryTime(n, m, c), ::testing::ExitedWithCode(3), "");
}

TEST(RotaryLockCh1Test, getMinCodeEntryTime_fail_5) {
    // 1 ≤ Ci
    auto n = 3;
    auto m = 3;
    auto size = 1 - 1;
    vector<int> c{size, 2, 3};
    EXPECT_EXIT(RotaryLock::getMinCodeEntryTime(n, m, c), ::testing::ExitedWithCode(3), "");
}

TEST(RotaryLockCh1Test, getMinCodeEntryTime_fail_6) {
    // Ci ≤ N
    auto n = 3;
    auto m = 3;
    auto size = n + 1;
    vector<int> c{size, 2, 3};
    EXPECT_EXIT(RotaryLock::getMinCodeEntryTime(n, m, c), ::testing::ExitedWithCode(3), "");
}

#endif