#ifndef INTERVIEW_META_PREPARATION_HELLO_WORLD_TEST
#define INTERVIEW_META_PREPARATION_HELLO_WORLD_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/coderpad/HelloWorld.cpp"  // NOLINT : Ignore .cpp import

TEST(HelloWorldTest, hello_eq) {
    auto expected = "Hello, World!\n";
    testing::internal::CaptureStdout();
    HelloWorld::helloWorld();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif