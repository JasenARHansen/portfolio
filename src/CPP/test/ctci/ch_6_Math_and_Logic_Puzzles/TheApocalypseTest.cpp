#ifndef CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_THE_APOCALYPSE_TEST
#define CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_THE_APOCALYPSE_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_6_Math_and_Logic_Puzzles/TheApocalypse.h"

using namespace ctci;
TEST(CtCI_TheApocalypseTest, description) {
    testing::internal::CaptureStdout();
    TheApocalypse::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_TheApocalypseTest, getRatio_1) {
    auto families = 1004;
    auto result = TheApocalypse::getRatio(families);
    EXPECT_EQ(families, std::get<1>(result));
}

TEST(CtCI_TheApocalypseTest, getRatio_2) {
    auto families = 1000;
    auto result = TheApocalypse::getRatio(families);
    EXPECT_EQ(families, std::get<1>(result));
}

#endif