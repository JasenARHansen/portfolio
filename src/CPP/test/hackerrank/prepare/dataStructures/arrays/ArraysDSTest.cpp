#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_ARRAYS_DS_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_ARRAYS_DS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/arrays/ArraysDS.cpp"  // NOLINT : Ignore .cpp import

TEST(ArraysDSTest, description) {
    testing::internal::CaptureStdout();
    ArraysDS::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ArraysDSTest, reverseArray_1) {
    vector<int> expected{3, 2, 1};
    vector<int> a{1, 2, 3};
    auto result = ArraysDS::reverseArray(a);
    EXPECT_EQ(expected, result);
}

TEST(ArraysDSTest, reverseArray_2) {
    vector<int> expected{2, 3, 4, 1};
    vector<int> a{1, 4, 3, 2};
    auto result = ArraysDS::reverseArray(a);
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop