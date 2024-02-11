#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_1_ARRAYS_AND_STRINGS_ONE_AWAY
#define CTCI_CH_1_ARRAYS_AND_STRINGS_ONE_AWAY

#include <string>

namespace ctci {
    class OneAway {
    public:
        static void description();

        static bool isOneAway(const std::string &left, const std::string &right);
    };
}
#endif
#pragma clang diagnostic pop