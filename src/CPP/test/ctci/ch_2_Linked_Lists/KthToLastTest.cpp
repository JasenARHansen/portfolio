#ifndef CTCI_CH_2_LINKED_LISTS_KTH_TO_LAST_TEST
#define CTCI_CH_2_LINKED_LISTS_KTH_TO_LAST_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_2_Linked_Lists/KthToLast.h"

using namespace ctci;
TEST(CtCI_KthToLastTest, description) {
    testing::internal::CaptureStdout();
    KthToLast::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_KthToLastTest, kthToLast_1) {
    auto expected = 3;
    std::vector<int> data{1, 2, 3, 4, 5, 6};
    auto k = 3;
    auto list = KthToLast::generateList(data);
    auto result = KthToLast::kthToLast(list, k);
    EXPECT_EQ(expected, result);
    KthToLast::deleteList(&list);
}

TEST(CtCI_KthToLastTest, kthToLastBrute_1) {
    auto expected = 3;
    std::vector<int> data{1, 2, 3, 4, 5, 6};
    auto k = 3;
    auto list = KthToLast::generateList(data);
    auto result = KthToLast::kthToLastRecursive(list, k);
    EXPECT_EQ(expected, result);
    KthToLast::deleteList(&list);
}

#endif