#ifndef UDEMY_BEGINNERS_6_INHERITANCE_TEST
#define UDEMY_BEGINNERS_6_INHERITANCE_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section6/Section6Inheritance.h"

TEST(Section6InheritanceTest, Inheritance) {
    string expected[]{"Section6Base action.",
                         "Section6Inheritance action."};
    auto result1 = Section6Base::getAction();
    EXPECT_EQ(expected[0], result1);
    auto result2 = Section6SubClass::getAction();
    EXPECT_EQ(expected[0], result2);
    auto result3 = Section6Inheritance::getAction();
    EXPECT_EQ(expected[1], result3);
}

TEST(Section6InheritanceTest, constructors) {
    auto expected = 10;
    Section6Base section6Base(expected);
    auto result1 = section6Base.getId();
    EXPECT_EQ(expected, result1);
    Section6SubClass section6SubClass(expected);
    auto result2 = section6SubClass.getId();
    EXPECT_EQ(expected, result2);
    Section6Inheritance section6Inheritance(expected);
    auto result3 = section6Inheritance.getId();
    EXPECT_EQ(expected, result3);
}

#endif