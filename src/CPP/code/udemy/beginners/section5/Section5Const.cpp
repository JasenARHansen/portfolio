#include "Section5Const.h"

void Section5Const::setName(const string &input) {
    this->name = input;
}

const string &Section5Const::getName() {
    return this->name;
}
