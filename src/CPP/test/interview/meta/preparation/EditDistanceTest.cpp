#ifndef INTERVIEW_META_PREPARATION_EDIT_DISTANCE_TEST
#define INTERVIEW_META_PREPARATION_EDIT_DISTANCE_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/preparation/EditDistance.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_EditDistanceTest, description) {
    testing::internal::CaptureStdout();
    EditDistance::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_EditDistanceTest, oneEditApart_1) {
    auto expected = false;
    auto s1 = "cat";
    auto s2 = "dog";
    auto result = EditDistance::oneEditApart(s1, s2);
    EXPECT_EQ(expected, result);
}

TEST(Interview_EditDistanceTest, oneEditApart_2) {
    auto expected = true;
    auto s1 = "cat";
    auto s2 = "cats";
    auto result = EditDistance::oneEditApart(s1, s2);
    EXPECT_EQ(expected, result);
}

TEST(Interview_EditDistanceTest, oneEditApart_3) {
    auto expected = true;
    auto s1 = "cat";
    auto s2 = "cut";
    auto result = EditDistance::oneEditApart(s1, s2);
    EXPECT_EQ(expected, result);
}

TEST(Interview_EditDistanceTest, oneEditApart_4) {
    auto expected = true;
    auto s1 = "cat";
    auto s2 = "cast";
    auto result = EditDistance::oneEditApart(s1, s2);
    EXPECT_EQ(expected, result);
}

TEST(Interview_EditDistanceTest, oneEditApart_5) {
    auto expected = true;
    auto s1 = "cat";
    auto s2 = "at";
    auto result = EditDistance::oneEditApart(s1, s2);
    EXPECT_EQ(expected, result);
}

TEST(Interview_EditDistanceTest, oneEditApart_6) {
    auto expected = false;
    auto s1 = "cat";
    auto s2 = "act";
    auto result = EditDistance::oneEditApart(s1, s2);
    EXPECT_EQ(expected, result);
}

#endif