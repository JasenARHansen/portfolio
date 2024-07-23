#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_DOMINOS
#define CTCI_CH_6_MATH_AND_LOGIC_PUZZLES_DOMINOS

#include <vector>

namespace ctci {
    class Dominos {
    public:
        static void description();

        static std::pair<bool, int> howManyDominos(int n, int m);
    };
}
#endif
#pragma clang diagnostic pop