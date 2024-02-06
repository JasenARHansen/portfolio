#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_ONE_AWAY_TEST
#define CTCI_CH_1_ARRAYS_AND_STRINGS_ONE_AWAY_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_1_Arrays_and_Strings/OneAway.h"

TEST(OneAwayTest, description) {
    testing::internal::CaptureStdout();
    OneAway::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(OneAwayTest, OneAway_1) {
    vector<bool> expected = {true, false, true, true, false, false};
    vector<string> left{"1111", "1222", "1111", "11112",  "1121", "11112"};
    vector<string> right{"2111", "2223", "11112", "1111", "11112", "1121"};
    for (auto index = 0; index < left.size(); index++) {
        auto result = OneAway::isOneAway(left.at(index), right.at(index));
        EXPECT_EQ(expected.at(index), result);
    }
}

#endif