#ifndef INTERVIEW_META_PREPARATION_REVERSE_TEST
#define INTERVIEW_META_PREPARATION_REVERSE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/linked_lists/ReverseOperations.cpp"

TEST(ReverseOperationsTest, description) {
    testing::internal::CaptureStdout();
    ReverseOperations::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ReverseOperationsTest, reverse_1) {
    vector<int> expected{1, 8, 2, 9, 16, 12};
    vector<int> numbers{1, 2, 8, 9, 12, 16};
    auto head = ReverseOperations::deserializeList(numbers);
    auto reversed = ReverseOperations::reverse(head);
    auto result = ReverseOperations::serializeList(reversed);
    EXPECT_EQ(expected, result);
    ReverseOperations::deleteList(&head);
}

TEST(ReverseOperationsTest, reverse_2) {
    vector<int> expected{24, 18, 2, 3, 5, 7, 9, 12, 6};
    vector<int> numbers{2, 18, 24, 3, 5, 7, 9, 6, 12};
    auto head = ReverseOperations::deserializeList(numbers);
    auto reversed = ReverseOperations::reverse(head);
    auto result = ReverseOperations::serializeList(reversed);
    EXPECT_EQ(expected, result);
    ReverseOperations::deleteList(&head);
}

#endif