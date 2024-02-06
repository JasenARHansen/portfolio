#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_COMPRESSION
#define CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_COMPRESSION

#include <iostream>
#include <string>
#include <vector>
#include <bitset>
#include <algorithm>

using namespace std;

class StringCompression {
public:
    static void description();

    static string compress(const string &input);

    static string decompress(const string &input);
};

#endif
#pragma clang diagnostic pop