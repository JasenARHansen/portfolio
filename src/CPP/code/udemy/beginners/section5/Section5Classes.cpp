#include "Section5Classes.h"

#include <utility>

Section5Classes::Section5Classes() {
    this->name = "Default";
}

Section5Classes::Section5Classes(string name) : name(std::move(name)) {}

Section5Classes::~Section5Classes() = default;

const string &Section5Classes::getName() const {
    return this->name;
}

Section5Classes *Section5Classes::createObject() {
    return new Section5Classes();
}

Section5Classes *Section5Classes::createArray(const int size) {
    return new Section5Classes[size];
}

void Section5Classes::deleteObject(Section5Classes **pClasses) {
    delete *pClasses;
    *pClasses = nullptr;
}

void Section5Classes::deleteArray(Section5Classes **pClasses) {
    delete[] *pClasses;
    *pClasses = nullptr;
}
