#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_REVERSE_LINKED_LIST_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_REVERSE_LINKED_LIST_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/ReverseLinkedListII.cpp"

TEST(ReverseLinkedListIITest, description) {
    testing::internal::CaptureStdout();
    ReverseLinkedListII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ReverseLinkedListIITest, reverseBetween_1) {
    vector<int> expectedValues{1, 4, 3, 2, 5};
    ListNode *expected = ReverseLinkedListII::generateList(expectedValues);
    vector<int> headValues{1, 2, 3, 4, 5};
    ListNode *head = ReverseLinkedListII::generateList(headValues);
    int left = 2;
    int right = 4;
    ListNode *result = ReverseLinkedListII::reverseBetween(head, left, right);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    ReverseLinkedListII::deleteList(expectedValues.size(), &expected);
    ReverseLinkedListII::deleteList(expectedValues.size(), &result);
}

TEST(ReverseLinkedListIITest, reverseBetween_2) {
    vector<int> expectedValues{5};
    ListNode *expected = ReverseLinkedListII::generateList(expectedValues);
    vector<int> headValues{5};
    ListNode *head = ReverseLinkedListII::generateList(headValues);
    int left = 1;
    int right = 1;
    ListNode *result = ReverseLinkedListII::reverseBetween(head, left, right);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    ReverseLinkedListII::deleteList(expectedValues.size(), &expected);
    ReverseLinkedListII::deleteList(expectedValues.size(), &result);
}

TEST(ReverseLinkedListIITest, reverseBetween_3) {
    vector<int> expectedValues{1, 2, 3};
    ListNode *expected = ReverseLinkedListII::generateList(expectedValues);
    vector<int> headValues{1, 2, 3};
    ListNode *head = ReverseLinkedListII::generateList(headValues);
    int left = 3;
    int right = 3;
    ListNode *result = ReverseLinkedListII::reverseBetween(head, left, right);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    ReverseLinkedListII::deleteList(expectedValues.size(), &expected);
    ReverseLinkedListII::deleteList(expectedValues.size(), &result);
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_1) {
    // 1 <= n
    int size = 1 - 1;
    vector<int> values(size);
    EXPECT_EXIT(ReverseLinkedListII::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_2) {
    // n <= 500
    int size = 500 + 1;
    vector<int> values(size);
    EXPECT_EXIT(ReverseLinkedListII::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_3) {
    // -500 <= Node.va
    int size = -500 - 1;
    vector<int> values{size};
    EXPECT_EXIT(ReverseLinkedListII::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_4) {
    // Node.val <= 500
    int size = 500 + 1;
    vector<int> values{size};
    EXPECT_EXIT(ReverseLinkedListII::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_5) {
    // 1 <= left
    vector<int> headValues{1, 2, 3, 4, 5};
    ListNode *head = ReverseLinkedListII::generateList(headValues);
    int left = 1 - 1;
    int right = 1;
    EXPECT_EXIT(ReverseLinkedListII::reverseBetween(head, left, right), ::testing::ExitedWithCode(3), "");
    ReverseLinkedListII::deleteList(headValues.size(), &head);
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_6) {
    // 1 <= right
    vector<int> headValues{1, 2, 3, 4, 5};
    ListNode *head = ReverseLinkedListII::generateList(headValues);
    int left = 2;
    int right = 1 - 1;
    EXPECT_EXIT(ReverseLinkedListII::reverseBetween(head, left, right), ::testing::ExitedWithCode(3), "");
    ReverseLinkedListII::deleteList(headValues.size(), &head);
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_7) {
    // left <= right
    vector<int> headValues{1, 2, 3, 4, 5};
    ListNode *head = ReverseLinkedListII::generateList(headValues);
    int left = 5;
    int right = left - 1;
    EXPECT_EXIT(ReverseLinkedListII::reverseBetween(head, left, right), ::testing::ExitedWithCode(3), "");
    ReverseLinkedListII::deleteList(headValues.size(), &head);
}

#endif
#pragma clang diagnostic pop