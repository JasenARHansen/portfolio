#pragma clang diagnostic push
#pragma ide diagnostic ignored "UnusedLocalVariable"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef UDEMY_BEGINNERS_7_STATIC_TEST
#define UDEMY_BEGINNERS_7_STATIC_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section7/Section7Static.h"

TEST(Section7StaticTest, MAXIMUM) {
    int expected = 100;
    int result = Section7Static::MAXIMUM;
    EXPECT_EQ(expected, result);
}

TEST(Section7StaticTest, count) {
    int expected = 0;
    int result = Section7Static::getCount();
    EXPECT_EQ(expected, result);
    expected = 1;
    Section7Static first;
    result = Section7Static::getCount();
    EXPECT_EQ(expected, result);
    result = Section7Static::getCount();
    EXPECT_EQ(expected, result);
    expected = 2;
    Section7Static second;
    result = Section7Static::getCount();
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop