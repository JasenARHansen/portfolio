#include "Section4Classes.h"


section4Classes::section4Classes() {
    this->mood = true;
    this->name = "Unnamed";
}

section4Classes::section4Classes(const string &input) {
    this->mood = true;
    this->name = input;
}

section4Classes::~section4Classes() = default;

string section4Classes::sound() const {
    if (this->mood) {
        return "Meeeeow";
    } else {
        return "Hisssss";
    }
}

string section4Classes::move() {
    return "Moving away.";
}


void section4Classes::setHappy() {
    this->mood = true;
}

void section4Classes::setUnHappy() {
    this->mood = false;
}

const string &section4Classes::getName() const {
    return this->name;
}

void section4Classes::setName(const string &input) {
    this->name = input;
}
