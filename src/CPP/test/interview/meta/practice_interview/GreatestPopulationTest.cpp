#ifndef INTERVIEW_META_PREPARATION_PRACTICE_INTERVIEW_GREATEST_POPULATION_TEST
#define INTERVIEW_META_PREPARATION_PRACTICE_INTERVIEW_GREATEST_POPULATION_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/practice_interview/GreatestPopulation.cpp"

TEST(GreatestPopulationTest, description) {
    testing::internal::CaptureStdout();
    GreatestPopulation::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(GreatestPopulationTest, averageByLevel_1) {
    int expected = 1803;
    vector<Person> people{{2000, 2010},
                          {1975, 2005},
                          {1975, 2003},
                          {1803, 1809},
                          {1750, 1869},
                          {1840, 1935},
                          {1803, 1921},
                          {1894, 1921}};
    auto result = GreatestPopulation::findGreatestPopulation(people);
    EXPECT_EQ(expected, result);
}

#endif