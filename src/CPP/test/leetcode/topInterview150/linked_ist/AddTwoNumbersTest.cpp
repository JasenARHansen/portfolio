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
    vector<int> expected{7, 0, 8};
    vector<int> l1Values{2, 4, 3};
    vector<int> l2Values{5, 6, 4};
    auto l1 = AddTwoNumbers::deserializeList(l1Values);
    auto l2 = AddTwoNumbers::deserializeList(l2Values);
    auto values = AddTwoNumbers::addTwoNumbers(l1, l2);
    auto result = AddTwoNumbers::serializeList(values);
    EXPECT_EQ(expected, result);
    AddTwoNumbers::deleteList(&l1);
    AddTwoNumbers::deleteList(&l2);
    AddTwoNumbers::deleteList(&values);
}

TEST(AddTwoNumbersTest, addTwoNumbers_2) {
    vector<int> expected{0};
    vector<int> l1Values{0};
    vector<int> l2Values{0};
    auto l1 = AddTwoNumbers::deserializeList(l1Values);
    auto l2 = AddTwoNumbers::deserializeList(l2Values);
    auto values = AddTwoNumbers::addTwoNumbers(l1, l2);
    auto result = AddTwoNumbers::serializeList(values);
    EXPECT_EQ(expected, result);
    AddTwoNumbers::deleteList(&l1);
    AddTwoNumbers::deleteList(&l2);
    AddTwoNumbers::deleteList(&values);
}

TEST(AddTwoNumbersTest, addTwoNumbers_3) {
    vector<int> expected{8, 9, 9, 9, 0, 0, 0, 1};
    vector<int> l1Values{9, 9, 9, 9, 9, 9, 9};
    vector<int> l2Values{9, 9, 9, 9};
    auto l1 = AddTwoNumbers::deserializeList(l1Values);
    auto l2 = AddTwoNumbers::deserializeList(l2Values);
    auto values = AddTwoNumbers::addTwoNumbers(l1, l2);
    auto result = AddTwoNumbers::serializeList(values);
    EXPECT_EQ(expected, result);
    AddTwoNumbers::deleteList(&l1);
    AddTwoNumbers::deleteList(&l2);
    AddTwoNumbers::deleteList(&values);
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_1) {
    // 0 < values.length
    auto size = 100 + 1;
    vector<int> values(size);
    EXPECT_EXIT(AddTwoNumbers::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_2) {
    // values.length  ≤ 100 + 1
    auto size = 100 + 1;
    vector<int> values(size);
    EXPECT_EXIT(AddTwoNumbers::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_3) {
    // 0 ≤ AddTwoNumbersListNode.val
    auto size = 0 - 1;
    vector<int> values{size};
    EXPECT_EXIT(AddTwoNumbers::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(AddTwoNumbersTest, addTwoNumbers_fail_4) {
    // AddTwoNumbersListNode.val ≤ 9
    auto size = 9 + 1;
    vector<int> values{size};
    EXPECT_EXIT(AddTwoNumbers::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

#endif