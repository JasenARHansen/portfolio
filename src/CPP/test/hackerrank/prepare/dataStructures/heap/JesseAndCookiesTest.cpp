#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_HEAP_JESSE_AND_COOKIES_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_HEAP_JESSE_AND_COOKIES_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/heap/JesseAndCookies.cpp"  // NOLINT : Ignore .cpp import

TEST(JesseAndCookiesTest, description) {
    testing::internal::CaptureStdout();
    JesseAndCookies::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(JesseAndCookiesTest, cookies_1) {
    int expected = 4;
    auto k = 9;
    vector<int> a{2, 7, 3, 6, 4, 6};
    auto result = JesseAndCookies::cookies(k, a);
    EXPECT_EQ(expected, result);
}

TEST(JesseAndCookiesTest, cookies_2) {
    int expected = 2;
    auto k = 7;
    vector<int> a{1, 2, 3, 9, 10, 12};
    auto result = JesseAndCookies::cookies(k, a);
    EXPECT_EQ(expected, result);
}

#endif