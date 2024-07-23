#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"
#ifndef CTCI_CH_5_BIT_MANIPULATION_DRAW_LINE
#define CTCI_CH_5_BIT_MANIPULATION_DRAW_LINE

#include <vector>
#include <string>

namespace ctci {
    class DrawLine {
    public:
        static void description();

        static std::vector<std::string>
        drawLine(const std::vector<std::byte> &screen, int width, int x1, int x2, int y);
    };
}
#endif
#pragma clang diagnostic pop