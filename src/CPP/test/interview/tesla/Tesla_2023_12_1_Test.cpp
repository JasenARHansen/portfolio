#pragma clang diagnostic push
#pragma ide diagnostic ignored "cert-msc51-cpp"
#ifndef INTERVIEW_TESLA_2023_12_1_TEST
#define INTERVIEW_TESLA_2023_12_1_TEST

#include "gtest/gtest.h"
#include "../../../code/interview/tesla/Tesla_2023_12_1.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_Tesla_Interview_2023_12_1_Test, getReadingAtTime_1) {
    srand(time(nullptr));
    auto s = Sensor();
    auto reading = s.getReading();
    EXPECT_NE(0, reading);
    sleep(4);
    auto testTime = Time::now();
    sleep(6);
    auto readingInRange = s.getReadingAtTime(testTime);
    EXPECT_NE(0, readingInRange);
}

#endif
#pragma clang diagnostic pop