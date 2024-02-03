#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_EQUAL_STACKS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_EQUAL_STACKS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/stack/EqualStacks.cpp"  // NOLINT : Ignore .cpp import

TEST(EqualStacksTest, description) {
    testing::internal::CaptureStdout();
    EqualStacks::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(EqualStacksTest, equalStacks_1) {
    int expected = 5;
    vector<int> h1{3, 2, 1, 1, 1};
    vector<int> h2{4, 3, 2};
    vector<int> h3{1, 1, 4, 1};
    auto result = EqualStacks::equalStacks(h1, h2, h3);
    EXPECT_EQ(expected, result);
}

#endif