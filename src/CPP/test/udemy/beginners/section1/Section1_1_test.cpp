#ifndef TEST_UDEMY_BEGINNERS_1_FIRST
#define TEST_UDEMY_BEGINNERS_1_FIRST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section1/Section1_1.h"

TEST(Section1_1_test, test_eq) {
    std::string expected = "!!! Hello there World!!!";
    auto result = Section1_1::hello();
    EXPECT_EQ(expected, result);
}

TEST(Section1_1_test, test_neq) {
    std::string expected = "Cat";
    auto result = Section1_1::hello();
    EXPECT_NE(expected, result);
}

#endif