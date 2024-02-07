#ifndef HACKERRANK_PREPARE_DATA_STRUCTURES_QUEUE_CASTLE_ON_THE_GRID_TEST
#define HACKERRANK_PREPARE_DATA_STRUCTURES_QUEUE_CASTLE_ON_THE_GRID_TEST

#include "gtest/gtest.h"
#include "../../../../../code/hackerrank/prepare/dataStructures/queue/CastleOnTheGrid.cpp"  // NOLINT : Ignore .cpp import

TEST(CastleOnTheGridTest, description) {
    testing::internal::CaptureStdout();
    CastleOnTheGrid::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(CastleOnTheGridTest, minimumMoves_1) {
    auto expected = 2;
    vector<string> grid{"...", ".X.", "..."};
    auto startX = 0;
    auto startY = 0;
    auto goalX = 1;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMoves(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMoves_2) {
    auto expected = 3;
    vector<string> grid{".X.", ".X.", "..."};
    auto startX = 0;
    auto startY = 0;
    auto goalX = 0;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMoves(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMoves_3) {
    auto expected = 2;
    vector<string> grid{"...", ".X.", ".X."};
    auto startX = 2;
    auto startY = 0;
    auto goalX = 0;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMoves(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMoves_4) {
    auto expected = 3;
    vector<string> grid{"...", ".X.", ".X."};
    auto startX = 2;
    auto startY = 0;
    auto goalX = 2;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMoves(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMoves_5) {
    auto expected = 13;
    vector<string> grid{".X..X.X..X..X.......XX..XX....X.X...X........X.....XX.X.X...X.X...X..X",
                        "...X.....XX.........XX......X.X.......X......X..XX.X..X..X.....X.X....",
                        "............X.......X........X..X.X......X.......X...X.X.....X.X...X..",
                        ".........X....XX.X.X.X......X..X......X.....X.........X..X.......XX...",
                        ".....X.......X.X.....XX.....X.XXX.........X.....X.X....XX......XX.....",
                        "..X....X..........................X...X.........XX.....X..............",
                        "......X.......X...XX.....X.X....X.......X.............X........X.X....",
                        "...X.X.XX.XX...X............XX...X.....X..X..X....X.........X.........",
                        "X.XX........X..........XX..X.X..X.XX.XXX..X........X..X.....XX......X.",
                        "......X..XXX.......X..XX.XX...........X.....XX..X..X.X......X.X...X...",
                        "X........X.X....X..X..................XX......X..X.......X.....X..X...",
                        "...X......X....XX.......X.....X...........X..X....X.....XXX...X...X.X.",
                        "......X..X....X.XXX.X.....X..X....XX.....X....X.....X...X...........X.",
                        "....X..X.X...XX..X.X.X..X.....X......X..X......X.X.X.X......X......X..",
                        "..X..............X...X.........X........X...........X..X.X......X....X",
                        ".X....X..X......X.........X.....XX....XX............XX..X...X...X.....",
                        "...........X....X.X...XX...X......X...............X....XX..........X..",
                        ".X..X..XX..X...X.....XX...XX...........X.....X..XXX.........XX..X....X",
                        ".XX........XX.XX..........XX............X.........X.XXXX.X.X.........X",
                        ".....X........X......X.............X.......X............X....X...X..X.",
                        "X..X.X..X...........XX..X.....X......X...XXX........XX...........X....",
                        "..X....X.XX.X.....X..X..X...........X......X..........X.....X.......X.",
                        "..........X.X...X.....X....XX.XX.......XX...X.............XXX..X..X..X",
                        "X.....X....XX...X.X...X.X.X..X.X..X....X..X..XXX...X...........X.X.X..",
                        "...XX.X....X...X.....XX...X.....X..XXX.......XX......X....XX......X.XX",
                        "X..X......X.....X......X.X...X............X.X..........X.X.X..X......X",
                        "..X....X..X.X....XX....X.XXX..X.XX.....X........X..X...X...X.X......X.",
                        ".......X...............XX..........X...X......XX...X.X........X.......",
                        "XXX....X.....X..X.....X.X.....XX..X.......X..X.....XX.......X..X.....X",
                        ".......X......X.......X..X.......X.........X...X.........X...X.....XXX",
                        "...X..X....X....X.X..XX......X.......X............X...................",
                        ".X.....X............X...............X.....X.X...X...X.XXX..X....X..XXX",
                        "..........X........X...........XX..........X..............X.....XX.X..",
                        ".X...............XX..X.X......................X..X...X......X.....X...",
                        "XX..X.X..XXXX..X..........XX..XX..X.............X................XX...",
                        "......X.XX..X...............X.X....X....X......X.....X..XX............",
                        "..X.X..X..X......X..X................X......X...X......X.XX...X..X....",
                        ".........X............X......X......XX.X..................X.....X.....",
                        "X..X....X...........X.....XX..X.......XXX.....XXX.......X....X.....X.X",
                        "XX..............XXX....X.X......XX..........X....X.....X......X.......",
                        ".......X.XX.......X......X..XXX.............X.......XX.....X.XX.......",
                        "..X.X.....XXX.X.......X.X.........X..X...X...X..X.....X.....XX.......X",
                        "..XX........XX....X..XX..X...XXX.................X..X...........X.....",
                        "...X........X..X.....X......X.X...XXX..X..XX.X..X...X........X.XXXX...",
                        "...X.X....X.....X.X.......X..............X...X.X.XX...X...XX.X.......X",
                        "......X...........X.......X.....XXXX...........X.X.XX......X...X......",
                        "....X......X......XXX..XX.X.......X.............X.......X.........X..X",
                        "..X..X..X......X.....X............XX....X..........X......X..X..X.X...",
                        "X.........X..X..XX........X.X.X......................X.X....X.....X...",
                        ".....X.X...X.X..X...X...XX...X...X............X..............X...X....",
                        "......................X....X...X....X.X..............XX.....X.........",
                        ".................X..X.....X.....XX......X.......X......X.........X.X..",
                        "...........X..X...X.....X..X.............X............X..X..XX.X......",
                        "X..........X.X..X..X..........X.XX.............X...X.XX........X......",
                        "..XX.XX.....X.....X..X.....X.....X...X...........X..X..X....X.........",
                        "..X.XX...X.X....X.X....X..X.X...X..X.........X..X.....................",
                        "............X...................X....X.X......X.XX..X...X....X..XX.XX.",
                        "...X..X.X....X..............X..X.....X.X.........X..........X.......X.",
                        "..X...........................X......X.X...X........X.................",
                        ".........X..X...............X...........X..X.X......X.................",
                        "..XX.............XX.X.........X....XX........X..X...X........X.....X..",
                        ".............X.X....X.X...X...X.....X...X.....X.....X..X......X......X",
                        ".....X....X.X.X...XXX...X.X.X.X...X...X.X.....X..X...........X.X.X...X",
                        "...XX.X...XX......X..........X.......XX..X.......X...X..X.X......X....",
                        ".......X.......X....................X..........XX.....XXXX..X.X.......",
                        ".....X...XX...X........X..X...X.X...X..........X...X.........X........",
                        "XXX..XX.....X...................X.....X.X.......X.X.X..X..............",
                        "....X.........X.....X.X...XX.....XX......X..........XX..X.XXX...X.X...",
                        "..X...............X.XX.......X....X......X......X.X.X.......X.......X.",
                        "..X.X.......XXX..X....X...X....X.....X.X......X..X......X............."};
    auto startX = 2;
    auto startY = 42;
    auto goalX = 68;
    auto goalY = 12;
    auto result = CastleOnTheGrid::minimumMoves(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMovesExhaustive_1) {
    auto expected = 2;
    vector<string> grid{"...", ".X.", "..."};
    auto startX = 0;
    auto startY = 0;
    auto goalX = 1;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMovesExhaustive(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMovesExhaustive_2) {
    auto expected = 3;
    vector<string> grid{".X.", ".X.", "..."};
    auto startX = 0;
    auto startY = 0;
    auto goalX = 0;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMovesExhaustive(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMovesExhaustive_3) {
    auto expected = 2;
    vector<string> grid{"...", ".X.", ".X."};
    auto startX = 2;
    auto startY = 0;
    auto goalX = 0;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMovesExhaustive(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMovesExhaustive_4) {
    auto expected = 3;
    vector<string> grid{"...", ".X.", ".X."};
    auto startX = 2;
    auto startY = 0;
    auto goalX = 2;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMovesExhaustive(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMovesGraph_1) {
    auto expected = 2;
    vector<string> grid{"...", ".X.", "..."};
    auto startX = 0;
    auto startY = 0;
    auto goalX = 1;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMovesGraph(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMovesGraph_2) {
    auto expected = 3;
    vector<string> grid{".X.", ".X.", "..."};
    auto startX = 0;
    auto startY = 0;
    auto goalX = 0;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMovesGraph(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMovesGraph_3) {
    auto expected = 2;
    vector<string> grid{"...", ".X.", ".X."};
    auto startX = 2;
    auto startY = 0;
    auto goalX = 0;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMovesGraph(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMovesGraph_4) {
    auto expected = 3;
    vector<string> grid{"...", ".X.", ".X."};
    auto startX = 2;
    auto startY = 0;
    auto goalX = 2;
    auto goalY = 2;
    auto result = CastleOnTheGrid::minimumMovesGraph(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

TEST(CastleOnTheGridTest, minimumMovesGraph_5) {
    auto expected = 13;
    vector<string> grid{".X..X.X..X..X.......XX..XX....X.X...X........X.....XX.X.X...X.X...X..X",
                        "...X.....XX.........XX......X.X.......X......X..XX.X..X..X.....X.X....",
                        "............X.......X........X..X.X......X.......X...X.X.....X.X...X..",
                        ".........X....XX.X.X.X......X..X......X.....X.........X..X.......XX...",
                        ".....X.......X.X.....XX.....X.XXX.........X.....X.X....XX......XX.....",
                        "..X....X..........................X...X.........XX.....X..............",
                        "......X.......X...XX.....X.X....X.......X.............X........X.X....",
                        "...X.X.XX.XX...X............XX...X.....X..X..X....X.........X.........",
                        "X.XX........X..........XX..X.X..X.XX.XXX..X........X..X.....XX......X.",
                        "......X..XXX.......X..XX.XX...........X.....XX..X..X.X......X.X...X...",
                        "X........X.X....X..X..................XX......X..X.......X.....X..X...",
                        "...X......X....XX.......X.....X...........X..X....X.....XXX...X...X.X.",
                        "......X..X....X.XXX.X.....X..X....XX.....X....X.....X...X...........X.",
                        "....X..X.X...XX..X.X.X..X.....X......X..X......X.X.X.X......X......X..",
                        "..X..............X...X.........X........X...........X..X.X......X....X",
                        ".X....X..X......X.........X.....XX....XX............XX..X...X...X.....",
                        "...........X....X.X...XX...X......X...............X....XX..........X..",
                        ".X..X..XX..X...X.....XX...XX...........X.....X..XXX.........XX..X....X",
                        ".XX........XX.XX..........XX............X.........X.XXXX.X.X.........X",
                        ".....X........X......X.............X.......X............X....X...X..X.",
                        "X..X.X..X...........XX..X.....X......X...XXX........XX...........X....",
                        "..X....X.XX.X.....X..X..X...........X......X..........X.....X.......X.",
                        "..........X.X...X.....X....XX.XX.......XX...X.............XXX..X..X..X",
                        "X.....X....XX...X.X...X.X.X..X.X..X....X..X..XXX...X...........X.X.X..",
                        "...XX.X....X...X.....XX...X.....X..XXX.......XX......X....XX......X.XX",
                        "X..X......X.....X......X.X...X............X.X..........X.X.X..X......X",
                        "..X....X..X.X....XX....X.XXX..X.XX.....X........X..X...X...X.X......X.",
                        ".......X...............XX..........X...X......XX...X.X........X.......",
                        "XXX....X.....X..X.....X.X.....XX..X.......X..X.....XX.......X..X.....X",
                        ".......X......X.......X..X.......X.........X...X.........X...X.....XXX",
                        "...X..X....X....X.X..XX......X.......X............X...................",
                        ".X.....X............X...............X.....X.X...X...X.XXX..X....X..XXX",
                        "..........X........X...........XX..........X..............X.....XX.X..",
                        ".X...............XX..X.X......................X..X...X......X.....X...",
                        "XX..X.X..XXXX..X..........XX..XX..X.............X................XX...",
                        "......X.XX..X...............X.X....X....X......X.....X..XX............",
                        "..X.X..X..X......X..X................X......X...X......X.XX...X..X....",
                        ".........X............X......X......XX.X..................X.....X.....",
                        "X..X....X...........X.....XX..X.......XXX.....XXX.......X....X.....X.X",
                        "XX..............XXX....X.X......XX..........X....X.....X......X.......",
                        ".......X.XX.......X......X..XXX.............X.......XX.....X.XX.......",
                        "..X.X.....XXX.X.......X.X.........X..X...X...X..X.....X.....XX.......X",
                        "..XX........XX....X..XX..X...XXX.................X..X...........X.....",
                        "...X........X..X.....X......X.X...XXX..X..XX.X..X...X........X.XXXX...",
                        "...X.X....X.....X.X.......X..............X...X.X.XX...X...XX.X.......X",
                        "......X...........X.......X.....XXXX...........X.X.XX......X...X......",
                        "....X......X......XXX..XX.X.......X.............X.......X.........X..X",
                        "..X..X..X......X.....X............XX....X..........X......X..X..X.X...",
                        "X.........X..X..XX........X.X.X......................X.X....X.....X...",
                        ".....X.X...X.X..X...X...XX...X...X............X..............X...X....",
                        "......................X....X...X....X.X..............XX.....X.........",
                        ".................X..X.....X.....XX......X.......X......X.........X.X..",
                        "...........X..X...X.....X..X.............X............X..X..XX.X......",
                        "X..........X.X..X..X..........X.XX.............X...X.XX........X......",
                        "..XX.XX.....X.....X..X.....X.....X...X...........X..X..X....X.........",
                        "..X.XX...X.X....X.X....X..X.X...X..X.........X..X.....................",
                        "............X...................X....X.X......X.XX..X...X....X..XX.XX.",
                        "...X..X.X....X..............X..X.....X.X.........X..........X.......X.",
                        "..X...........................X......X.X...X........X.................",
                        ".........X..X...............X...........X..X.X......X.................",
                        "..XX.............XX.X.........X....XX........X..X...X........X.....X..",
                        ".............X.X....X.X...X...X.....X...X.....X.....X..X......X......X",
                        ".....X....X.X.X...XXX...X.X.X.X...X...X.X.....X..X...........X.X.X...X",
                        "...XX.X...XX......X..........X.......XX..X.......X...X..X.X......X....",
                        ".......X.......X....................X..........XX.....XXXX..X.X.......",
                        ".....X...XX...X........X..X...X.X...X..........X...X.........X........",
                        "XXX..XX.....X...................X.....X.X.......X.X.X..X..............",
                        "....X.........X.....X.X...XX.....XX......X..........XX..X.XXX...X.X...",
                        "..X...............X.XX.......X....X......X......X.X.X.......X.......X.",
                        "..X.X.......XXX..X....X...X....X.....X.X......X..X......X............."};
    auto startX = 2;
    auto startY = 42;
    auto goalX = 68;
    auto goalY = 12;
    auto result = CastleOnTheGrid::minimumMovesGraph(grid, startX, startY, goalX, goalY);
    EXPECT_EQ(expected, result);
}

#endif