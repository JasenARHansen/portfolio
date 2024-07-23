#ifndef CTCI_CH_5_BIT_MANIPULATION_CONVERSION_TEST
#define CTCI_CH_5_BIT_MANIPULATION_CONVERSION_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_5_Bit_Manipulation/Conversion.h"

using namespace ctci;
TEST(CtCI_ConversionTest, description) {
    testing::internal::CaptureStdout();
    Conversion::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_ConversionTest, conversion_1) {
    auto expected = 2;
    auto source = 0b11101;
    auto target = 0b01111;
    auto result = Conversion::conversion(source, target);
    EXPECT_EQ(expected, result);
}


#endif