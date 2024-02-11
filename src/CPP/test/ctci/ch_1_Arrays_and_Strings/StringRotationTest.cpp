#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_ROTATION_TEST
#define CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_ROTATION_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_1_Arrays_and_Strings/StringRotation.h"

using namespace ctci;
TEST(CtCI_StringRotationTest, description) {
    testing::internal::CaptureStdout();
    StringRotation::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_StringRotationTest, isRotation_1) {
    auto expected = true;
    auto s1 = "waterbottle";
    auto s2 = "erbottlewat";
    auto result = StringRotation::isRotation(s1, s2);
    EXPECT_EQ(expected, result);
}

TEST(CtCI_StringRotationTest, rotate_1) {
    auto expected = "erbottlewat";
    auto s1 = "waterbottle";
    auto spaces = 3;
    auto result = StringRotation::rotate(s1, spaces);
    EXPECT_EQ(expected, result);
}

#endif