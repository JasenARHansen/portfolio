#ifndef CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_JUGS_OF_WATER_TEST
#define CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_JUGS_OF_WATER_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_6_Math_and_Logic_Puzzles/JugsOfWater.h"
#include <vector>

using namespace ctci;
TEST(CtCI_JugsOfWaterTest, description) {
    testing::internal::CaptureStdout();
    JugsOfWater::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_JugsOfWaterTest, testAmountOfWater_1) {
    auto expected = true;
    auto quarts = 10;
    auto result = JugsOfWater::testAmountOfWater(quarts);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_JugsOfWaterTest, testAmountOfWater_2) {
    auto expected = false;
    auto quarts = 5;
    auto result = JugsOfWater::testAmountOfWater(quarts);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_JugsOfWaterTest, testAmountOfWater_3) {
    auto expected = true;
    auto quarts = 6;
    auto result = JugsOfWater::testAmountOfWater(quarts);
    EXPECT_EQ(expected, result);
}

#endif