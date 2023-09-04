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
    auto expected = true;
    vector<string> values{"1", "2", "3"};
    auto p = SameTree::deserialize(values);
    auto q = SameTree::deserialize(values);
    auto result = SameTree::isSameTree(p, q);
    EXPECT_EQ(expected, result);
    SameTree::deleteTree(&p);
    SameTree::deleteTree(&q);
}

TEST(SameTreeTest, isSameTree_2) {
    auto expected = false;
    vector<string> valuesP{"1", "2"};
    auto p = SameTree::deserialize(valuesP);
    vector<string> valuesQ{"1", "null", "2"};
    auto q = SameTree::deserialize(valuesQ);
    auto result = SameTree::isSameTree(p, q);
    EXPECT_EQ(expected, result);
    SameTree::deleteTree(&p);
    SameTree::deleteTree(&q);
}

TEST(SameTreeTest, isSameTree_3) {
    auto expected = false;
    vector<string> valuesP{"1", "2", "1"};
    auto p = SameTree::deserialize(valuesP);
    vector<string> valuesQ{"1", "1", "2"};
    auto q = SameTree::deserialize(valuesQ);
    auto result = SameTree::isSameTree(p, q);
    EXPECT_EQ(expected, result);
    SameTree::deleteTree(&p);
    SameTree::deleteTree(&q);
}

TEST(SameTreeTest, isSameTree_4) {
    auto expected = false;
    vector<string> valuesP{};
    auto p = SameTree::deserialize(valuesP);
    vector<string> valuesQ{"1"};
    auto q = SameTree::deserialize(valuesQ);
    auto result = SameTree::isSameTree(p, q);
    EXPECT_EQ(expected, result);
    SameTree::deleteTree(&p);
    SameTree::deleteTree(&q);
}

#endif