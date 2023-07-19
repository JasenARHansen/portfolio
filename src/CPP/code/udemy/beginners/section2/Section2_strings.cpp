#include "Section2_strings.h"

string Section2_strings::hello() {
    string text1 = "Hello ";
    string text2 = "Jasen";
    string text3 = text1 + text2;
    return text3;
}

void Section2_strings::hello_out() {
    string text1 = "Hello ";
    string text2 = "Jasen";
    string text3 = text1 + text2;
    cout << text1 << text2 << std::endl;
    cout << text3 << std::endl;
}
