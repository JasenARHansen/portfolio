#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_LEFT_ROTATION_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_ARRAYS_LEFT_ROTATION_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/arrays/LeftRotation.cpp"  // NOLINT : Ignore .cpp import

TEST(LeftRotationTest, description) {
    testing::internal::CaptureStdout();
    LeftRotation::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeftRotationTest, rotLeft_1) {
    vector<int> expected{2, 3, 4, 5, 1};
    vector<int> a{1, 2, 3, 4, 5};
    auto d = 1;
    auto result = LeftRotation::rotLeft(a, d);
    EXPECT_EQ(expected, result);
}

TEST(LeftRotationTest, rotLeft_2) {
    vector<int> expected{5, 1, 2, 3, 4};
    vector<int> a{1, 2, 3, 4, 5};
    auto d = 4;
    auto result = LeftRotation::rotLeft(a, d);
    EXPECT_EQ(expected, result);
}

TEST(LeftRotationTest, rotLeft_3) {
    vector<int> expected{77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77};
    vector<int> a{41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};
    auto d = 10;
    auto result = LeftRotation::rotLeft(a, d);
    EXPECT_EQ(expected, result);
}

TEST(LeftRotationTest, rotLeft_4) {
    vector<int> expected{87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60};
    vector<int> a{33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97};
    auto d = 13;
    auto result = LeftRotation::rotLeft(a, d);
    EXPECT_EQ(expected, result);
}

TEST(LeftRotationTest, rotLeft_5) {
    vector<int> expected{2, 3, 4, 5, 1};
    vector<int> a{1, 2, 3, 4, 5};
    int d = a.size() + 1;
    auto result = LeftRotation::rotLeft(a, d);
    EXPECT_EQ(expected, result);
}

TEST(LeftRotationTest, rotLeft_6) {
    vector<int> expected{5, 1, 2, 3, 4};
    vector<int> a{1, 2, 3, 4, 5};
    auto d = -1;
    auto result = LeftRotation::rotLeft(a, d);
    EXPECT_EQ(expected, result);
}

TEST(LeftRotationTest, rotLeft_7) {
    vector<int> expected{5, 1, 2, 3, 4};
    vector<int> a{1, 2, 3, 4, 5};
    int d = -a.size() - 1;
    auto result = LeftRotation::rotLeft(a, d);
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop