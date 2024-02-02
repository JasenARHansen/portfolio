#ifndef LEETCODE_TOP_INTERVIEW_150_PARTITION_LIST_TEST
#define LEETCODE_TOP_INTERVIEW_150_PARTITION_LIST_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/linked_list/PartitionList.cpp"  // NOLINT : Ignore .cpp import

TEST(PartitionListTest, description) {
    testing::internal::CaptureStdout();
    PartitionList::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PartitionListTest, partition_1) {
    vector<int> expected{1, 2, 2, 4, 3, 5};
    vector<int> headValues{1, 4, 3, 2, 5, 2};
    auto x = 3;
    auto head = PartitionList::deserializeList(headValues);
    auto values = PartitionList::partition(head, x);
    auto result = PartitionList::serializeList(values);
    EXPECT_EQ(expected, result);
    PartitionList::deleteList(&head);
    PartitionList::deleteList(&values);
}

TEST(PartitionListTest, partition_2) {
    vector<int> expected{1, 2};
    vector<int> headValues{2, 1};
    auto x = 2;
    auto head = PartitionList::deserializeList(headValues);
    auto values = PartitionList::partition(head, x);
    auto result = PartitionList::serializeList(values);
    EXPECT_EQ(expected, result);
    PartitionList::deleteList(&head);
    PartitionList::deleteList(&values);
}

TEST(PartitionListTest, partition_3) {
    vector<int> expected{1, 0, 2, 2, 4, 3, 5};
    vector<int> headValues{1, 4, 3, 0, 2, 5, 2};
    auto x = 3;
    auto head = PartitionList::deserializeList(headValues);
    auto values = PartitionList::partition(head, x);
    auto result = PartitionList::serializeList(values);
    EXPECT_EQ(expected, result);
    PartitionList::deleteList(&head);
    PartitionList::deleteList(&values);
}

TEST(PartitionListTest, partition_4) {
    vector<int> expected{1, 1};
    vector<int> headValues{1, 1};
    auto x = 2;
    auto head = PartitionList::deserializeList(headValues);
    auto values = PartitionList::partition(head, x);
    auto result = PartitionList::serializeList(values);
    EXPECT_EQ(expected, result);
    PartitionList::deleteList(&head);
    PartitionList::deleteList(&values);
}

TEST(PartitionListTest, partition_5) {
    vector<int> expected{1, 2, 3};
    vector<int> headValues{1, 2, 3};
    auto x = 3;
    auto head = PartitionList::deserializeList(headValues);
    auto values = PartitionList::partition(head, x);
    auto result = PartitionList::serializeList(values);
    EXPECT_EQ(expected, result);
    PartitionList::deleteList(&head);
    PartitionList::deleteList(&values);
}

TEST(PartitionListTest, partition_fail_1) {
    // n ≤ 200
    auto size = 200 + 1;
    vector<int> values(size);
    EXPECT_EXIT(PartitionList::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(PartitionListTest, partition_fail_2) {
    // -100 ≤ Node.val
    auto size = -100 - 1;
    vector<int> values{size};
    EXPECT_EXIT(PartitionList::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(PartitionListTest, partition_fail_3) {
    // Node.val ≤ 100
    auto size = 100 + 1;
    vector<int> values{size};
    EXPECT_EXIT(PartitionList::deserializeList(values), ::testing::ExitedWithCode(3), "");
}

TEST(PartitionListTest, partition_fail_4) {
    // -200 ≤ x
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = PartitionList::deserializeList(headValues);
    auto x = -200 - 1;
    EXPECT_EXIT(PartitionList::partition(head, x), ::testing::ExitedWithCode(3), "");
    PartitionList::deleteList(&head);
}

TEST(PartitionListTest, partition_fail_5) {
    // x ≤ 200
    vector<int> headValues{1, 2, 3, 4, 5};
    auto head = PartitionList::deserializeList(headValues);
    auto x = 200 + 1;
    EXPECT_EXIT(PartitionList::partition(head, x), ::testing::ExitedWithCode(3), "");
    PartitionList::deleteList(&head);
}

#endif