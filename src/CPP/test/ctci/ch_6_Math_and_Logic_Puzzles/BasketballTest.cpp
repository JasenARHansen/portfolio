#ifndef CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_BASKETBALL_TEST
#define CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_BASKETBALL_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_6_Math_and_Logic_Puzzles/Basketball.h"
#include <vector>

using namespace ctci;
TEST(CtCI_BasketballTest, description) {
    testing::internal::CaptureStdout();
    Basketball::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_BasketballTest, selectGame_1) {
    auto expected = 1;
    auto probability = 0.5;
    auto result = Basketball::selectGame(probability);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_BasketballTest, selectGame_2) {
    auto expected = 1;
    auto probability = 0.25;
    auto result = Basketball::selectGame(probability);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_BasketballTest, selectGame_3) {
    auto expected = 2;
    auto probability = 0.75;
    auto result = Basketball::selectGame(probability);
    EXPECT_EQ(expected, result);
}


#endif