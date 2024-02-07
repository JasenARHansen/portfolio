#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_URLIFY
#define CTCI_CH_1_ARRAYS_AND_STRINGS_URLIFY

#include <string>

using namespace std;

class URLify {
public:
    static void description();

    static string urlify(const string &input);

    static void urlifyInPlace(string *input);
};

#pragma clang diagnostic pop
#endif