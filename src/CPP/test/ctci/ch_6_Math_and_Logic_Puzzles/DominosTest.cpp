#ifndef CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_DOMINOS_TEST
#define CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_DOMINOS_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_6_Math_and_Logic_Puzzles/Dominos.h"
#include <vector>

using namespace ctci;
TEST(CtCI_DominosTest, description) {
    testing::internal::CaptureStdout();
    Dominos::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_DominosTest, howManyDominos_1) {
    auto expected = std::make_pair(false, 0);
    auto n = 8;
    auto m = 8;
    auto result = Dominos::howManyDominos(n, m);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_DominosTest, howManyDominos_2) {
    auto expected = std::make_pair(true, 13);
    auto n = 7;
    auto m = 4;
    auto result = Dominos::howManyDominos(n, m);
    EXPECT_EQ(expected, result);
}

#endif