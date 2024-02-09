#ifndef CTCI_CH_3_STACKS_AND_QUEUES_STACK_OF_PLATES_TEST
#define CTCI_CH_3_STACKS_AND_QUEUES_STACK_OF_PLATES_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_3_Stacks_and_Queues/StackOfPlates.h"

TEST(StackOfPlatesTest, description) {
    testing::internal::CaptureStdout();
    StackOfPlates::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(StackOfPlatesTest, StackOfPlates_1) {
    auto stacks = StackOfPlates();
    auto numberStacks = 3;
    auto stackMax = 10;
    EXPECT_TRUE(stacks.empty());
    for (auto outer = 0; outer < numberStacks; outer++) {
        for (auto inner = 0; inner < stackMax; inner++) {
            stacks.push(inner);
        }
    }
    EXPECT_FALSE(stacks.empty());
    EXPECT_EQ(numberStacks * stackMax, stacks.size());
    EXPECT_EQ(stackMax - 1, stacks.top());
    stacks.pop(1);
    EXPECT_EQ(numberStacks * stackMax - 1, stacks.size());
    EXPECT_EQ(stackMax - 1, stacks.top());
    stacks.pop();
    EXPECT_EQ(numberStacks * stackMax - 2, stacks.size());
    EXPECT_EQ(stackMax - 2, stacks.top());
}

TEST(StackOfPlatesTest, StackOfPlates_2) {
    auto stackMax = 3;
    auto stacks = StackOfPlates(stackMax);
    auto numberStacks = 3;
    EXPECT_TRUE(stacks.empty());
    for (auto outer = 0; outer < numberStacks; outer++) {
        for (auto inner = 0; inner < stackMax; inner++) {
            stacks.push(inner);
        }
    }
    EXPECT_FALSE(stacks.empty());
    EXPECT_EQ(numberStacks * stackMax, stacks.size());
    EXPECT_EQ(stackMax - 1, stacks.top());
    stacks.pop(1);
    EXPECT_EQ(numberStacks * stackMax - 1, stacks.size());
    EXPECT_EQ(stackMax - 1, stacks.top());
    stacks.pop();
    EXPECT_EQ(numberStacks * stackMax - 2, stacks.size());
    EXPECT_EQ(stackMax - 2, stacks.top());
}

TEST(StackOfPlatesTest, StackOfPlates_3) {
    auto stackMax = 1;
    auto stacks = StackOfPlates(stackMax);
    auto numberStacks = 3;
    EXPECT_TRUE(stacks.empty());
    for (auto outer = 0; outer < numberStacks; outer++) {
        for (auto inner = 0; inner < stackMax; inner++) {
            stacks.push(inner);
        }
    }
    EXPECT_FALSE(stacks.empty());
    EXPECT_EQ(numberStacks * stackMax, stacks.size());
    EXPECT_EQ(stackMax - 1, stacks.top());
    stacks.pop(1);
    EXPECT_EQ(numberStacks * stackMax - 1, stacks.size());
    EXPECT_EQ(stackMax - 1, stacks.top());
    stacks.pop();
    EXPECT_EQ(numberStacks * stackMax - 2, stacks.size());
    EXPECT_EQ(stackMax - 1, stacks.top());
}

#endif