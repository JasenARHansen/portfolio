#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_DYNAMIC_ARRAY_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_DYNAMIC_ARRAY_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/arrays/DynamicArray.cpp"  // NOLINT : Ignore .cpp import

TEST(DynamicArrayTest, description) {
    testing::internal::CaptureStdout();
    DynamicArray::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(DynamicArrayTest, dynamicArray_1) {
    vector<int> expected{7, 3};
    int n = 2;
    vector<vector<int>> queries{{1, 0, 5},
                                {1, 1, 7},
                                {1, 0, 3},
                                {2, 1, 0},
                                {2, 1, 1}};
    auto result = DynamicArray::dynamicArray(n, queries);
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop