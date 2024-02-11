#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_CHECK_PERMUTATION
#define CTCI_CH_1_ARRAYS_AND_STRINGS_CHECK_PERMUTATION

#include <string>

namespace ctci {
    class CheckPermutation {
    public:
        static void description();

        static bool isPermutation(std::string first, std::string second);

        static bool isPermutationCount(const std::string &first, const std::string &second);
    };
}
#endif
#pragma clang diagnostic pop