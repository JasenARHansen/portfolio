#include "section1.h"

string section1::hello() {
    return "!!! Hello there World!!!";
}

void section1::helloOutEndl() {
    cout << "!!! Hello there World!!!" << std::endl;
}

void section1::helloOutFlush() {
    cout << "!!! Hello there World!!!" << std::flush;
}

void section1::fruit() {
    cout << "Banana. " << "Apple. " << "Orange." << std::flush;
}