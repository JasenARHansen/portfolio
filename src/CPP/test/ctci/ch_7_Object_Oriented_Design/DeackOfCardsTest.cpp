#ifndef CTCI_CH_7_OBJECT_ORIENTED_DESIGN_DECK_OF_CARDS_TEST
#define CTCI_CH_7_OBJECT_ORIENTED_DESIGN_DECK_OF_CARDS_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_7_Object_Oriented_Design/DeckOfCards.h"

using namespace ctci;
TEST(CtCI_DeckOfCardsTest, description) {
    testing::internal::CaptureStdout();
    DeckOfCards::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_DeckOfCardsTest, findProbabilityOfCollision_1) {

    auto deck = DeckOfCards();
    deck.shuffle();
    //auto result = DeckOfCards::findProbabilityOfCollision(vertexes);
    //EXPECT_EQ(expected, result);
}


#endif