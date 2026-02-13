#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"
#pragma ide diagnostic ignored "cert-msc50-cpp"
#pragma ide diagnostic ignored "cert-msc51-cpp"

#include "BlackJackHand.h"
#include <iostream>

using namespace ctci;

void BlackJackHand::description() {
    std::cout << R"(Object Oriented Design: BlackJack
    Design the data structures to implement BlackJack.)" << std::endl;
}

BlackJackHand::BlackJackHand() {
    this->deck = StandardDeckOfCards();
    this->firstAce = true;
};

void BlackJackHand::deal() {
    this->deck.shuffle();
    this->hand.clear();
    this->points = std::make_pair(0, 0);
    this->firstAce = true;
    hit();
    hit();
};

void BlackJackHand::hit() {
    this->hand.insert(this->hand.begin(), this->deck.deal(1).at(0));
    updateScore();
};

void BlackJackHand::updateScore() {
    auto face = this->hand.at(0)->faceValue;
    if ((face == Ace) && this->firstAce) {
        this->points.first += 10;
        this->firstAce = false;
    }
    if (face > 10) {
        this->points.first += 10;
        this->points.second += 10;
    } else {
        this->points.first += face;
        this->points.second += face;
    }
};

std::string BlackJackHand::score() {
    std::string result;
    auto min = std::min(this->points.first, this->points.first);
    auto max = std::max(this->points.first, this->points.first);
    if (min > 21) {
        result = "Busted!";
    } else if ((min == 21) || (max == 21)) {
        if (this->hand.size() == 2) {
            result = "BlackJack!";
        } else {
            result = "21";
        }
    }
    else{
        result.append("Your potential scores are: ");
        result += std::to_string(max);
        result.append(", ");
        result += std::to_string(min);
    }
    return result;
}

#pragma clang diagnostic pop