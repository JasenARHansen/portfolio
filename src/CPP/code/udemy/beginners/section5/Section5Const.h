#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef PORTFOLIO_SECTION_5_CONST_H
#define PORTFOLIO_SECTION_5_CONST_H

#include <string>
#include <iostream>

using namespace std;

class Section5Const {
private:
    string name;

public:
    [[nodiscard]] const string &getName();

    void setName(const string &name);
};


#endif
#pragma clang diagnostic pop