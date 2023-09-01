#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_ADD_TWO_NUMBERS_TEST
#define LEETCODE_TOP_INTERVIEW_150_ADD_TWO_NUMBERS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/AddTwoNumbers.cpp"

TEST(AddTwoNumbersTest, description) {
    testing::internal::CaptureStdout();
    AddTwoNumbers::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(AddTwoNumbersTest, addTwoNumbers_1) {
    vector<int> expectedValues{7, 0, 8};
    ListNode *expected = AddTwoNumbers::generateList(expectedValues);
    vector<int> l1Values{2, 4, 3};
    ListNode *l1 = AddTwoNumbers::generateList(l1Values);
    vector<int> l2Values{5, 6, 4};
    ListNode *l2 = AddTwoNumbers::generateList(l2Values);
    ListNode *result = AddTwoNumbers::addTwoNumbers(l1, l2);
    AddTwoNumbers::deleteList(l1Values.size(), &l1);
    AddTwoNumbers::deleteList(l2Values.size(), &l2);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest->next != nullptr) && ((resultTest->next != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    AddTwoNumbers::deleteList(expectedValues.size(), &expected);
    AddTwoNumbers::deleteList(expectedValues.size(), &result);
}

TEST(AddTwoNumbersTest, addTwoNumbers_2) {
    vector<int> expectedValues{0};
    ListNode *expected = AddTwoNumbers::generateList(expectedValues);
    vector<int> l1Values{0};
    ListNode *l1 = AddTwoNumbers::generateList(l1Values);
    vector<int> l2Values{0};
    ListNode *l2 = AddTwoNumbers::generateList(l2Values);
    ListNode *result = AddTwoNumbers::addTwoNumbers(l1, l2);
    AddTwoNumbers::deleteList(l1Values.size(), &l1);
    AddTwoNumbers::deleteList(l2Values.size(), &l2);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest->next != nullptr) && ((resultTest->next != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    AddTwoNumbers::deleteList(expectedValues.size(), &expected);
    AddTwoNumbers::deleteList(expectedValues.size(), &result);
}

TEST(AddTwoNumbersTest, addTwoNumbers_3) {
    vector<int> expectedValues{8, 9, 9, 9, 0, 0, 0, 1};
    ListNode *expected = AddTwoNumbers::generateList(expectedValues);
    vector<int> l1Values{9, 9, 9, 9, 9, 9, 9};
    ListNode *l1 = AddTwoNumbers::generateList(l1Values);
    vector<int> l2Values{9, 9, 9, 9};
    ListNode *l2 = AddTwoNumbers::generateList(l2Values);
    ListNode *result = AddTwoNumbers::addTwoNumbers(l1, l2);
    AddTwoNumbers::deleteList(l1Values.size(), &l1);
    AddTwoNumbers::deleteList(l2Values.size(), &l2);
    ListNode *expectedTest = expected;
    ListNode *resultTest = result;
    while ((expectedTest->next != nullptr) && ((resultTest->next != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    AddTwoNumbers::deleteList(expectedValues.size(), &expected);
    AddTwoNumbers::deleteList(expectedValues.size(), &result);
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_1) {
    // 0 < values.length
    int size = 100 + 1;
    vector<int> values(size);
    EXPECT_EXIT(AddTwoNumbers::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_2) {
    // values.length  <= 100 + 1
    int size = 100 + 1;
    vector<int> values(size);
    EXPECT_EXIT(AddTwoNumbers::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_3) {
    // 0 <= Node.val
    int size = 0 - 1;
    vector<int> values{size};
    EXPECT_EXIT(AddTwoNumbers::generateList(values), ::testing::ExitedWithCode(3), "");
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_4) {
    // Node.val <= 9
    int size = 9 + 1;
    vector<int> values{size};
    EXPECT_EXIT(AddTwoNumbers::generateList(values), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop