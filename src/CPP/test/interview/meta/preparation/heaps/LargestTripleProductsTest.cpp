#ifndef INTERVIEW_META_PREPARATION_LARGEST_TRIPLE_PRODUCTS_TEST
#define INTERVIEW_META_PREPARATION_LARGEST_TRIPLE_PRODUCTS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/heaps/LargestTripleProducts.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_LargestTripleProductsTest, description) {
    testing::internal::CaptureStdout();
    LargestTripleProducts::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_LargestTripleProductsTest, findMaxProduct_1) {
    vector<int> expected{-1, -1, 6, 24, 60};
    vector<int> arr{1, 2, 3, 4, 5};
    auto result = LargestTripleProducts::findMaxProduct(arr);
    EXPECT_EQ(expected, result);
}

TEST(Interview_LargestTripleProductsTest, findMaxProduct_2) {
    vector<int> expected{-1, -1, 4, 4, 8};
    vector<int> arr{2, 1, 2, 1, 2};
    auto result = LargestTripleProducts::findMaxProduct(arr);
    EXPECT_EQ(expected, result);
}

TEST(Interview_LargestTripleProductsTest, findMinProduct_1) {
    vector<int> expected{-1, -1, 6, 6, 6};
    vector<int> arr{1, 2, 3, 4, 5};
    auto result = LargestTripleProducts::findMinProduct(arr);
    EXPECT_EQ(expected, result);
}

TEST(Interview_LargestTripleProductsTest, findMinProduct_2) {
    vector<int> expected{-1, -1, 4, 2, 2, 1};
    vector<int> arr{2, 1, 2, 1, 2, 1};
    auto result = LargestTripleProducts::findMinProduct(arr);
    EXPECT_EQ(expected, result);
}

#endif