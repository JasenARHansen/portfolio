#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef TEST_UDEMY_BEGINNERS_6_INHERITANCE_TEST
#define TEST_UDEMY_BEGINNERS_6_INHERITANCE_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section6/Section6Inheritance.h"

TEST(Section6InheritanceTest, Inheritance) {
    string expected[] = {"Section6Base action.",
                         "Section6Inheritance action."};
    auto result_1 = Section6Base::getAction();
    EXPECT_EQ(expected[0], result_1);
    auto result_2 = Section6SubClass::getAction();
    EXPECT_EQ(expected[0], result_2);
    auto result_3 = Section6Inheritance::getAction();
    EXPECT_EQ(expected[1], result_3);
}

TEST(Section6InheritanceTest, constructors) {
    int expected = 10;
    Section6Base section6Base(expected);
    auto result_1 = section6Base.getId();
    EXPECT_EQ(expected, result_1);
    Section6SubClass section6SubClass(expected);
    auto result_2 = section6SubClass.getId();
    EXPECT_EQ(expected, result_2);
    Section6Inheritance section6Inheritance(expected);
    auto result_3 = section6Inheritance.getId();
    EXPECT_EQ(expected, result_3);
}

#endif
#pragma clang diagnostic pop