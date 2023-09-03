#ifndef UDEMY_BEGINNERS_5_CONST_TEST
#define UDEMY_BEGINNERS_5_CONST_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section5/Section5Const.h"

TEST(Section5ConstTest, reassign) {
    auto expected = "Jasen";
    Section5Const person;
    person.setName(expected);
    auto result = person.getName();
    EXPECT_EQ(expected, result);
}

#endif