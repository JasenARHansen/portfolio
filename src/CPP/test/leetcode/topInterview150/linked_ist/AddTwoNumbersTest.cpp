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
    auto expected = AddTwoNumbers::deserialize(expectedValues);
    vector<int> l1Values{2, 4, 3};
    auto l1 = AddTwoNumbers::deserialize(l1Values);
    vector<int> l2Values{5, 6, 4};
    auto l2 = AddTwoNumbers::deserialize(l2Values);
    auto result = AddTwoNumbers::addTwoNumbers(l1, l2);
    AddTwoNumbers::deleteList(&l1);
    AddTwoNumbers::deleteList(&l2);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest->next != nullptr) && ((resultTest->next != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    AddTwoNumbers::deleteList(&expected);
    AddTwoNumbers::deleteList(&result);
}

TEST(AddTwoNumbersTest, addTwoNumbers_2) {
    vector<int> expectedValues{0};
    auto expected = AddTwoNumbers::deserialize(expectedValues);
    vector<int> l1Values{0};
    auto l1 = AddTwoNumbers::deserialize(l1Values);
    vector<int> l2Values{0};
    auto l2 = AddTwoNumbers::deserialize(l2Values);
    auto result = AddTwoNumbers::addTwoNumbers(l1, l2);
    AddTwoNumbers::deleteList(&l1);
    AddTwoNumbers::deleteList(&l2);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest->next != nullptr) && ((resultTest->next != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    AddTwoNumbers::deleteList(&expected);
    AddTwoNumbers::deleteList(&result);
}

TEST(AddTwoNumbersTest, addTwoNumbers_3) {
    vector<int> expectedValues{8, 9, 9, 9, 0, 0, 0, 1};
    auto expected = AddTwoNumbers::deserialize(expectedValues);
    vector<int> l1Values{9, 9, 9, 9, 9, 9, 9};
    auto l1 = AddTwoNumbers::deserialize(l1Values);
    vector<int> l2Values{9, 9, 9, 9};
    auto l2 = AddTwoNumbers::deserialize(l2Values);
    auto result = AddTwoNumbers::addTwoNumbers(l1, l2);
    AddTwoNumbers::deleteList(&l1);
    AddTwoNumbers::deleteList(&l2);
    auto expectedTest = expected;
    auto resultTest = result;
    while ((expectedTest->next != nullptr) && ((resultTest->next != nullptr))) {
        EXPECT_EQ(expectedTest->val, resultTest->val);
        expectedTest = expectedTest->next;
        resultTest = resultTest->next;
    }
    AddTwoNumbers::deleteList(&expected);
    AddTwoNumbers::deleteList(&result);
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_1) {
    // 0 < values.length
    auto size = 100 + 1;
    vector<int> values(size);
    EXPECT_EXIT(AddTwoNumbers::deserialize(values), ::testing::ExitedWithCode(3), "");
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_2) {
    // values.length  ≤ 100 + 1
    auto size = 100 + 1;
    vector<int> values(size);
    EXPECT_EXIT(AddTwoNumbers::deserialize(values), ::testing::ExitedWithCode(3), "");
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_3) {
    // 0 ≤ Node.val
    auto size = 0 - 1;
    vector<int> values{size};
    EXPECT_EXIT(AddTwoNumbers::deserialize(values), ::testing::ExitedWithCode(3), "");
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_4) {
    // Node.val ≤ 9
    auto size = 9 + 1;
    vector<int> values{size};
    EXPECT_EXIT(AddTwoNumbers::deserialize(values), ::testing::ExitedWithCode(3), "");
}

#endif