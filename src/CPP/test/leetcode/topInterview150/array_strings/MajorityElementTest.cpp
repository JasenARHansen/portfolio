#ifndef LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_ARRAY_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_ARRAY_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/MajorityElement.cpp"  // NOLINT : Ignore .cpp import

TEST(MajorityElementTest, description) {
    testing::internal::CaptureStdout();
    MajorityElement::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MajorityElementTest, majorityElement_1) {
    auto expected = 3;
    vector<int> nums{3, 2, 3};
    auto result = MajorityElement::majorityElement(nums);
    EXPECT_EQ(expected, result);
}

TEST(MajorityElementTest, majorityElement_2) {
    auto expected = 2;
    vector<int> nums{2, 2, 1, 1, 1, 2, 2};
    auto result = MajorityElement::majorityElement(nums);
    EXPECT_EQ(expected, result);
}

TEST(MajorityElementTest, majorityElement_fail_1) {
    // 1 ≤ nums.length
    auto size = 0;
    vector<int> nums(size);
    EXPECT_EXIT(MajorityElement::majorityElement(nums), ::testing::ExitedWithCode(3), "");
}

TEST(MajorityElementTest, majorityElement_fail_2) {
    // nums.length ≤ 5 * 10^4
    auto size = 5 * (int) pow(10, 4) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(MajorityElement::majorityElement(nums), ::testing::ExitedWithCode(3), "");
}

TEST(MajorityElementTest, majorityElement_fail_3) {
    // -10^9 ≤ nums[i]
    auto value = (int) -pow(10, 9) - 1;
    vector<int> nums{value};
    EXPECT_EXIT(MajorityElement::majorityElement(nums), ::testing::ExitedWithCode(3), "");
}

TEST(MajorityElementTest, majorityElement_fail_4) {
    // nums[i] ≤ 10^9
    auto value = (int) pow(10, 9) + 1;
    vector<int> nums{value};
    EXPECT_EXIT(MajorityElement::majorityElement(nums), ::testing::ExitedWithCode(3), "");
}

TEST(MajorityElementTest, majorityElement_fail_5) {
    // nums[i] ≤ 109
    auto value = (int) pow(10, 9) + 1;
    vector<int> nums{1, value};
    EXPECT_EXIT(MajorityElement::majorityElement(nums), ::testing::ExitedWithCode(3), "");
}

#endif