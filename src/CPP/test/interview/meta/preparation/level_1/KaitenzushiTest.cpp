#ifndef INTERVIEW_META_PREPARATION_KAITENZUSHI_TEST
#define INTERVIEW_META_PREPARATION_KAITENZUSHI_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/level_1/Kaitenzushi.cpp"  // NOLINT : Ignore .cpp import

TEST(KaitenzushiTest, description) {
    testing::internal::CaptureStdout();
    Kaitenzushi::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(KaitenzushiTest, getMaximumEatenDishCount_1) {
    auto expected = 5;
    vector<int> d{1, 2, 3, 3, 2, 1};
    auto n = (int) d.size();
    auto k = 1;
    auto result = Kaitenzushi::getMaximumEatenDishCount(n, d, k);
    EXPECT_EQ(expected, result);
}

TEST(KaitenzushiTest, getMaximumEatenDishCount_2) {
    auto expected = 4;
    vector<int> d{1, 2, 3, 3, 2, 1};
    auto n = (int) d.size();
    auto k = 2;
    auto result = Kaitenzushi::getMaximumEatenDishCount(n, d, k);
    EXPECT_EQ(expected, result);
}

TEST(KaitenzushiTest, getMaximumEatenDishCount_3) {
    auto expected = 2;
    vector<int> d{1, 2, 1, 2, 1, 2, 1};
    auto n = (int) d.size();
    auto k = 2;
    auto result = Kaitenzushi::getMaximumEatenDishCount(n, d, k);
    EXPECT_EQ(expected, result);
}

TEST(KaitenzushiTest, getMaximumEatenDishCount_fail_1) {
    // 1 ≤ n
    auto n = 1 - 1;
    auto k = 1;
    vector<int> d{1, 2, 3, 3, 2, 1};
    EXPECT_EXIT(Kaitenzushi::getMaximumEatenDishCount(n, d, k), ::testing::ExitedWithCode(3), "");
}

TEST(KaitenzushiTest, getMaximumEatenDishCount_fail_2) {
    // n ≤ 500,000
    auto n = 5 * pow(10, 5) + 1;
    auto k = 1;
    vector<int> d{1, 2, 3, 3, 2, 1};
    EXPECT_EXIT(Kaitenzushi::getMaximumEatenDishCount(n, d, k), ::testing::ExitedWithCode(3), "");
}

TEST(KaitenzushiTest, getMaximumEatenDishCount_fail_3) {
    // 1 ≤ k
    auto n = 10;
    auto k = 1 - 1;
    vector<int> d{1, 2, 3, 3, 2, 1};
    EXPECT_EXIT(Kaitenzushi::getMaximumEatenDishCount(n, d, k), ::testing::ExitedWithCode(3), "");
}

TEST(KaitenzushiTest, getMaximumEatenDishCount_fail_4) {
    // k ≤ n
    vector<int> d{1, 2, 3, 3, 2, 1};
    auto n = (int) d.size();
    auto k = n + 1;
    EXPECT_EXIT(Kaitenzushi::getMaximumEatenDishCount(n, d, k), ::testing::ExitedWithCode(3), "");
}

TEST(KaitenzushiTest, getMaximumEatenDishCount_fail_5) {
    // 1 ≤ Di
    auto k = 1;
    auto size = 1 - 1;
    vector<int> d{size};
    auto n = (int) d.size();
    EXPECT_EXIT(Kaitenzushi::getMaximumEatenDishCount(n, d, k), ::testing::ExitedWithCode(3), "");
}

TEST(KaitenzushiTest, getMaximumEatenDishCount_fail_6) {
    // Di ≤ 1,000,000
    auto k = 1;
    auto size = (int) pow(10, 6) + 1;
    vector<int> d{size};
    auto n = (int) d.size();
    EXPECT_EXIT(Kaitenzushi::getMaximumEatenDishCount(n, d, k), ::testing::ExitedWithCode(3), "");
}

#endif