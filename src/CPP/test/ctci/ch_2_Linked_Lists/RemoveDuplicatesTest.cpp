#ifndef CTCI_CH_2_LINKED_LISTS_REMOVE_DUPLICATES_TEST
#define CTCI_CH_2_LINKED_LISTS_REMOVE_DUPLICATES_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_2_Linked_Lists/RemoveDuplicates.h"

TEST(RemoveDuplicatesTest, description) {
    testing::internal::CaptureStdout();
    RemoveDuplicates::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RemoveDuplicatesTest, removeDuplicates_1) {
    vector<int> expected{1, 2, 3, 4, 5};
    vector<int> data{1, 2, 3, 3, 4, 1, 5, 1};
    auto list = RemoveDuplicates::generateList(data);
    RemoveDuplicates::removeDuplicates(list);
    auto result = RemoveDuplicates::getList(list);
    EXPECT_EQ(expected, result);
    RemoveDuplicates::deleteList(&list);
}

TEST(RemoveDuplicatesTest, removeDuplicatesBrute_1) {
    vector<int> expected{1, 2, 3, 4, 5};
    vector<int> data{1, 2, 3, 3, 4, 1, 5, 1};
    auto list = RemoveDuplicates::generateList(data);
    RemoveDuplicates::removeDuplicatesBrute(list);
    auto result = RemoveDuplicates::getList(list);
    EXPECT_EQ(expected, result);
    RemoveDuplicates::deleteList(&list);
}

#endif