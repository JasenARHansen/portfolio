#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_QUEUE_DOWN_TO_ZERO_II_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_QUEUE_DOWN_TO_ZERO_II_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/queue/DownToZeroII.cpp"  // NOLINT : Ignore .cpp import

TEST(HackerRank_DownToZeroIITest, description) {
    testing::internal::CaptureStdout();
    DownToZeroII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(HackerRank_DownToZeroIITest, downToZeroDynamic_1) {
    auto expected = 3;
    auto n = 3;
    auto result = DownToZeroII::downToZeroDynamic(n);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_DownToZeroIITest, downToZeroDynamic_2) {
    auto expected = 3;
    auto n = 4;
    auto result = DownToZeroII::downToZeroDynamic(n);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_DownToZeroIITest, downToZeroDynamic_3) {
    auto expected = 5;
    auto n = 10;
    auto result = DownToZeroII::downToZeroDynamic(n);
    EXPECT_EQ(expected, result);
}

TEST(HackerRank_DownToZeroIITest, downToZeroPreCompute_1) {
    auto expected = 3;
    auto n = 3;
    auto range = DownToZeroII::generateRange(n);
    auto result = DownToZeroII::downToZeroPreCompute(n, range);
    EXPECT_EQ(expected, result);
}

#endif