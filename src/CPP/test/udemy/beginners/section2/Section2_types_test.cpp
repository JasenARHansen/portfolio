#ifndef TEST_UDEMY_BEGINNERS_2_TYPES_TEST
#define TEST_UDEMY_BEGINNERS_2_TYPES_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section2/section2Types.h"

TEST(Section2_types_test, integerType) {
    std::string expected = "Int value: 1234\n"
                           "Size of Int: 4\n"
                           "Max in value is: 2147483647\n"
                           "Min in value is: -2147483648\n"
                           "Long Int value: 123456789\n"
                           "Size of Long Int: 4\n"
                           "Short Int value: 123\n"
                           "Size of Short Int: 2\n"
                           "Unsigned Int value: 123456789\n"
                           "Size of Short Unsigned Int: 4\n";
    testing::internal::CaptureStdout();
    section2Types::integerType();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2_types_test, floatType) {
    std::string expected = "Float value: 123.457\n"
                           "Size of Float: 4\n"
                           "Float value precision: 123.45678710937500000000\n"
                           "Double value: 123.45678900000000055570\n"
                           "Size of Double: 8\n"
                           "Double value precision: 123.45678710937500000000\n"
                           "Long Double value: 123.45678909876500028986\n"
                           "Size of Long Double: 16\n"
                           "Long Double value precision: 123.45678710937500000000\n";
    testing::internal::CaptureStdout();
    section2Types::floatType();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2_types_test, boolType) {
    std::string expected = "Bool True value: 1\n"
                           "Bool False value: 0\n"
                           "Size of Bool: 1\n";
    testing::internal::CaptureStdout();
    section2Types::boolType();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2_types_test, charType) {
    std::string expected = "Char number value: 106\n"
                           "Char character value: j\n"
                           "Size of Char: 1\n";
    testing::internal::CaptureStdout();
    section2Types::charType();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2_types_test, wcharType) {
    std::string expected = "Wchar_t number value: 106\n"
                           "Wchar_t character value: j\n"
                           "Size of Wchar_t: 2\n";
    testing::internal::CaptureStdout();
    section2Types::wcharType();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif