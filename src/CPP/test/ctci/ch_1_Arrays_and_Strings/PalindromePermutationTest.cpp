#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_PALINDROME_PERMUTATION_TEST
#define CTCI_CH_1_ARRAYS_AND_STRINGS_PALINDROME_PERMUTATION_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_1_Arrays_and_Strings/PalindromePermutation.h"

using namespace ctci;
TEST(CtCI_PalindromePermutationTest, description) {
    testing::internal::CaptureStdout();
    PalindromePermutation::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_PalindromePermutationTest, isPalindromePermutation_1) {
    std::vector<bool> expected = {true, true, false, true, false, true};
    std::vector<std::string> source{
            "",
            "a",
            "ab",
            "Tact Coa",
            "Rats live on no evil st",
            "Rats live on no evil star"
    };
    for (auto index = 0; index < source.size(); index++) {
        auto result = PalindromePermutation::isPalindromePermutation(source.at(index));
        EXPECT_EQ(expected.at(index), result);
    }
}

#endif