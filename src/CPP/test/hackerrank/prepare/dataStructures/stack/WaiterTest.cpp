#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_WAITER_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STACKS_WAITER_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/stack/Waiter.cpp"  // NOLINT : Ignore .cpp import

TEST(WaiterTest, description) {
    testing::internal::CaptureStdout();
    Waiter::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(WaiterTest, waiter_1) {
    vector<int> expected{2, 4, 6, 3, 5, 7};
    vector<int> number{2, 3, 4, 5, 6, 7};
    int q = 3;
    auto result = Waiter::waiter(number, q);
    EXPECT_EQ(expected, result);
}

TEST(WaiterTest, waiter_2) {
    vector<int> expected{4, 6, 3, 7, 5};
    vector<int> number{3, 4, 7, 6, 5};
    int q = 1;
    auto result = Waiter::waiter(number, q);
    EXPECT_EQ(expected, result);
}

TEST(WaiterTest, waiter_3) {
    vector<int> expected{4, 4, 9, 3, 3};
    vector<int> number{3, 3, 4, 4, 9};
    int q = 2;
    auto result = Waiter::waiter(number, q);
    EXPECT_EQ(expected, result);
}

#endif