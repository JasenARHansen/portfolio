#ifndef LEETCODE_TOP_INTERVIEW_150_ADD_BINARY_TEST
#define LEETCODE_TOP_INTERVIEW_150_ADD_BINARY_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/bit_manipulation/AddBinary.cpp"

TEST(AddBinaryTest, description) {
    testing::internal::CaptureStdout();
    AddBinary::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(AddBinaryTest, addBinary_1) {
    auto expected = "100";
    auto a = "11";
    auto b = "1";
    auto result = AddBinary::addBinary(a, b);
    EXPECT_EQ(expected, result);
}

TEST(AddBinaryTest, addBinary_2) {
    auto expected = "10101";
    auto a = "1010";
    auto b = "1011";
    auto result = AddBinary::addBinary(a, b);
    EXPECT_EQ(expected, result);
}

TEST(AddBinaryTest, addBinary_3) {
    auto expected = "100";
    auto a = "1";
    auto b = "11";
    auto result = AddBinary::addBinary(a, b);
    EXPECT_EQ(expected, result);
}

TEST(AddBinaryTest, addBinary_fail_1) {
    // 1 <= a.length
    auto size = 1 - 1;
    string a(size, ' ');
    auto b = "1";
    EXPECT_EXIT(AddBinary::addBinary(a, b), ::testing::ExitedWithCode(3), "");
}

TEST(AddBinaryTest, addBinary_fail_2) {
    // b.length <= 10^4
    auto size = (int) pow(10, 4) + 1;
    string a(size, ' ');
    auto b = "1";
    EXPECT_EXIT(AddBinary::addBinary(a, b), ::testing::ExitedWithCode(3), "");
}

TEST(AddBinaryTest, addBinary_fail_3) {
    // 1 <= b.length
    auto size = 1 - 1;
    auto a = "11";
    string b(size, ' ');
    EXPECT_EXIT(AddBinary::addBinary(a, b), ::testing::ExitedWithCode(3), "");
}

TEST(AddBinaryTest, addBinary_fail_4) {
    // b.length <= 10^4
    auto size = (int) pow(10, 4) + 1;
    auto a = "11";
    string b(size, ' ');
    EXPECT_EXIT(AddBinary::addBinary(a, b), ::testing::ExitedWithCode(3), "");
}

#endif