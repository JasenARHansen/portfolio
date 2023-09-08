#ifndef INTERVIEW_FACEBOOK_PREPARATION_EDIT_DISTANCE_TEST
#define INTERVIEW_FACEBOOK_PREPARATION_EDIT_DISTANCE_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/facebook/preparation/EditDistance.cpp"

TEST(EditDistanceTest, description) {
    testing::internal::CaptureStdout();
    EditDistance::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(EditDistanceTest, oneEditApart_1) {
    bool expected = false;
    auto s1 = "cat";
    auto s2 = "dog";
    auto result = EditDistance::oneEditApart(s1,s2);
    EXPECT_EQ(expected, result);
}

TEST(EditDistanceTest, oneEditApart_2) {
    bool expected = true;
    auto s1 = "cat";
    auto s2 = "cats";
    auto result = EditDistance::oneEditApart(s1,s2);
    EXPECT_EQ(expected, result);
}

TEST(EditDistanceTest, oneEditApart_3) {
    bool expected = true;
    auto s1 = "cat";
    auto s2 = "cut";
    auto result = EditDistance::oneEditApart(s1,s2);
    EXPECT_EQ(expected, result);
}

TEST(EditDistanceTest, oneEditApart_4) {
    bool expected = true;
    auto s1 = "cat";
    auto s2 = "cast";
    auto result = EditDistance::oneEditApart(s1,s2);
    EXPECT_EQ(expected, result);
}

TEST(EditDistanceTest, oneEditApart_5) {
    bool expected = true;
    auto s1 = "cat";
    auto s2 = "at";
    auto result = EditDistance::oneEditApart(s1,s2);
    EXPECT_EQ(expected, result);
}

TEST(EditDistanceTest, oneEditApart_6) {
    bool expected = false;
    auto s1 = "cat";
    auto s2 = "act";
    auto result = EditDistance::oneEditApart(s1,s2);
    EXPECT_EQ(expected, result);
}

#endif