#ifndef INTERVIEW_META_PREPARATION_CHANGE_IN_A_FOREIGN_CURRENCY_TEST
#define INTERVIEW_META_PREPARATION_CHANGE_IN_A_FOREIGN_CURRENCY_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/recursion/ChangeInAForeignCurrency.cpp"  // NOLINT : Ignore .cpp import

TEST(ChangeInAForeignCurrencyTest, description) {
    testing::internal::CaptureStdout();
    ChangeInAForeignCurrency::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ChangeInAForeignCurrencyTest, canGetExactChange_1) {
    auto expected = false;
    vector<int> denominations{5, 10, 25, 100, 200};
    auto targetMoney = 94;
    auto result = ChangeInAForeignCurrency::canGetExactChange(targetMoney, denominations);
    EXPECT_EQ(expected, result);
}

TEST(ChangeInAForeignCurrencyTest, canGetExactChange_2) {
    auto expected = true;
    vector<int> denominations{4, 17, 29};
    auto targetMoney = 75;
    auto result = ChangeInAForeignCurrency::canGetExactChange(targetMoney, denominations);
    EXPECT_EQ(expected, result);
}

#endif