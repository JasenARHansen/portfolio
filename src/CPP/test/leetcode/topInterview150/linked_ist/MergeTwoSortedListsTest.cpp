#ifndef LEETCODE_TOP_INTERVIEW_150_ADD_TWO_NUMBERS_TEST
#define LEETCODE_TOP_INTERVIEW_150_ADD_TWO_NUMBERS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/MergeTwoSortedLists.cpp"  // NOLINT : Ignore .cpp import

TEST(MergeTwoSortedListsTest, description) {
    testing::internal::CaptureStdout();
    MergeTwoSortedLists::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_splice_1) {
    vector<int> expected{1, 1, 2, 3, 4, 4};
    vector<int> l1Values{1, 2, 4};
    vector<int> l2Values{1, 3, 4};
    auto l1 = MergeTwoSortedLists::deserializeList(l1Values);
    auto l2 = MergeTwoSortedLists::deserializeList(l2Values);
    auto values = MergeTwoSortedLists::mergeTwoLists_splice(l1, l2);
    auto result = MergeTwoSortedLists::serializeList(values);
    EXPECT_EQ(expected, result);
    MergeTwoSortedLists::deleteList(&values);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_splice_2) {
    vector<int> expected{};
    vector<int> l1Values{};
    vector<int> l2Values{};
    auto l1 = MergeTwoSortedLists::deserializeList(l1Values);
    auto l2 = MergeTwoSortedLists::deserializeList(l2Values);
    auto values = MergeTwoSortedLists::mergeTwoLists_splice(l1, l2);
    auto result = MergeTwoSortedLists::serializeList(values);
    EXPECT_EQ(expected, result);
    MergeTwoSortedLists::deleteList(&values);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_splice_3) {
    vector<int> expected{0};
    vector<int> l1Values{};
    vector<int> l2Values{0};
    auto l1 = MergeTwoSortedLists::deserializeList(l1Values);
    auto l2 = MergeTwoSortedLists::deserializeList(l2Values);
    auto values = MergeTwoSortedLists::mergeTwoLists_splice(l1, l2);
    auto result = MergeTwoSortedLists::serializeList(values);
    EXPECT_EQ(expected, result);
    MergeTwoSortedLists::deleteList(&values);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_new_1) {
    vector<int> expected{1, 1, 2, 3, 4, 4};
    vector<int> l1Values{1, 2, 4};
    vector<int> l2Values{1, 3, 4};
    auto l1 = MergeTwoSortedLists::deserializeList(l1Values);
    auto l2 = MergeTwoSortedLists::deserializeList(l2Values);
    auto values = MergeTwoSortedLists::mergeTwoLists_new(l1, l2);
    auto result = MergeTwoSortedLists::serializeList(values);
    EXPECT_EQ(expected, result);
    MergeTwoSortedLists::deleteList(&l1);
    MergeTwoSortedLists::deleteList(&l2);
    MergeTwoSortedLists::deleteList(&values);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_new_2) {
    vector<int> expected{};
    vector<int> l1Values{};
    vector<int> l2Values{};
    auto l1 = MergeTwoSortedLists::deserializeList(l1Values);
    auto l2 = MergeTwoSortedLists::deserializeList(l2Values);
    auto values = MergeTwoSortedLists::mergeTwoLists_new(l1, l2);
    auto result = MergeTwoSortedLists::serializeList(values);
    EXPECT_EQ(expected, result);
    MergeTwoSortedLists::deleteList(&l1);
    MergeTwoSortedLists::deleteList(&l2);
    MergeTwoSortedLists::deleteList(&values);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_new_3) {
    vector<int> expected{0};
    vector<int> l1Values{};
    vector<int> l2Values{0};
    auto l1 = MergeTwoSortedLists::deserializeList(l1Values);
    auto l2 = MergeTwoSortedLists::deserializeList(l2Values);
    auto values = MergeTwoSortedLists::mergeTwoLists_new(l1, l2);
    auto result = MergeTwoSortedLists::serializeList(values);
    EXPECT_EQ(expected, result);
    MergeTwoSortedLists::deleteList(&l1);
    MergeTwoSortedLists::deleteList(&l2);
    MergeTwoSortedLists::deleteList(&values);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_fail_1) {
    // values.length  ≤ 50 + 1
    auto size = 50 + 1;
    vector<int> values(size);
    EXPECT_EXIT(MergeTwoSortedLists::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_fail_2) {
    // -100 ≤ AddTwoNumbersListNode.val
    auto size = -100 - 1;
    vector<int> values{size};
    EXPECT_EXIT(MergeTwoSortedLists::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_fail_3) {
    // AddTwoNumbersListNode.val ≤ 100
    auto size = 100 + 1;
    vector<int> values{size};
    EXPECT_EXIT(MergeTwoSortedLists::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

#endif