#ifndef CTCI_CH_3_STACKS_AND_QUEUES_ANIMAL_SHELTER_TEST
#define CTCI_CH_3_STACKS_AND_QUEUES_ANIMAL_SHELTER_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_3_Stacks_and_Queues/AnimalShelter.h"

TEST(AnimalShelterTest, description) {
    testing::internal::CaptureStdout();
    AnimalShelter::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(AnimalShelterTest, AnimalShelter_1) {
    auto cat1 = "Smokey";
    auto cat2 = "Bandit";
    auto dog = "Fred";
    auto shelter = AnimalShelter();
    EXPECT_TRUE(shelter.empty());
    EXPECT_TRUE(shelter.emptyCat());
    EXPECT_TRUE(shelter.emptyDog());
    EXPECT_EQ(0, shelter.size());
    EXPECT_EQ(0, shelter.sizeCat());
    EXPECT_EQ(0, shelter.sizeDog());
    shelter.enqueueCat(cat1);
    EXPECT_EQ(1, shelter.size());
    EXPECT_EQ(1, shelter.sizeCat());
    EXPECT_EQ(0, shelter.sizeDog());
    shelter.enqueueDog(dog);
    EXPECT_EQ(2, shelter.size());
    EXPECT_EQ(1, shelter.sizeCat());
    EXPECT_EQ(1, shelter.sizeDog());
    EXPECT_EQ(cat1, shelter.peekCat());
    EXPECT_EQ(dog, shelter.peekDog());
    EXPECT_EQ(cat1, shelter.peek());
    shelter.enqueueCat(cat2);
    EXPECT_EQ(3, shelter.size());
    EXPECT_EQ(2, shelter.sizeCat());
    EXPECT_EQ(1, shelter.sizeDog());
    EXPECT_EQ(cat1, shelter.peek());
    EXPECT_EQ(cat1, shelter.dequeue());
    EXPECT_EQ(2, shelter.size());
    EXPECT_EQ(1, shelter.sizeCat());
    EXPECT_EQ(1, shelter.sizeDog());
    EXPECT_EQ(cat2, shelter.dequeueCat());
    EXPECT_EQ(dog, shelter.dequeueDog());
}

#endif