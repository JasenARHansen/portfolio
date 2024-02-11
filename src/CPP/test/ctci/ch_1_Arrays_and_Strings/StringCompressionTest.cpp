#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_COMPRESSION_TEST
#define CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_COMPRESSION_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_1_Arrays_and_Strings/StringCompression.h"

using namespace ctci;
TEST(CtCI_StringCompressionTest, description) {
    testing::internal::CaptureStdout();
    StringCompression::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_StringCompressionTest, compress_1) {
    auto expected = "a2b1c5a3";
    auto source = "aabcccccaaa";
    auto result = StringCompression::compress(source);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_StringCompressionTest, compress_2) {
    auto expected = "string";
    auto source = "string";
    auto result = StringCompression::compress(source);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_StringCompressionTest, decompress_1) {
    auto expected = "aabcccccaaa";
    auto source = "a2b1c5a3";
    auto result = StringCompression::decompress(source);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_StringCompressionTest, decompress_2) {
    auto expected = "string";
    auto source = "string";
    auto result = StringCompression::decompress(source);
    EXPECT_EQ(expected, result);
}

#endif