#pragma clang diagnostic push
#pragma ide diagnostic ignored "cert-msc50-cpp"
#pragma ide diagnostic ignored "cert-msc51-cpp"

#include "StandardDeckOfCards.h"
#include <iostream>
#include <random>

using namespace ctci;

void StandardDeckOfCards::description() {
    std::cout << R"(Object Oriented Design: Standard Deck of Cards
    Design the data structures for a generic deck of cards.)" << std::endl;
}

StandardDeckOfCards::StandardDeckOfCards() {
    for (Suit suit = Suit::Hearts;
         suit != Suit::SuitEnd;
         suit = static_cast<Suit>(static_cast<int>(suit) + 1)) {
        for (Face faceValue = Face::Ace;
             faceValue != Face::FaceEnd;
             faceValue = static_cast<Face>(static_cast<int>(faceValue) + 1)) {
            this->deck.push_back(new Card(suit, faceValue));
        }
    }
};

void StandardDeckOfCards::shuffle() {
    srand(time(nullptr));
    // restore used cards to deck
    for (auto card: this->used) {
        this->deck.push_back(card);
    }
    this->used.clear();
    // shuffle all cards in deck
    for (auto max = (int) this->deck.size(); max > 0; max--) {
        auto index = (int) (rand() % max);
        auto pull = this->deck.at(index);
        this->deck.erase(this->deck.begin() + index);
        this->deck.push_back(pull);
    }
};

std::vector<Card *> StandardDeckOfCards::deal(int count) {
    std::vector<Card *> hand;
    if (count <= (int) this->deck.size()) {
        for (auto number = 0; number < count; number++) {
            auto pull = this->deck.at(0);
            this->deck.erase(this->deck.begin());
            this->used.push_back(pull);
            hand.push_back(pull);
        }
    }
    return hand;
};

void StandardDeckOfCards::addCards(int count, std::vector<Card *> &hand) {
    if (count <= (int) this->deck.size()) {
        for (auto number = 0; number < count; number++) {
            auto pull = this->deck.at(0);
            this->deck.erase(this->deck.begin());
            this->used.push_back(pull);
            hand.push_back(pull);
        }
    }
};
#pragma clang diagnostic pop