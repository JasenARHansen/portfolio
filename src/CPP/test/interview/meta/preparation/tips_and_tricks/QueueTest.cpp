#ifndef INTERVIEW_META_PREPARATION_QUEUE_TEST
#define INTERVIEW_META_PREPARATION_QUEUE_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/tips_and_tricks/Queue.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_QueueTest, description) {
    testing::internal::CaptureStdout();
    Queue::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_QueueTest, constructor_1) {
    auto expected = "{}";
    Queue queue;
    auto result = queue.toString();
    EXPECT_EQ(expected, result);
}

TEST(Interview_QueueTest, enqueue) {
    auto expected = "{5, 10}";
    Queue queue;
    auto data = 5;
    queue.enqueue(data);
    data = 10;
    queue.enqueue(data);
    auto result = queue.toString();
    EXPECT_EQ(expected, result);
}

TEST(Interview_QueueTest, front) {
    auto expected = "{5, 10}";
    Queue queue;
    auto data = 5;
    queue.enqueue(data);
    data = 10;
    queue.enqueue(data);
    auto front = queue.front();
    auto result = queue.toString();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(5, front);
}

TEST(Interview_QueueTest, back) {
    auto expected = "{5, 10}";
    Queue queue;
    auto data = 5;
    queue.enqueue(data);
    data = 10;
    queue.enqueue(data);
    auto back = queue.back();
    auto result = queue.toString();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(10, back);
}

TEST(Interview_QueueTest, dequeue) {
    auto expected = "{10}";
    Queue queue;
    auto data = 5;
    queue.enqueue(data);
    data = 10;
    queue.enqueue(data);
    queue.dequeue();
    auto result = queue.toString();
    EXPECT_EQ(expected, result);
}

TEST(Interview_QueueTest, size) {
    auto expected = "{10}";
    Queue queue;
    auto data = 10;
    queue.enqueue(data);
    auto result = queue.toString();
    auto size = queue.size();
    EXPECT_EQ(expected, result);
    EXPECT_EQ(1, size);
}

TEST(Interview_QueueTest, dequeue_fail) {
    // Queue empty
    Queue queue;
    EXPECT_THROW(queue.dequeue(), runtime_error);
}

TEST(Interview_QueueTest, front_fail) {
    // Queue empty
    Queue queue;
    EXPECT_THROW(queue.front(), runtime_error);
}

TEST(Interview_QueueTest, back_fail) {
    // Queue empty
    Queue queue;
    EXPECT_THROW(queue.back(), runtime_error);
}

#endif