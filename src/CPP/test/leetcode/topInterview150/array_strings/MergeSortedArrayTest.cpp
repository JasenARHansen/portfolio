#ifndef LEETCODE_TOP_INTERVIEW_150_MERGE_SORTED_ARRAY_TEST
#define LEETCODE_TOP_INTERVIEW_150_MERGE_SORTED_ARRAY_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/MergeSortedArray.cpp"  // NOLINT : Ignore .cpp import

TEST(MergeSortedArrayTest, description) {
    testing::internal::CaptureStdout();
    MergeSortedArray::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MergeSortedArrayTest, merge_1) {
    vector<int> expected{1, 2, 2, 3, 5, 6};
    vector<int> nums1{1, 2, 3, 0, 0, 0};
    auto m = 3;
    vector<int> nums2{2, 5, 6};
    auto n = 3;
    MergeSortedArray::merge(nums1, m, nums2, n);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums1[i]);
    }
}

TEST(MergeSortedArrayTest, merge2_) {
    vector<int> expected{1};
    vector<int> nums1{1};
    auto m = 1;
    vector<int> nums2{};
    auto n = 0;
    MergeSortedArray::merge(nums1, m, nums2, n);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums1[i]);
    }
}

TEST(MergeSortedArrayTest, merge_3) {
    vector<int> expected{1};
    vector<int> nums1{0};
    auto m = 0;
    vector<int> nums2{1};
    auto n = 1;
    MergeSortedArray::merge(nums1, m, nums2, n);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums1[i]);
    }
}

TEST(MergeSortedArrayTest, merge_fail_1) {
    // nums1.length == m + n
    vector<int> nums1{1, 2, 3, 0, 0, 0, 0};
    auto m = 3;
    vector<int> nums2{2, 5, 6};
    auto n = 3;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_2) {
    // nums2.length == n
    vector<int> expected{1, 2, 3, 0, 0, 0};
    vector<int> nums1{1, 2, 3, 0, 0, 0};
    auto m = 3;
    vector<int> nums2{2, 5, 6};
    auto n = nums2.size() - 1;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_3) {
    // TEST(MergeSortedArrayTest, merge_fail_4) {
    auto m = 0;
    auto n = 0;
    vector<int> nums1(m + n);
    vector<int> nums2(n);
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_4) {
    // n ≤ 200
    auto m = 3;
    auto n = 201;
    vector<int> nums1(m + n);
    vector<int> nums2(n);
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_5) {
    // 1 ≤ m + n
    auto m = 0;
    auto n = 0;
    vector<int> nums1(m + n);
    vector<int> nums2(n);
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_6) {
    // m + n ≤ 200
    auto m = 100;
    auto n = 101;
    vector<int> nums1(m + n);
    vector<int> nums2(n);
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_7) {
    // -10^9 ≤ nums1[i]
    auto value = (int) -pow(10, 9) - 1;
    vector<int> nums1{value, 2, 3, 0, 0, 0};
    auto m = 3;
    vector<int> nums2{2, 5, 6};
    auto n = 3;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_8) {
    // -10^9 ≤ nums2[i]
    vector<int> nums1{1, 2, 3, 0, 0, 0};
    auto m = 3;
    auto value = (int) -pow(10, 9) - 1;
    vector<int> nums2{value, 5, 6};
    auto n = 3;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_9) {
    // nums1[i] ≤ 10^9
    auto value = (int) pow(10, 9) + 1;
    vector<int> nums1{1, 2, value, 0, 0, 0};
    auto m = 3;
    vector<int> nums2{2, 5, 6};
    auto n = 3;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

TEST(MergeSortedArrayTest, merge_fail_10) {
    // nums2[j] ≤ 10^9
    vector<int> nums1{1, 2, 3, 0, 0, 0};
    auto m = 3;
    auto value = (int) pow(10, 9) + 1;
    vector<int> nums2{2, 5, value};
    auto n = 3;
    EXPECT_EXIT(MergeSortedArray::merge(nums1, m, nums2, n), ::testing::ExitedWithCode(3), "");
}

#endif