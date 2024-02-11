#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_INSERT_AT_HEAD_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_INSERT_AT_HEAD_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/InsertAtHead.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_InsertAtHeadTest, description) {
    testing::internal::CaptureStdout();
    InsertAtHead::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_InsertAtHeadTest, insertNodeAtHead_1) {
    vector<int> expected{383};
    vector<int> source{};
    auto list = InsertAtHead::createList(source);
    auto data = 383;
    auto updatedList = InsertAtHead::insertNodeAtHead(list, data);
    auto result = InsertAtHead::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtHead::deleteList(&updatedList);
}

TEST(HackerRank_InsertAtHeadTest, insertNodeAtHead_2) {
    vector<int> expected{484, 383};
    vector<int> source{383};
    auto list = InsertAtHead::createList(source);
    auto data = 484;
    auto updatedList = InsertAtHead::insertNodeAtHead(list, data);
    auto result = InsertAtHead::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtHead::deleteList(&updatedList);
}

TEST(HackerRank_InsertAtHeadTest, insertNodeAtHead_3) {
    vector<int> expected{392, 484, 383};
    vector<int> source{484, 383};
    auto list = InsertAtHead::createList(source);
    auto data = 392;
    auto updatedList = InsertAtHead::insertNodeAtHead(list, data);
    auto result = InsertAtHead::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtHead::deleteList(&updatedList);
}

TEST(HackerRank_InsertAtHeadTest, insertNodeAtHead_4) {
    vector<int> expected{975, 392, 484, 383};
    vector<int> source{392, 484, 383};
    auto list = InsertAtHead::createList(source);
    auto data = 975;
    auto updatedList = InsertAtHead::insertNodeAtHead(list, data);
    auto result = InsertAtHead::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtHead::deleteList(&updatedList);
}

TEST(HackerRank_InsertAtHeadTest, insertNodeAtHead_5) {
    vector<int> expected{321, 975, 392, 484, 383};
    vector<int> source{975, 392, 484, 383};
    auto list = InsertAtHead::createList(source);
    auto data = 321;
    auto updatedList = InsertAtHead::insertNodeAtHead(list, data);
    auto result = InsertAtHead::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtHead::deleteList(&updatedList);
}

TEST(HackerRank_InsertAtHeadTest, insertNodeAtHead_6) {
    vector<int> expected{236};
    vector<int> source{};
    auto list = InsertAtHead::createList(source);
    auto data = 236;
    auto updatedList = InsertAtHead::insertNodeAtHead(list, data);
    auto result = InsertAtHead::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtHead::deleteList(&updatedList);
}

#endif