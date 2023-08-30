#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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
    string expected = "100";
    string a = "11";
    string b = "1";
    string result = AddBinary::addBinary(a,b);
    EXPECT_EQ(expected, result);
}

TEST(AddBinaryTest, addBinary_2) {
    string expected = "10101";
    string a = "1010";
    string b = "1011";
    string result = AddBinary::addBinary(a,b);
    EXPECT_EQ(expected, result);
}

TEST(AddBinaryTest, addBinary_3) {
    string expected = "100";
    string a = "1";
    string b = "11";
    string result = AddBinary::addBinary(a,b);
    EXPECT_EQ(expected, result);
}

TEST(AddBinaryTest, addBinary_fail_1) {
    // 1 <= a.length
    int size = 1 - 1;
    string a(size, ' ');
    string b = "1";
    EXPECT_EXIT(AddBinary::addBinary(a,b), ::testing::ExitedWithCode(3), "");
}

TEST(AddBinaryTest, addBinary_fail_2) {
    // b.length <= 10^4
    int size = pow(10,4) + 1;
    string a(size, ' ');
    string b = "1";
    EXPECT_EXIT(AddBinary::addBinary(a,b), ::testing::ExitedWithCode(3), "");
}

TEST(AddBinaryTest, addBinary_fail_3) {
    // 1 <= b.length
    int size = 1 - 1;
    string a = "11";
    string b(size, ' ');
    EXPECT_EXIT(AddBinary::addBinary(a,b), ::testing::ExitedWithCode(3), "");
}

TEST(AddBinaryTest, addBinary_fail_4) {
    // b.length <= 10^4
    int size = pow(10,4) + 1;
    string a = "11";
    string b(size, ' ');
    EXPECT_EXIT(AddBinary::addBinary(a,b), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop