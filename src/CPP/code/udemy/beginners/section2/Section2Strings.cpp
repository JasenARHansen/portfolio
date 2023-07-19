#include "section2Strings.h"

string section2Strings::hello() {
    string text1 = "Hello ";
    string text2 = "Jasen";
    string text3 = text1 + text2;
    return text3;
}

void section2Strings::helloOut() {
    string text1 = "Hello ";
    string text2 = "Jasen";
    string text3 = text1 + text2;
    cout << text1 << text2 << std::endl;
    cout << text3 << std::endl;
}
