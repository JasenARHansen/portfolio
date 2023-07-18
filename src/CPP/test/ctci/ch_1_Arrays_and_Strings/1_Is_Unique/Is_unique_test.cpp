#ifndef TEST_UDEMY_BEGINNERS_1_FIRST
#define TEST_UDEMY_BEGINNERS_1_FIRST

#include "gtest/gtest.h"
#include "../../../../code/ctci/ch_1_Arrays_and_Strings/1_Is_Unique/Is_unique.h"

TEST(IsUnique_test, isUniqueChars_true) {
    std::string source = "string";
    auto result = Ch1_isUnique::isUniqueChars(source);
    EXPECT_TRUE(result);
}

TEST(IsUnique_test, isUniqueChars_false) {
    std::string source = "I am not unique";
    auto result = Ch1_isUnique::isUniqueChars(source);
    EXPECT_FALSE(result);
}

TEST(IsUnique_test, isUniqueChars_bitvector_true) {
    std::string source = "string";
    auto result = Ch1_isUnique::isUniqueChars_bitvector(source);
    EXPECT_TRUE(result);
}

TEST(IsUnique_test, isUniqueChars_bitvector_false) {
    std::string source = "I am not unique";
    auto result = Ch1_isUnique::isUniqueChars_bitvector(source);
    EXPECT_FALSE(result);
}

TEST(IsUnique_test, isUniqueChars_noDS_true) {
    std::string source = "string";
    auto result = Ch1_isUnique::isUniqueChars_noDS(source);
    EXPECT_TRUE(result);
}

TEST(IsUnique_test, isUniqueChars_noDS_false) {
    std::string source = "I am not unique";
    auto result = Ch1_isUnique::isUniqueChars_noDS(source);
    EXPECT_FALSE(result);
}

#endif