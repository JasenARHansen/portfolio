#ifndef CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_PRIME_TEST
#define CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_PRIME_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_6_Math_and_Logic_Puzzles/Prime.h"
#include <vector>

using namespace ctci;
TEST(CtCI_PrimeTest, description) {
    testing::internal::CaptureStdout();
    Prime::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_PrimeTest, prime_1) {
    auto expected = true;
    auto value = 3;
    auto result = Prime::prime(value);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_PrimeTest, prime_2) {
    auto expected = false;
    auto value = 4;
    auto result = Prime::prime(value);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_PrimeTest, prime_3) {
    auto expected = false;
    auto value = 100;
    auto result = Prime::prime(value);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_PrimeTest, prime_4) {
    auto expected = true;
    auto value = 97;
    auto result = Prime::prime(value);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_PrimeTest, prime_5) {
    auto expected = false;
    auto value = 91;
    auto result = Prime::prime(value);
    EXPECT_EQ(expected, result);
}

#endif