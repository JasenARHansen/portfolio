#ifndef INTERVIEW_META_PREPARATION_BILLION_USERS_TEST
#define INTERVIEW_META_PREPARATION_BILLION_USERS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/search/BillionUsers.cpp"  // NOLINT : Ignore .cpp import

TEST(BillionUsersTest, description) {
    testing::internal::CaptureStdout();
    BillionUsers::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BillionUsersTest, getBillionUsersDay_1) {
    auto expected = 52;
    vector<float> growthRates{1.5};
    auto result = BillionUsers::getBillionUsersDay(growthRates);
    EXPECT_EQ(expected, result);
}

TEST(BillionUsersTest, getBillionUsersDay_2) {
    auto expected = 79;
    vector<float> growthRates{1.1, 1.2, 1.3};
    auto result = BillionUsers::getBillionUsersDay(growthRates);
    EXPECT_EQ(expected, result);
}

TEST(BillionUsersTest, getBillionUsersDay_3) {
    auto expected = 1047;
    vector<float> growthRates{1.01, 1.02};
    auto result = BillionUsers::getBillionUsersDay(growthRates);
    EXPECT_EQ(expected, result);
}

#endif