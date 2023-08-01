#ifndef TEST_UDEMY_BEGINNERS_5_CONST_TEST
#define TEST_UDEMY_BEGINNERS_5_CONST_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section5/Section5Const.h"

TEST(Section5ConstTest, reassign) {
    string expected = "Jasen";
    Section5Const person;
    person.setName(expected);
    string result = person.getName();
    EXPECT_EQ(expected, result);
}


#endif