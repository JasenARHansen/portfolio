#ifndef LEETCODE_TOP_INTERVIEW_150_SAME_TREE_TEST
#define LEETCODE_TOP_INTERVIEW_150_SAME_TREE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/binary_tree_general/SameTree.cpp"

TEST(SameTreeTest, description) {
    testing::internal::CaptureStdout();
    SameTree::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SameTreeTest, isSameTree_1) {
    bool expected = true;
    vector<string> values{"1", "2", "3", "null", "null", "null", "null"};
    auto *p = SameTree::generateTree(values);
    auto *q = SameTree::generateTree(values);
    bool result = SameTree::isSameTree(p, q);
    EXPECT_EQ(expected, result);
    SameTree::deleteTree(&p);
    SameTree::deleteTree(&q);
}

TEST(SameTreeTest, isSameTree_2) {
    bool expected = false;
    vector<string> valuesP{"1", "2", "null", "null", "null"};
    auto *p = SameTree::generateTree(valuesP);
    vector<string> valuesQ{"1", "null", "2", "null", "null"};
    auto *q = SameTree::generateTree(valuesQ);
    bool result = SameTree::isSameTree(p, q);
    EXPECT_EQ(expected, result);
    SameTree::deleteTree(&p);
    SameTree::deleteTree(&q);
}

TEST(SameTreeTest, isSameTree_3) {
    bool expected = false;
    vector<string> valuesP{"1", "2", "1", "null", "null", "null", "null"};
    auto *p = SameTree::generateTree(valuesP);
    vector<string> valuesQ{"1", "1", "2", "null", "null", "null", "null"};
    auto *q = SameTree::generateTree(valuesQ);
    bool result = SameTree::isSameTree(p, q);
    EXPECT_EQ(expected, result);
    SameTree::deleteTree(&p);
    SameTree::deleteTree(&q);
}

TEST(SameTreeTest, isSameTree_4) {
    bool expected = false;
    vector<string> valuesP{};
    auto *p = SameTree::generateTree(valuesP);
    vector<string> valuesQ{"1"};
    auto *q = SameTree::generateTree(valuesQ);
    bool result = SameTree::isSameTree(p, q);
    EXPECT_EQ(expected, result);
    SameTree::deleteTree(&p);
    SameTree::deleteTree(&q);
}


#endif