#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_IS_UNIQUE_TEST
#define CTCI_CH_1_ARRAYS_AND_STRINGS_IS_UNIQUE_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_1_Arrays_and_Strings/IsUnique.h"

TEST(IsUniqueTest, description) {
    testing::internal::CaptureStdout();
    IsUnique::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(IsUniqueTest, isUniqueChars_1) {
    auto source = "string";
    auto result = IsUnique::isUniqueChars(source);
    EXPECT_TRUE(result);
}

TEST(IsUniqueTest, isUniqueChars_2) {
    auto source = "I am not unique";
    auto result = IsUnique::isUniqueChars(source);
    EXPECT_FALSE(result);
}

TEST(IsUniqueTest, isUniqueChars_3) {
    vector<bool> expected{true, false, false, true, true};
    vector<string> source{"abcde", "hello", "apple", "kite", "padle"};
    for (auto index = 0; index < source.size(); index++) {
        auto result = IsUnique::isUniqueChars(source.at(index));
        EXPECT_EQ(expected.at(index), result);
    }
}

TEST(IsUniqueTest, isUniqueCharsBitvector_1) {
    auto source = "string";
    auto result = IsUnique::isUniqueCharsBitvector(source);
    EXPECT_TRUE(result);
}

TEST(IsUniqueTest, isUniqueCharsBitvector_2) {
    auto source = "I am not unique";
    auto result = IsUnique::isUniqueCharsBitvector(source);
    EXPECT_FALSE(result);
}

TEST(IsUniqueTest, isUniqueCharsBitvector_3) {
    vector<bool> expected{true, false, false, true, true};
    vector<string> source{"abcde", "hello", "apple", "kite", "padle"};
    for (auto index = 0; index < source.size(); index++) {
        auto result = IsUnique::isUniqueCharsBitvector(source.at(index));
        EXPECT_EQ(expected.at(index), result);
    }
}

TEST(IsUniqueTest, isUniqueCharsNoDS_1) {
    auto source = "string";
    auto result = IsUnique::isUniqueCharsNoDs(source);
    EXPECT_TRUE(result);
}

TEST(IsUniqueTest, isUniqueCharsNoDS_2) {
    auto source = "I am not unique";
    auto result = IsUnique::isUniqueCharsNoDs(source);
    EXPECT_FALSE(result);
}

TEST(IsUniqueTest, isUniqueCharsNoDS_3) {
    vector<bool> expected{true, false, false, true, true};
    vector<string> source{"abcde", "hello", "apple", "kite", "padle"};
    for (auto index = 0; index < source.size(); index++) {
        auto result = IsUnique::isUniqueCharsNoDs(source.at(index));
        EXPECT_EQ(expected.at(index), result);
    }
}

#endif