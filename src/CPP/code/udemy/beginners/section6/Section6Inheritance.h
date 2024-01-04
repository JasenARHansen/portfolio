#pragma clang diagnostic push
#pragma ide diagnostic ignored "HidingNonVirtualFunction"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef UDEMY_BEGINNERS_6_INHERITANCE_H
#define UDEMY_BEGINNERS_6_INHERITANCE_H

#include <string>
#include <iostream>

using namespace std;

class Section6Base {
private:
    int id;
public:
    explicit Section6Base(int id);

    static string getAction();

    [[nodiscard]] int getId() const;
};

class Section6SubClass : public Section6Base {
public:
    explicit Section6SubClass(int id);

    int getId();
};

class Section6Inheritance : public Section6SubClass {
public:
    explicit Section6Inheritance(int id);

    static string getAction();

    int getId();
};

#endif
#pragma clang diagnostic pop