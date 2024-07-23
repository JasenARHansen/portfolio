#ifndef INTERVIEW_AMAZON_2024_2_16_MINIMUM_RUNTIME_TEST
#define INTERVIEW_AMAZON_2024_2_16_MINIMUM_RUNTIME_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/amazon/interview_2024_2_16/MinimumRuntime.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_Amazon_Interview_2024_2_16_MinimumRuntime_Test, description) {
    testing::internal::CaptureStdout();
    MinimumRuntime::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_Amazon_Interview_2024_2_16_MinimumRuntime_Test, calculateRuntime_1) {
    auto expected = 110;
    vector<MinimumRuntime::Task> tasks{};
    tasks.push_back(MinimumRuntime::Task("task_1", "First Task", 20, {}));
    tasks.push_back(MinimumRuntime::Task("task_2", "Some Task", 50, {}));
    tasks.push_back(MinimumRuntime::Task("task_3", "Some Other Task", 35, {"task_1", "task_2"}));
    tasks.push_back(MinimumRuntime::Task("task_4", "Some Other Task", 60, {"task_2"}));
    auto result = MinimumRuntime::calculateRuntimeTimeline(tasks);
    EXPECT_EQ(expected, result);
}


TEST(Interview_Amazon_Interview_2024_2_16_MinimumRuntime_Test, calculateRuntime_2) {
    auto expected = -1;
    vector<MinimumRuntime::Task> tasks{};
    tasks.push_back(MinimumRuntime::Task("task_1", "First Task", 20, {}));
    tasks.push_back(MinimumRuntime::Task("task_2", "Some Task", 50, {}));
    tasks.push_back(MinimumRuntime::Task("task_3", "Some Other Task", 35, {"task_1", "task_2", "task_4"}));
    tasks.push_back(MinimumRuntime::Task("task_4", "Some Other Task", 60, {"task_2", "task_3"}));
    auto result = MinimumRuntime::calculateRuntimeTimeline(tasks);
    EXPECT_EQ(expected, result);
}
#endif