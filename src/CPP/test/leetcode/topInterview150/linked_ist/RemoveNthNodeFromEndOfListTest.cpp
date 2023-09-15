#ifndef LEETCODE_TOP_INTERVIEW_150_REMOVE_NTH_NODE_FROM_END_OF_LIST_TEST
#define LEETCODE_TOP_INTERVIEW_150_REMOVE_NTH_NODE_FROM_END_OF_LIST_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/RemoveNthNodeFromEndOfList.cpp"  // NOLINT : Ignore .cpp import

TEST(RemoveNthNodeFromEndOfListTest, description) {
    testing::internal::CaptureStdout();
    RemoveNthNodeFromEndOfList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_1) {
    vector<int> expected{1, 2, 3, 5};
    vector<int> headValues{1, 2, 3, 4, 5};
    auto n = 2;
    auto head = RemoveNthNodeFromEndOfList::deserializeList(headValues);
    auto values = RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n);
    auto result = RemoveNthNodeFromEndOfList::serializeList(values);
    EXPECT_EQ(expected, result);
    RemoveNthNodeFromEndOfList::deleteList(&head);
    RemoveNthNodeFromEndOfList::deleteList(&values);
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_2) {
    vector<int> expected{};
    vector<int> headValues{1};
    auto n = 1;
    auto head = RemoveNthNodeFromEndOfList::deserializeList(headValues);
    auto values = RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n);
    auto result = RemoveNthNodeFromEndOfList::serializeList(values);
    EXPECT_EQ(expected, result);
    RemoveNthNodeFromEndOfList::deleteList(&head);
    RemoveNthNodeFromEndOfList::deleteList(&values);
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_3) {
    vector<int> expected{1};
    vector<int> headValues{1, 2};
    auto n = 1;
    auto head = RemoveNthNodeFromEndOfList::deserializeList(headValues);
    auto values = RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n);
    auto result = RemoveNthNodeFromEndOfList::serializeList(values);
    EXPECT_EQ(expected, result);
    RemoveNthNodeFromEndOfList::deleteList(&head);
    RemoveNthNodeFromEndOfList::deleteList(&values);
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_4) {
    vector<int> expected{2};
    vector<int> headValues{1, 2};
    auto n = 2;
    auto head = RemoveNthNodeFromEndOfList::deserializeList(headValues);
    auto values = RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n);
    auto result = RemoveNthNodeFromEndOfList::serializeList(values);
    EXPECT_EQ(expected, result);
    RemoveNthNodeFromEndOfList::deleteList(&head);
    RemoveNthNodeFromEndOfList::deleteList(&values);
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_fail_1) {
    // sz ≤ 30
    auto size = 30 + 1;
    vector<int> values(size);
    EXPECT_EXIT(RemoveNthNodeFromEndOfList::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_fail_2) {
    // 0 ≤ AddTwoNumbersListNode.val
    auto size = 0 - 1;
    vector<int> values{size};
    EXPECT_EXIT(RemoveNthNodeFromEndOfList::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_fail_3) {
    // AddTwoNumbersListNode.val ≤ 100
    auto size = 100 + 1;
    vector<int> values{size};
    EXPECT_EXIT(RemoveNthNodeFromEndOfList::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_fail_4) {
    // 1 ≤ n
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = RemoveNthNodeFromEndOfList::deserializeList(headValues);
    auto n = 1 - 1;
    EXPECT_EXIT(RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n), ::testing::ExitedWithCode(3), "");
    RemoveNthNodeFromEndOfList::deleteList(&head);
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_fail_5) {
    // n ≤ sz
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = RemoveNthNodeFromEndOfList::deserializeList(headValues);
    auto n = headValues.size() + 1;
    EXPECT_EXIT(RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n), ::testing::ExitedWithCode(3), "");
    RemoveNthNodeFromEndOfList::deleteList(&head);
}

#endif