#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef UDEMY_BEGINNERS_7_STATIC_H
#define UDEMY_BEGINNERS_7_STATIC_H

#include <bitset>
#include <iostream>

using namespace std;

class Section7Static {

private:

    static int count;

public:

    static const int MAXIMUM = 100;

    Section7Static();

    static int getCount();

};

#endif
#pragma clang diagnostic pop