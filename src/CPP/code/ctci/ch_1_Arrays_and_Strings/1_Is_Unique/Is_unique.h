#ifndef CTCI_CH_1_IS_UNIQUE
#define CTCI_CH_1_IS_UNIQUE

#include <string>
#include <vector>
#include <iostream>
#include <bitset>
#include <algorithm> // for sort() 

using namespace std;
#pragma once

class ch1_isUnique {
public:
    static bool isUniqueChars(const string &str);

    static bool isUniqueChars_bitvector(const string &str);

    static bool isUniqueChars_noDS(string str);

    int main();
};

#endif