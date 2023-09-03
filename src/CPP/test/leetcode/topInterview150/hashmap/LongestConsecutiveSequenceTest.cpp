#ifndef LEETCODE_TOP_INTERVIEW_150_LONGEST_CONSECUTIVE_SEQUENCE_TEST
#define LEETCODE_TOP_INTERVIEW_150_LONGEST_CONSECUTIVE_SEQUENCE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/LongestConsecutiveSequence.cpp"

TEST(LongestConsecutiveSequenceTest, description) {
    testing::internal::CaptureStdout();
    LongestConsecutiveSequence::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LongestConsecutiveSequenceTest, longestConsecutive_1) {
    auto expected = 4;
    vector<int> nums{100, 4, 200, 1, 3, 2};
    auto result = LongestConsecutiveSequence::longestConsecutive(nums);
    EXPECT_EQ(expected, result);
}

TEST(LongestConsecutiveSequenceTest, longestConsecutive_2) {
    auto expected = 9;
    vector<int> nums{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    auto result = LongestConsecutiveSequence::longestConsecutive(nums);
    EXPECT_EQ(expected, result);
}

TEST(LongestConsecutiveSequenceTest, longestConsecutive_fail_1) {
    // nums.length <= 10^5
    auto size = (int) pow(10, 5) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(LongestConsecutiveSequence::longestConsecutive(nums), ::testing::ExitedWithCode(3), "");
}

TEST(LongestConsecutiveSequenceTest, longestConsecutive_fail_2) {
    // -10^9 <= nums[i]
    auto size = (int) -pow(10, 9) - 1;
    vector<int> nums{size};
    EXPECT_EXIT(LongestConsecutiveSequence::longestConsecutive(nums), ::testing::ExitedWithCode(3), "");
}

TEST(LongestConsecutiveSequenceTest, longestConsecutive_fail_3) {
    //  nums[i] <= 10^9
    auto size = (int) pow(10, 9) + 1;
    vector<int> nums{size};
    EXPECT_EXIT(LongestConsecutiveSequence::longestConsecutive(nums), ::testing::ExitedWithCode(3), "");
}

#endif