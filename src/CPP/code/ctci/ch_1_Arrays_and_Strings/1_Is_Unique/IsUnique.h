#ifndef PORTFOLIO_ISUNIQUE_H
#define PORTFOLIO_ISUNIQUE_H

#include <string>

using namespace std;

class ch1IsUnique {
public:
    static bool isUniqueChars(const string &str);

    static bool isUniqueCharsBitvector(const string &str);

    static bool isUniqueCharsNoDs(string str);

    static void test();
};

#endif