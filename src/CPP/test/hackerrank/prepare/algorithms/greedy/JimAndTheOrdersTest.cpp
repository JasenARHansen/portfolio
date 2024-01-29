#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef HACKERRANK_PREPARE_ALGORITHMS_GREEDY_JIM_ORDERS_TEST
#define HACKERRANK_PREPARE_ALGORITHMS_GREEDY_JIM_ORDERS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/algorithms/greedy/JimAndTheOrders.cpp"  // NOLINT : Ignore .cpp import

TEST(JimAndTheOrdersTest, description) {
    testing::internal::CaptureStdout();
    JimAndTheOrders::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(JimAndTheOrdersTest, jimOrders_1) {
    vector<int> expected{4, 5, 3, 1, 2};
    vector<vector<int>> order{{8, 3},
                              {5, 6},
                              {6, 2},
                              {2, 3},
                              {4, 3}};
    auto result = JimAndTheOrders::jimOrders(order);
    EXPECT_EQ(expected, result);
}

TEST(JimAndTheOrdersTest, jimOrders_2) {
    vector<int> expected{1, 2, 3};
    vector<vector<int>> order{{1, 3},
                              {2, 3},
                              {3, 3}};
    auto result = JimAndTheOrders::jimOrders(order);
    EXPECT_EQ(expected, result);
}

TEST(JimAndTheOrdersTest, jimOrders_3) {
    vector<int> expected{4, 2, 5, 1, 3};
    vector<vector<int>> order{{8, 1},
                              {4, 2},
                              {5, 6},
                              {3, 1},
                              {4, 3}};
    auto result = JimAndTheOrders::jimOrders(order);
    EXPECT_EQ(expected, result);
}

TEST(JimAndTheOrdersTest, jimOrders_4) {
    vector<int> expected{1, 2, 3, 4, 5};
    vector<vector<int>> order{{8, 1},
                              {7, 2},
                              {6, 3},
                              {5, 4},
                              {4, 5}};
    auto result = JimAndTheOrders::jimOrders(order);
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop