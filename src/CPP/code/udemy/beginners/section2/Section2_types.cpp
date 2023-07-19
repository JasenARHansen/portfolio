#include "Section2_types.h"

void Section2_types::integerType() {
    int value = 1234;
    cout << "Int value: " << value << endl;
    cout << "Size of Int: " << sizeof(int) << endl;

    cout << "Max in value is: " << INT_MAX << endl;
    cout << "Min in value is: " << INT_MIN << endl;

    long int lValue = 123456789;
    cout << "Long Int value: " << lValue << endl;
    cout << "Size of Long Int: " << sizeof(long int) << endl;

    short int sValue = 123;
    cout << "Short Int value: " << sValue << endl;
    cout << "Size of Short Int: " << sizeof(short int) << endl;


    unsigned int uValue = 123456789;
    cout << "Unsigned Int value: " << uValue << endl;
    cout << "Size of Short Unsigned Int: " << sizeof(unsigned int) << endl;
}

