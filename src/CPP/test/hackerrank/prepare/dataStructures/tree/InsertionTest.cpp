#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_INSERTION_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_TREE_INSERTION_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/tree/Insertion.cpp"  // NOLINT : Ignore .cpp import

TEST(InsertionTest, description) {
    testing::internal::CaptureStdout();
    Insertion::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(InsertionTest, insert_1) {
    vector<string> expected{"4", "2", "7", "1", "3", "6"};
    vector<string> values{"4", "2", "7", "1", "3"};
    auto root = Insertion::deserializeTree(values);
    auto data = 6;
    Insertion::insert(root, data);
    auto result = Insertion::serializeTree(root);
    EXPECT_EQ(expected, result);
    Insertion::deleteTree(&root);
}

#endif