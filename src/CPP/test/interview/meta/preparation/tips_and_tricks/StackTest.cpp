#ifndef INTERVIEW_META_PREPARATION_STACK_TEST
#define INTERVIEW_META_PREPARATION_STACK_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/tips_and_tricks/Stack.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_StackTest, description) {
    testing::internal::CaptureStdout();
    Stack::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_StackTest, constructor_1) {
    auto expected = "{}";
    Stack stack;
    auto result = stack.toString();
    EXPECT_EQ(expected, result);
}

TEST(Interview_StackTest, push) {
    auto expected = "{10}";
    Stack stack;
    auto data = 10;
    stack.push(data);
    auto result = stack.toString();
    EXPECT_EQ(expected, result);
}

TEST(Interview_StackTest, peek) {
    auto expected = "{10}";
    Stack stack;
    auto data = 10;
    stack.push(data);
    auto result = stack.toString();
    auto peek = stack.peek();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(data, peek);
}

TEST(Interview_StackTest, pop) {
    auto expected = "{}";
    Stack stack;
    auto data = 10;
    stack.push(data);
    stack.pop();
    auto result = stack.toString();
    EXPECT_EQ(expected, result);
}

TEST(Interview_StackTest, size) {
    auto expected = "{10}";
    Stack stack;
    auto data = 10;
    stack.push(data);
    auto result = stack.toString();
    auto size = stack.size();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(1, size);
}

TEST(Interview_StackTest, max_1) {
    auto expected = "{5, 10}";
    Stack stack;
    auto data = 10;
    stack.push(data);
    data = 5;
    stack.push(data);
    auto result = stack.toString();
    auto max = stack.max();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(10, max);
}

TEST(Interview_StackTest, max_2) {
    auto expected = "{10, 5}";
    Stack stack;
    auto data = 5;
    stack.push(data);
    data = 10;
    stack.push(data);
    auto result = stack.toString();
    auto max = stack.max();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(10, max);
}

TEST(Interview_StackTest, min_1) {
    auto expected = "{5, 10}";
    Stack stack;
    auto data = 10;
    stack.push(data);
    data = 5;
    stack.push(data);
    auto result = stack.toString();
    auto min = stack.min();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(5, min);
}

TEST(Interview_StackTest, min_2) {
    auto expected = "{10, 5}";
    Stack stack;
    auto data = 5;
    stack.push(data);
    data = 10;
    stack.push(data);
    auto result = stack.toString();
    auto min = stack.min();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(5, min);
}

TEST(Interview_StackTest, pop_fail) {
    // Stack empty
    Stack stack;
    EXPECT_THROW(stack.pop(), runtime_error);
}

TEST(Interview_StackTest, peek_fail) {
    // Stack empty
    Stack stack;
    EXPECT_THROW(stack.peek(), runtime_error);
}

TEST(Interview_StackTest, min_fail) {
    // Stack empty
    Stack stack;
    EXPECT_THROW(stack.min(), runtime_error);
}

TEST(Interview_StackTest, max_fail) {
    // Stack empty
    Stack stack;
    EXPECT_THROW(stack.max(), runtime_error);
}

#endif