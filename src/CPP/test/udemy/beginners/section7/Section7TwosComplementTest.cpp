#ifndef UDEMY_BEGINNERS_7_TWOS_COMPLEMENT_TEST
#define UDEMY_BEGINNERS_7_TWOS_COMPLEMENT_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section7/Section7TwosComplement.h"

TEST(Udemy_Section7TwosComplementTest, performTwosComplement) {
    auto expectedOutput = "input = 5 as bits: 00000000000000000000000000000101\n"
                          "1's Complement: 11111111111111111111111111111010\n"
                          "2's Complement: 11111111111111111111111111111011\n";
    auto expected = -5;
    auto input = expected * -1;
    testing::internal::CaptureStdout();
    auto result = Section7TwosComplement::performTwosComplement(input);
    EXPECT_EQ(expectedOutput, testing::internal::GetCapturedStdout());
    EXPECT_EQ(expected, result);
}

#endif