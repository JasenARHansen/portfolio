#ifndef INTERVIEW_TESLA_2023_12_1_TEST
#define INTERVIEW_TESLA_2023_12_1_TEST

#include "gtest/gtest.h"
#include "../../../code/interview/tesla/Tesla_2023_12_1.cpp"  // NOLINT : Ignore .cpp import

TEST(Tesla_Interview_2023_12_1_Test, description) {
    testing::internal::CaptureStdout();
    Tesla_Interview_2023_12_1::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Tesla_Interview_2023_12_1_Test, Box_1) {

}


#endif