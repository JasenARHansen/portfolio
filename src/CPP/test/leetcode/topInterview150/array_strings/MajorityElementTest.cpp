#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"

#ifndef LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_ARRAY_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_REMOVE_DUPLICATES_FROM_SORTED_ARRAY_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/MajorityElement.cpp"

TEST(MajorityElementTest, description) {
    testing::internal::CaptureStdout();
    MajorityElement::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MajorityElementTest, majorityElement_1) {
    int expected = 3;
    vector<int> nums{3, 2, 3};
    int result = MajorityElement::majorityElement(nums);
    EXPECT_EQ(expected, result);
}

TEST(MajorityElementTest, majorityElement_2) {
    int expected = 2;
    vector<int> nums{2, 2, 1, 1, 1, 2, 2};
    int result = MajorityElement::majorityElement(nums);
    EXPECT_EQ(expected, result);

}

TEST(MajorityElementTest, majorityElement_fail_1) {
    // 1 <= nums.length
    int size = 0;
    vector<int> nums(size);
    EXPECT_EXIT(MajorityElement::majorityElement(nums), ::testing::ExitedWithCode(3), "");
}

TEST(MajorityElementTest, majorityElement_fail_2) {
    // nums.length <= 5 * 10^4
    int size = 5 * pow(10, 4) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(MajorityElement::majorityElement(nums), ::testing::ExitedWithCode(3), "");
}

TEST(MajorityElementTest, majorityElement_fail_3) {
    // -10^9 <= nums[i]
    int value = -(pow(10, 9) + 1);
    vector<int> nums{value};
    EXPECT_EXIT(MajorityElement::majorityElement(nums), ::testing::ExitedWithCode(3), "");
}

TEST(MajorityElementTest, majorityElement_fail_4) {
    // nums[i] <= 10^9
    int value = pow(10, 9) + 1;
    vector<int> nums{value};
    EXPECT_EXIT(MajorityElement::majorityElement(nums), ::testing::ExitedWithCode(3), "");
}

TEST(MajorityElementTest, majorityElement_fail_5) {
    // nums[i] <= 109
    int value = pow(10, 9) + 1;
    vector<int> nums{1, value};
    EXPECT_EXIT(MajorityElement::majorityElement(nums), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop