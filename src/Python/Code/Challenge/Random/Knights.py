import random


class Knights(object):
    @staticmethod
    def get_description():
        print("""Knights
    Given NxN board, determine if all spots can be navigated to with a
     knight without duplicating squares.
    Note: This gets slow with larger numbers so    
    """)

    @staticmethod
    def print_grid_with_padding(grid):
        # This method was Googled since it was just grunt work
        # Find the maximum width required for any item in the grid
        if not grid:
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
            formatted_row = " ".join(f"{item:<{max_width}}" for item in row)
            print(formatted_row)

    @staticmethod
    def generate_board(size: int) -> list:
        """Generate empty board"""
        # Creates N rows, each containing M instances of None
        return [[None for _ in range(size)] for _ in range(size)]

    @staticmethod
    def test_space(row: int, column: int, board: list) -> bool:
        """test if spot is valid and un visited"""
        if 0 <= row < len(board) and 0 <= column < len(board) and board[row][column] is None:
            # Valid spot
            return True
        return False

    @staticmethod
    def move_knight(visited: int, row: int, column: int, board: list) -> bool:
        """place knight"""
        if Knights.test_space(row=row, column=column, board=board):
            visited += 1
            board[row][column] = visited
        else:
            return False
        if visited == len(board) ** 2:
            Knights.print_grid_with_padding(grid=board)
            data = [(row, column)]
            (True, True, data)
            return True

        # If there is more than 1 path, it is boring to always find the same one,
        # so I am adding randomness tro the order
        order = list(range(8))
        random.shuffle(order)
        result = False

        while order and not result:
            select = order.pop()
            match select:
                case 0:
                    # Row + 2, Column + 1
                    if Knights.move_knight(visited=visited, row=row + 2, column=column + 1, board=board):
                        result = True
                case 1:
                    # Row + 2, Column - 1
                    if Knights.move_knight(visited=visited, row=row + 2, column=column - 1, board=board):
                        result = True
                case 2:
                    # Row - 2, Column + 1
                    if Knights.move_knight(visited=visited, row=row - 2, column=column + 1, board=board):
                        result = True
                case 3:
                    # Row - 2, Column - 1
                    if Knights.move_knight(visited=visited, row=row - 2, column=column - 1, board=board):
                        result = True
                case 4:
                    # Row + 1, Column + 2
                    if Knights.move_knight(visited=visited, row=row + 1, column=column + 2, board=board):
                        result = True
                case 5:
                    # Row + 1, Column - 2
                    if Knights.move_knight(visited=visited, row=row + 1, column=column - 2, board=board):
                        result = True
                case 6:
                    # Row - 1, Column + 2
                    if Knights.move_knight(visited=visited, row=row - 1, column=column + 2, board=board):
                        result = True
                case 7:
                    # Row - 1, Column - 2
                    if Knights.move_knight(visited=visited, row=row - 1, column=column - 2, board=board):
                        result = True

        if not result:
            board[row][column] = None
        return result

    @staticmethod
    def find_path(size: int, start_row: int, start_column: int) -> list:
        # This will be revisited later and implemented
        board = Knights.generate_board(size=size)
        if Knights.move_knight(visited=0, row=start_row, column=start_column, board=board):
            return []
        return []
