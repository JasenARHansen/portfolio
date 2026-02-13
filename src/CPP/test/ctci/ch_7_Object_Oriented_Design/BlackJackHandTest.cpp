#ifndef CTCI_CH_7_OBJECT_ORIENTED_DESIGN_BLACK_JACK_HAND_TEST
#define CTCI_CH_7_OBJECT_ORIENTED_DESIGN_BLACK_JACK_HAND_TEST

#include "gtest/gtest.h"
#include "../../../code/ctci/ch_7_Object_Oriented_Design/BlackJackHand.h"

using namespace ctci;
TEST(CtCI_BlackJackHandTest, description) {
    testing::internal::CaptureStdout();
    BlackJackHand::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CtCI_BlackJackHandTest, deal_1) {
    auto deck = BlackJackHand();
    deck.deal();
    auto result = deck.score();
    EXPECT_NE("", result);
}

#endif