#ifndef CTCI_CH_5_BIT_MANIPULATION_FLIP_BIT_TO_WIN_TEST
#define CTCI_CH_5_BIT_MANIPULATION_FLIP_BIT_TO_WIN_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_5_Bit_Manipulation/FlipBitToWin.h"

using namespace ctci;
TEST(CtCI_FlipBitToWinTest, description) {
    testing::internal::CaptureStdout();
    FlipBitToWin::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_FlipBitToWinTest, flipBitToWin_1) {
    auto expected = 8;
    auto value = 1775;
    auto result = FlipBitToWin::flipBitToWin(value);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_FlipBitToWinTest, flipBitToWin_2) {
    auto expected = 7;
    auto value = 1471351;
    auto result = FlipBitToWin::flipBitToWin(value);
    EXPECT_EQ(expected, result);
}

#endif