#ifndef CTCI_CH_7_OBJECT_ORIENTED_DESIGN_STANDARD_DECK_OF_CARDS_TEST
#define CTCI_CH_7_OBJECT_ORIENTED_DESIGN_STANDARD_DECK_OF_CARDS_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_7_Object_Oriented_Design/StandardDeckOfCards.h"

using namespace ctci;
TEST(CtCI_StandardDeckOfCardsTest, description) {
    testing::internal::CaptureStdout();
    StandardDeckOfCards::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_StandardDeckOfCardsTest, shuffle_1) {
    auto deck = StandardDeckOfCards();
    auto defaultHand = deck.deal(52);
    deck.shuffle();
    auto shuffledHand = deck.deal(52);
    EXPECT_NE(defaultHand, shuffledHand);
}

TEST(CtCI_StandardDeckOfCardsTest, deal_1) {
    auto deck = StandardDeckOfCards();
    auto hand1 = deck.deal(5);
    auto hand2 = deck.deal(5);
    EXPECT_NE(hand1, hand2);
}

TEST(CtCI_StandardDeckOfCardsTest, deal_2) {
    auto deck = StandardDeckOfCards();
    auto hand = deck.deal(53);
    EXPECT_EQ(0, hand.size());
}

TEST(CtCI_StandardDeckOfCardsTest, addCards_1) {
    auto count = 5;
    auto deck = StandardDeckOfCards();
    auto hand = deck.deal(count);
    deck.addCards(count, hand);
    EXPECT_EQ(count * 2, hand.size());
}

#endif