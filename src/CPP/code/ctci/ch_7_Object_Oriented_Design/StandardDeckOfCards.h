#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_7_OBJECT_ORIENTED_DESIGN_STANDARD_DECK_OF_CARDS
#define CTCI_CH_7_OBJECT_ORIENTED_DESIGN_STANDARD_DECK_OF_CARDS

#include "StandardCard.h"
#include <vector>

namespace ctci {
    class StandardDeckOfCards {
    public:
        static void description();

        StandardDeckOfCards();

        void shuffle();

        std::vector<Card *> deal(int count);

        void addCards(int count, std::vector<Card *> &hand);

    private:
        std::vector<Card *> used;
    protected:
        std::vector<Card *> deck;
    };
}
#endif
#pragma clang diagnostic pop