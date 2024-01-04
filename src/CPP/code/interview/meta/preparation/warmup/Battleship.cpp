#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class Battleship {
public:
    static void description() {
        cout << R"(Battleship
    You're playing Battleship on a grid of cells with R rows and C columns.
    There are 0 or more battleships on the grid, each occupying a single distinct cell.
    The cell in the Ith row from the top and Jth column from the left either contains a battleship (Gi, j=1G)
     or doesn't (Gi, j=0).
    You're going to fire a single shot at a random cell in the grid.
    You'll choose this cell uniformly at random from the R∗CR∗C possible cells.
    You're interested in the probability that the cell hit by your shot contains a battleship.
    Your task is to implement the function getHitProbability(R, C, G) which returns this probability.
    Note: Your return value must have an absolute or relative error of at most 10−6 to be considered correct.
    Constraints:
        1 ≤ R, C ≤ 100
        0 ≤ Gi, j ≤ 10
    Sample test case #1
        R = 2
        C = 3
        G = 0 0 1
            1 0 1
        Expected Return Value = 0.50000000
    Sample test case #2
        R = 2
        C = 2
        G = 1 1
            1 1
        Expected Return Value = 1.00000000
    Sample Explanation:
        In the first case, 33 of the 66 cells in the grid contain battleships.
        Therefore, the probability that your shot will hit one of them is 3/6=0.53/6=0.5.
        In the second case, all 44 cells contain battleships, resulting in a probability of 1.0of
         hitting a battleship.)" << endl;
    }

    static double getHitProbability(int r, int c, vector<vector<int>> g) {
        assert(1 <= r);
        assert(r <= 100);
        assert(1 <= c);
        assert(c <= 100);
        assert(!g.empty());
        assert(g.size() <= 100);
        assert(!g[0].empty());
        assert(g[0].size() <= 100);
        auto hit = 0;
        for (const auto &row: g) {
            for (const auto &cell: row) {
                if (cell == 1) {
                    hit++;
                }
            }
        }
        return hit / (double) (r * c);
    }
};

#pragma clang diagnostic pop