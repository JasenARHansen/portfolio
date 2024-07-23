#include "DrawLine.h"
#include <iostream>

using namespace ctci;

void DrawLine::description() {
    std::cout << R"(Bit Manipulation: Draw Line
    A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels to
     be stored in one byte.
    The screen has width w, where w is divisible by 8 (that is, no byte will be split across rows).
    The height of the screen, of course, can be derived from the length of the array and the width.
    Implement a function that draws a horizontal line from (x1, y) to ( x2, y).
    The method signature should look something like:
        drawLine(byte[] screen, int width, int x1 , int x2, int y))" << std::endl;
}

std::vector<std::string> DrawLine::drawLine(const std::vector<std::byte> &screen, int width, int x1, int x2, int y) {
    std::vector<std::string> result;
    auto maxWidth = (int) (width * sizeof(char) * CHAR_BIT);
    result.reserve((int) screen.size() / width);
    for (auto height = 0; height < (int) screen.size() / width; height++) {
        result.emplace_back(maxWidth, '_');
    }
    if ((y < result.size()) and (x2 < maxWidth)) {
        for (auto index = x1; index < std::min(x2, maxWidth); index++) {
            result.at(y)[index] = '-';
        }
    }
    return result;
}