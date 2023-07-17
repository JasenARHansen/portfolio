#ifndef CTCI_CH_1_IS_UNIQUE_H
#define CTCI_CH_1_IS_UNIQUE_H

#pragma once

#include <string>

using namespace std;

class Ch1_isUnique {
public:
    static bool isUniqueChars(const string &str);

    static bool isUniqueChars_bitvector(const string &str);

    static bool isUniqueChars_noDS(string str);

    static void test();
};

#endif