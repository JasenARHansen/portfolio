#ifndef CTCI_CH_2_LINKED_LISTS_SUM_LISTS_TEST
#define CTCI_CH_2_LINKED_LISTS_SUM_LISTS_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_2_Linked_Lists/SumLists.h"

using namespace ctci;
TEST(CtCI_SumListsTest, description) {
    testing::internal::CaptureStdout();
    SumLists::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_SumListsTest, sumReverseOrder_1) {
    std::vector<int> expected{2, 1, 9};
    std::vector<int> addend1Data{7, 1, 6};
    std::vector<int> addend2Data{5, 9, 2};
    auto addend1 = SumLists::generateList(addend1Data);
    auto addend2 = SumLists::generateList(addend2Data);
    auto data = SumLists::sumReverseOrder(addend1, addend2);
    auto result = SumLists::getList(data);
    EXPECT_EQ(expected, result);
    SumLists::deleteList(&addend1);
    SumLists::deleteList(&addend2);
    SumLists::deleteList(&data);
}

TEST(CtCI_SumListsTest, sumReverseOrder_2) {
    std::vector<int> expected{0, 1, 0, 1};
    std::vector<int> addend1Data{1, 1, 9};
    std::vector<int> addend2Data{9, 9};
    auto addend1 = SumLists::generateList(addend1Data);
    auto addend2 = SumLists::generateList(addend2Data);
    auto data = SumLists::sumReverseOrder(addend1, addend2);
    auto result = SumLists::getList(data);
    EXPECT_EQ(expected, result);
    SumLists::deleteList(&addend1);
    SumLists::deleteList(&addend2);
    SumLists::deleteList(&data);
}

TEST(CtCI_SumListsTest, sumRForwardOrder_1) {
    std::vector<int> expected{9, 1, 2};
    std::vector<int> addend1Data{6, 1, 7};
    std::vector<int> addend2Data{2, 9, 5};
    auto addend1 = SumLists::generateList(addend1Data);
    auto addend2 = SumLists::generateList(addend2Data);
    auto data = SumLists::sumRForwardOrder(addend1, addend2);
    auto result = SumLists::getList(data);
    EXPECT_EQ(expected, result);
    SumLists::deleteList(&addend1);
    SumLists::deleteList(&addend2);
    SumLists::deleteList(&data);
}

TEST(CtCI_SumListsTest, sumRForwardOrder_2) {
    std::vector<int> expected{1, 0, 1, 0};
    std::vector<int> addend1Data{9, 1, 1};
    std::vector<int> addend2Data{9, 9};
    auto addend1 = SumLists::generateList(addend1Data);
    auto addend2 = SumLists::generateList(addend2Data);
    auto data = SumLists::sumRForwardOrder(addend1, addend2);
    auto result = SumLists::getList(data);
    EXPECT_EQ(expected, result);
    SumLists::deleteList(&addend1);
    SumLists::deleteList(&addend2);
    SumLists::deleteList(&data);
}

#endif