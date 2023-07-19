#ifndef TEST_UDEMY_BEGINNERS_2_TYPES_TEST
#define TEST_UDEMY_BEGINNERS_2_TYPES_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section2/Section2_types.h"

TEST(Section2_types_test, limits_eq) {
    std::string expected = "Int value: 1234\n"
                           "Size of Int: 4\n"
                           "Max in value is: 2147483647\n"
                           "Min in value is: -2147483648\n"
                           "Long Int value: 123456789\n"
                           "Size of Long Int: 4\n"
                           "Short Int value: 123\n"
                           "Size of Short Int: 2\n"
                           "Unsigned Int value: 123456789\n"
                           "Size of Short Unsigned Int: 4\n";
    testing::internal::CaptureStdout();
    Section2_types::integerType();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif