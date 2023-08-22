#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_JUMP_GAME_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_JUMP_GAME_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/JumpGameII.cpp"

TEST(JumpGameIITest, description) {
    testing::internal::CaptureStdout();
    JumpGameII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(JumpGameIITest, jump_1) {
    int expected = 2;
    vector<int> nums{2, 3, 1, 1, 4};
    int result = JumpGameII::jump(nums);
    EXPECT_EQ(expected, result);
}

TEST(JumpGameIITest, jump_2) {
    int expected = 2;
    vector<int> nums{2, 3, 0, 1, 4};
    int result = JumpGameII::jump(nums);
    EXPECT_EQ(expected, result);
}

TEST(JumpGameIITest, jump_fail_1) {
    // 1 <= nums.length
    int size = 0;
    vector<int> nums(size);
    EXPECT_EXIT(JumpGameII::jump(nums), ::testing::ExitedWithCode(3), "");
}

TEST(JumpGameIITest, jump_fail_2) {
    // nums.length <= 10^4
    int size = pow(10, 4) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(JumpGameII::jump(nums), ::testing::ExitedWithCode(3), "");
}

TEST(JumpGameIITest, jump_fail_3) {
    // 0 <= nums[i]
    int value = -1;
    vector<int> nums{3, 2, value, 0, 4};
    EXPECT_EXIT(JumpGameII::jump(nums), ::testing::ExitedWithCode(3), "");
}

TEST(JumpGameIITest, jump_fail_4) {
    // nums[i] <= 10^5
    int value = pow(10, 5) + 1;
    vector<int> nums{3, value, 1, 0, 4};
    EXPECT_EXIT(JumpGameII::jump(nums), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop