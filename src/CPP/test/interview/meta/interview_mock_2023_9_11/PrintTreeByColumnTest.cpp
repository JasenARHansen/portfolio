#ifndef INTERVIEW_META_INTERVIEW_MOCK_2023_9_11_PRINT_TREE_BY_COLUMN_TEST
#define INTERVIEW_META_INTERVIEW_MOCK_2023_9_11_PRINT_TREE_BY_COLUMN_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/interview_mock_2023_9_11/PrintTreeByColumn.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_PrintTreeByColumnTest, description) {
    testing::internal::CaptureStdout();
    PrintTreeByColumn::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_PrintTreeByColumnTest, order_1) {
    vector<int> expected{5, 9, 3, 2, 6, 1, 7, 4, 8, 0};
    vector<string> values{"6", "3", "4", "5", "null", "1", "0", "null", "2", "null", "null", "8", "null", "9", "7"};
    auto root = PrintTreeByColumn::deserialize(values);
    auto result = PrintTreeByColumn::order(root);
    EXPECT_EQ(expected, result);
    PrintTreeByColumn::deleteTree(&root);
}

TEST(Interview_PrintTreeByColumnTest, order_2) {
    vector<int> expected{6, 1, 2, 5, 9, 7, 8, 4};
    vector<string> values{"5", "1", "8", "6", "null", "9", "4", "null", "2", "null", "null", "null", "null", "null",
                          "7"};
    auto root = PrintTreeByColumn::deserialize(values);
    auto result = PrintTreeByColumn::order(root);
    EXPECT_EQ(expected, result);
    PrintTreeByColumn::deleteTree(&root);
}

#endif