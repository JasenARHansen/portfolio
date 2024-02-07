#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_CHECK_PERMUTATION
#define CTCI_CH_1_ARRAYS_AND_STRINGS_CHECK_PERMUTATION

#include <string>

using namespace std;

class CheckPermutation {
public:
    static void description();

    static bool isPermutation(string first, string second);

    static bool isPermutationCount(const string &first, const string &second);
};

#endif
#pragma clang diagnostic pop