#ifndef CTCI_CH_2_LINKED_LISTS_PARTITION_TEST
#define CTCI_CH_2_LINKED_LISTS_PARTITION_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_2_Linked_Lists/Partition.h"

TEST(PartitionTest, description) {
    testing::internal::CaptureStdout();
    Partition::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PartitionTest, partition_1) {
    vector<int> expected{3, 2, 1, 5, 8, 5, 10};
    vector<int> data{3, 5, 8, 5, 10, 2, 1};
    auto value = 5;
    auto list = Partition::generateList(data);
    Partition::partition(&list, value);
    auto result = Partition::getList(list);
    EXPECT_EQ(expected, result);
    Partition::deleteList(&list);
}

#endif