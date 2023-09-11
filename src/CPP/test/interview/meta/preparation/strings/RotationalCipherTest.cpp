#ifndef INTERVIEW_META_PREPARATION_RotationalCipher_TEST
#define INTERVIEW_META_PREPARATION_RotationalCipher_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/strings/RotationalCipher.cpp"

TEST(RotationalCipherTest, description) {
    testing::internal::CaptureStdout();
    RotationalCipher::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RotationalCipherTest, countSubArrays_1) {
    vector<int> expected{1, 3, 1, 5, 1};
    vector<int> array{3, 4, 1, 6, 2};
    auto result = RotationalCipher::countSubArrays(array);
    EXPECT_EQ(expected, result);
}

TEST(RotationalCipherTest, countSubArrays_2) {
    vector<int> expected{1, 2, 6, 1, 3, 1};
    vector<int> array{2, 4, 7, 1, 5, 3};
    auto result = RotationalCipher::countSubArrays(array);
    EXPECT_EQ(expected, result);
}

TEST(RotationalCipherTest, climbStairs_fail_1) {
    // 1 ≤ array.length
    auto size = 1 - 1;
    vector<int> array(size);
    EXPECT_EXIT(RotationalCipher::countSubArrays(array), ::testing::ExitedWithCode(3), "");
}

TEST(RotationalCipherTest, climbStairs_fail_2) {
    // array.length ≤ 1,000,000
    auto size = (int) pow(10, 6) + 1;
    vector<int> array(size);
    EXPECT_EXIT(RotationalCipher::countSubArrays(array), ::testing::ExitedWithCode(3), "");
}

TEST(RotationalCipherTest, climbStairs_fail_3) {
    // 1 ≤ array[i]
    auto size = 1 - 1;
    vector<int> array{size};
    EXPECT_EXIT(RotationalCipher::countSubArrays(array), ::testing::ExitedWithCode(3), "");
}

TEST(RotationalCipherTest, climbStairs_fail_4) {
    // array[i] ≤ 1,000,000,000
    auto size = (int) pow(10, 9) + 1;
    vector<int> array{size};
    EXPECT_EXIT(RotationalCipher::countSubArrays(array), ::testing::ExitedWithCode(3), "");
}

#endif