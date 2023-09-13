#ifndef INTERVIEW_META_PREPARATION_MAGICAL_CANDY_BAGS_TEST
#define INTERVIEW_META_PREPARATION_MAGICAL_CANDY_BAGS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/heaps/MagicalCandyBags.cpp"

TEST(MagicalCandyBagsTest, description) {
    testing::internal::CaptureStdout();
    MagicalCandyBags::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MagicalCandyBagsTest, maxCandies_1) {
    auto expected = 14;
    vector<int> arr{2, 1, 7, 4, 2};
    auto k = 3;
    auto result = MagicalCandyBags::maxCandies(arr, k);
    EXPECT_EQ(expected, result);
}

TEST(MagicalCandyBagsTest, maxCandies_2) {
    auto expected = 228;
    vector<int> arr{19, 78, 76, 72, 48, 8, 24, 74, 29};
    auto k = 3;
    auto result = MagicalCandyBags::maxCandies(arr, k);
    EXPECT_EQ(expected, result);
}

TEST(MagicalCandyBagsTest, maxCandies_fail_1) {
    // 1 ≤ arr.length
    int size = 1 - 1;
    vector<int> arr(size);
    auto k = 3;
    EXPECT_EXIT(MagicalCandyBags::maxCandies(arr, k), ::testing::ExitedWithCode(3), "");
}

TEST(MagicalCandyBagsTest, maxCandies_fail_2) {
    // 1 ≤ arr.length
    int size = (int) pow(10, 5) + 1;
    vector<int> arr(size);
    auto k = 3;
    EXPECT_EXIT(MagicalCandyBags::maxCandies(arr, k), ::testing::ExitedWithCode(3), "");
}

TEST(MagicalCandyBagsTest, maxCandies_fail_3) {
    // 1 ≤ k
    vector<int> arr{2, 1, 7, 4, 2};
    auto k = 1 - 1;
    EXPECT_EXIT(MagicalCandyBags::maxCandies(arr, k), ::testing::ExitedWithCode(3), "");
}

TEST(MagicalCandyBagsTest, maxCandies_fail_4) {
    // k ≤ 10,000
    vector<int> arr{2, 1, 7, 4, 2};
    auto k = (int) pow(10, 5) + 1;
    EXPECT_EXIT(MagicalCandyBags::maxCandies(arr, k), ::testing::ExitedWithCode(3), "");
}

TEST(MagicalCandyBagsTest, maxCandies_fail_5) {
    // 1 ≤ arr[i]
    int size = 1 - 1;
    vector<int> arr{size, 1, 7, 4, 2};
    auto k = 3;
    EXPECT_EXIT(MagicalCandyBags::maxCandies(arr, k), ::testing::ExitedWithCode(3), "");
}

TEST(MagicalCandyBagsTest, maxCandies_fail_6) {
    // 1 ≤ arr[i]
    int size = (int) pow(10, 9) + 1;
    vector<int> arr{size, 1, 7, 4, 2};
    auto k = 3;
    EXPECT_EXIT(MagicalCandyBags::maxCandies(arr, k), ::testing::ExitedWithCode(3), "");
}

#endif