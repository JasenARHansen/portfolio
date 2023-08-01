#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef PORTFOLIO_SECTION_5_CLASSES_H
#define PORTFOLIO_SECTION_5_CLASSES_H

#include <string>
#include <iostream>

using namespace std;

class Section5Classes {
private:
    string name;

public:
    Section5Classes();

    explicit Section5Classes(string name);

    ~Section5Classes();

    [[nodiscard]] const string &getName() const;

    static Section5Classes *createObject();

    static Section5Classes *createArray(int size);

    static void deleteObject(Section5Classes **pClasses);

    static void deleteArray(Section5Classes **pClasses);
};


#endif
#pragma clang diagnostic pop