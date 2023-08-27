#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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
    bool expected = true;
    vector<int> nums{1, 2, 3, 1};
    int k = 3;
    bool result = ContainsDuplicateII::containsNearbyDuplicate(nums, k);
    EXPECT_EQ(expected, result);
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_2) {
    bool expected = true;
    vector<int> nums{1, 0, 1, 1};
    int k = 1;
    bool result = ContainsDuplicateII::containsNearbyDuplicate(nums, k);
    EXPECT_EQ(expected, result);
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_3) {
    bool expected = false;
    vector<int> nums{1, 2, 3, 1, 2, 3};
    int k = 2;
    bool result = ContainsDuplicateII::containsNearbyDuplicate(nums, k);
    EXPECT_EQ(expected, result);
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_1) {
    // 0 <= nums.length
    int size = 1 - 1;
    vector<int> nums(size);
    int k = 3;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_2) {
    // nums.length <= 10^5
    int size = pow(10, 5) + 1;
    vector<int> nums(size);
    int k = 3;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_3) {
    // -10^9 <= nums[i]
    int size = -pow(10, 9) - 1;
    vector<int> nums{size};
    int k = 3;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_4) {
    //  nums[i] <= 10^9
    int size = pow(10, 9) + 1;
    vector<int> nums{size};
    int k = 3;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_5) {
    // 0 <= k
    vector<int> nums{1, 2, 3, 1};
    int k = 0 - 1;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

TEST(ContainsDuplicateIITest, containsNearbyDuplicate_fail_6) {
    // k <= 10^5)
    vector<int> nums{1, 2, 3, 1};
    int k = pow(10, 5) + 1;
    EXPECT_EXIT(ContainsDuplicateII::containsNearbyDuplicate(nums, k), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop