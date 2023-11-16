#ifndef INTERVIEW_AMAZON_INTERVIEW_2023_11_16_INTERVIEW_2_TEST
#define INTERVIEW_AMAZON_INTERVIEW_2023_11_26_INTERVIEW_2_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/amazon/interview_2023_11_16/Interview2.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview1Test, description) {
    testing::internal::CaptureStdout();
    Interview1::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview1Test, clone_1) {

}

#endif