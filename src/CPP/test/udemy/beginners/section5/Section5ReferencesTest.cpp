#ifndef UDEMY_BEGINNERS_5_REFERENCES_TEST
#define UDEMY_BEGINNERS_5_REFERENCES_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section5/Section5References.h"

TEST(Section5ReferencesTest, reassign) {
    int result = 5;
    int expected = 10;
    Section5References::reassign(result, expected);
    EXPECT_EQ(expected, result);
}



#endif