#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_STRING_COMMON_CHILD_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_STRING_COMMON_CHILD_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/strings/CommonChild.cpp"  // NOLINT : Ignore .cpp import

TEST(CommonChildTest, description) {
    testing::internal::CaptureStdout();
    CommonChild::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

/*
TEST(CommonChildTest, commonChild_1) {
    auto expected = 3;
    auto s1 = "ABCD";
    auto s2 = "ABDC";
    auto result = CommonChild::commonChild(s1, s2);
    EXPECT_EQ(expected, result);
}

TEST(CommonChildTest, commonChild_2) {
    auto expected = 2;
    auto s1 = "HARRY";
    auto s2 = "SALLY";
    auto result = CommonChild::commonChild(s1, s2);
    EXPECT_EQ(expected, result);
}

TEST(CommonChildTest, commonChild_3) {
    auto expected = 0;
    auto s1 = "AA";
    auto s2 = "BB";
    auto result = CommonChild::commonChild(s1, s2);
    EXPECT_EQ(expected, result);
}

TEST(CommonChildTest, commonChild_4) {
    auto expected = 3;
    auto s1 = "SHINCHAN";
    auto s2 = "NOHARAAA";
    auto result = CommonChild::commonChild(s1, s2);
    EXPECT_EQ(expected, result);
}
*/
#endif