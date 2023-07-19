#ifndef TEST_UDEMY_BEGINNERS_2_VARIABLES_TEST
#define TEST_UDEMY_BEGINNERS_2_VARIABLES_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section2/Section2_variables.h"

TEST(Section2_variables_test, numAnimals_eq) {
    std::string expected = "Number of cats: 5\n"
                           "Number of dogs: 7\n"
                           "Total number of animals: 12\n"
                           "New dog acquired\n"
                           "Number of dogs: 8";
    auto result = Section2_variables::numAnimals();
    EXPECT_EQ(expected, result);
}

TEST(Section2_variables_test, numAnimals_neq) {
    std::string expected = "Cat";
    auto result = Section2_variables::numAnimals();
    EXPECT_NE(expected, result);
}

TEST(Section2_variables_test, numAnimals_out_eq) {
    std::string expected = "Number of cats: 5\n"
                           "Number of dogs: 7\n"
                           "Total number of animals: 12\n"
                           "New dog acquired\n"
                           "Number of dogs: 8\n";
    testing::internal::CaptureStdout();
    Section2_variables::numAnimals_out();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Section2_variables_test, numAnimals_out_neq) {
    std::string expected = "Cat";
    testing::internal::CaptureStdout();
    Section2_variables::numAnimals_out();
    EXPECT_NE(expected, testing::internal::GetCapturedStdout());
}

#endif