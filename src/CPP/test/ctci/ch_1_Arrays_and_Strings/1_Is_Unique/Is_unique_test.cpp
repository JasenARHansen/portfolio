#ifndef TEST_UDEMY_BEGINNERS_1_FIRST
#define TEST_UDEMY_BEGINNERS_1_FIRST

#include "gtest/gtest.h"
#include "../../../../code/ctci/ch_1_Arrays_and_Strings/1_Is_Unique/IsUnique.h"

TEST(IsUnique_test, isUniqueChars_true) {
    std::string source = "string";
    auto result = ch1IsUnique::isUniqueChars(source);
    EXPECT_TRUE(result);
}

TEST(IsUnique_test, isUniqueChars_false) {
    std::string source = "I am not unique";
    auto result = ch1IsUnique::isUniqueChars(source);
    EXPECT_FALSE(result);
}

TEST(IsUnique_test, isUniqueChars_bitvector_true) {
    std::string source = "string";
    auto result = ch1IsUnique::isUniqueCharsBitvector(source);
    EXPECT_TRUE(result);
}

TEST(IsUnique_test, isUniqueChars_bitvector_false) {
    std::string source = "I am not unique";
    auto result = ch1IsUnique::isUniqueCharsBitvector(source);
    EXPECT_FALSE(result);
}

TEST(IsUnique_test, isUniqueChars_noDS_true) {
    std::string source = "string";
    auto result = ch1IsUnique::isUniqueCharsNoDs(source);
    EXPECT_TRUE(result);
}

TEST(IsUnique_test, isUniqueChars_noDS_false) {
    std::string source = "I am not unique";
    auto result = ch1IsUnique::isUniqueCharsNoDs(source);
    EXPECT_FALSE(result);
}

#endif