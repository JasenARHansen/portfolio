#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_GET_NODE_VALUE_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_GET_NODE_VALUE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/GetNodeValue.cpp"  // NOLINT : Ignore .cpp import

TEST(GetNodeValueTest, description) {
    testing::internal::CaptureStdout();
    GetNodeValue::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(GetNodeValueTest, getNode_1) {
    auto expected = 2;
    vector<int> source{3, 2, 1, 0};
    auto list = GetNodeValue::createList(source);
    auto positionFromTail = 2;
    auto result = GetNodeValue::getNode(list, positionFromTail);
    EXPECT_EQ(expected, result);
    GetNodeValue::deleteList(&list);
}

TEST(GetNodeValueTest, getNode_2) {
    auto expected = 1;
    vector<int> source{1};
    auto list = GetNodeValue::createList(source);
    auto positionFromTail = 0;
    auto result = GetNodeValue::getNode(list, positionFromTail);
    EXPECT_EQ(expected, result);
    GetNodeValue::deleteList(&list);
}

TEST(GetNodeValueTest, getNode_3) {
    auto expected = 3;
    vector<int> source{3, 2, 1};
    auto list = GetNodeValue::createList(source);
    auto positionFromTail = 2;
    auto result = GetNodeValue::getNode(list, positionFromTail);
    EXPECT_EQ(expected, result);
    GetNodeValue::deleteList(&list);
}

#endif