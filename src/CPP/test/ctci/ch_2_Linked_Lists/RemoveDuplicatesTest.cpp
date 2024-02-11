#ifndef CTCI_CH_2_LINKED_LISTS_REMOVE_DUPLICATES_TEST
#define CTCI_CH_2_LINKED_LISTS_REMOVE_DUPLICATES_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_2_Linked_Lists/RemoveDuplicates.h"

using namespace ctci;
TEST(CtCI_RemoveDuplicatesTest, description) {
    testing::internal::CaptureStdout();
    RemoveDuplicates::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_RemoveDuplicatesTest, removeDuplicates_1) {
    std::vector<int> expected{1, 2, 3, 4, 5};
    std::vector<int> data{1, 2, 3, 3, 4, 1, 5, 1};
    auto list = RemoveDuplicates::generateList(data);
    RemoveDuplicates::removeDuplicates(list);
    auto result = RemoveDuplicates::getList(list);
    EXPECT_EQ(expected, result);
    RemoveDuplicates::deleteList(&list);
}

TEST(CtCI_RemoveDuplicatesTest, removeDuplicatesBrute_1) {
    std::vector<int> expected{1, 2, 3, 4, 5};
    std::vector<int> data{1, 2, 3, 3, 4, 1, 5, 1};
    auto list = RemoveDuplicates::generateList(data);
    RemoveDuplicates::removeDuplicatesBrute(list);
    auto result = RemoveDuplicates::getList(list);
    EXPECT_EQ(expected, result);
    RemoveDuplicates::deleteList(&list);
}

#endif