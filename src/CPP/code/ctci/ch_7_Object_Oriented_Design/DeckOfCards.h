#pragma clang diagnostic push
#ifndef CTCI_CH_7_OBJECT_ORIENTED_DESIGN_DECK_OF_CARDS
#define CTCI_CH_7_OBJECT_ORIENTED_DESIGN_DECK_OF_CARDS

#include <vector>

namespace ctci {
    class DeckOfCards {
    private:
        enum Suit {
            Hearts = 1,
            Spades = 2,
            Diamonds = 3,
            Clubs = 4,
            Suit_End
        };
        enum Face {
            Ace = 1,
            Duce = 2,
            Three = 3,
            Four = 4,
            Five = 5,
            Six = 6,
            Seven=7,
            Eight=8,
            Nine=9,
            Ten=10,
            Jack=11,
            Queen=12,
            King=13,
            Face_End
        };

        struct Card {
            Suit suit;
            Face faceValue;

            explicit Card(Suit suit, Face faceValue) : suit(suit), faceValue(faceValue) {}
        };

    public:
        static void description();

        DeckOfCards();
        void shuffle();
    private:
        std::vector<Card*> deck;
    };
}
#endif
#pragma clang diagnostic pop