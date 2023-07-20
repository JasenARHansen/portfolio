#ifndef TEST_UDEMY_BEGINNERS_4_TEST
#define TEST_UDEMY_BEGINNERS_4_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section4/Section4Classes.h"

TEST(Section4ClassesTest, section4Classes) {
    string expected[] = {"Smokey",
                         "Hisssss",
                         "Meeeeow",
                         "Moving away."};
    section4Classes cat;
    cat.setName(expected[0]);
    EXPECT_EQ(expected[0], cat.getName());
    cat.setUnHappy();
    EXPECT_EQ(expected[1], cat.sound());
    cat.setHappy();
    EXPECT_EQ(expected[2], cat.sound());
    EXPECT_EQ(expected[3], cat.move());
}

TEST(Section4ClassesTest, Section4ClassesName) {
    string expected[] = {"Smokey",
                         "Hisssss",
                         "Meeeeow",
                         "Moving away."};
    section4Classes cat(expected[0]);
    EXPECT_EQ(expected[0], cat.getName());
    cat.setUnHappy();
    EXPECT_EQ(expected[1], cat.sound());
    cat.setHappy();
    EXPECT_EQ(expected[2], cat.sound());
    EXPECT_EQ(expected[3], cat.move());
}

#endif