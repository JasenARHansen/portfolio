#pragma clang diagnostic push
#pragma ide diagnostic ignored "cert-msc51-cpp"
#ifndef INTERVIEW_TESLA_2023_12_1_TEST
#define INTERVIEW_TESLA_2023_12_1_TEST

#include "gtest/gtest.h"
#include "../../../code/interview/tesla/Tesla_2023_12_1.cpp"  // NOLINT : Ignore .cpp import

TEST(Tesla_Interview_2023_12_1_Test, GetReadingAtTime_1) {
    srand(time(nullptr));
    auto s = Sensor();
    auto reading = s.GetReading();
    EXPECT_NE(0, reading);
    sleep(4);
    auto testTime = Time::now();
    sleep(6);
    auto readingInRange = s.GetReadingAtTime(testTime);
    EXPECT_NE(0, readingInRange);
}

#endif
#pragma clang diagnostic pop