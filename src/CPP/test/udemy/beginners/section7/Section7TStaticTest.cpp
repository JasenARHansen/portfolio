#ifndef UDEMY_BEGINNERS_7_STATIC_TEST
#define UDEMY_BEGINNERS_7_STATIC_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section7/Section7Static.h"

TEST(Udemy_Section7StaticTest, MAXIMUM) {
    auto expected = 100;
    auto result = Section7Static::MAXIMUM;
    EXPECT_EQ(expected, result);
}

TEST(Udemy_Section7StaticTest, getCount) {
    auto expected = 0;
    auto result = Section7Static::getCount();
    EXPECT_EQ(expected, result);
    expected = 1;
    Section7Static();
    result = Section7Static::getCount();
    EXPECT_EQ(expected, result);
    result = Section7Static::getCount();
    EXPECT_EQ(expected, result);
    expected = 2;
    Section7Static();
    result = Section7Static::getCount();
    EXPECT_EQ(expected, result);
}

#endif