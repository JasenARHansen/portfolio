#ifndef CTCI_CH_5_BIT_MANIPULATION_NEXT_NUMBER_TEST
#define CTCI_CH_5_BIT_MANIPULATION_NEXT_NUMBER_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_5_Bit_Manipulation/NextNumber.h"

using namespace ctci;
TEST(CtCI_NextNumberTest, description) {
    testing::internal::CaptureStdout();
    NextNumber::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_NextNumberTest, nextNumber_1) {
    std::pair<int, int> expected = {0b10001, 0b1010};
    auto value = 0b1100;
    auto result = NextNumber::nextNumber(value);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_NextNumberTest, nextNumber_2) {
    std::pair<int, int> expected = {0b10011, 0b1101};
    auto value = 0b1110;
    auto result = NextNumber::nextNumber(value);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_NextNumberTest, nextNumber_3) {
    std::pair<int, int> expected = {0b1101, 0b111};
    auto value = 0b1011;
    auto result = NextNumber::nextNumber(value);
    EXPECT_EQ(expected, result);
}

#endif