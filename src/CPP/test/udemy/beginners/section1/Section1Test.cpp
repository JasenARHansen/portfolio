#ifndef TEST_UDEMY_BEGINNERS_1_TEST
#define TEST_UDEMY_BEGINNERS_1_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section1/Section1.h"

TEST(Section1Test, hello_eq) {
    std::string expected = "!!! Hello there World!!!";
    auto result = section1::hello();
    EXPECT_EQ(expected, result);
}

TEST(Section1Test, hello_neq) {
    std::string expected = "Cat";
    auto result = section1::hello();
    EXPECT_NE(expected, result);
}

TEST(Section1Test, helloOutEndl_eq) {
    std::string expected = "!!! Hello there World!!!\n";
    testing::internal::CaptureStdout();
    section1::helloOutEndl();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1Test, helloOutEndl_neq) {
    std::string expected = "Cat";
    testing::internal::CaptureStdout();
    section1::helloOutEndl();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1Test, helloOutFlush_eq) {
    std::string expected = "!!! Hello there World!!!";
    testing::internal::CaptureStdout();
    section1::helloOutFlush();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1Test, helloOutFlush_neq) {
    std::string expected = "Cat";
    testing::internal::CaptureStdout();
    section1::helloOutFlush();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

TEST(Section1Test, fruit) {
    std::string expected = "Banana. Apple. Orange.";
    testing::internal::CaptureStdout();
    section1::fruit();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif