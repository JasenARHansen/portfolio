#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_ROTATE_ARRAY_TEST
#define LEETCODE_TOP_INTERVIEW_150_ROTATE_ARRAY_TEST

#include "gtest/gtest.h"
#include "../../../code/leetcode/topInterview150/RotateArray.cpp"

TEST(RotateArrayTest, description) {
    testing::internal::CaptureStdout();
    RotateArray::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RotateArrayTest, rotate_1) {
    vector<int> expected{5, 6, 7, 1, 2, 3, 4};
    vector<int> nums{1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    RotateArray::rotate(nums, k);
    for (int i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RotateArrayTest, rotate_2) {
    vector<int> expected{3, 99, -1, -100};
    vector<int> nums{-1, -100, 3, 99};
    int k = 2;
    RotateArray::rotate(nums, k);
    for (int i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RotateArrayTest, rotate_fail_1) {
    // 1 <= nums.length
    int size = 0;
    vector<int> nums(size);
    int val = 5;
    EXPECT_EXIT(RotateArray::rotate(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RotateArrayTest, rotate_fail_2) {
    // nums.length <= 10^5
    int size = pow(10, 5) + 1;
    vector<int> nums(size);
    int val = 5;
    EXPECT_EXIT(RotateArray::rotate(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RotateArrayTest, rotate_fail_3) {
    // 0 <= k
    vector<int> nums{1, 2, 3, 4, 5, 6, 7};
    int val = -1;
    EXPECT_EXIT(RotateArray::rotate(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RotateArrayTest, rotate_fail_4) {
    // k <= 10^5
    vector<int> nums{1, 2, 3, 4, 5, 6, 7};
    int val = pow(10, 5) + 1;
    EXPECT_EXIT(RotateArray::rotate(nums, val), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop