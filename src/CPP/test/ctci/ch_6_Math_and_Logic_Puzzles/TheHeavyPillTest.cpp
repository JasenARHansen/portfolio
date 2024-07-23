#ifndef CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_THE_HEAVY_PILL_TEST
#define CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_THE_HEAVY_PILL_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_6_Math_and_Logic_Puzzles/TheHeavyPill.h"
#include <vector>

using namespace ctci;
TEST(CtCI_TheHeavyPillTest, description) {
    testing::internal::CaptureStdout();
    TheHeavyPill::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_TheHeavyPillTest, findHeavy_1) {
    auto expected = 1;
    std::vector<double> pills = {1.0, 1.1, 1.0};
    auto result = TheHeavyPill::findHeavy(pills);
    EXPECT_EQ(expected, result);
}

#endif