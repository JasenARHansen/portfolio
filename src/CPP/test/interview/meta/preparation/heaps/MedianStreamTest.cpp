#ifndef INTERVIEW_META_PREPARATION_MEDIAN_STREAM_TEST
#define INTERVIEW_META_PREPARATION_MEDIAN_STREAM_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/heaps/MedianStream.cpp"

TEST(MedianStreamTest, description) {
    testing::internal::CaptureStdout();
    MedianStream::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MedianStreamTest, findMedian_1) {
    vector<int> expected{5, 10, 5, 4};
    vector<int> arr{5, 15, 1, 3};
    auto result = MedianStream::findMedian(arr);
    EXPECT_EQ(expected, result);
}

TEST(MedianStreamTest, findMedian_2) {
    vector<int> expected{1, 1};
    vector<int> arr{1, 2};
    auto result = MedianStream::findMedian(arr);
    EXPECT_EQ(expected, result);
}

TEST(MedianStreamTest, findMinProduct_fail_1) {
    // 1 ≤ arr.length
    int size = 1 - 1;
    vector<int> arr(size);
    EXPECT_EXIT(MedianStream::findMedian(arr), ::testing::ExitedWithCode(3), "");
}

TEST(MedianStreamTest, findMinProduct_fail_2) {
    // arr.length ≤ arr.length
    int size = (int) pow(10, 6) + 1;
    vector<int> arr(size);
    EXPECT_EXIT(MedianStream::findMedian(arr), ::testing::ExitedWithCode(3), "");
}

TEST(MedianStreamTest, findMinProduct_fail_3) {
    // 1 ≤ arr[i]
    int size = 1 - 1;
    vector<int> arr{size};
    EXPECT_EXIT(MedianStream::findMedian(arr), ::testing::ExitedWithCode(3), "");
}

TEST(MedianStreamTest, findMinProduct_fail_4) {
    // arr[i] ≤ 1,000,000
    int size = (int) pow(10, 6) + 1;
    vector<int> arr{size};
    EXPECT_EXIT(MedianStream::findMedian(arr), ::testing::ExitedWithCode(3), "");
}

#endif