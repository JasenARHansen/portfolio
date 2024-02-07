#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_ROTATION
#define CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_ROTATION

#include <string>

using namespace std;

class StringRotation {
public:
    static void description();

    static string rotate(const string &input, int spaces);

    static bool isRotation(const string &s1, const string &s2);
};

#pragma clang diagnostic pop
#endif