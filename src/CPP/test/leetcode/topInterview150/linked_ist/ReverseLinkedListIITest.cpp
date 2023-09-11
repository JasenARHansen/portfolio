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
    auto expected = ReverseLinkedListII::deserialize(expectedValues);
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = ReverseLinkedListII::deserialize(headValues);
    auto left = 2;
    auto right = 4;
    auto result = ReverseLinkedListII::reverseBetween(head, left, right);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    ReverseLinkedListII::deleteList(&expected);
    ReverseLinkedListII::deleteList(&result);
}

TEST(ReverseLinkedListIITest, reverseBetween_2) {
    vector<int> expectedValues{5};
    auto expected = ReverseLinkedListII::deserialize(expectedValues);
    vector<int> headValues{5};
    auto head = ReverseLinkedListII::deserialize(headValues);
    auto left = 1;
    auto right = 1;
    auto result = ReverseLinkedListII::reverseBetween(head, left, right);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    ReverseLinkedListII::deleteList(&expected);
    ReverseLinkedListII::deleteList(&result);
}

TEST(ReverseLinkedListIITest, reverseBetween_3) {
    vector<int> expectedValues{1, 2, 3};
    auto expected = ReverseLinkedListII::deserialize(expectedValues);
    vector<int> headValues{1, 2, 3};
    auto head = ReverseLinkedListII::deserialize(headValues);
    auto left = 3;
    auto right = 3;
    auto result = ReverseLinkedListII::reverseBetween(head, left, right);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    ReverseLinkedListII::deleteList(&expected);
    ReverseLinkedListII::deleteList(&result);
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_1) {
    // 1 ≤ n
    auto size = 1 - 1;
    vector<int> values(size);
    EXPECT_EXIT(ReverseLinkedListII::deserialize(values), ::testing::ExitedWithCode(3), "");
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_2) {
    // n ≤ 500
    auto size = 500 + 1;
    vector<int> values(size);
    EXPECT_EXIT(ReverseLinkedListII::deserialize(values), ::testing::ExitedWithCode(3), "");
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_3) {
    // -500 ≤ ListNode.va
    auto size = -500 - 1;
    vector<int> values{size};
    EXPECT_EXIT(ReverseLinkedListII::deserialize(values), ::testing::ExitedWithCode(3), "");
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_4) {
    // ListNode.val ≤ 500
    auto size = 500 + 1;
    vector<int> values{size};
    EXPECT_EXIT(ReverseLinkedListII::deserialize(values), ::testing::ExitedWithCode(3), "");
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_5) {
    // 1 ≤ left
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = ReverseLinkedListII::deserialize(headValues);
    auto left = 1 - 1;
    auto right = 1;
    EXPECT_EXIT(ReverseLinkedListII::reverseBetween(head, left, right), ::testing::ExitedWithCode(3), "");
    ReverseLinkedListII::deleteList(&head);
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_6) {
    // 1 ≤ right
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = ReverseLinkedListII::deserialize(headValues);
    auto left = 2;
    auto right = 1 - 1;
    EXPECT_EXIT(ReverseLinkedListII::reverseBetween(head, left, right), ::testing::ExitedWithCode(3), "");
    ReverseLinkedListII::deleteList(&head);
}

TEST(ReverseLinkedListIITest, reverseBetween_fail_7) {
    // left ≤ right
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = ReverseLinkedListII::deserialize(headValues);
    auto left = 5;
    auto right = left - 1;
    EXPECT_EXIT(ReverseLinkedListII::reverseBetween(head, left, right), ::testing::ExitedWithCode(3), "");
    ReverseLinkedListII::deleteList(&head);
}

#endif