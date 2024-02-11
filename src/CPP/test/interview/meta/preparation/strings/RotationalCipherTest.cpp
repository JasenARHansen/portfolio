#ifndef INTERVIEW_META_PREPARATION_ROTATIONAL_CIPHER_TEST
#define INTERVIEW_META_PREPARATION_ROTATIONAL_CIPHER_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/strings/RotationalCipher.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_RotationalCipherTest, description) {
    testing::internal::CaptureStdout();
    RotationalCipher::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_RotationalCipherTest, rotationalCipher_1) {
    auto expected = "Cheud-726?";
    auto input = "Zebra-493?";
    auto rotationFactor = 3;
    auto result = RotationalCipher::rotationalCipher(input, rotationFactor);
    EXPECT_EQ(expected, result);
}

TEST(Interview_RotationalCipherTest, rotationalCipher_2) {
    auto expected = "nopqrstuvwxyzABCDEFGHIJKLM9012345678";
    auto input = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
    auto rotationFactor = 39;
    auto result = RotationalCipher::rotationalCipher(input, rotationFactor);
    EXPECT_EQ(expected, result);
}

TEST(Interview_RotationalCipherTest, climbStairs_fail_1) {
    // 1 ≤ input.length
    auto size = 0;
    string input(size, ' ');
    auto rotationFactor = 3;
    EXPECT_EXIT(RotationalCipher::rotationalCipher(input, rotationFactor), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_RotationalCipherTest, climbStairs_fail_2) {
    // input.length ≤ 1,000,000
    auto size = (int) pow(10, 6) + 1;
    string input(size, ' ');
    auto rotationFactor = 3;
    EXPECT_EXIT(RotationalCipher::rotationalCipher(input, rotationFactor), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_RotationalCipherTest, climbStairs_fail_3) {
    // 0 ≤ rotationFactor
    auto input = "Zebra-493?";
    auto rotationFactor = 0 - 1;
    EXPECT_EXIT(RotationalCipher::rotationalCipher(input, rotationFactor), ::testing::ExitedWithCode(3), "");
}

TEST(Interview_RotationalCipherTest, climbStairs_fail_4) {
    // rotationFactor] ≤ 1,000,000,000
    auto input = "Zebra-493?";
    auto rotationFactor = (int) pow(10, 6) + 1;
    EXPECT_EXIT(RotationalCipher::rotationalCipher(input, rotationFactor), ::testing::ExitedWithCode(3), "");
}

#endif