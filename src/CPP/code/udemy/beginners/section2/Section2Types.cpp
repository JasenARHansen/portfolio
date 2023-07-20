#include "Section2Types.h"

void section2Types::integerType() {
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

void section2Types::floatType() {
    float value = 123.456789;
    cout << "Float value: " << value << endl;
    cout << "Size of Float: " << sizeof(float) << endl;
    cout << "Float value precision: " << setprecision(20) << fixed << value << endl;
    double dValue = 123.456789;
    cout << "Double value: " << dValue << endl;
    cout << "Size of Double: " << sizeof(double) << endl;
    cout << "Double value precision: " << setprecision(20) << fixed << value << endl;
    long double lValue = 123.456789098765;
    cout << "Long Double value: " << lValue << endl;
    cout << "Size of Long Double: " << sizeof(long double) << endl;
    cout << "Long Double value precision: " << setprecision(20) << fixed << value << endl;
}

void section2Types::boolType() {
    bool trueValue = true;
    bool falseValue = false;
    cout << "Bool True value: " << trueValue << endl;
    cout << "Bool False value: " << falseValue << endl;
    cout << "Size of Bool: " << sizeof(bool) << endl;
}

void section2Types::charType() {
    char numberValue = 106;
    char characterValue = 'j';
    cout << "Char number value: " << (int) numberValue << endl;
    cout << "Char character value: " << characterValue << endl;
    cout << "Size of Char: " << sizeof(char) << endl;
}

void section2Types::wcharType() {
    wchar_t numberValue = 106;
    wchar_t characterValue = 'j';
    cout << "Wchar_t number value: " << (int) numberValue << endl;
    cout << "Wchar_t character value: " << (char) characterValue << endl;
    cout << "Size of Wchar_t: " << sizeof(wchar_t) << endl;
}
