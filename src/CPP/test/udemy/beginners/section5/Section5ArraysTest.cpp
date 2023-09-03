#ifndef UDEMY_BEGINNERS_5_ARRAYS_TEST
#define UDEMY_BEGINNERS_5_ARRAYS_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section5/Section5Arrays.h"

TEST(Section5ArraysTest, incrementArrayPointer) {
    int expected[]{2, 3, 4};
    int result[]{1, 2, 3};
    int size = sizeof(result) / sizeof(result[0]);
    Section5Arrays::incrementArrayPointer(size, result);
    for (auto i = 0; i < size; i++) {
        EXPECT_EQ(expected[i], result[i]);
    }
}

#endif