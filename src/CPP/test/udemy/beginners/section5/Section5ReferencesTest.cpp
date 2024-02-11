#ifndef UDEMY_BEGINNERS_5_REFERENCES_TEST
#define UDEMY_BEGINNERS_5_REFERENCES_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section5/Section5References.h"

TEST(Udemy_Section5ReferencesTest, reassign) {
    auto result = 5;
    auto expected = 10;
    Section5References::reassign(result, expected);
    EXPECT_EQ(expected, result);
}

#endif