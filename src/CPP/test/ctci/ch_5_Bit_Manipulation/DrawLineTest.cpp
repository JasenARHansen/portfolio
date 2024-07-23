#ifndef CTCI_CH_5_BIT_MANIPULATION_DRAW_LINE_P_TEST
#define CTCI_CH_5_BIT_MANIPULATION_DRAW_LINE_P_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_5_Bit_Manipulation/DrawLine.h"

using namespace ctci;
TEST(CtCI_DrawLineTest, description) {
    testing::internal::CaptureStdout();
    DrawLine::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_DrawLineTest, drawLine_1) {
    std::vector<std::string> expected{"________________________________________",
                                      "________________________________________",
                                      "________________________________________",
                                      "_____________-----------------__________",
                                      "________________________________________"};
    auto height = 5;
    auto width = 5;
    std::vector<std::byte> screen = std::vector<std::byte>(width * height);
    auto x1 = 13;
    auto x2 = 30;
    auto y = 3;
    auto result = DrawLine::drawLine(screen, width, x1, x2, y);
    EXPECT_EQ((int) expected.size(), (int) result.size());
    EXPECT_EQ(height, (int) result.size());
    for (auto index = 0; index < height; index++) {
        EXPECT_EQ(expected.at(index), result.at(index));
    }
}

#endif