#ifndef CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_THE_EGG_DROP_PROBLEM_TEST
#define CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_THE_EGG_DROP_PROBLEM_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_6_Math_and_Logic_Puzzles/TheEggDropProblem.h"
#include <vector>

using namespace ctci;
TEST(CtCI_TheEggDropProblemTest, description) {
    testing::internal::CaptureStdout();
    TheEggDropProblem::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_TheEggDropProblemTest, findHeavy_1) {
    auto expected = 1;
    auto first = 0;
    auto result = TheEggDropProblem::eggDrop(first);
    EXPECT_EQ(expected, result);
}

#endif