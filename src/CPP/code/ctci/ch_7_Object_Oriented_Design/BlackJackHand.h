#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_7_OBJECT_ORIENTED_DESIGN_BLACK_JACK_HAND
#define CTCI_CH_7_OBJECT_ORIENTED_DESIGN_BLACK_JACK_HAND

#include "StandardDeckOfCards.h"
#include <vector>
#include <string>

namespace ctci {
    class BlackJackHand : public StandardDeckOfCards {
    public:
        static void description();

        BlackJackHand();

        void deal();

        void hit();

        std::string score();

    private:
        StandardDeckOfCards deck;

        std::vector<Card *> hand;

        bool firstAce;

        std::pair<int, int> points;

        void updateScore();
    };
}
#endif
#pragma clang diagnostic pop