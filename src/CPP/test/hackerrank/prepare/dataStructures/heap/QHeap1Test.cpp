#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_HEAP_Q_HEAP_1_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_HEAP_Q_HEAP_1_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/heap/QHeap1.cpp"  // NOLINT : Ignore .cpp import

TEST(QHeap1Test, description) {
    testing::internal::CaptureStdout();
    QHeap1::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(QHeap1Test, processQueries_1) {
    vector<int> expected{4, 9};
    vector<string> operations{"1 4", "1 9", "3", "2 4", "3"};
    auto result = QHeap1::processQueries(operations);
    EXPECT_EQ(expected, result);
}


#endif