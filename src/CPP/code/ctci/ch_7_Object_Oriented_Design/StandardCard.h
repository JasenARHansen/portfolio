#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#pragma ide diagnostic ignored "OCUnusedStructInspection"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"
#ifndef CTCI_CH_7_OBJECT_ORIENTED_DESIGN_STANDARD_CARD
#define CTCI_CH_7_OBJECT_ORIENTED_DESIGN_STANDARD_CARD

#include <vector>

namespace ctci {
    enum Suit {
        Hearts = 1,
        Spades = 2,
        Diamonds = 3,
        Clubs = 4,
        SuitEnd
    };
    enum Face {
        Ace = 1,
        Duce = 2,
        Three = 3,
        Four = 4,
        Five = 5,
        Six = 6,
        Seven = 7,
        Eight = 8,
        Nine = 9,
        Ten = 10,
        Jack = 11,
        Queen = 12,
        King = 13,
        FaceEnd
    };

    struct Card {
        Suit suitType;
        Face faceValue;

        explicit Card(Suit suit, Face faceValue) : suitType(suit), faceValue(faceValue) {}
    };

}
#endif
#pragma clang diagnostic pop