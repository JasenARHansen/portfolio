#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <queue>
#include <set>
#include <stack>

using namespace std;

class CastleOnTheGrid {
public:
    static void description() {
        cout << R"(Queues: Castle on the Grid
    You are given a square grid with some cells open (.) and some blocked (X).
    Your playing piece can move along any row or column until it reaches the edge of the grid or a blocked cell.
    Given a grid, a start and a goal, determine the minimum number of moves to get to the goal.
    Example:
        grid = ['...', '.X.', '...']
        startX = 0
        startY = 0
        goalX = 1
        goalY = 2
        The grid is shown below:
            ...
            .X.
            ...
        The starting position (startX, startY) == (0, 0) so start in the top left corner.
        The goal is (goalX, goalY) == (1, 2).
        The path is (0, 0) → (0, 2) → (1, 2).
        It takes 2 moves to reach the goal.
    Function Description:
        Complete the minimumMoves function in the editor.
        minimumMoves has the following parameter(s):
            string grid[n]: an array of strings that represent the rows of the grid
            int startX: starting X coordinate
            int startY: starting Y coordinate
            int goalX: ending X coordinate
            int goalY: ending Y coordinate
    Returns:
        int: the minimum moves to reach the goal
    Input Format:
        The first line contains an integer n, the size of the array grid.
        Each of the next n lines contains a string of length n.
        The last line contains four space-separated integers, startX, startY, goalX, goalY
    Constraints:
        1 ≤ n ≤ 100
        0 ≤ startX, startY, goalX, goalY < n
    Sample Input:
        STDIN       FUNCTION
        -----       --------
        3           grid[] size n = 3
        .X.         grid = ['.X.','.X.', '...']
        .X.
        ...
        0 0 0 2     startX = 0, startY = 0, goalX = 0, goalY = 2
    Sample Output:
        3
    Explanation:
        Here is a path that one could follow in order to reach the destination in 3 steps:
            (0, 0) → (2, 0) → (2, 2) → (0, 2)
        Path:
            S = (0, 0)  SX.   1 = (2, 0)  SX.   2 = (2, 2)   SX.   2 = (0, 2)   SX3
                        .X.               .X.                .X.                .X.
                        ...               1..                1.2                1.2
    Note: These look like they are (x, y) coordinates where X is down ↕ up and y is left ↔ right)" << endl;
    }

    static int minimumMoves(vector<string> grid, int startX, int startY, int goalX, int goalY) {
        // Generate grid to track movements
        vector<vector<int>> tracking((int) grid.size(), vector<int>((int) grid[0].size(), 1));
        // Update available grid to mark obstacles as unavailable
        for (int targetX = 0; targetX < (int) grid.size(); targetX++) {
            for (int targetY = 0; targetY < (int) grid[0].size(); targetY++) {
                if (grid[targetX][targetY] == 'X') {
                    tracking[targetX][targetY] = 3;
                    continue;
                }
            }
        }
        // Generate grid to track predecessor
        vector<vector<pair<int, int>>> predecessor((int) grid.size(), vector<pair<int, int>>((int) grid[0].size()));
        // Generate queue for BFS
        queue<pair<int, int>> bfs;
        // Enter start point for BFS
        bfs.emplace(startX, startY);
        // Increment starting location
        tracking[startX][startY]++;
        // Process BFS search
        pair<int, int> current;
        while (!bfs.empty()) {
            current = bfs.front();
            bfs.pop();
            auto targetY = current.second - 1;
            while (targetY >= 0) {
                if (tracking[current.first][targetY] == 1) {
                    bfs.emplace(current.first, targetY);
                    predecessor[current.first][targetY] = current;
                    tracking[current.first][targetY]++;
                } else {
                    break;
                }
                targetY--;
            }
            // Move right if available: Can move 1 or more steps
            auto targetX = current.first - 1;
            while (targetX >= 0) {
                if (tracking[targetX][current.second] == 1) {
                    bfs.emplace(targetX, current.second);
                    predecessor[targetX][current.second] = current;
                    tracking[targetX][current.second]++;
                } else {
                    break;
                }
                targetX--;
            }
            // Move up if available: Can move 1 or more steps
            targetY = current.second + 1;
            while (targetY < (int) grid[0].size()) {
                if (tracking[current.first][targetY] == 1) {
                    bfs.emplace(current.first, targetY);
                    predecessor[current.first][targetY] = current;
                    tracking[current.first][targetY]++;
                } else {
                    break;
                }
                targetY++;
            }
            // Move down if available: Can move 1 or more steps
            targetX = current.first + 1;
            while (targetX < (int) grid.size()) {
                if (tracking[targetX][current.second] == 1) {
                    bfs.emplace(targetX, current.second);
                    predecessor[targetX][current.second] = current;
                    tracking[targetX][current.second]++;
                } else {
                    break;
                }
                targetX++;
            }
            if (predecessor[goalX][goalY].first != 0 && predecessor[goalX][goalY].second != 0) {
                break;
            }
        }
        // Calculate number of transitions in path
        auto pathLength = 0;
        current = predecessor[goalX][goalY];
        while (true) {
            pathLength++;
            if ((current.first == startX) and (current.second == startY)) {
                break;
            }
            current = predecessor[current.first][current.second];
        }
        return pathLength;
    }

    static int minimumMovesGraph(vector<string> grid, int startX, int startY, int goalX, int goalY) {
        // Has an off by 1 error somewhere
        stack<vector<int>> path;
        // generate grid to track movements
        vector<vector<bool>> available;
        available.reserve(grid.size());
        for (const auto &count: grid) {
            available.emplace_back(count.size(), true);
        }
        // update available grid to mark obstacles as unavailable
        for (auto xCoordinate = 0; xCoordinate < (int) grid.size(); xCoordinate++) {
            for (auto yCoordinate = 0; yCoordinate < (int) grid.at(xCoordinate).size(); yCoordinate++) {
                if (grid.at(xCoordinate).at(yCoordinate) != '.') {
                    available[xCoordinate][yCoordinate] = false;
                }
            }
        }
        // Mark starting location as unavailable
        available[startX][startY] = false;
        // generate grid to track predecessor
        vector<vector<vector<int>>> predecessor;
        predecessor.reserve(grid.size());
        for (const auto &count: grid) {
            predecessor.emplace_back(count.size());
        }
        // Generate queue for BFS
        queue<vector<int>> bfs;
        bfs.push({startX, startY});
        // Process queue for BFS
        vector<int> current;
        while (!bfs.empty()) {
            current = bfs.front();
            bfs.pop();
            if ((current.at(0) == goalX) and (current.at(1) == goalY)) {
                path.push(current);
                break;
            }
            // Generate graph edges and add them to BFS
            // Move left if available: Can move 1 or more steps
            auto targetY = current.at(1) - 1;
            while ((0 <= targetY) and (available[current.at(0)][targetY])) {
                bfs.push({current.at(0), targetY});
                available[current.at(0)][targetY] = false;
                predecessor[current.at(0)][targetY].push_back(current.at(0));
                predecessor[current.at(0)][targetY].push_back(current.at(1));
                targetY--;
            }
            // Move right if available: Can move 1 or more steps
            targetY = current.at(1) + 1;
            while ((targetY < (int) available[startY].size()) and (available[current.at(0)][targetY])) {
                bfs.push({current.at(0), targetY});
                available[current.at(0)][targetY] = false;
                predecessor[current.at(0)][targetY].push_back(current.at(0));
                predecessor[current.at(0)][targetY].push_back(current.at(1));
                targetY++;
            }
            // Move up if available: Can move 1 or more steps
            auto targetX = current.at(0) - 1;
            while ((0 <= targetX) and (available[targetX][current.at(1)])) {
                bfs.push({targetX, current.at(1)});
                available[targetX][current.at(1)] = false;
                predecessor[targetX][current.at(1)].push_back(current.at(0));
                predecessor[targetX][current.at(1)].push_back(current.at(1));
                targetX--;
            }
            // Move down if available: Can move 1 or more steps
            targetX = current.at(0) + 1;
            while ((targetX < (int) available.size()) and (available[targetX][current.at(1)])) {
                bfs.push({targetX, current.at(1)});
                available[targetX][current.at(1)] = false;
                predecessor[targetX][current.at(1)].push_back(current.at(0));
                predecessor[targetX][current.at(1)].push_back(current.at(1));
                targetX++;
            }
        }
        // path found, now build path stack
        if (!path.empty()) {
            while (true) {
                path.push(predecessor[path.top().at(0)][path.top().at(1)]);
                if ((path.top().at(0) == startX) and (path.top().at(1) == startY)) {
                    break;
                }
            }
        }
        return path.empty() ? 0 : (int) path.size() - 1;
    }

    static int minimumMovesExhaustive(vector<string> grid, int startX, int startY, int goalX, int goalY) {
        // Too slow
        set<int> results;
        vector<vector<bool>> available;
        // generate grid to track movements
        available.reserve(grid.size());
        for (const auto &count: grid) {
            available.emplace_back(count.size(), true);
        }
        // update available grid to mark obstacles as unavailable
        for (auto xCoordinate = 0; xCoordinate < grid.size(); xCoordinate++) {
            for (auto yCoordinate = 0; yCoordinate < grid.at(xCoordinate).size(); yCoordinate++) {
                if (grid.at(xCoordinate).at(yCoordinate) != '.') {
                    available[xCoordinate][yCoordinate] = false;
                }
            }
        }
        // Mark starting location as unavailable
        available[startX][startY] = false;
        auto moves = 0;
        navigate(startX, startY, goalX, goalY, moves, &available, &results);
        // Find the smallest value is result set, or return 0 if empty
        return results.empty() ? 0 : *(results.begin());
    }

