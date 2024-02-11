#ifndef UDEMY_BEGINNERS_5_POINTERS_TEST
#define UDEMY_BEGINNERS_5_POINTERS_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section5/Section5Pointers.h"

TEST(Udemy_Section5PointersTest, pointerDemo) {
    testing::internal::CaptureStdout();
    Section5Pointers::pointerDemo();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(Udemy_Section5PointersTest, doubleDouble) {
    auto output = "Retrieving the double value from pointer value: 1.234\n"
                  "The doubled value from pointer value: 2.468\n";
    auto result = 1.234;
    auto expected = result * 2;
    testing::internal::CaptureStdout();
    Section5Pointers::doubleDouble(&result);
    EXPECT_EQ(expected, result);
    EXPECT_EQ(output, testing::internal::GetCapturedStdout());
}

TEST(Udemy_Section5PointersTest, printAllString) {
    auto output = "First: first and Last: third\n"
                  "Using index counter\n"
                  "Element: 0 is: first\n"
                  "Element: 1 is: second\n"
                  "Element: 2 is: third\n"
                  "Using pString++\n"
                  "Element: 0 is: first\n"
                  "Element: 1 is: second\n"
                  "Element: 2 is: third\n";
    string source[]{"first", "second", "third"};
    int size = sizeof(source) / sizeof(source[0]);
    testing::internal::CaptureStdout();
    Section5Pointers::printAllString(size, source);
    EXPECT_EQ(output, testing::internal::GetCapturedStdout());
}

TEST(Udemy_Section5PointersTest, reverseCharArray) {
    char expected[]{'o', 'l', 'l', 'e', 'h'};
    char result[]{'h', 'e', 'l', 'l', 'o'};
    int size = sizeof(result) / sizeof(result[0]);
    Section5Pointers::reverseCharArray(size, result);
    for (auto i = 0; i < size; i++) {
        EXPECT_EQ(expected[i], result[i]);
    }
}

#endif