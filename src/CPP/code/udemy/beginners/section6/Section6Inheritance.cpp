#include "Section6Inheritance.h"

Section6Base::Section6Base(int id) : id(id) {}

string Section6Base::getAction() {
    return "Section6Base action.";
}

int Section6Base::getId() const {
    return this->id;
}

Section6SubClass::Section6SubClass(int id) : Section6Base(id) {}

int Section6SubClass::getId() {
    return Section6Base::getId();
}

Section6Inheritance::Section6Inheritance(int id) : Section6SubClass(id) {}

string Section6Inheritance::getAction() {
    return "Section6Inheritance action.";
}

int Section6Inheritance::getId() {
    return Section6SubClass::getId();
}
