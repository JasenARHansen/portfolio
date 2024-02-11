#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_ISUNIQUE
#define CTCI_CH_1_ARRAYS_AND_STRINGS_ISUNIQUE

#include <string>

namespace ctci {
    class IsUnique {
    public:
        static void description();

        static bool isUniqueChars(const std::string &str);

        static bool isUniqueCharsBitvector(const std::string &str);

        static bool isUniqueCharsNoDs(std::string str);
    };
}
#endif
#pragma clang diagnostic pop