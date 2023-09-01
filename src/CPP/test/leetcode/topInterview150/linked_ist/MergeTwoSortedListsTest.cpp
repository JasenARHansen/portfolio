#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_ADD_TWO_NUMBERS_TEST
#define LEETCODE_TOP_INTERVIEW_150_ADD_TWO_NUMBERS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/MergeTwoSortedLists.cpp"

TEST(MergeTwoSortedListsTest, description) {
    testing::internal::CaptureStdout();
    MergeTwoSortedLists::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_splice_1) {
    vector<int> expectedValues{1, 1, 2, 3, 4, 4};
    ListNode *expected = MergeTwoSortedLists::generateList(expectedValues);
    vector<int> l1Values{1, 2, 4};
    ListNode *l1 = MergeTwoSortedLists::generateList(l1Values);
    vector<int> l2Values{1, 3, 4};
    ListNode *l2 = MergeTwoSortedLists::generateList(l2Values);
    ListNode *result = MergeTwoSortedLists::mergeTwoLists_splice(l1, l2);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(expectedValues.size(), &expected);
    MergeTwoSortedLists::deleteList(expectedValues.size(), &result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_splice_2) {
    vector<int> expectedValues{};
    ListNode *expected = MergeTwoSortedLists::generateList(expectedValues);
    vector<int> l1Values{};
    ListNode *l1 = MergeTwoSortedLists::generateList(l1Values);
    vector<int> l2Values{};
    ListNode *l2 = MergeTwoSortedLists::generateList(l2Values);
    ListNode *result = MergeTwoSortedLists::mergeTwoLists_splice(l1, l2);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(expectedValues.size(), &expected);
    MergeTwoSortedLists::deleteList(expectedValues.size(), &result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_splice_3) {
    vector<int> expectedValues{0};
    ListNode *expected = MergeTwoSortedLists::generateList(expectedValues);
    vector<int> l1Values{};
    ListNode *l1 = MergeTwoSortedLists::generateList(l1Values);
    vector<int> l2Values{0};
    ListNode *l2 = MergeTwoSortedLists::generateList(l2Values);
    ListNode *result = MergeTwoSortedLists::mergeTwoLists_splice(l1, l2);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(expectedValues.size(), &expected);
    MergeTwoSortedLists::deleteList(expectedValues.size(), &result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_new_1) {
    vector<int> expectedValues{1, 1, 2, 3, 4, 4};
    ListNode *expected = MergeTwoSortedLists::generateList(expectedValues);
    vector<int> l1Values{1, 2, 4};
    ListNode *l1 = MergeTwoSortedLists::generateList(l1Values);
    vector<int> l2Values{1, 3, 4};
    ListNode *l2 = MergeTwoSortedLists::generateList(l2Values);
    ListNode *result = MergeTwoSortedLists::mergeTwoLists_new(l1, l2);
    MergeTwoSortedLists::deleteList(l1Values.size(), &l1);
    MergeTwoSortedLists::deleteList(l2Values.size(), &l2);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(expectedValues.size(), &expected);
    MergeTwoSortedLists::deleteList(expectedValues.size(), &result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_new_2) {
    vector<int> expectedValues{};
    ListNode *expected = MergeTwoSortedLists::generateList(expectedValues);
    vector<int> l1Values{};
    ListNode *l1 = MergeTwoSortedLists::generateList(l1Values);
    vector<int> l2Values{};
    ListNode *l2 = MergeTwoSortedLists::generateList(l2Values);
    ListNode *result = MergeTwoSortedLists::mergeTwoLists_new(l1, l2);
    MergeTwoSortedLists::deleteList(l1Values.size(), &l1);
    MergeTwoSortedLists::deleteList(l2Values.size(), &l2);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(expectedValues.size(), &expected);
    MergeTwoSortedLists::deleteList(expectedValues.size(), &result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_new_3) {
    vector<int> expectedValues{0};
    ListNode *expected = MergeTwoSortedLists::generateList(expectedValues);
    vector<int> l1Values{};
    ListNode *l1 = MergeTwoSortedLists::generateList(l1Values);
    vector<int> l2Values{0};
    ListNode *l2 = MergeTwoSortedLists::generateList(l2Values);
    ListNode *result = MergeTwoSortedLists::mergeTwoLists_new(l1, l2);
    MergeTwoSortedLists::deleteList(l1Values.size(), &l1);
    MergeTwoSortedLists::deleteList(l2Values.size(), &l2);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(expectedValues.size(), &expected);
    MergeTwoSortedLists::deleteList(expectedValues.size(), &result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_fail_1) {
    // values.length  <= 50 + 1
    int size = 50 + 1;
    vector<int> values(size);
    EXPECT_EXIT(MergeTwoSortedLists::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_fail_2) {
    // -100 <= Node.val
    int size = -100 - 1;
    vector<int> values{size};
    EXPECT_EXIT(MergeTwoSortedLists::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_fail_3) {
    // Node.val <= 100
    int size = 100 + 1;
    vector<int> values{size};
    EXPECT_EXIT(MergeTwoSortedLists::generateList(values), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop