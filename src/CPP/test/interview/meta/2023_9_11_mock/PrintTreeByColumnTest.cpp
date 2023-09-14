#ifndef INTERVIEW_META_2023_9_11_MOCK_INTERVIEW_PRINT_TREE_BY_COLUMN_TEST
#define INTERVIEW_META_2023_9_11_MOCK_INTERVIEW_PRINT_TREE_BY_COLUMN_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/2023_9_11_mock/PrintTreeByColumn.cpp"

TEST(PrintTreeByColumnTest, description) {
    testing::internal::CaptureStdout();
    PrintTreeByColumn::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PrintTreeByColumnTest, order_1) {
    vector<int> expected{5, 9, 3, 2, 6, 1, 7, 4, 8, 0};
    vector<string> values{"6", "3", "4", "5", "null", "1", "0", "null", "2", "null", "null", "8", "null", "9", "7"};
    auto root = PrintTreeByColumn::deserialize(values);
    auto result = PrintTreeByColumn::order(root);
    EXPECT_EQ(expected, result);
    PrintTreeByColumn::deleteTree(&root);
}

TEST(PrintTreeByColumnTest, order_2) {
    vector<int> expected{6, 1, 2, 5, 9, 7, 8, 4};
    vector<string> values{"5", "1", "8", "6", "null", "9", "4", "null", "2", "null", "null", "null", "null", "null",
                          "7"};
    auto root = PrintTreeByColumn::deserialize(values);
    auto result = PrintTreeByColumn::order(root);
    EXPECT_EQ(expected, result);
    PrintTreeByColumn::deleteTree(&root);
}

#endif