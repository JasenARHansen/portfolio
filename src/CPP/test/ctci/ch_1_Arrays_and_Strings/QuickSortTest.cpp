#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_QUICK_SORT_TEST
#define CTCI_CH_1_ARRAYS_AND_STRINGS_QUICK_SORT_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_1_Arrays_and_Strings/QuickSort.h"

using namespace ctci;
TEST(CtCI_QuickSortTest, description) {
    testing::internal::CaptureStdout();
    QuickSort::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_QuickSortTest, QuickSort_1) {
    std::vector<int> expected{1, 2, 3, 4, 5};
    std::vector<int> input = {1, 4, 2, 3, 5};
    auto result = QuickSort::quickSort(input);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_QuickSortTest, quickSortInPlace_1) {
    std::vector<int> expected{1, 2, 3, 4, 5};
    std::vector<int> input = {2, 4, 1, 3, 5};
    QuickSort::quickSortInPlace(input);
    EXPECT_EQ(expected, input);
}

TEST(CtCI_QuickSortTest, quickSortInPlace_2) {
    std::vector<int> expected{1, 2, 3, 4, 5};
    std::vector<int> input = {3, 5, 2, 4, 1};
    QuickSort::quickSortInPlace(input);
    EXPECT_EQ(expected, input);
}

TEST(CtCI_QuickSortTest, quickSortInPlace_3) {
    std::vector<int> expected{1, 2, 3, 4, 5};
    std::vector<int> input = {3, 5, 1, 4, 2};
    QuickSort::quickSortInPlace(input);
    EXPECT_EQ(expected, input);
}

#endif