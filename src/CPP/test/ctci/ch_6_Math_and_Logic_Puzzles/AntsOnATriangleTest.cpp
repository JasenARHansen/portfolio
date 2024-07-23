#ifndef CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_ANTS_ON_A_TRIANGLE_TEST
#define CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_ANTS_ON_A_TRIANGLE_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_6_Math_and_Logic_Puzzles/AntsOnATriangle.h"
#include <vector>

using namespace ctci;
TEST(CtCI_AntsOnATriangleTest, description) {
    testing::internal::CaptureStdout();
    AntsOnATriangle::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_AntsOnATriangleTest, findProbabilityOfCollision_1) {
    auto expected = .75;
    auto vertexes = 3;
    auto result = AntsOnATriangle::findProbabilityOfCollision(vertexes);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_AntsOnATriangleTest, findProbabilityOfCollision_2) {
    auto expected = .875;
    auto vertexes = 4;
    auto result = AntsOnATriangle::findProbabilityOfCollision(vertexes);
    EXPECT_EQ(expected, result);
}

#endif