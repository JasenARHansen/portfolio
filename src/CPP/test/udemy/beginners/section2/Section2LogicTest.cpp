#ifndef UDEMY_BEGINNERS_2_LOGIC_TEST
#define UDEMY_BEGINNERS_2_LOGIC_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section2/Section2Logic.h"

TEST(Udemy_Section2LogicTest, conditions) {
    auto expected = "Condition 1 true.\n"
                    "Condition 2 false.\n"
                    "Condition 3 true.\n"
                    "Condition 4 true.\n"
                    "Condition 5 true.\n"
                    "Condition 6 0\n"
                    "Condition 7 1\n"
                    "Condition 8 true.\n";
    testing::internal::CaptureStdout();
    Section2Logic::conditions();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Udemy_Section2LogicTest, whileLoop) {
    auto expected = "Infinite while loop with break.\n"
                    "Infinite while loop over.\n"
                    "While loop execution 1\n"
                    "While loop execution 2\n"
                    "While loop execution 3\n"
                    "While loop over.\n";
    testing::internal::CaptureStdout();
    Section2Logic::whileLoop();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Udemy_Section2LogicTest, doWhileLoop) {
    auto expected = "Do while loop with condition already met\n"
                    "Do while loop execution 1\n"
                    "Do while loop execution 2\n"
                    "Do while loop execution 3\n";
    testing::internal::CaptureStdout();
    Section2Logic::doWhileLoop();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

TEST(Udemy_Section2LogicTest, forLoop) {
    auto expected = "For loop no inputs with a break\n"
                    "For loop with a break, only counter defined execution 0\n"
                    "For loop increment in loop execution 1\n"
                    "For loop increment in loop execution 2\n"
                    "For loop increment in loop execution 3\n"
                    "For loop fully defined execution 0\n"
                    "For loop fully defined execution 1\n"
                    "For loop fully defined execution 2\n"
                    "For loop mod 2 continue execution 0\n"
                    "For loop mod 2 continue execution 2\n"
                    "For loop mod 2 break execution 0\n";
    testing::internal::CaptureStdout();
    Section2Logic::forLoop();
    EXPECT_EQ(expected, testing::internal::GetCapturedStdout());
}

#endif