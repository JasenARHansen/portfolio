#ifndef UDEMY_BEGINNERS_4_CLASSES_TEST
#define UDEMY_BEGINNERS_4_CLASSES_TEST

#include "gtest/gtest.h"
#include "../../../../code/udemy/beginners/section4/Section4Classes.h"

TEST(Udemy_Section4ClassesTest, constructor_1) {
    string expected[]{"Smokey",
                      "Hisssss",
                      "Meeeeow",
                      "Moving away."};
    Section4Classes cat;
    cat.setName(expected[0]);
    EXPECT_EQ(expected[0], cat.getName());
    cat.setUnHappy();
    EXPECT_EQ(expected[1], cat.sound());
    cat.setHappy();
    EXPECT_EQ(expected[2], cat.sound());
    EXPECT_EQ(expected[3], cat.move());
}

TEST(Udemy_Section4ClassesTest, constructor_2) {
    string expected[]{"Smokey",
                      "Hisssss",
                      "Meeeeow",
                      "Moving away."};
    Section4Classes cat(expected[0]);
    EXPECT_EQ(expected[0], cat.getName());
    cat.setUnHappy();
    EXPECT_EQ(expected[1], cat.sound());
    cat.setHappy();
    EXPECT_EQ(expected[2], cat.sound());
    EXPECT_EQ(expected[3], cat.move());
}

TEST(Udemy_Section4ClassesTest, constructor_3) {
    string expected[]{"Smokey",
                      "Hisssss",
                      "Meeeeow",
                      "Moving away."};
    auto age = 5;
    Section4Classes cat(expected[0], age);
    EXPECT_EQ(expected[0], cat.getName());
    EXPECT_EQ(age, cat.getAge());
    cat.setUnHappy();
    EXPECT_EQ(expected[1], cat.sound());
    cat.setHappy();
    EXPECT_EQ(expected[2], cat.sound());
    EXPECT_EQ(expected[3], cat.move());
}

#endif