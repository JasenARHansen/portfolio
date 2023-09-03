#ifndef UDEMY_BEGINNERS_2_STRINGS_TEST
#define UDEMY_BEGINNERS_2_STRINGS_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section2/Section2Strings.h"

TEST(Section2StringsTest, hello_eq) {
    auto expected = "Hello Jasen";
    auto result = Section2Strings::hello();
    EXPECT_EQ(expected, result);
}

TEST(Section2StringsTest, hello_neq) {
    auto expected = "Cat";
    auto result = Section2Strings::hello();
    EXPECT_NE(expected, result);
}

TEST(Section2StringsTest, helloOut_eq) {
    auto expected = "Hello Jasen\n"
                           "Hello Jasen\n";
    testing::internal::CaptureStdout();
    Section2Strings::helloOut();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2StringsTest, helloOut_neq) {
    auto expected = "Cat";
    testing::internal::CaptureStdout();
    Section2Strings::helloOut();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

#endif