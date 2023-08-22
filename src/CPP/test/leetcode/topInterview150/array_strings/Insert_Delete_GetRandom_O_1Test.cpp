#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_INSERT_DELETE_GET_RANDOM_O_1_TEST
#define LEETCODE_TOP_INTERVIEW_150_INSERT_DELETE_GET_RANDOM_O_1_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/Insert_Delete_GetRandom_O_1.cpp"

TEST(Insert_Delete_GetRandom_O_1Test, description) {
    testing::internal::CaptureStdout();
    RandomizedSet::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Insert_Delete_GetRandom_O_1Test, RandomizedSet) {
    EXPECT_NO_THROW(RandomizedSet());
}

TEST(Insert_Delete_GetRandom_O_1Test, insert_1) {
    bool expected = true;
    RandomizedSet randomizedSet =  RandomizedSet();
    int value = 0;
    bool result = randomizedSet.insert(value);
    EXPECT_EQ(expected, result);
}

TEST(Insert_Delete_GetRandom_O_1Test, insert_2) {
    bool expected = false;
    RandomizedSet randomizedSet =  RandomizedSet();
    int value = 0;
    randomizedSet.insert(value);
    bool result = randomizedSet.insert(value);
    EXPECT_EQ(expected, result);
}

TEST(Insert_Delete_GetRandom_O_1Test, remove_1) {
    bool expected = true;
    RandomizedSet randomizedSet =  RandomizedSet();
    int value = 0;
    randomizedSet.insert(value);
    bool result = randomizedSet.remove(value);
    EXPECT_EQ(expected, result);
}

TEST(Insert_Delete_GetRandom_O_1Test, remove_2) {
    bool expected = false;
    RandomizedSet randomizedSet =  RandomizedSet();
    int value = 0;
    bool result = randomizedSet.remove(value);
    EXPECT_EQ(expected, result);
}

TEST(Insert_Delete_GetRandom_O_1Test, getRandom_1) {
    int value = 0;
    int expected = value;
    RandomizedSet randomizedSet =  RandomizedSet();
    randomizedSet.insert(value);
    int result = randomizedSet.getRandom();
    EXPECT_EQ(expected, result);
}

TEST(Insert_Delete_GetRandom_O_1Test, getRandom_2) {
    vector<int> data {1,2,3,4,5};
    RandomizedSet randomizedSet =  RandomizedSet();
    for(auto value :data) {
        randomizedSet.insert(value);
    }
    int result = randomizedSet.getRandom();
    bool test = find(data.begin(), data.end(), result) != data.end();
    EXPECT_TRUE(test);
}

#endif
#pragma clang diagnostic pop