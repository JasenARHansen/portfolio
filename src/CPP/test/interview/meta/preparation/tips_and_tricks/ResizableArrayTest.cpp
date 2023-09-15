#ifndef INTERVIEW_META_PREPARATION_RESIZABLE_ARRAY_TEST
#define INTERVIEW_META_PREPARATION_RESIZABLE_ARRAY_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/tips_and_tricks/ResizableArray.cpp"  // NOLINT : Ignore .cpp import

TEST(ResizableArrayTest, description) {
    testing::internal::CaptureStdout();
    ResizableArray::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ResizableArrayTest, initial) {
    string expected = "[]";
    auto test = ResizableArray();
    auto result = test.print();
    EXPECT_EQ(expected, result);
}

TEST(ResizableArrayTest, size_1) {
    int expected = 0;
    auto test = ResizableArray();
    auto result = test.size();
    EXPECT_EQ(expected, result);
}

TEST(ResizableArrayTest, set_1) {
    int expected = 1;
    string expectedString = "[5]";
    auto test = ResizableArray();
    test.set(5, 0);
    auto result = test.size();
    auto resultString = test.print();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(expectedString, resultString);
}

TEST(ResizableArrayTest, set_2) {
    int expected = 6;
    string expectedString = "[0, 0, 0, 0, 5]";
    auto test = ResizableArray();
    test.set(5, 5);
    auto result = test.size();
    auto resultString = test.print();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(expectedString, resultString);
}

TEST(ResizableArrayTest, set_3) {
    int expected = 6;
    string expectedString = "[0, 0, 5, 5, 0]";
    auto test = ResizableArray();
    test.set(5, 2);
    test.set(5, 3);
    auto result = test.size();
    auto resultString = test.print();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(expectedString, resultString);
}

#endif