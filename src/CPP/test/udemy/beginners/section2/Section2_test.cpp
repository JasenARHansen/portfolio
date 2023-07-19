#ifndef TEST_UDEMY_BEGINNERS_2_FIRST
#define TEST_UDEMY_BEGINNERS_2_FIRST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/Section2/Section2.h"

TEST(Section2_test, hello_eq) {
    std::string expected = "!!! Hello there World!!!";
    auto result = Section2::hello();
    EXPECT_EQ(expected, result);
}

TEST(Section2_test, hello_neq) {
    std::string expected = "Cat";
    auto result = Section2::hello();
    EXPECT_NE(expected, result);
}

TEST(Section2_test, hello_out_end_eq) {
    std::string expected = "!!! Hello there World!!!\n";
    testing::internal::CaptureStdout();
    Section2::hello_out_endl();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2_test, hello_out_end_neq) {
    std::string expected = "Cat";
    testing::internal::CaptureStdout();
    Section2::hello_out_endl();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2_test, hello_out_flush_eq) {
    std::string expected = "!!! Hello there World!!!";
    testing::internal::CaptureStdout();
    Section2::hello_out_flush();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2_test, hello_out_flush_neq) {
    std::string expected = "Cat";
    testing::internal::CaptureStdout();
    Section2::hello_out_flush();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2_test, fruit_eq) {
    std::string expected = "Banana. Apple. Orange.";
    testing::internal::CaptureStdout();
    Section2::fruit();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif