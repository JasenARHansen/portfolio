#ifndef LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_LIST_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_LIST_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/RemoveDuplicatesFromSortedListII.cpp"

TEST(RemoveDuplicatesFromSortedListIITest, description) {
    testing::internal::CaptureStdout();
    RemoveDuplicatesFromSortedListII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RemoveDuplicatesFromSortedListIITest, deleteDuplicates_1) {
    vector<int> expectedValues{1, 2, 5};
    auto expected = RemoveDuplicatesFromSortedListII::deserialize(expectedValues);
    vector<int> headValues{1, 2, 3, 3, 4, 4, 5};
    auto head = RemoveDuplicatesFromSortedListII::deserialize(headValues);
    auto result = RemoveDuplicatesFromSortedListII::deleteDuplicates(head);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    RemoveDuplicatesFromSortedListII::deleteList(&expected);
    RemoveDuplicatesFromSortedListII::deleteList(&result);
}

TEST(RemoveDuplicatesFromSortedListIITest, deleteDuplicates_2) {
    vector<int> expectedValues{2, 3};
    auto expected = RemoveDuplicatesFromSortedListII::deserialize(expectedValues);
    vector<int> headValues{1, 1, 1, 2, 3};
    auto head = RemoveDuplicatesFromSortedListII::deserialize(headValues);
    auto result = RemoveDuplicatesFromSortedListII::deleteDuplicates(head);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    RemoveDuplicatesFromSortedListII::deleteList(&expected);
    RemoveDuplicatesFromSortedListII::deleteList(&result);
}

#endif