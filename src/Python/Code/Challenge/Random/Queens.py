import copy
import random


class Queens(object):
    @staticmethod
    def get_description():
        print("""Knights
    Given NxN board, place N Queens on a chessboard such that no Queen is on
     the same row, column, or diagonal as another Queens.
    """)

    @staticmethod
    def print_grid_with_padding(grid: list) -> None:
        """This method was Googled since it was just grunt work
        Find the maximum width required for any item in the grid"""
        print("Grid showing full placement:"
              "\n\t\"Q\" represents a Queen"
              "\n\t\"x\" represents a space under threat from a Queen"
              "\n\t\"None\" seen in the grid indicates that there was no valid placement")
        if not grid:
            print("No grid found")
            return
        max_width = 0
        for row in grid:
            for item in row:
                # Convert to string to get accurate length
                item_str = str(item)
                if len(item_str) > max_width:
                    max_width = len(item_str)

        # Print each row with consistent padding
        for row in grid:
            # Use an f-string to format each element to the max_width
            # The '<' aligns left within the padding
            formatted_row = " ".join(f"{str(item):<{max_width}}" for item in row)
            print(formatted_row)

    @staticmethod
    def generate_board(size: int) -> list:
        """Generate empty board"""
        # Creates N rows, each containing M instances of None
        return [[None for _ in range(size)] for _ in range(size)]

    @staticmethod
    def test_space(point: tuple, board: list) -> bool:
        """test if spot is valid and un visited"""
        conflict = ['Q', 'x']
        # Test if on board
        if point[0] not in range(len(board)) or (point[1] not in range(len(board[0]))):
            return False
        # Test For conflict
        if board[point[0]][point[1]] in conflict:
            return False
        return True

    @staticmethod
    def add_queen(placed: int, row: int, board: list) -> tuple[bool, list]:
        """Place Queens on a row of a chessboard"""
        if row >= len(board) and placed == len(board):
            return True, board

        if row > len(board):
            return False, board

        # There is more than 1 solution, it is boring to always find the same one,
        # so I am adding randomness to the order of processing
        order = list(range(len(board)))
        random.shuffle(order)
        while order:
            column = order.pop()
            working_board = copy.deepcopy(board)
            if Queens.test_space(point=(row, column), board=working_board):
                # Populate Column
                for value in range(len(working_board)):
                    working_board[value][column] = 'x'
                # Populate Row
                for value in range(len(working_board[0])):
                    working_board[row][value] = 'x'
                # Populate up and Left
                test_row = row
                test_column = column
                while test_row >= 0 and test_column >= 0:
                    working_board[test_row][test_column] = 'x'
                    test_row -= 1
                    test_column -= 1
                # Populate up and right
                test_row = row
                test_column = column
                while test_row >= 0 and test_column < len(working_board[0]):
                    working_board[test_row][test_column] = 'x'
                    test_row -= 1
                    test_column += 1
                # Populate down and Left
                test_row = row
                test_column = column
                while test_row < len(working_board) and test_column >= 0:
                    working_board[test_row][test_column] = 'x'
                    test_row += 1
                    test_column -= 1
                # Populate down and right
                test_row = row
                test_column = column
                while test_row < len(working_board) and test_column < len(working_board[0]):
                    working_board[test_row][test_column] = 'x'
                    test_row += 1
                    test_column += 1
                # Place Queen
                working_board[row][column] = "Q"
                data = Queens.add_queen(placed=placed + 1, row=row + 1, board=working_board)
                if data[0]:
                    return data
        return False, board

    @staticmethod
    def place_queens(size: int) -> list:
        board = Queens.generate_board(size=size)
        data = Queens.add_queen(placed=0, row=0, board=board)[1]
        Queens.print_grid_with_padding(data)
        return data

    @staticmethod
    def can_place_queens(size: int) -> bool:
        board = Queens.generate_board(size=size)
        return Queens.add_queen(placed=0, row=0, board=board)[0]
