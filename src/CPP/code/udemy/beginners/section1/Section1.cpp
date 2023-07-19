#include "Section1.h"

string Section1::hello() {
    return "!!! Hello there World!!!";
}

void Section1::hello_out_endl() {
    cout << "!!! Hello there World!!!" << std::endl;
}

void Section1::hello_out_flush() {
    cout << "!!! Hello there World!!!" << std::flush;
}

void Section1::fruit() {
    cout << "Banana. " << "Apple. " << "Orange." << std::flush;
}