#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_5_BIT_MANIPULATION_NEXT_NUMBER
#define CTCI_CH_5_BIT_MANIPULATION_NEXT_NUMBER

#include <vector>

namespace ctci {
    class NextNumber {
    public:
        static void description();

        static std::pair<int, int> nextNumber(int value);
    };
}
#endif
#pragma clang diagnostic pop