#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_INSERT_SPECIFIC_POSITION_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_INSERT_SPECIFIC_POSITION_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/InsertSpecificPosition.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_InsertSpecificPositionTest, description) {
    testing::internal::CaptureStdout();
    InsertSpecificPosition::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_InsertSpecificPositionTest, insertNodeAtPosition_1) {
    vector<int> expected{1, 2, 4, 3};
    vector<int> source{1, 2, 3};
    auto list = InsertSpecificPosition::createList(source);
    auto data = 4;
    auto position = 2;
    auto updatedList = InsertSpecificPosition::insertNodeAtPosition(list, data, position);
    auto result = InsertSpecificPosition::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertSpecificPosition::deleteList(&list);
}

TEST(HackerRank_InsertSpecificPositionTest, insertNodeAtPosition_2) {
    vector<int> expected{1};
    vector<int> source{};
    auto list = InsertSpecificPosition::createList(source);
    auto data = 1;
    auto position = 0;
    auto updatedList = InsertSpecificPosition::insertNodeAtPosition(list, data, position);
    auto result = InsertSpecificPosition::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertSpecificPosition::deleteList(&list);
}

TEST(HackerRank_InsertSpecificPositionTest, insertNodeAtPosition_3) {
    vector<int> expected{1, 2, 3, 4};
    vector<int> source{1, 2, 3};
    auto list = InsertSpecificPosition::createList(source);
    auto data = 4;
    auto position = 3;
    auto updatedList = InsertSpecificPosition::insertNodeAtPosition(list, data, position);
    auto result = InsertSpecificPosition::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertSpecificPosition::deleteList(&list);
}

TEST(HackerRank_InsertSpecificPositionTest, insertNodeAtPosition_4) {
    vector<int> expected{16, 13, 1, 7};
    vector<int> source{16, 13, 7};
    auto list = InsertSpecificPosition::createList(source);
    auto data = 1;
    auto position = 2;
    auto updatedList = InsertSpecificPosition::insertNodeAtPosition(list, data, position);
    auto result = InsertSpecificPosition::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertSpecificPosition::deleteList(&list);
}

#endif