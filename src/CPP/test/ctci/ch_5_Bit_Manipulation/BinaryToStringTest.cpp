#ifndef CTCI_CH_5_BIT_MANIPULATION_BINARY_TO_STRING_TEST
#define CTCI_CH_5_BIT_MANIPULATION_BINARY_TO_STRING_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_5_Bit_Manipulation/BinaryToString.h"
#include <vector>

using namespace ctci;
TEST(CtCI_BinaryToStringTest, description) {
    testing::internal::CaptureStdout();
    BinaryToString::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_BinaryToStringTest, binaryToString_1) {
    std::vector<std::string> expected = {"ERROR", "ERROR", "1", "0", "ERROR", "0.1"};
    std::vector<double> data = {2, -1, 1, 0, 0.72, 0.5};
    EXPECT_EQ(expected.size(), data.size());
    for (auto index = 0; index < data.size(); index++) {
        auto result = BinaryToString::binaryToString(data.at(index));
        EXPECT_EQ(expected.at(index), result);
    }
}

#endif