#ifndef UDEMY_BEGINNERS_6_ENCAPSULATION_TEST
#define UDEMY_BEGINNERS_6_ENCAPSULATION_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section6/Section6Encapsulation.h"

TEST(Udemy_Section6EncapsulationTest, encapsulation) {
    string expected = "Info: name = Default";
    Section6Encapsulation base;
    auto result = base.getInfo();
    EXPECT_EQ(expected, result);
}

#endif