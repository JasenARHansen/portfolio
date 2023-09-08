#ifndef INTERVIEW_FACEBOOK_PREPARATION_Look_And_Say_TEST
#define INTERVIEW_FACEBOOK_PREPARATION_Look_And_Say_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/facebook/preparation/LookAndSay.cpp"

TEST(LookAndSayTest, description) {
    testing::internal::CaptureStdout();
    LookAndSay::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LookAndSayTest, lookAndSay_1) {
    vector<string> expected = {"1"};
    auto count = 1;
    auto result = LookAndSay::lookAndSay(count);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LookAndSayTest, lookAndSay_2) {
    vector<string> expected = {"1", "11", "21", "1211"};
    auto iterations = 4;
    auto result = LookAndSay::lookAndSay(iterations);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(LookAndSayTest, lookAndSay_3) {
    vector<string> expected = {"1", "11", "21", "1211", "111221", "312211", "13112221", "1113213211",
                               "31131211131221", "13211311123113112211"};
    auto iterations = 10;
    auto result = LookAndSay::lookAndSay(iterations);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

#endif