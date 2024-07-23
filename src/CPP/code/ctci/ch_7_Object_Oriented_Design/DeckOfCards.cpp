#include "DeckOfCards.h"
#include <iostream>
#include <random>

using namespace ctci;

void DeckOfCards::description() {
    std::cout << R"(Object Oriented Design: Deck of Cards
    Design the data structures for a generic deck of cards.
    Explain how you would subclass the data structures to implement BlackJack.)" << std::endl;
}

DeckOfCards::DeckOfCards(){
    for(Suit suit = Suit::Hearts;
        suit != Suit::Suit_End;
        suit = static_cast<Suit>(static_cast<int>(suit) + 1)) {
        for(Face faceValue = Face::Ace;
            faceValue != Face::Face_End;
            faceValue = static_cast<Face>(static_cast<int>(faceValue) + 1)) {
            this->deck.push_back(new Card(suit, faceValue));
        }
    }
};
void DeckOfCards::shuffle(){
    srand(time(nullptr));
    for (auto max = (int)this->deck.size(); max > 0; max--){
        auto index = (int) (rand() % max);
        auto pull = this->deck.at(index);
        this->deck.erase(this->deck.begin() + index);
        this->deck.push_back(pull);
        auto foo = 1;
    }
    auto foo2 = 1;
};
