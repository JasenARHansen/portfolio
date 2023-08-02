#include "Section6Encapsulation.h"

const string &Section6Encapsulation::getName() const {
    return this->name;
}

Section6Encapsulation::Section6Encapsulation() {
    this->name = "Default";
}

string Section6Encapsulation::getInfo() {
    return "Info: name = " + getName();
}