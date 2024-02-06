#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_URLIFY_TEST
#define CTCI_CH_1_ARRAYS_AND_STRINGS_URLIFY_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_1_Arrays_and_Strings/URLify.h"

TEST(URLifyTest, description) {
    testing::internal::CaptureStdout();
    URLify::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(URLifyTest, urlify_1) {
    auto expected = "Mr%20John%20Smith";
    string source = "Mr John Smith";
    auto result = URLify::urlify(source);
    EXPECT_EQ(expected, result);
}

TEST(URLifyTest, urlifyInPlace_1) {
    auto expected = "Mr%20John%20Smith";
    string source = "Mr John Smith";
    URLify::urlifyInPlace(&source);
    EXPECT_EQ(expected, source);
}

#endif