private:
    static void
    navigate(int startX, int startY, int goalX, int goalY, int moves, vector<vector<bool>> *available,
             set<int> *results) {
        // Recursive call to navigate tto the destination.
        // Base case, arrived at destination
        if ((startX == goalX) and (startY == goalY)) {
            results->insert(moves);
        } else {
            // Move up if available: Can move 1 or more steps
            auto targetX = startX - 1;
            while ((0 <= targetX) and (available->operator[](targetX)[startY])) {
                available->operator[](targetX)[startY] = false;
                navigate(targetX, startY, goalX, goalY, moves + 1, available, results);
                available->operator[](targetX)[startY] = true;
                targetX--;
            }
            // Move down if available: Can move 1 or more steps
            targetX = startX + 1;
            while ((targetX < (int) available->size()) and (available->operator[](targetX)[startY])) {
                available->operator[](targetX)[startY] = false;
                navigate(targetX, startY, goalX, goalY, moves + 1, available, results);
                available->operator[](targetX)[startY] = true;
                targetX++;
            }
            // Move left if available: Can move 1 or more steps
            auto targetY = startY - 1;
            while ((0 <= targetY) and (available->operator[](startX)[targetY])) {
                available->operator[](startX)[targetY] = false;
                navigate(startX, targetY, goalX, goalY, moves + 1, available, results);
                available->operator[](startX)[targetY] = true;
                targetY--;
            }
            // Move right if available: Can move 1 or more steps
            targetY = startY + 1;
            while ((targetY < (int) available->operator[](startY).size()) and
                   (available->operator[](startX)[targetY])) {
                available->operator[](startX)[targetY] = false;
                navigate(startX, targetY, goalX, goalY, moves + 1, available, results);
                available->operator[](startX)[targetY] = true;
                targetY++;
            }
        }
    }
};

#pragma clang diagnostic pop