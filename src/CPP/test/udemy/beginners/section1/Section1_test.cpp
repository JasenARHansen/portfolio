#ifndef TEST_UDEMY_BEGINNERS_1_FIRST
#define TEST_UDEMY_BEGINNERS_1_FIRST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section1/Section1.h"

TEST(Section1_test, hello_eq) {
    std::string expected = "!!! Hello there World!!!";
    auto result = Section1::hello();
    EXPECT_EQ(expected, result);
}

TEST(Section1_test, hello_neq) {
    std::string expected = "Cat";
    auto result = Section1::hello();
    EXPECT_NE(expected, result);
}

TEST(Section1_test, hello_out_endl_eq) {
    std::string expected = "!!! Hello there World!!!\n";
    testing::internal::CaptureStdout();
    Section1::hello_out_endl();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1_test, hello_out_endl_neq) {
    std::string expected = "Cat";
    testing::internal::CaptureStdout();
    Section1::hello_out_endl();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1_test, hello_out_flush_eq) {
    std::string expected = "!!! Hello there World!!!";
    testing::internal::CaptureStdout();
    Section1::hello_out_flush();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1_test, hello_out_flush_neq) {
    std::string expected = "Cat";
    testing::internal::CaptureStdout();
    Section1::hello_out_flush();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1_test, fruit_eq) {
    std::string expected = "Banana. Apple. Orange.";
    testing::internal::CaptureStdout();
    Section1::fruit();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif