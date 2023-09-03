#ifndef LEETCODE_TOP_INTERVIEW_150_REMOVE_ELEMENT_TEST
#define LEETCODE_TOP_INTERVIEW_150_REMOVE_ELEMENT_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/RemoveElement.cpp"

TEST(RemoveElementTest, description) {
    testing::internal::CaptureStdout();
    RemoveElement::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RemoveElementTest, removeElement_1) {
    vector<int> expected{2, 2, 0, 0};
    auto expectedCount = 2;
    vector<int> nums{3, 2, 2, 3};
    auto val = 3;
    auto result = RemoveElement::removeElement(nums, val);
    EXPECT_EQ(expectedCount, result);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RemoveElementTest, removeElement_2) {
    vector<int> expected{0, 1, 4, 0, 3, 0, 0, 0};
    auto expectedCount = 5;
    vector<int> nums{0, 1, 2, 2, 3, 0, 4, 2};
    auto val = 2;
    auto result = RemoveElement::removeElement(nums, val);
    EXPECT_EQ(expectedCount, result);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RemoveElementTest, removeElement_3) {
    vector<int> expected{0};
    auto expectedCount = 1;
    vector<int> nums{0};
    auto val = 2;
    auto result = RemoveElement::removeElement(nums, val);
    EXPECT_EQ(expectedCount, result);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RemoveElementTest, removeElement_4) {
    vector<int> expected{0};
    auto expectedCount = 0;
    auto val = 2;
    vector<int> nums{val};
    auto result = RemoveElement::removeElement(nums, val);
    EXPECT_EQ(expectedCount, result);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RemoveElementTest, removeElement_5) {
    auto val = 2;
    vector<int> expected{val + 1, val + 1};
    auto expectedCount = 2;
    vector<int> nums{val + 1, val, val + 1};
    auto result = RemoveElement::removeElement(nums, val);
    EXPECT_EQ(expectedCount, result);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RemoveElementTest, removeElement_6) {
    vector<int> expected{0, 0, 0, 0, 0, 0, 0, 0};
    auto expectedCount = 0;
    auto val = 2;
    vector<int> nums{val, val, val, val, val, val, val, val};
    auto result = RemoveElement::removeElement(nums, val);
    EXPECT_EQ(expectedCount, result);
    for (auto i = 0; i < expected.size(); i++) {
        EXPECT_EQ(expected[i], nums[i]);
    }
}

TEST(RemoveElementTest, removeElement_7) {
    // 0 <= nums.length Cant test for the fail condition
    auto expected = 0;
    auto size = 0;
    vector<int> nums(size);
    auto val = 5;
    auto result = RemoveElement::removeElement(nums, val);
    EXPECT_EQ(expected, result);
}

TEST(RemoveElementTest, removeElement_fail_2) {
    // nums.length <= 100
    auto size = 101;
    vector<int> nums(size);
    auto val = 5;
    EXPECT_EXIT(RemoveElement::removeElement(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveElementTest, removeElement_fail_3) {
    // 0 <= nums[i]
    vector<int> nums{-1};
    auto val = 5;
    EXPECT_EXIT(RemoveElement::removeElement(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveElementTest, removeElement_fail_4) {
    // 0 <= nums[i]
    vector<int> nums{1, -1, 0};
    auto val = 5;
    EXPECT_EXIT(RemoveElement::removeElement(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveElementTest, removeElement_fail_5) {
    // 0 <= nums[i]
    vector<int> nums{1, 2, -1};
    auto val = 5;
    EXPECT_EXIT(RemoveElement::removeElement(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveElementTest, removeElement_fail_6) {
    // nums[i] <= 50
    vector<int> nums{51};
    auto val = 5;
    EXPECT_EXIT(RemoveElement::removeElement(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveElementTest, removeElement_fail_7) {
    // nums[i] <= 50
    vector<int> nums{1, 51, 0};
    auto val = 5;
    EXPECT_EXIT(RemoveElement::removeElement(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveElementTest, removeElement_fail_8) {
    // nums[i] <= 50
    vector<int> nums{1, 2, 51};
    auto val = 5;
    EXPECT_EXIT(RemoveElement::removeElement(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveElementTest, removeElement_fail_9) {
    // 0 <= val
    vector<int> nums{3, 2, 2, 3};
    auto val = -1;
    EXPECT_EXIT(RemoveElement::removeElement(nums, val), ::testing::ExitedWithCode(3), "");
}

TEST(RemoveElementTest, removeElement_fail_10) {
    // val <= 100
    vector<int> nums{3, 2, 2, 3};
    auto val = 101;
    EXPECT_EXIT(RemoveElement::removeElement(nums, val), ::testing::ExitedWithCode(3), "");
}

#endif