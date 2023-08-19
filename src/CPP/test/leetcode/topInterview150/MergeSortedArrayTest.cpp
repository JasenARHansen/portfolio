#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_MERGE_SORTED_ARRAY_TEST
#define LEETCODE_TOP_INTERVIEW_150_MERGE_SORTED_ARRAY_TEST

#include "gtest/gtest.h"
#include "../../../code/leetcode/topInterview150/MergeSortedArray.cpp"

TEST(MergeSortedArrayTest, description) {
    testing::internal::CaptureStdout();
    MergeSortedArray::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MergeSortedArrayTest, merge_1) {
    vector<int> expected{1, 2, 2, 3, 5, 6};
    vector<int> nums1{1, 2, 3, 0, 0, 0};
    int m = 3;
    vector<int> nums2{2, 5, 6};
    int n = 3;
    MergeSortedArray::merge(nums1, m, nums2, n);
    for (int i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums1[i]);
    }
}

TEST(MergeSortedArrayTest, merge2_) {
    vector<int> expected{1};
    vector<int> nums1{1};
    int m = 1;
    vector<int> nums2{};
    int n = 0;
    MergeSortedArray::merge(nums1, m, nums2, n);
    for (int i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums1[i]);
    }
}

TEST(MergeSortedArrayTest, merge_3) {
    vector<int> expected{1};
    vector<int> nums1{0};
    int m = 0;
    vector<int> nums2{1};
    int n = 1;
    MergeSortedArray::merge(nums1, m, nums2, n);
    for (int i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums1[i]);
    }
}

TEST(MergeSortedArrayTest, merge_fail_1) {
    // nums1.length == m + n
    vector<int> nums1{1, 2, 3, 0, 0, 0, 0};
    int m = 3;
    vector<int> nums2{2, 5, 6};
    int n = 3;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_2) {
    // nums2.length == n
    vector<int> expected{1, 2, 3, 0, 0, 0};
    vector<int> nums1{1, 2, 3, 0, 0, 0};
    int m = 3;
    vector<int> nums2{2, 5, 6};
    int n = nums2.size() - 1;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_3) {
    // TEST(MergeSortedArrayTest, merge_fail_4) {
    int m = 0;
    int n = 0;
    vector<int> nums1(m + n);
    vector<int> nums2(n);
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_4) {
    // n <= 200
    int m = 3;
    int n = 201;
    vector<int> nums1(m + n);
    vector<int> nums2(n);
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_5) {
    // 1 <= m + n
    int m = 0;
    int n = 0;
    vector<int> nums1(m + n);
    vector<int> nums2(n);
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_6) {
    //  m + n <= 200
    int m = 100;
    int n = 101;
    vector<int> nums1(m + n);
    vector<int> nums2(n);
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_7) {
    // -10^9 <= nums1[i]
    int value = -(pow(10, 9) + 1);
    vector<int> nums1{value, 2, 3, 0, 0, 0};
    int m = 3;
    vector<int> nums2{2, 5, 6};
    int n = 3;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_8) {
    // -10^9 <= nums2[i]
    vector<int> nums1{1, 2, 3, 0, 0, 0};
    int m = 3;
    int value = -(pow(10, 9) + 1);
    vector<int> nums2{value, 5, 6};
    int n = 3;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_9) {
    // nums1[i] <= 10^9
    int value = pow(10, 9) + 1;
    vector<int> nums1{1, 2, value, 0, 0, 0};
    int m = 3;
    vector<int> nums2{2, 5, 6};
    int n = 3;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_10) {
    // nums2[j] <= 10^9
    vector<int> nums1{1, 2, 3, 0, 0, 0};
    int m = 3;
    int value = pow(10, 9) + 1;
    vector<int> nums2{2, 5, value};
    int n = 3;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop