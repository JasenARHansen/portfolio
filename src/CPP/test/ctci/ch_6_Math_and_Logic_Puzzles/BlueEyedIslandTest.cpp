#ifndef CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_BLUE_EYED_ISLAND_TEST
#define CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_BLUE_EYED_ISLAND_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_6_Math_and_Logic_Puzzles/BlueEyedIsland.h"
#include <vector>

using namespace ctci;
TEST(CtCI_BlueEyedIslandTest, description) {
    testing::internal::CaptureStdout();
    BlueEyedIsland::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_BlueEyedIslandTest, evacuate_1) {
    auto expected = 1;
    auto people = 1;
    auto result = BlueEyedIsland::evacuate(people);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_BlueEyedIslandTest, evacuate_2) {
    auto expected = 2;
    auto people = 2;
    auto result = BlueEyedIsland::evacuate(people);
    EXPECT_EQ(expected, result);
}

#endif