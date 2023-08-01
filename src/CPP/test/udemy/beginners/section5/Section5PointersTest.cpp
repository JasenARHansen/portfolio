#ifndef TEST_UDEMY_BEGINNERS_5_POINTERS_TEST
#define TEST_UDEMY_BEGINNERS_5_POINTERS_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section5/Section5Pointers.h"

TEST(Section5PointersTest, demo) {
    Section5Pointers::pointerDemo();
}

TEST(Section5PointersTest, doubleDouble) {
    double result = 1.234;
    double expected = result * 2;
    Section5Pointers::doubleDouble(&result);
    EXPECT_EQ(expected, result);
}

TEST(Section5PointersTest, printAllString) {
    string source[] = {"first", "second", "third"};
    int size = sizeof(source) / sizeof(source[0]);
    Section5Pointers::printAllString(size, source);
}

TEST(Section5PointersTest, reverseCharArray) {
    char expected[] = {'o', 'l', 'l', 'e', 'h'};
    char result[] = {'h', 'e', 'l', 'l', 'o'};
    int size = sizeof(result) / sizeof(result[0]);
    Section5Pointers::reverseCharArray(size, result);
    for (int i = 0; i < size; i++) {
        EXPECT_EQ(expected[i], result[i]);
    }
}

#endif