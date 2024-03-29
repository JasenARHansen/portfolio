#ifndef CTCI_CH_2_LINKED_LISTS_DELETE_MIDDLE_NODE_TEST
#define CTCI_CH_2_LINKED_LISTS_DELETE_MIDDLE_NODE_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_2_Linked_Lists/DeleteMiddleNode.h"

using namespace ctci;
TEST(CtCI_DeleteMiddleNodeTest, description) {
    testing::internal::CaptureStdout();
    DeleteMiddleNode::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_DeleteMiddleNodeTest, deleteMiddleNodeByValue_1) {
    std::vector<int> expected{0, 1, 2, 4, 5, 6};
    std::vector<int> data{0, 1, 2, 3, 4, 5, 6};
    auto value = 3;
    auto list = DeleteMiddleNode::generateList(data);
    DeleteMiddleNode::deleteMiddleNodeByValue(list, value);
    auto result = DeleteMiddleNode::getList(list);
    EXPECT_EQ(expected, result);
    DeleteMiddleNode::deleteList(&list);
}

TEST(CtCI_DeleteMiddleNodeTest, deleteMiddleNodeByIndex_1) {
    std::vector<int> expected{0, 1, 2, 4, 5, 6};
    std::vector<int> data{0, 1, 2, 3, 4, 5, 6};
    auto index = 3;
    auto list = DeleteMiddleNode::generateList(data);
    DeleteMiddleNode::deleteMiddleNodeByIndex(list, index);
    auto result = DeleteMiddleNode::getList(list);
    EXPECT_EQ(expected, result);
    DeleteMiddleNode::deleteList(&list);
}

#endif