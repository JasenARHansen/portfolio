#ifndef LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_LIST_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_LIST_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_list/RemoveDuplicatesFromSortedListII.cpp"  // NOLINT : Ignore .cpp import

TEST(RemoveDuplicatesFromSortedListIITest, description) {
    testing::internal::CaptureStdout();
    RemoveDuplicatesFromSortedListII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RemoveDuplicatesFromSortedListIITest, deleteDuplicates_1) {
    vector<int> expected{1, 2, 5};
    vector<int> headValues{1, 2, 3, 3, 4, 4, 5};
    auto head = RemoveDuplicatesFromSortedListII::deserializeList(headValues);
    auto values = RemoveDuplicatesFromSortedListII::deleteDuplicates(head);
    auto result = RemoveDuplicatesFromSortedListII::serializeList(values);
    EXPECT_EQ(expected, result);
    RemoveDuplicatesFromSortedListII::deleteList(&head);
    RemoveDuplicatesFromSortedListII::deleteList(&values);
}

TEST(RemoveDuplicatesFromSortedListIITest, deleteDuplicates_2) {
    vector<int> expected{2, 3};
    vector<int> headValues{1, 1, 1, 2, 3};
    auto head = RemoveDuplicatesFromSortedListII::deserializeList(headValues);
    auto values = RemoveDuplicatesFromSortedListII::deleteDuplicates(head);
    auto result = RemoveDuplicatesFromSortedListII::serializeList(values);
    EXPECT_EQ(expected, result);
    RemoveDuplicatesFromSortedListII::deleteList(&head);
    RemoveDuplicatesFromSortedListII::deleteList(&values);
}

#endif