#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>

using namespace std;

class DirectorOfPhotography {
public:
    static void description() {
        cout << R"(Director of Photography (Chapter 2)
    Note: Chapter 1 is an easier version of this puzzle. The only difference is a smaller constraint on NN.
    A photography set consists of N cells in a row, numbered from 1 to N in order, and can be represented by a string C of length N. Each cell i is one of the following types (indicated by Ci, the Ith character of C):
        If Ci = “P”, it is allowed to contain a photographer
        If Ci = “A”, it is allowed to contain an actor
        If Ci = “B”, it is allowed to contain a backdrop
        If Ci = “.”, it must be left empty

    A photograph consists of a photographer, an actor, and a backdrop, such that each of them is placed in a valid cell, and such that the actor is between the photographer and the backdrop. Such a photograph is considered artistic if the distance between the photographer and the actor is between X and Y cells (inclusive), and the distance between the actor and the backdrop is also between X and Y cells (inclusive). The distance between cells i and j is ∣i−j∣ (the absolute value of the difference between their indices).
    Determine the number of different artistic photographs which could potentially be taken at the set. Two photographs are considered different if they involve a different photographer cell, actor cell, and/or backdrop cell.
    Constraints
        1 ≤ N ≤ 300,000
        1 ≤ X ≤ Y ≤ N

    Sample test case #1
        N = 5
        C = APABA
        X = 1
        Y = 2
        Expected Return Value = 1
        In the first case, the absolute distances between photographer/actor and actor/backdrop must be between 1 and 2. The only possible photograph that can be taken is with the 3 middle cells, and it happens to be artistic.

    Sample test case #2
        N = 5
        C = APABA
        X = 2
        Y = 3
        Expected Return Value = 0
        In the second case, the only possible photograph is again taken with the 3 middle cells. However, as the distance requirement is between 2 and 3, it is not possible to take an artistic photograph.

    Sample test case #3
        N = 8
        C = .PBAAP.B
        X = 1
        Y = 3
        Expected Return Value = 3

    Sample Explanation
        In the third case, there are 4 possible photographs, illustrated as follows:
            .P.A...B
            .P..A..B
            ..BA.P..
            ..B.AP..
        All are artistic except the first, where the artist and backdrop exceed the maximum distance of 3.)" << endl;
    }

    static int getArtisticPhotographCount(int N, string C, int X, int Y) {
        assert(1 <= N);
        assert(N <= 3 * pow(10, 5));
        assert(1 <= X);
        assert(X <= Y);
        assert(Y <= N);
        auto result = 0;
        for (auto photographer = 0; photographer < C.size(); photographer++) {
            if (C.at(photographer) == 'P') {
                // look left
                for (auto actor = photographer - X;
                     (actor >= 0) && (actor >= photographer - Y); actor--) {
                    if (C.at(actor) == 'A') {
                        for (auto backdrop = actor - X; (backdrop >= 0) && (backdrop >= actor - Y); backdrop--) {
                            if (C.at(backdrop) == 'B') {
                                result++;
                            }
                        }
                    }
                }
                // look right
                for (auto actor = photographer + X;
                     (actor < C.size()) && (actor <= photographer + Y); actor++) {
                    if (C.at(actor) == 'A') {
                        for (auto backdrop = actor + X; (backdrop < C.size()) && (backdrop <= actor + Y); backdrop++) {
                            if (C.at(backdrop) == 'B') {
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
};

#pragma clang diagnostic pop