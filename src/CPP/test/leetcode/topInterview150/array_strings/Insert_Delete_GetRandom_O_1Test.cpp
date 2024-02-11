#ifndef LEETCODE_TOP_INTERVIEW_150_INSERT_DELETE_GET_RANDOM_O_1_TEST
#define LEETCODE_TOP_INTERVIEW_150_INSERT_DELETE_GET_RANDOM_O_1_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/Insert_Delete_GetRandom_O_1.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_Insert_Delete_GetRandom_O_1Test, description) {
    testing::internal::CaptureStdout();
    RandomizedSet::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_Insert_Delete_GetRandom_O_1Test, RandomizedSet) {
    EXPECT_NO_THROW(RandomizedSet());
}

TEST(LeetCode_Insert_Delete_GetRandom_O_1Test, insert_1) {
    auto expected = true;
    auto randomizedSet = RandomizedSet();
    auto value = 0;
    auto result = randomizedSet.insert(value);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_Insert_Delete_GetRandom_O_1Test, insert_2) {
    auto expected = false;
    auto randomizedSet = RandomizedSet();
    auto value = 0;
    randomizedSet.insert(value);
    auto result = randomizedSet.insert(value);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_Insert_Delete_GetRandom_O_1Test, remove_1) {
    auto expected = true;
    auto randomizedSet = RandomizedSet();
    auto value = 0;
    randomizedSet.insert(value);
    auto result = randomizedSet.remove(value);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_Insert_Delete_GetRandom_O_1Test, remove_2) {
    auto expected = false;
    auto randomizedSet = RandomizedSet();
    auto value = 0;
    auto result = randomizedSet.remove(value);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_Insert_Delete_GetRandom_O_1Test, getRandom_1) {
    auto value = 0;
    auto expected = value;
    auto randomizedSet = RandomizedSet();
    randomizedSet.insert(value);
    auto result = randomizedSet.getRandom();
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_Insert_Delete_GetRandom_O_1Test, getRandom_2) {
    vector<int> data{1, 2, 3, 4, 5};
    auto randomizedSet = RandomizedSet();
    for (auto value: data) {
        randomizedSet.insert(value);
    }
    auto result = randomizedSet.getRandom();
    auto test = find(data.begin(), data.end(), result) != data.end();
    EXPECT_TRUE(test);
}

#endif