#ifndef CTCI_CH_2_LINKED_LISTS_SUM_LISTS_TEST
#define CTCI_CH_2_LINKED_LISTS_SUM_LISTS_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_2_Linked_Lists/SumLists.h"

TEST(SumListsTest, description) {
    testing::internal::CaptureStdout();
    SumLists::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SumListsTest, sumReverseOrder_1) {
    vector<int> expected{2, 1, 9};
    vector<int> addend1Data{7, 1, 6};
    vector<int> addend2Data{5, 9, 2};
    auto addend1 = SumLists::generateList(addend1Data);
    auto addend2 = SumLists::generateList(addend2Data);
    auto data = SumLists::sumReverseOrder(addend1, addend2);
    auto result = SumLists::getList(data);
    EXPECT_EQ(expected, result);
    SumLists::deleteList(&addend1);
    SumLists::deleteList(&addend2);
    SumLists::deleteList(&data);
}

TEST(SumListsTest, sumReverseOrder_2) {
    vector<int> expected{0, 1, 0, 1};
    vector<int> addend1Data{1, 1, 9};
    vector<int> addend2Data{9, 9};
    auto addend1 = SumLists::generateList(addend1Data);
    auto addend2 = SumLists::generateList(addend2Data);
    auto data = SumLists::sumReverseOrder(addend1, addend2);
    auto result = SumLists::getList(data);
    EXPECT_EQ(expected, result);
    SumLists::deleteList(&addend1);
    SumLists::deleteList(&addend2);
    SumLists::deleteList(&data);
}

TEST(SumListsTest, sumRForwardOrder_1) {
    vector<int> expected{9, 1, 2};
    vector<int> addend1Data{6, 1, 7};
    vector<int> addend2Data{2, 9, 5};
    auto addend1 = SumLists::generateList(addend1Data);
    auto addend2 = SumLists::generateList(addend2Data);
    auto data = SumLists::sumRForwardOrder(addend1, addend2);
    auto result = SumLists::getList(data);
    EXPECT_EQ(expected, result);
    SumLists::deleteList(&addend1);
    SumLists::deleteList(&addend2);
    SumLists::deleteList(&data);
}

TEST(SumListsTest, sumRForwardOrder_2) {
    vector<int> expected{1, 0, 1, 0};
    vector<int> addend1Data{9, 1, 1};
    vector<int> addend2Data{9, 9};
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