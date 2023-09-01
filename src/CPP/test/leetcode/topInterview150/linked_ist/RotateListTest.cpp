#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_REVERSE_LINKED_LIST_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_REVERSE_LINKED_LIST_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/RotateList.cpp"

TEST(RotateListTest, description) {
    testing::internal::CaptureStdout();
    RotateList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RotateListTest, rotateRight_1) {
    vector<int> expectedValues{4, 5, 1, 2, 3};
    ListNode *expected = RotateList::generateList(expectedValues);
    vector<int> headValues{1, 2, 3, 4, 5};
    ListNode *head = RotateList::generateList(headValues);
    int k = 2;
    ListNode *result = RotateList::rotateRight(head, k);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    RotateList::deleteList(expectedValues.size(), &expected);
    RotateList::deleteList(expectedValues.size(), &result);
}

TEST(RotateListTest, rotateRight_2) {
    vector<int> expectedValues{2, 0, 1};
    ListNode *expected = RotateList::generateList(expectedValues);
    vector<int> headValues{0, 1, 2};
    ListNode *head = RotateList::generateList(headValues);
    int k = 4;
    ListNode *result = RotateList::rotateRight(head, k);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    RotateList::deleteList(expectedValues.size(), &expected);
    RotateList::deleteList(expectedValues.size(), &result);
}

TEST(RotateListTest, rotateRight_3) {
    vector<int> expectedValues{1, 2, 3, 4, 5};
    ListNode *expected = RotateList::generateList(expectedValues);
    vector<int> headValues{1, 2, 3, 4, 5};
    ListNode *head = RotateList::generateList(headValues);
    int k = 0;
    ListNode *result = RotateList::rotateRight(head, k);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    RotateList::deleteList(expectedValues.size(), &expected);
    RotateList::deleteList(expectedValues.size(), &result);
}

TEST(RotateListTest, rotateRight_4) {
    vector<int> expectedValues{1};
    ListNode *expected = RotateList::generateList(expectedValues);
    vector<int> headValues{1};
    ListNode *head = RotateList::generateList(headValues);
    int k = 5;
    ListNode *result = RotateList::rotateRight(head, k);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    RotateList::deleteList(expectedValues.size(), &expected);
    RotateList::deleteList(expectedValues.size(), &result);
}

TEST(RotateListTest, rotateRight_5) {
    vector<int> expectedValues{};
    ListNode *expected = RotateList::generateList(expectedValues);
    vector<int> headValues{};
    ListNode *head = RotateList::generateList(headValues);
    int k = 0;
    ListNode *result = RotateList::rotateRight(head, k);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest != nullptr) && ((resultTest != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    RotateList::deleteList(expectedValues.size(), &expected);
    RotateList::deleteList(expectedValues.size(), &result);
}

TEST(RotateListTest, rotateRight_fail_1) {
    // n <= 500
    int size = 500 + 1;
    vector<int> values(size);
    EXPECT_EXIT(RotateList::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RotateListTest, rotateRight_fail_2) {
    // -100 <= Node.va
    int size = -100 - 1;
    vector<int> values{size};
    EXPECT_EXIT(RotateList::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RotateListTest, rotateRight_fail_3) {
    // Node.val <= 100
    int size = 100 + 1;
    vector<int> values{size};
    EXPECT_EXIT(RotateList::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RotateListTest, rotateRight_fail_4) {
    // 0 <= k
    vector<int> headValues{1, 2, 3, 4, 5};
    ListNode *head = RotateList::generateList(headValues);
    int k = 0 - 1;
    EXPECT_EXIT(RotateList::rotateRight(head, k), ::testing::ExitedWithCode(3), "");
    RotateList::deleteList(headValues.size(), &head);
}

TEST(RotateListTest, rotateRight_fail_5) {
    // k <= 2 * 10^9
    vector<int> headValues{1, 2, 3, 4, 5};
    ListNode *head = RotateList::generateList(headValues);
    int k = 2 * pow(10, 9) + 1;
    EXPECT_EXIT(RotateList::rotateRight(head, k), ::testing::ExitedWithCode(3), "");
    RotateList::deleteList(headValues.size(), &head);
}

#endif
#pragma clang diagnostic pop