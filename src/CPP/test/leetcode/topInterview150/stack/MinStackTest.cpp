#ifndef LEETCODE_TOP_INTERVIEW_150_MIN_STACK_TEST
#define LEETCODE_TOP_INTERVIEW_150_MIN_STACK_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/stack/MinStack.cpp"  // NOLINT : Ignore .cpp import

TEST(MinStackTest, description) {
    testing::internal::CaptureStdout();
    MinStack::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MinStackTest, MinStack_1) {
    vector<int> expected{1, 2, 2, 1, 1, 1};
    auto myStack = MinStack();
    myStack.push(expected[0]);
    myStack.push(expected[1]);
    auto result = myStack.top();
    EXPECT_EQ(expected[1], result);
    result = myStack.getMin();
    EXPECT_EQ(expected[0], result);
    myStack.pop();
    result = myStack.top();
    EXPECT_EQ(expected[0], result);
    result = myStack.getMin();
    EXPECT_EQ(expected[0], result);
}

TEST(MinStackTest, MinStack_2) {
    vector<int> expected{1, 2, 2, 1, 1, 1};
    auto myStack = new MinStack();
    myStack->push(expected[0]);
    myStack->push(expected[1]);
    auto result = myStack->top();
    EXPECT_EQ(expected[1], result);
    result = myStack->getMin();
    EXPECT_EQ(expected[0], result);
    myStack->pop();
    result = myStack->top();
    EXPECT_EQ(expected[0], result);
    result = myStack->getMin();
    EXPECT_EQ(expected[0], result);
}

#endif