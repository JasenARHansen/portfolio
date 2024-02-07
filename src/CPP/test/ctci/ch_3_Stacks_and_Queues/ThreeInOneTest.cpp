#ifndef CTCI_CH_3_STACKS_AND_QUEUES_THREE_IN_ONE_TEST
#define CTCI_CH_3_STACKS_AND_QUEUES_THREE_IN_ONE_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_3_Stacks_and_Queues/ThreeInOne.h"

TEST(ThreeInOneTest, description) {
    testing::internal::CaptureStdout();
    ThreeInOne::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ThreeInOneTest, isPermutation_1) {
    auto stacks = ThreeInOne();
    EXPECT_TRUE(stacks.empty(0));
    EXPECT_TRUE(stacks.empty(1));
    EXPECT_TRUE(stacks.empty(2));
    stacks.push(0, 1);
    stacks.push(1, 5);
    stacks.push(2, 10);
    stacks.push(0, 2);
    stacks.push(1, 6);
    stacks.push(2, 11);
    EXPECT_FALSE(stacks.empty(0));
    EXPECT_FALSE(stacks.empty(2));
    EXPECT_FALSE(stacks.empty(3));
    EXPECT_EQ(2, stacks.top(0));
    EXPECT_EQ(6, stacks.top(1));
    EXPECT_EQ(11, stacks.top(2));
    stacks.pop(1);
    EXPECT_EQ(2, stacks.top(0));
    EXPECT_EQ(5, stacks.top(1));
    EXPECT_EQ(11, stacks.top(2));

}


#endif