#ifndef INTERVIEW_META_PREPARATION_QUEUE_REMOVALS_TEST
#define INTERVIEW_META_PREPARATION_QUEUE_REMOVALS_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/queues/QueueRemovals.cpp"  // NOLINT : Ignore .cpp import

TEST(QueueRemovalsTest, description) {
    testing::internal::CaptureStdout();
    QueueRemovals::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(QueueRemovalsTest, findPositions_1) {
    vector<int> expected{5, 6, 4, 1, 2};
    vector<int> arr{1, 2, 2, 3, 4, 5};
    auto x = 5;
    auto result = QueueRemovals::findPositions(arr, x);
    EXPECT_EQ(expected, result);
}

#endif