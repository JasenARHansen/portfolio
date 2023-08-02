#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef TEST_UDEMY_BEGINNERS_6_ENCAPSULATION_TEST
#define TEST_UDEMY_BEGINNERS_6_ENCAPSULATION_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section6/Section6Encapsulation.h"

TEST(Section6EncapsulationTest, Encapsulation) {
    string expected = "Info: name = Default";
    Section6Encapsulation base;
    auto result = base.getInfo();
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop