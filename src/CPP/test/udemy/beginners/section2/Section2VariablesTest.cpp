#ifndef UDEMY_BEGINNERS_2_VARIABLES_TEST
#define UDEMY_BEGINNERS_2_VARIABLES_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section2/Section2Variables.h"

TEST(Udemy_Section2VariablesTest, numAnimals) {
    auto expected = "Number of cats: 5\n"
                    "Number of dogs: 7\n"
                    "Total number of animals: 12\n"
                    "New dog acquired\n"
                    "Number of dogs: 8";
    auto result = Section2Variables::numAnimals();
    EXPECT_EQ(expected, result);
}

TEST(Udemy_Section2VariablesTest, numAnimalsOut) {
    auto expected = "Number of cats: 5\n"
                    "Number of dogs: 7\n"
                    "Total number of animals: 12\n"
                    "New dog acquired\n"
                    "Number of dogs: 8\n";
    testing::internal::CaptureStdout();
    Section2Variables::numAnimalsOut();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif