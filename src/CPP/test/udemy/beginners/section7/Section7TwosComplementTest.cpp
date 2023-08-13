#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef UDEMY_BEGINNERS_7_TWOS_COMPLEMENT_TEST
#define UDEMY_BEGINNERS_7_TWOS_COMPLEMENT_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section7/Section7TwosComplement.h"

TEST(Section7TwosComplementTest, performTwosComplement) {
    std::string expected_output = "input = 5 as bits: 00000000000000000000000000000101\n"
                           "1's Complement: 11111111111111111111111111111010\n"
                           "2's Complement: 11111111111111111111111111111011\n";
    int expected = -5;
    int input = expected * -1;
    testing::internal::CaptureStdout();
    int result = Section7TwosComplement::performTwosComplement(input);
    EXPECT_EQ(expected_output, testing::internal::GetCapturedStdout());
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop