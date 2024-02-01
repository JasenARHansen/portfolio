#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_INSERT_AT_TAIL_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_LINKED_LISTS_INSERT_AT_TAIL_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/linked_list/InsertAtTail.cpp"  // NOLINT : Ignore .cpp import

TEST(InsertAtTailTest, description) {
    testing::internal::CaptureStdout();
    InsertAtTail::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(InsertAtTailTest, insertNodeAtTail_1) {
    vector<int> expected{141};
    vector<int> source{};
    auto head = InsertAtTail::createList(source);
    auto data = 141;
    auto updatedList = InsertAtTail::insertNodeAtTail(head, data);
    auto result = InsertAtTail::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtTail::deleteList(&updatedList);
}

TEST(InsertAtTailTest, insertNodeAtTail_2) {
    vector<int> expected{141, 302};
    vector<int> source{141};
    auto head = InsertAtTail::createList(source);
    auto data = 302;
    auto updatedList = InsertAtTail::insertNodeAtTail(head, data);
    auto result = InsertAtTail::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtTail::deleteList(&head);
}

TEST(InsertAtTailTest, insertNodeAtTail_3) {
    vector<int> expected{141, 302, 164};
    vector<int> source{141, 302};
    auto head = InsertAtTail::createList(source);
    auto data = 164;
    auto updatedList = InsertAtTail::insertNodeAtTail(head, data);
    auto result = InsertAtTail::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtTail::deleteList(&head);
}

TEST(InsertAtTailTest, insertNodeAtTail_4) {
    vector<int> expected{141, 302, 164, 530};
    vector<int> source{141, 302, 164};
    auto head = InsertAtTail::createList(source);
    auto data = 530;
    auto updatedList = InsertAtTail::insertNodeAtTail(head, data);
    auto result = InsertAtTail::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtTail::deleteList(&head);
}

TEST(InsertAtTailTest, insertNodeAtTail_5) {
    vector<int> expected{141, 302, 164, 530, 474};
    vector<int> source{141, 302, 164, 530};
    auto head = InsertAtTail::createList(source);
    auto data = 474;
    auto updatedList = InsertAtTail::insertNodeAtTail(head, data);
    auto result = InsertAtTail::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtTail::deleteList(&head);
}

TEST(InsertAtTailTest, insertNodeAtTail_6) {
    vector<int> expected{236};
    vector<int> source{};
    auto head = InsertAtTail::createList(source);
    auto data = 236;
    auto updatedList = InsertAtTail::insertNodeAtTail(head, data);
    auto result = InsertAtTail::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtTail::deleteList(&updatedList);
}

TEST(InsertAtTailTest, insertNodeAtTail_7) {
    vector<int> expected{236, 326};
    vector<int> source{236};
    auto head = InsertAtTail::createList(source);
    auto data = 326;
    auto updatedList = InsertAtTail::insertNodeAtTail(head, data);
    auto result = InsertAtTail::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtTail::deleteList(&head);
}

TEST(InsertAtTailTest, insertNodeAtTail_8) {
    vector<int> expected{236, 326, 937};
    vector<int> source{236, 326};
    auto head = InsertAtTail::createList(source);
    auto data = 937;
    auto updatedList = InsertAtTail::insertNodeAtTail(head, data);
    auto result = InsertAtTail::getlist(updatedList);
    EXPECT_EQ(expected, result);
    InsertAtTail::deleteList(&head);
}

#endif