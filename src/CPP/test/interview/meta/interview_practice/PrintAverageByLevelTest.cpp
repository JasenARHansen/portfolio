#ifndef INTERVIEW_META_PREPARATION_INTERVIEW_PRACTICE_PRINT_AVERAGE_BY_LEVEL_TEST
#define INTERVIEW_META_PREPARATION_INTERVIEW_PRACTICE_PRINT_AVERAGE_BY_LEVEL_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/interview_practice/PrintAverageByLevel.cpp"  // NOLINT : Ignore .cpp import

TEST(PrintAverageByLevelTest, description) {
    testing::internal::CaptureStdout();
    PrintAverageByLevel::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PrintAverageByLevelTest, averageByLevel_1) {
    vector<int> expected{4, 8, 6, 6, 2};
    vector<string> values{"4", "7", "9", "10", "2", "null", "6", "null", "null", "null", "6", "null", "null", "2"};
    auto root = PrintAverageByLevel::deserialize(values);
    auto result = PrintAverageByLevel::averageByLevel(root);
    EXPECT_EQ(expected, result);
    PrintAverageByLevel::deleteTree(&root);
}

#endif