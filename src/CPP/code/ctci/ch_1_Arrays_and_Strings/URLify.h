#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_URLIFY
#define CTCI_CH_1_ARRAYS_AND_STRINGS_URLIFY

#include <string>

namespace ctci {
    class URLify {
    public:
        static void description();

        static std::string urlify(const std::string &input);

        static void urlifyInPlace(std::string *input);
    };
}
#pragma clang diagnostic pop
#endif