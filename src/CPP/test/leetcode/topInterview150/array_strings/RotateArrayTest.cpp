#ifndef LEETCODE_TOP_INTERVIEW_150_ROTATE_ARRAY_TEST
#define LEETCODE_TOP_INTERVIEW_150_ROTATE_ARRAY_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/RotateArray.cpp"  // NOLINT : Ignore .cpp import

TEST(RotateArrayTest, description) {
    testing::internal::CaptureStdout();
    RotateArray::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RotateArrayTest, rotate_1) {
    vector<int> expected{5, 6, 7, 1, 2, 3, 4};
    vector<int> nums{1, 2, 3, 4, 5, 6, 7};
    auto k = 3;
    RotateArray::rotate(nums, k);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RotateArrayTest, rotate_2) {
    vector<int> expected{3, 99, -1, -100};
    vector<int> nums{-1, -100, 3, 99};
    auto k = 2;
    RotateArray::rotate(nums, k);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RotateArrayTest, rotate_fail_1) {
    // 1 ≤ nums.length
    auto size = 0;
    vector<int> nums(size);
    auto val = 5;
    EXPECT_EXIT(RotateArray::rotate(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RotateArrayTest, rotate_fail_2) {
    // nums.length ≤ 10^5
    auto size = (int) pow(10, 5) + 1;
    vector<int> nums(size);
    auto val = 5;
    EXPECT_EXIT(RotateArray::rotate(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RotateArrayTest, rotate_fail_3) {
    // 0 ≤ k
    vector<int> nums{1, 2, 3, 4, 5, 6, 7};
    auto val = -1;
    EXPECT_EXIT(RotateArray::rotate(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RotateArrayTest, rotate_fail_4) {
    // k ≤ 10^5
    vector<int> nums{1, 2, 3, 4, 5, 6, 7};
    auto val = (int) pow(10, 5) + 1;
    EXPECT_EXIT(RotateArray::rotate(nums, val), ::testing::ExitedWithCode(3), "");
}

#endif