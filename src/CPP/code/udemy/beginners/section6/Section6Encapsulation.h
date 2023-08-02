#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef PORTFOLIO_SECTION_6_ENCAPSULATION_H
#define PORTFOLIO_SECTION_6_ENCAPSULATION_H

#include <string>
#include <iostream>

using namespace std;


class Section6Encapsulation {
private:
    string name;

    [[nodiscard]] const string &getName() const;

public:

    Section6Encapsulation();

    string getInfo();

};


#endif
#pragma clang diagnostic pop