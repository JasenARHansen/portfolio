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
    auto expected = MergeTwoSortedLists::deserialize(expectedValues);
    vector<int> l1Values{1, 2, 4};
    auto l1 = MergeTwoSortedLists::deserialize(l1Values);
    vector<int> l2Values{1, 3, 4};
    auto l2 = MergeTwoSortedLists::deserialize(l2Values);
    auto result = MergeTwoSortedLists::mergeTwoLists_splice(l1, l2);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(&expected);
    MergeTwoSortedLists::deleteList(&result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_splice_2) {
    vector<int> expectedValues{};
    auto expected = MergeTwoSortedLists::deserialize(expectedValues);
    vector<int> l1Values{};
    auto l1 = MergeTwoSortedLists::deserialize(l1Values);
    vector<int> l2Values{};
    auto l2 = MergeTwoSortedLists::deserialize(l2Values);
    auto result = MergeTwoSortedLists::mergeTwoLists_splice(l1, l2);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(&expected);
    MergeTwoSortedLists::deleteList(&result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_splice_3) {
    vector<int> expectedValues{0};
    auto expected = MergeTwoSortedLists::deserialize(expectedValues);
    vector<int> l1Values{};
    auto l1 = MergeTwoSortedLists::deserialize(l1Values);
    vector<int> l2Values{0};
    auto l2 = MergeTwoSortedLists::deserialize(l2Values);
    auto result = MergeTwoSortedLists::mergeTwoLists_splice(l1, l2);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(&expected);
    MergeTwoSortedLists::deleteList(&result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_new_1) {
    vector<int> expectedValues{1, 1, 2, 3, 4, 4};
    auto expected = MergeTwoSortedLists::deserialize(expectedValues);
    vector<int> l1Values{1, 2, 4};
    auto l1 = MergeTwoSortedLists::deserialize(l1Values);
    vector<int> l2Values{1, 3, 4};
    auto l2 = MergeTwoSortedLists::deserialize(l2Values);
    auto result = MergeTwoSortedLists::mergeTwoLists_new(l1, l2);
    MergeTwoSortedLists::deleteList(&l1);
    MergeTwoSortedLists::deleteList(&l2);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(&expected);
    MergeTwoSortedLists::deleteList(&result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_new_2) {
    vector<int> expectedValues{};
    auto expected = MergeTwoSortedLists::deserialize(expectedValues);
    vector<int> l1Values{};
    auto l1 = MergeTwoSortedLists::deserialize(l1Values);
    vector<int> l2Values{};
    auto l2 = MergeTwoSortedLists::deserialize(l2Values);
    auto result = MergeTwoSortedLists::mergeTwoLists_new(l1, l2);
    MergeTwoSortedLists::deleteList(&l1);
    MergeTwoSortedLists::deleteList(&l2);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(&expected);
    MergeTwoSortedLists::deleteList(&result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_new_3) {
    vector<int> expectedValues{0};
    auto expected = MergeTwoSortedLists::deserialize(expectedValues);
    vector<int> l1Values{};
    auto l1 = MergeTwoSortedLists::deserialize(l1Values);
    vector<int> l2Values{0};
    auto l2 = MergeTwoSortedLists::deserialize(l2Values);
    auto result = MergeTwoSortedLists::mergeTwoLists_new(l1, l2);
    MergeTwoSortedLists::deleteList(&l1);
    MergeTwoSortedLists::deleteList(&l2);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    MergeTwoSortedLists::deleteList(&expected);
    MergeTwoSortedLists::deleteList(&result);
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_fail_1) {
    // values.length  <= 50 + 1
    auto size = 50 + 1;
    vector<int> values(size);
    EXPECT_EXIT(MergeTwoSortedLists::deserialize(values), ::testing::ExitedWithCode(3), "");
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_fail_2) {
    // -100 <= Node.val
    auto size = -100 - 1;
    vector<int> values{size};
    EXPECT_EXIT(MergeTwoSortedLists::deserialize(values), ::testing::ExitedWithCode(3), "");
}

TEST(MergeTwoSortedListsTest, mergeTwoLists_fail_3) {
    // Node.val <= 100
    auto size = 100 + 1;
    vector<int> values{size};
    EXPECT_EXIT(MergeTwoSortedLists::deserialize(values), ::testing::ExitedWithCode(3), "");
}

#endif