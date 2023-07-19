#ifndef TEST_UDEMY_BEGINNERS_2_VARIABLES_TEST
#define TEST_UDEMY_BEGINNERS_2_VARIABLES_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section2/section2Variables.h"

TEST(Section2_variables_test, numAnimals) {
    std::string expected = "Number of cats: 5\n"
                           "Number of dogs: 7\n"
                           "Total number of animals: 12\n"
                           "New dog acquired\n"
                           "Number of dogs: 8";
    auto result = section2Variables::numAnimals();
    EXPECT_EQ(expected, result);
}

TEST(Section2_variables_test, numAnimalsOut) {
    std::string expected = "Number of cats: 5\n"
                           "Number of dogs: 7\n"
                           "Total number of animals: 12\n"
                           "New dog acquired\n"
                           "Number of dogs: 8\n";
    testing::internal::CaptureStdout();
    section2Variables::numAnimalsOut();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif