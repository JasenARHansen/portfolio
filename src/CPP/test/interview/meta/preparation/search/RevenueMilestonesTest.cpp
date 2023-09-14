#ifndef INTERVIEW_META_PREPARATION_REVENUE_MILESTONES_TEST
#define INTERVIEW_META_PREPARATION_REVENUE_MILESTONES_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/search/RevenueMilestones.cpp"

TEST(RevenueMilestonesTest, description) {
    testing::internal::CaptureStdout();
    RevenueMilestones::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RevenueMilestonesTest, getMilestoneDays_1) {
    vector<int> expected{4, 6, 10};
    vector<int> revenues{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    vector<int> milestones{100, 200, 500};
    auto result = RevenueMilestones::getMilestoneDays(revenues, milestones);
    EXPECT_EQ(expected, result);
}

TEST(RevenueMilestonesTest, getMilestoneDays_2) {
    vector<int> expected{2, 4, 4, 5};
    vector<int> revenues{100, 200, 300, 400, 500};
    vector<int> milestones{300, 800, 1000, 1400};
    auto result = RevenueMilestones::getMilestoneDays(revenues, milestones);
    EXPECT_EQ(expected, result);
}

TEST(RevenueMilestonesTest, getMilestoneDays_3) {
    vector<int> expected{5, 4, 2, 3, 2};
    vector<int> revenues{700, 800, 600, 400, 600, 700};
    vector<int> milestones{3100, 2200, 800, 2100, 1000};
    auto result = RevenueMilestones::getMilestoneDays(revenues, milestones);
    EXPECT_EQ(expected, result);
}

#endif