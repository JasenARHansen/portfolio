#ifndef LEETCODE_TOP_INTERVIEW_150_CONTAINS_DUPLICATE_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_CONTAINS_DUPLICATE_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/hashmap/ContainsDuplicateII.cpp"

TEST(ContainsDuplicateIITest, description) {
    testing::internal::CaptureStdout();
    ContainsDuplicateII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_1) {
    auto expected = true;
    vector<int> nums{1, 2, 3, 1};
    auto k = 3;
    auto result = ContainsDuplicateII::containsNearbyDuplicate(nums, k);
    EXPECT_EQ(expected, result);
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_2) {
    auto expected = true;
    vector<int> nums{1, 0, 1, 1};
    auto k = 1;
    auto result = ContainsDuplicateII::containsNearbyDuplicate(nums, k);
    EXPECT_EQ(expected, result);
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_3) {
    auto expected = false;
    vector<int> nums{1, 2, 3, 1, 2, 3};
    auto k = 2;
    auto result = ContainsDuplicateII::containsNearbyDuplicate(nums, k);
    EXPECT_EQ(expected, result);
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_1) {
    // 0 ≤ nums.length
    auto size = 1 - 1;
    vector<int> nums(size);
    auto k = 3;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_2) {
    // nums.length ≤ 10^5
    auto size = (int) pow(10, 5) + 1;
    vector<int> nums(size);
    auto k = 3;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_3) {
    // -10^9 ≤ nums[i]
    auto size = (int) -pow(10, 9) - 1;
    vector<int> nums{size};
    auto k = 3;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_4) {
    // nums[i] ≤ 10^9
    auto size = (int) pow(10, 9) + 1;
    vector<int> nums{size};
    auto k = 3;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_5) {
    // 0 ≤ k
    vector<int> nums{1, 2, 3, 1};
    auto k = 0 - 1;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_6) {
    // k ≤ 10^5)
    vector<int> nums{1, 2, 3, 1};
    auto k = (int) pow(10, 5) + 1;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

#endif