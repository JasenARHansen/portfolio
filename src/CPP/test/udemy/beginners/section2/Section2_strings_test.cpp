#ifndef TEST_UDEMY_BEGINNERS_2_STRINGS_TEST
#define TEST_UDEMY_BEGINNERS_2_STRINGS_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section2/Section2_strings.h"

TEST(Section2_strings_test, hello_eq) {
    std::string expected = "Hello Jasen";
    auto result = Section2_strings::hello();
    EXPECT_EQ(expected, result);
}

TEST(Section2_strings_test, hello_neq) {
    std::string expected = "Cat";
    auto result = Section2_strings::hello();
    EXPECT_NE(expected, result);
}

TEST(Section2_strings_test, hello_out_eq) {
    std::string expected = "Hello Jasen\n"
                           "Hello Jasen\n";
    testing::internal::CaptureStdout();
    Section2_strings::hello_out();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2_strings_test, hello_out_neq) {
    std::string expected = "Cat";
    testing::internal::CaptureStdout();
    Section2_strings::hello_out();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

#endif