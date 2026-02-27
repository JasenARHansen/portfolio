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
    def print_grid_with_padding(grid: list) -> None:
        """This method was Googled since it was just grunt work
        Find the maximum width required for any item in the grid"""
        print("Grid showing full traversal:"
              "\n\t\"()\" represents the origin coordinates"
              "\n\t\"(x, y)\" represents the coordinates that were used to navigate to that element:")
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
    def print_path(data: list) -> None:
        """Prints the path in order"""
        print("List of coordinates representing each step in the full traversal:")
        formatted_row = " -> ".join(str(item) for item in data)
        print(formatted_row)

    @staticmethod
    def generate_board(size: int) -> list:
        """Generate empty board"""
        # Creates N rows, each containing M instances of None
        return [[None for _ in range(size)] for _ in range(size)]

    @staticmethod
    def test_space(point: tuple, board: list) -> bool:
        """test if spot is valid and un visited"""
        if 0 <= point[0] < len(board) and 0 <= point[1] < len(board) and board[point[0]][point[1]] is None:
            # Valid spot
            return True
        return False

    @staticmethod
    def move_knight(visited: int, parent: tuple, target: tuple, board: list) -> tuple:
        """place knight"""
        if Knights.test_space(point=target, board=board):
            visited += 1
            board[target[0]][target[1]] = parent
        else:
            return False, []

        if visited == len(board) ** 2:
            Knights.print_grid_with_padding(grid=board)
            return True, [target]

        # If there is more than 1 path, it is boring to always find the same one,
        # so I am adding randomness tro the order
        order = list(range(8))
        random.shuffle(order)
        result = False
        path = []

        while order and not result:
            select = order.pop()
            match select:
                case 0:
                    # Row + 2, Column + 1
                    destination = (target[0] + 2, target[1] + 1)
                    data = Knights.move_knight(visited=visited, parent=target, target=destination, board=board)
                    if data[0]:
                        result = True
                        path = data[1]
                        path.insert(0, target)
                case 1:
                    # Row + 2, Column - 1
                    destination = (target[0] + 2, target[1] - 1)
                    data = Knights.move_knight(visited=visited, parent=target, target=destination, board=board)
                    if data[0]:
                        result = True
                        path = data[1]
                        path.insert(0, target)
                case 2:
                    # Row - 2, Column + 1
                    destination = (target[0] - 2, target[1] + 1)
                    data = Knights.move_knight(visited=visited, parent=target, target=destination, board=board)
                    if data[0]:
                        result = True
                        path = data[1]
                        path.insert(0, target)
                case 3:
                    # Row - 2, Column - 1
                    destination = (target[0] - 2, target[1] + 1)
                    data = Knights.move_knight(visited=visited, parent=target, target=destination, board=board)
                    if data[0]:
                        result = True
                        path = data[1]
                        path.insert(0, target)
                case 4:
                    # Row + 1, Column + 2
                    destination = (target[0] + 1, target[1] + 2)
                    data = Knights.move_knight(visited=visited, parent=target, target=destination, board=board)
                    if data[0]:
                        result = True
                        path = data[1]
                        path.insert(0, target)
                case 5:
                    # Row + 1, Column - 2
                    destination = (target[0] + 1, target[1] - 2)
                    data = Knights.move_knight(visited=visited, parent=target, target=destination, board=board)
                    if data[0]:
                        result = True
                        path = data[1]
                        path.insert(0, target)
                case 6:
                    # Row - 1, Column + 2
                    destination = (target[0] - 1, target[1] + 2)
                    data = Knights.move_knight(visited=visited, parent=target, target=destination, board=board)
                    if data[0]:
                        result = True
                        path = data[1]
                        path.insert(0, target)
                case 7:
                    # Row - 1, Column - 2
                    destination = (target[0] - 1, target[1] - 2)
                    data = Knights.move_knight(visited=visited, parent=target, target=destination, board=board)
                    if data[0]:
                        result = True
                        path = data[1]
                        path.insert(0, target)

        if not result:
            board[target[0]][target[1]] = None
        return result, path

    @staticmethod
    def path_exists(size: int, start_row: int, start_column: int) -> bool:
        board = Knights.generate_board(size=size)
        return Knights.move_knight(visited=0, parent=(), target=(start_row, start_column), board=board)[0]

    @staticmethod
    def find_path(size: int, start_row: int, start_column: int) -> list:
        board = Knights.generate_board(size=size)
        data = Knights.move_knight(visited=0, parent=(), target=(start_row, start_column), board=board)[1]
        if data:
            Knights.print_path(data=data)
        else:
            print("No path found")
        return data
