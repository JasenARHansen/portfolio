#include "Section4Classes.h"

Section4Classes::Section4Classes() {
    this->mood = true;
    this->name = "Unnamed";
    this->age = 0;
}

Section4Classes::Section4Classes(const string &name) {
    this->mood = true;
    this->name = name;
    this->age = 0;
}

Section4Classes::Section4Classes(string name, const int age) : name(std::move(name)), age(age), mood(true) {}

Section4Classes::~Section4Classes() = default;

string Section4Classes::sound() const {
    if (this->mood) {
        return "Meeeeow";
    } else {
        return "Hisssss";
    }
}

string Section4Classes::move() {
    return "Moving away.";
}

void Section4Classes::setHappy() {
    this->mood = true;
}

void Section4Classes::setUnHappy() {
    this->mood = false;
}

const string &Section4Classes::getName() const {
    return this->name;
}

void Section4Classes::setName(const string &input) {
    this->name = input;
}

int Section4Classes::getAge() const {
    return this->age;
}
