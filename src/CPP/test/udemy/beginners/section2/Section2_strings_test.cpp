#ifndef TEST_UDEMY_BEGINNERS_2_STRINGS_TEST
#define TEST_UDEMY_BEGINNERS_2_STRINGS_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section2/section2Strings.h"

TEST(Section2_strings_test, hello_eq) {
    std::string expected = "Hello Jasen";
    auto result = section2Strings::hello();
    EXPECT_EQ(expected, result);
}

TEST(Section2_strings_test, hello_neq) {
    std::string expected = "Cat";
    auto result = section2Strings::hello();
    EXPECT_NE(expected, result);
}

TEST(Section2_strings_test, helloOut_eq) {
    std::string expected = "Hello Jasen\n"
                           "Hello Jasen\n";
    testing::internal::CaptureStdout();
    section2Strings::helloOut();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2_strings_test, helloOut_neq) {
    std::string expected = "Cat";
    testing::internal::CaptureStdout();
    section2Strings::helloOut();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

#endif