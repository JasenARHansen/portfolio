#ifndef LEETCODE_TOP_INTERVIEW_150_REMOVE_NTH_NODE_FROM_END_OF_LIST_TEST
#define LEETCODE_TOP_INTERVIEW_150_REMOVE_NTH_NODE_FROM_END_OF_LIST_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/RemoveNthNodeFromEndOfList.cpp"

TEST(RemoveNthNodeFromEndOfListTest, description) {
    testing::internal::CaptureStdout();
    RemoveNthNodeFromEndOfList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_1) {
    vector<int> expectedValues{1, 2, 3, 5};
    auto expected = RemoveNthNodeFromEndOfList::generateList(expectedValues);
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = RemoveNthNodeFromEndOfList::generateList(headValues);
    auto n = 2;
    auto result = RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    RemoveNthNodeFromEndOfList::deleteList(expectedValues.size(), &expected);
    RemoveNthNodeFromEndOfList::deleteList(expectedValues.size(), &result);
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_2) {
    vector<int> expectedValues{};
    auto expected = RemoveNthNodeFromEndOfList::generateList(expectedValues);
    vector<int> headValues{1};
    auto head = RemoveNthNodeFromEndOfList::generateList(headValues);
    auto n = 1;
    auto result = RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    RemoveNthNodeFromEndOfList::deleteList(expectedValues.size(), &expected);
    RemoveNthNodeFromEndOfList::deleteList(expectedValues.size(), &result);
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_3) {
    vector<int> expectedValues{1};
    auto expected = RemoveNthNodeFromEndOfList::generateList(expectedValues);
    vector<int> headValues{1, 2};
    auto head = RemoveNthNodeFromEndOfList::generateList(headValues);
    auto n = 1;
    auto result = RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    RemoveNthNodeFromEndOfList::deleteList(expectedValues.size(), &expected);
    RemoveNthNodeFromEndOfList::deleteList(expectedValues.size(), &result);
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_4) {
    vector<int> expectedValues{2};
    auto expected = RemoveNthNodeFromEndOfList::generateList(expectedValues);
    vector<int> headValues{1, 2};
    auto head = RemoveNthNodeFromEndOfList::generateList(headValues);
    auto n = 2;
    auto result = RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    RemoveNthNodeFromEndOfList::deleteList(expectedValues.size(), &expected);
    RemoveNthNodeFromEndOfList::deleteList(expectedValues.size(), &result);
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_fail_1) {
    // sz <= 30
    auto size = 30 + 1;
    vector<int> values(size);
    EXPECT_EXIT(RemoveNthNodeFromEndOfList::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_fail_2) {
    // 0 <= Node.val
    auto size = 0 - 1;
    vector<int> values{size};
    EXPECT_EXIT(RemoveNthNodeFromEndOfList::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_fail_3) {
    // Node.val <= 100
    auto size = 100 + 1;
    vector<int> values{size};
    EXPECT_EXIT(RemoveNthNodeFromEndOfList::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_fail_4) {
    // 1 <= n
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = RemoveNthNodeFromEndOfList::generateList(headValues);
    auto n = 1 - 1;
    EXPECT_EXIT(RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n), ::testing::ExitedWithCode(3), "");
    RemoveNthNodeFromEndOfList::deleteList(headValues.size(), &head);
}

TEST(RemoveNthNodeFromEndOfListTest, removeNthFromEnd_fail_5) {
    // n <= sz
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = RemoveNthNodeFromEndOfList::generateList(headValues);
    auto n = headValues.size() + 1;
    EXPECT_EXIT(RemoveNthNodeFromEndOfList::removeNthFromEnd(head, n), ::testing::ExitedWithCode(3), "");
    RemoveNthNodeFromEndOfList::deleteList(headValues.size(), &head);
}

#endif