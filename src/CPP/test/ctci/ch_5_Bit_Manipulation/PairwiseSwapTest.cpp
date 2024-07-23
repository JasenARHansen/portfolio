#ifndef CTCI_CH_5_BIT_MANIPULATION_PAIRWISE_SWAP_TEST
#define CTCI_CH_5_BIT_MANIPULATION_PAIRWISE_SWAP_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_5_Bit_Manipulation/PairwiseSwap.h"

using namespace ctci;
TEST(CtCI_PairwiseSwapTest, description) {
    testing::internal::CaptureStdout();
    PairwiseSwap::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_PairwiseSwapTest, pairwiseSwap_1) {
    auto expected = 0b0110;
    auto value = 0b1001;
    auto result = PairwiseSwap::pairwiseSwap(value);
    EXPECT_EQ(expected, result);
}

#endif