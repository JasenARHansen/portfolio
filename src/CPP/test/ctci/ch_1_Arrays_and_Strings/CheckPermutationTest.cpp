#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_CHECK_PERMUTATION_TEST
#define CTCI_CH_1_ARRAYS_AND_STRINGS_CHECK_PERMUTATION_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_1_Arrays_and_Strings/CheckPermutation.h"

using namespace ctci;
TEST(CtCI_CheckPermutationTest, description) {
    testing::internal::CaptureStdout();
    CheckPermutation::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_CheckPermutationTest, isPermutation_1) {
    auto source1 = "string";
    auto source2 = "trings";
    auto result = CheckPermutation::isPermutation(source1, source2);
    EXPECT_TRUE(result);
}

TEST(CtCI_CheckPermutationTest, isPermutation_2) {
    auto source1 = "cat";
    auto source2 = "hat";
    auto result = CheckPermutation::isPermutation(source1, source2);
    EXPECT_FALSE(result);
}

TEST(CtCI_CheckPermutationTest, isPermutationCount_1) {
    auto source1 = "string";
    auto source2 = "trings";
    auto result = CheckPermutation::isPermutationCount(source1, source2);
    EXPECT_TRUE(result);
}

TEST(CtCI_CheckPermutationTest, isPermutationCount_2) {
    auto source1 = "cat";
    auto source2 = "hat";
    auto result = CheckPermutation::isPermutationCount(source1, source2);
    EXPECT_FALSE(result);
}

#endif