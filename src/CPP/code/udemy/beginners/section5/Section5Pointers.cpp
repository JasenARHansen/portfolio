#include "Section5Pointers.h"
#include <iostream>

void Section5Pointers::pointerDemo() {
    int value = 10;
    int *pnValue = &value;
    cout << "Int value: " << value << endl;
    cout << "Int pointer value: " << pnValue << endl;
    cout << "Retrieving the int value from pointer value: " << *pnValue << endl;
}

void Section5Pointers::doubleDouble(double *pValue) {
    cout << "Retrieving the double value from pointer value: " << *pValue << endl;
    *pValue *= 2;
    cout << "The doubled value from pointer value: " << *pValue << endl;
}

void Section5Pointers::printAllString(const int size, string *pString) {
    string *first = pString;
    string *last = &(pString[size - 1]);
    cout << "First: " << *first << " and Last: " << *last << endl;
    cout << "Using index counter" << endl;
    for (auto i = 0; i < size; i++) {
        cout << "Element: " << i << " is: " << pString[i] << endl;
    }
    cout << "Using pString++" << endl;
    for (auto i = 0; i < size; i++, pString++) {
        cout << "Element: " << i << " is: " << *pString << endl;
    }
}

void Section5Pointers::reverseCharArray(const int size, char *pChar) {
    char *left = pChar;
    char *right = &(pChar[size - 1]);
    char swap;
    while (left < right) {
        swap = *left;
        *left = *right;
        *right = swap;
        left++;
        right--;
    }
}