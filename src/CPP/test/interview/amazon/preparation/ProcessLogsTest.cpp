#ifndef INTERVIEW_AMAZON_PREPARATION_PROCESS_LOGS_TEST
#define INTERVIEW_AMAZON_PREPARATION_PROCESS_LOGS_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/amazon/preparation/ProcessLogs.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_ProcessLogs_Test, description) {
    testing::internal::CaptureStdout();
    ProcessLogs::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_ProcessLogs_Test, processLogs_1) {
    vector<string> expected = {"88", "99"};
    vector<string> logs = {"88 99 200", "88 99 300", "99 32 100", "12 12 15"};
    auto threshold = 2;
    auto result = ProcessLogs::processLogs(logs, threshold);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(Interview_ProcessLogs_Test, processLogs_2) {
    vector<string> expected = {"1", "2"};
    vector<string> logs = {"1 2 50", "1 7 70", "1 3 20", "2 2 17"};
    auto threshold = 2;
    auto result = ProcessLogs::processLogs(logs, threshold);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

TEST(Interview_ProcessLogs_Test, processLogs_3) {
    vector<string> expected = {"7"};
    vector<string> logs = {"9 7 50", "22 7 20", "33 7 50", "22 7 30"};
    auto threshold = 3;
    auto result = ProcessLogs::processLogs(logs, threshold);
    for (auto index = 0; index < result.size(); index++) {
        EXPECT_EQ(expected[index], result[index]);
    }
}

#endif