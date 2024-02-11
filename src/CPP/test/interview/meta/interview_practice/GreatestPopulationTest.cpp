#ifndef INTERVIEW_META_PREPARATION_INTERVIEW_PRACTICE_GREATEST_POPULATION_TEST
#define INTERVIEW_META_PREPARATION_INTERVIEW_PRACTICE_GREATEST_POPULATION_TEST

#include "gtest/gtest.h"
#include "../../../../code/interview/meta/interview_practice/GreatestPopulation.cpp"  // NOLINT : Ignore .cpp import

TEST(Interview_GreatestPopulationTest, description) {
    testing::internal::CaptureStdout();
    GreatestPopulation::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Interview_GreatestPopulationTest, findGreatestPopulation_1) {
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