#ifndef UDEMY_BEGINNERS_2_ARRAYS_TEST
#define UDEMY_BEGINNERS_2_ARRAYS_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section2/Section2Arrays.h"

TEST(Udemy_Section2ArraysTest, arrays) {
    auto expected = "Array with individual assignments\n"
                    "First array size: 12\n"
                    "First array element size: 4\n"
                    "First index 0 has a value of 7\n"
                    "First index 1 has a value of 0\n"
                    "First index 2 has a value of 3\n"
                    "Second index 0 has a value of 3\n"
                    "Second index 1 has a value of 0\n"
                    "Second index 2 has a value of 1\n"
                    "Third index 0 has a value of 1.100\n"
                    "Third index 1 has a value of 5.550\n"
                    "Third index 2 has a value of 1.000\n"
                    "Fourth array size: 64\n"
                    "Fourth array element size: 32\n"
                    "Fourth index 0 has a value of cat\n"
                    "Fourth index 1 has a value of dog\n"
                    "Fifth (partial initialization) index 0 has a value of first\n"
                    "Fifth (partial initialization) index 1 has a value of second\n"
                    "Fifth (partial initialization) index 2 has a value of \n"
                    "Character 0 is: h\n"
                    "Character 1 is: e\n"
                    "Character 2 is: l\n"
                    "Character 3 is: l\n"
                    "Character 4 is: o\n"
                    "hello\n";
    testing::internal::CaptureStdout();
    Section2Arrays::arrays();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Udemy_Section2ArraysTest, arraysMultiDimensional) {
    auto expected = "Animals array size: 192\n"
                    "Animals row size: 96\n"
                    "Animal size: 32\n"
                    "Animals Row 0: Fox Cat Dog\n"
                    "Animals Row 1: Mouse Squirrel Parrot\n";
    testing::internal::CaptureStdout();
    Section2Arrays::arraysMultiDimensional();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif