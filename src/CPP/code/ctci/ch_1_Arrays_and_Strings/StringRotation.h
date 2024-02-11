#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_ROTATION
#define CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_ROTATION

#include <string>

namespace ctci {
    class StringRotation {
    public:
        static void description();

        static std::string rotate(const std::string &input, int spaces);

        static bool isRotation(const std::string &s1, const std::string &s2);
    };
}
#pragma clang diagnostic pop
#endif