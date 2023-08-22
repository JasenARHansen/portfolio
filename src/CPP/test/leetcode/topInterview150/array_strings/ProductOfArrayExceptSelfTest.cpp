#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_PRODUCT_OF_ARRAY_EXCEPT_SELF_TEST
#define LEETCODE_TOP_INTERVIEW_150_PRODUCT_OF_ARRAY_EXCEPT_SELF_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/ProductOfArrayExceptSelf.cpp"

TEST(ProductOfArrayExceptSelfTest, description) {
    testing::internal::CaptureStdout();
    ProductOfArrayExceptSelf::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ProductOfArrayExceptSelfTest, productExceptSelf_1) {
    vector<int> expected{24, 12, 8, 6};
    vector<int> nums{1, 2, 3, 4};
    vector<int> result = ProductOfArrayExceptSelf::productExceptSelf(nums);
    for (int i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], result[i]);
    }
}

TEST(ProductOfArrayExceptSelfTest, productExceptSelf_2) {
    vector<int> expected{0, 0, 9, 0, 0};
    vector<int> nums{-1, 1, 0, -3, 3};
    vector<int> result = ProductOfArrayExceptSelf::productExceptSelf(nums);
    for (int i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], result[i]);
    }
}

TEST(ProductOfArrayExceptSelfTest, productExceptSelf_fail_1) {
    // 2 <= nums.length
    int size = 2 - 1;
    vector<int> nums(size);
    EXPECT_EXIT(ProductOfArrayExceptSelf::productExceptSelf(nums), ::testing::ExitedWithCode(3), "");
}

TEST(ProductOfArrayExceptSelfTest, productExceptSelf_fail_2) {
    // nums.length <= 10^5
    int size = pow(10, 5) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(ProductOfArrayExceptSelf::productExceptSelf(nums), ::testing::ExitedWithCode(3), "");
}

TEST(ProductOfArrayExceptSelfTest, productExceptSelf_fail_3) {
    // -30 <= nums[i]
    int value = -30 - 1;
    vector<int> nums{1, value, 1};
    EXPECT_EXIT(ProductOfArrayExceptSelf::productExceptSelf(nums), ::testing::ExitedWithCode(3), "");
}

TEST(ProductOfArrayExceptSelfTest, productExceptSelf_fail_4) {
    // nums[i] <= 30
    int value = 30 + 1;
    vector<int> nums{1, value, 1};
    EXPECT_EXIT(ProductOfArrayExceptSelf::productExceptSelf(nums), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop