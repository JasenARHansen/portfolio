#pragma clang diagnostic push
#pragma ide diagnostic ignored "cert-msc50-cpp"

#include "TheApocalypse.h"
#include <iostream>

using namespace ctci;

void TheApocalypse::description() {
    std::cout << R"(Math and Logic Puzzles: The Apocalypse
    In the new post-apocalyptic world, the world queen is desperately concerned about the birth rate.
    Therefore, she decrees that all families should ensure that they have one girl or else they face
     massive fines.
    If all families abide by this policy—that is, they have continue to have children until they have
     one girl, at which point they immediately stop—what will the gender ratio of the new generation be?
    (Assume that the odds of someone having a boy or a girl on any given pregnancy is equal.)
    Solve this out logically and then write a computer simulation of it.)" << std::endl;
}

#pragma clang diagnostic push
#pragma ide diagnostic ignored "cert-msc51-cpp"

std::tuple<int, int, double> TheApocalypse::getRatio(int families) {
    auto result = std::make_tuple(0, 0, 0.0);
    time_t seconds;
    time(&seconds);
    srand((unsigned int) seconds);
    for (auto family = 0; family < families; family++) {
        auto boy = true;
        while (boy) {
            boy = (bool) (rand() % 2);
            if (boy) {
                std::get<0>(result)++;
            } else {
                std::get<1>(result)++;
            }
        }
    }
    std::get<2>(result) = std::get<1>(result) / static_cast<double>( std::get<0>(result) + std::get<1>(result));
    return result;
}

#pragma clang diagnostic pop

#pragma clang diagnostic pop