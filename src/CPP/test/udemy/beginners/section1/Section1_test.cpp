#ifndef TEST_UDEMY_BEGINNERS_1_TEST
#define TEST_UDEMY_BEGINNERS_1_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section1/section1.h"

TEST(Section1_test, hello_eq) {
    std::string expected = "!!! Hello there World!!!";
    auto result = section1::hello();
    EXPECT_EQ(expected, result);
}

TEST(Section1_test, hello_neq) {
    std::string expected = "Cat";
    auto result = section1::hello();
    EXPECT_NE(expected, result);
}

TEST(Section1_test, helloOutEndl_eq) {
    std::string expected = "!!! Hello there World!!!\n";
    testing::internal::CaptureStdout();
    section1::helloOutEndl();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1_test, helloOutEndl_neq) {
    std::string expected = "Cat";
    testing::internal::CaptureStdout();
    section1::helloOutEndl();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1_test, helloOutFlush_eq) {
    std::string expected = "!!! Hello there World!!!";
    testing::internal::CaptureStdout();
    section1::helloOutFlush();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1_test, helloOutFlush_neq) {
    std::string expected = "Cat";
    testing::internal::CaptureStdout();
    section1::helloOutFlush();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1_test, fruit) {
    std::string expected = "Banana. Apple. Orange.";
    testing::internal::CaptureStdout();
    section1::fruit();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif