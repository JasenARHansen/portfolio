#include "Prime.h"
#include <iostream>
#include <cmath>
#include <vector>

using namespace ctci;

void Prime::description() {
    std::cout << R"(Math and Logic Puzzles: Prime
    A natural number (1, 2, 3, 4, 5, 6, etc.) is called a prime number (or a prime)
     if it is greater than 1 and cannot be written as the product of two smaller
     natural numbers.
    The first 25 prime numbers (all the prime numbers less than 100) are:
     2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
    Test to see if a given number is a Prime Number.)" << std::endl;
}

bool Prime::prime(int value) {
    auto result = true;
    auto squareRoot = sqrt(value);
    if (std::floor(squareRoot) == squareRoot) {
        result = false;
    } else {
        // Precalculate primes and if a prime is found, test against value
        auto bound = (int) squareRoot + 1;
        std::vector<bool> primeTest(bound, true);
        for (auto index = 2; index < bound; index++) {
            if (primeTest.at(index)) {
                // Test to see if prime is a factor of value
                if (!(value % index)) {
                    result = false;
                    break;
                }
                // Eliminate future values to find primes
                auto notPrime = index * 2;
                while (notPrime < bound) {
                    if (primeTest.at(notPrime)) {
                        primeTest.at(notPrime) = false;
                    }
                    notPrime += index;
                }
            }
        }
    }
    return result;
}