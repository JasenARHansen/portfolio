#ifndef INTERVIEW_META_PREPARATION_QUEUE_FROM_STACK_TEST
#define INTERVIEW_META_PREPARATION_QUEUE_FROM_STACK_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/tips_and_tricks/QueueFromStack.cpp"  // NOLINT : Ignore .cpp import

TEST(QueueFromStackSlowPopTest, description) {
    testing::internal::CaptureStdout();
    QueueFromStackSlowPop::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(QueueFromStackSlowPopTest, constructor) {
    auto expected = "{}";
    QueueFromStackSlowPop queueFromStackSlowPop;
    auto result = queueFromStackSlowPop.toString();
    EXPECT_EQ(expected, result);
}

TEST(QueueFromStackSlowPopTest, push) {
    auto expected = "{2, 1}";
    QueueFromStackSlowPop queueFromStackSlowPop;
    queueFromStackSlowPop.push(1);
    queueFromStackSlowPop.push(2);
    auto result = queueFromStackSlowPop.toString();
    EXPECT_EQ(expected, result);
}

TEST(QueueFromStackSlowPopTest, pop) {
    auto expected = "{2}";
    QueueFromStackSlowPop queueFromStackSlowPop;
    queueFromStackSlowPop.push(1);
    queueFromStackSlowPop.push(2);
    queueFromStackSlowPop.pop();
    auto result = queueFromStackSlowPop.toString();
    EXPECT_EQ(expected, result);
}

TEST(QueueFromStackSlowPopTest, front) {
    auto expected = "{2, 1}";
    QueueFromStackSlowPop queueFromStackSlowPop;
    queueFromStackSlowPop.push(1);
    queueFromStackSlowPop.push(2);
    auto data = queueFromStackSlowPop.front();
    auto result = queueFromStackSlowPop.toString();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(1, data);
}

TEST(QueueFromStackSlowPopTest, back) {
    auto expected = "{2, 1}";
    QueueFromStackSlowPop queueFromStackSlowPop;
    queueFromStackSlowPop.push(1);
    queueFromStackSlowPop.push(2);
    auto data = queueFromStackSlowPop.back();
    auto result = queueFromStackSlowPop.toString();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(2, data);
}

TEST(QueueFromStackSlowInsertTest, description) {
    testing::internal::CaptureStdout();
    QueueFromStackSlowInsert::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(QueueFromStackSlowInsertTest, constructor) {
    auto expected = "{}";
    QueueFromStackSlowInsert queueFromStackSlowInsert;
    auto result = queueFromStackSlowInsert.toString();
    EXPECT_EQ(expected, result);
}

TEST(QueueFromStackSlowInsertTest, push) {
    auto expected = "{1, 2}";
    QueueFromStackSlowInsert queueFromStackSlowInsert;
    queueFromStackSlowInsert.push(1);
    queueFromStackSlowInsert.push(2);
    auto result = queueFromStackSlowInsert.toString();
    EXPECT_EQ(expected, result);
}

TEST(QueueFromStackSlowInsertTest, pop) {
    auto expected = "{2}";
    QueueFromStackSlowInsert queueFromStackSlowInsert;
    queueFromStackSlowInsert.push(1);
    queueFromStackSlowInsert.push(2);
    queueFromStackSlowInsert.pop();
    auto result = queueFromStackSlowInsert.toString();
    EXPECT_EQ(expected, result);
}

TEST(QueueFromStackSlowInsertTest, front) {
    auto expected = "{1, 2}";
    QueueFromStackSlowInsert queueFromStackSlowInsert;
    queueFromStackSlowInsert.push(1);
    queueFromStackSlowInsert.push(2);
    auto data = queueFromStackSlowInsert.front();
    auto result = queueFromStackSlowInsert.toString();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(1, data);
}

TEST(QueueFromStackSlowInsertTest, back) {
    auto expected = "{1, 2}";
    QueueFromStackSlowInsert queueFromStackSlowInsert;
    queueFromStackSlowInsert.push(1);
    queueFromStackSlowInsert.push(2);
    auto data = queueFromStackSlowInsert.back();
    auto result = queueFromStackSlowInsert.toString();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(2, data);
}

#endif