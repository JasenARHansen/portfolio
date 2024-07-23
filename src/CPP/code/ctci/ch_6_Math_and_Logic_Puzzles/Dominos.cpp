#include "Dominos.h"
#include <iostream>
#include <cmath>

using namespace ctci;

void Dominos::description() {
    std::cout << R"(Math and Logic Puzzles: Dominos
    There is an 8x8 chessboard in which two diagonally opposite corners have been cut off.
    You are given 31 dominos, and a single domino can cover exactly two squares.
    Can you use the 31 dominos to cover the entire board?
    Prove your answer (by providing an example or showing why it's impossible).)" << std::endl;
}

std::pair<bool, int> Dominos::howManyDominos(int n, int m) {
    auto result = std::make_pair(false, 0);
    if (n % 2 != m % 2) {
        result.first = true;
        result.second = (int) ((n * m) / 2) - 1;
    }
    return result;
}
