#include "Section1.h"

string Section1::hello() {
    return "!!! Hello there World!!!";
}

void Section1::helloOutEndl() {
    cout << "!!! Hello there World!!!" << std::endl;
}

void Section1::helloOutFlush() {
    cout << "!!! Hello there World!!!" << std::flush;
}

void Section1::fruit() {
    cout << "Banana. " << "Apple. " << "Orange." << std::flush;
}