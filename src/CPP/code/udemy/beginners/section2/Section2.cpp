#include "Section2.h"

string Section2::hello() {
    return "!!! Hello there World!!!";
}

void Section2::hello_out_endl() {
    cout << "!!! Hello there World!!!" << std::endl;
}

void Section2::hello_out_flush() {
    cout << "!!! Hello there World!!!" << std::flush;
}

void Section2::fruit() {
    cout << "Banana. " << "Apple. " << "Orange." << std::flush;
}