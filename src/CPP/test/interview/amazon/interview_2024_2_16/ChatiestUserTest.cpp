#ifndef INTERVIEW_AMAZON_2024_2_16_CHATIEST_USER_TEST
#define INTERVIEW_AMAZON_2024_2_16_CHATIEST_USER_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/amazon/interview_2024_2_16/ChatiestUser.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_Amazon_Interview_2024_2_16_ChatiestUser_Test, description) {
    testing::internal::CaptureStdout();
    ChatiestUser::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_Amazon_Interview_2024_2_16_ChatiestUser_Test, getChatiestUser_1) {
    vector<string> expected = {"jasen", "alan", "alan", "alan", "jasen"};
    vector<string> values = {"amazoninterview.today.jasen:Hi Hitesh how are u?",
                             "amazoninterview.today.alan:",
                             "amazoninterview.today.alan:",
                             "amazoninterview.today.jasen:",
                             "amazoninterview.today.jasen:"};
    auto chatiestUser = new ChatiestUser();
    for (auto index = 0; index < (int) values.size(); index++) {
        chatiestUser->trackMessage(values.at(index));
        auto result = chatiestUser->getChatiestUser();
        EXPECT_EQ(expected.at(index), result);
    }
}

TEST(Interview_Amazon_Interview_2024_2_16_ChatiestUser_Test, getChatiestUser_2) {
    vector<string> expected = {"jasen", "jasen", "alan", "alan", "jasen"};
    vector<string> values = {"amazoninterview.today.jasen:Hi Hitesh how are u?",
                             "amazoninterview.today.alan:",
                             "amazoninterview.today.alan:",
                             "amazoninterview.today.jasen:",
                             "amazoninterview.today.jasen:"};
    auto chatiestUser = new ChatiestUser();
    for (auto index = 0; index < (int) values.size(); index++) {
        auto result = chatiestUser->getChatiestUser(values.at(index));
        EXPECT_EQ(expected.at(index), result);
    }
}

#endif