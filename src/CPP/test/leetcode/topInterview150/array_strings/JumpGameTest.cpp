#ifndef LEETCODE_TOP_INTERVIEW_150_JUMP_GAME_TEST
#define LEETCODE_TOP_INTERVIEW_150_JUMP_GAME_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/JumpGame.cpp"

TEST(JumpGameTest, description) {
    testing::internal::CaptureStdout();
    JumpGame::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(JumpGameTest, canJump_1) {
    auto expected = true;
    vector<int> nums{2, 3, 1, 1, 4};
    auto result = JumpGame::canJump(nums);
    EXPECT_EQ(expected, result);
}

TEST(JumpGameTest, canJump_2) {
    auto expected = false;
    vector<int> nums{3, 2, 1, 0, 4};
    auto result = JumpGame::canJump(nums);
    EXPECT_EQ(expected, result);
}

TEST(JumpGameTest, canJump_3) {
    auto expected = false;
    vector<int> nums{2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2,
                     4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0,
                     4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7,
                     5, 1, 7, 9, 6};
    auto result = JumpGame::canJump(nums);
    EXPECT_EQ(expected, result);
}

TEST(JumpGameTest, canJump_fail_1) {
    // 1 ≤ nums.length
    auto size = 0;
    vector<int> nums(size);
    EXPECT_EXIT(JumpGame::canJump(nums), ::testing::ExitedWithCode(3), "");
}

TEST(JumpGameTest, canJump_fail_2) {
    // nums.length ≤ 10^4
    auto size = (int) pow(10, 4) + 1;
    vector<int> nums(size);
    EXPECT_EXIT(JumpGame::canJump(nums), ::testing::ExitedWithCode(3), "");
}

TEST(JumpGameTest, canJump_fail_3) {
    // 0 ≤ nums[i]
    auto value = -1;
    vector<int> nums{3, 2, value, 0, 4};
    EXPECT_EXIT(JumpGame::canJump(nums), ::testing::ExitedWithCode(3), "");
}

TEST(JumpGameTest, canJump_fail_4) {
    // nums[i] ≤ 10^5
    auto value = (int) pow(10, 5) + 1;
    vector<int> nums{3, value, 1, 0, 4};
    EXPECT_EXIT(JumpGame::canJump(nums), ::testing::ExitedWithCode(3), "");
}

#endif