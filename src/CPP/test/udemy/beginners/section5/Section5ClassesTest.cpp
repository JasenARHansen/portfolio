#ifndef UDEMY_BEGINNERS_5_CLASSES_TEST
#define UDEMY_BEGINNERS_5_CLASSES_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section5/Section5Classes.h"

TEST(Section5ClassesTest, newDelete) {
    auto expected = "Jasen";
    auto person = new Section5Classes(expected);
    auto result = person->getName();
    EXPECT_EQ(expected, result);
    EXPECT_NE(nullptr, person);
    delete person;
    person = nullptr;
    EXPECT_EQ(nullptr, person);
}

TEST(Section5ClassesTest, createObject) {
    auto expected = "Default";
    auto result = Section5Classes::createObject();
    EXPECT_EQ(expected, result->getName());
    Section5Classes::deleteObject(&result);
    EXPECT_EQ(nullptr, result);
}

TEST(Section5ClassesTest, createArray) {
    auto expected = "Default";
    auto size = 3;
    auto result = Section5Classes::createArray(size);
    for (int i = 0; i < size; i++) {
        EXPECT_EQ(expected, result[i].getName());
    }
    Section5Classes::deleteArray(&result);
    EXPECT_EQ(nullptr, result);
}

#endif