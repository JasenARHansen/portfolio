#ifndef CTCI_CH_5_BIT_MANIPULATION_INSERTION_TEST
#define CTCI_CH_5_BIT_MANIPULATION_INSERTION_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_5_Bit_Manipulation/Insertion.h"

using namespace ctci;
TEST(CtCI_InsertionTest, description) {
    testing::internal::CaptureStdout();
    Insertion::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_InsertionTest, insertion_1) {
    auto expected = 0b10001001100;
    auto base = 0b10000000000;
    auto insert = 0b10011;
    auto leftIndex = 6;
    auto rightIndex = 2;
    auto result = Insertion::insertion(base, insert, leftIndex, rightIndex);
    EXPECT_EQ(expected, result);
}

#endif