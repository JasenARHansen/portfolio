#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef UDEMY_BEGINNERS_5_POINTERS_H
#define UDEMY_BEGINNERS_5_POINTERS_H

#include <string>
#include <iostream>

using namespace std;

class Section5Pointers {
private:

public:

    static void pointerDemo();

    static void doubleDouble(double *pValue);

    static void printAllString(int size, string *pString);

    static void reverseCharArray(int size, char *pChar);
};


#endif
#pragma clang diagnostic pop