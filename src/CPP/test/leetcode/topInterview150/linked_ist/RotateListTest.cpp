#ifndef LEETCODE_TOP_INTERVIEW_150_ROTATE_LIST_TEST
#define LEETCODE_TOP_INTERVIEW_150_ROTATE_LIST_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_ist/RotateList.cpp"  // NOLINT : Ignore .cpp import

TEST(RotateListTest, description) {
    testing::internal::CaptureStdout();
    RotateList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RotateListTest, rotateRight_1) {
    vector<int> expected{4, 5, 1, 2, 3};
    vector<int> headValues{1, 2, 3, 4, 5};
    auto k = 2;
    auto head = RotateList::deserializeList(headValues);
    auto values = RotateList::rotateRight(head, k);
    auto result = RotateList::serializeList(values);
    EXPECT_EQ(expected, result);
    RotateList::deleteList(&head);
    RotateList::deleteList(&values);
}

TEST(RotateListTest, rotateRight_2) {
    vector<int> expected{2, 0, 1};
    vector<int> headValues{0, 1, 2};
    auto k = 4;
    auto head = RotateList::deserializeList(headValues);
    auto values = RotateList::rotateRight(head, k);
    auto result = RotateList::serializeList(values);
    EXPECT_EQ(expected, result);
    RotateList::deleteList(&head);
    RotateList::deleteList(&values);
}

TEST(RotateListTest, rotateRight_3) {
    vector<int> expected{1, 2, 3, 4, 5};
    vector<int> headValues{1, 2, 3, 4, 5};
    auto k = 0;
    auto head = RotateList::deserializeList(headValues);
    auto values = RotateList::rotateRight(head, k);
    auto result = RotateList::serializeList(values);
    EXPECT_EQ(expected, result);
    RotateList::deleteList(&head);
    RotateList::deleteList(&values);
}

TEST(RotateListTest, rotateRight_4) {
    vector<int> expected{1};
    vector<int> headValues{1};
    auto k = 5;
    auto head = RotateList::deserializeList(headValues);
    auto values = RotateList::rotateRight(head, k);
    auto result = RotateList::serializeList(values);
    EXPECT_EQ(expected, result);
    RotateList::deleteList(&head);
    RotateList::deleteList(&values);
}

TEST(RotateListTest, rotateRight_5) {
    vector<int> expected{};
    vector<int> headValues{};
    auto k = 0;
    auto head = RotateList::deserializeList(headValues);
    auto values = RotateList::rotateRight(head, k);
    auto result = RotateList::serializeList(values);
    EXPECT_EQ(expected, result);
    RotateList::deleteList(&head);
    RotateList::deleteList(&values);
}

TEST(RotateListTest, rotateRight_fail_1) {
    // n ≤ 500
    auto size = 500 + 1;
    vector<int> values(size);
    EXPECT_EXIT(RotateList::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RotateListTest, rotateRight_fail_2) {
    // -100 ≤ AddTwoNumbersListNode.val
    auto size = -100 - 1;
    vector<int> values{size};
    EXPECT_EXIT(RotateList::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RotateListTest, rotateRight_fail_3) {
    // AddTwoNumbersListNode.val ≤ 100
    auto size = 100 + 1;
    vector<int> values{size};
    EXPECT_EXIT(RotateList::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(RotateListTest, rotateRight_fail_4) {
    // 0 ≤ k
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = RotateList::deserializeList(headValues);
    auto k = 0 - 1;
    EXPECT_EXIT(RotateList::rotateRight(head, k), ::testing::ExitedWithCode(3), "");
    RotateList::deleteList(&head);
}

TEST(RotateListTest, rotateRight_fail_5) {
    // k ≤ 2 * 10^9
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = RotateList::deserializeList(headValues);
    auto k = 2 * (int) pow(10, 9) + 1;
    EXPECT_EXIT(RotateList::rotateRight(head, k), ::testing::ExitedWithCode(3), "");
    RotateList::deleteList(&head);
}

#endif