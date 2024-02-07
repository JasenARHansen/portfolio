#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef UDEMY_BEGINNERS_6_ENCAPSULATION_H
#define UDEMY_BEGINNERS_6_ENCAPSULATION_H

#include <string>

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