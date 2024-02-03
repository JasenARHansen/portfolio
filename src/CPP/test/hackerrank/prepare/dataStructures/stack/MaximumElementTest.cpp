#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_MAXIMUM_ELEMENT_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_MAXIMUM_ELEMENT_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/stack/MaximumElement.cpp"  // NOLINT : Ignore .cpp import

TEST(MaximumElementTest, description) {
    testing::internal::CaptureStdout();
    MaximumElement::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MaximumElementTest, getMax_1) {
    vector<int> expected{26, 91};
    vector<string> operations{"1 97", "2", "1 20", "2", "1 26", "1 20", "2", "3", "1 91", "3"};
    auto result = MaximumElement::getMax(operations);
    EXPECT_EQ(expected, result);
}

#endif