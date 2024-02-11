#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_COMPRESSION
#define CTCI_CH_1_ARRAYS_AND_STRINGS_STRING_COMPRESSION

#include <string>

namespace ctci {
    class StringCompression {
    public:
        static void description();

        static std::string compress(const std::string &input);

        static std::string decompress(const std::string &input);
    };
}
#endif
#pragma clang diagnostic pop