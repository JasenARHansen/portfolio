class Hadrian(object):
    @staticmethod
    def get_description():
        print("""Hadrian: Interview

              Given a grid of MxN dimensions, and a starting coordinates, find the
               shortest path to a destination coordinates
              Minimum number of steps to travel form 1 space to a second.
                |_|_|_|_|_|_|_|_|
                |_|_|_|_|_|_|_|_|
                |_|_|_|K|_|_|_|_|
                |_|_|_|_|_|_|_|_|
                |_|_|_|_|_|_|T|_|
                |_|_|_|_|_|_|_|_|
                
                Result:
                |_|_|_|_|_|_|_|_|
                |_|_|_|_|_|_|_|_|
                |_|_|_|K|_|2|_|_|
                |_|_|_|_|_|_|_|_|
                |_|_|_|_|1|_|3|_|
                |_|_|_|_|_|_|_|_|
            
              Implementation Steps.  The number of steps is the only relevant piece of data
              Implementation Path.  Provide a path that has the minimum number of steps
                Note: Since the path includes the first and the last node, it will be 1 longer than implementation Steps
              """)

    @staticmethod
    def generate_board(rows: int, cols: int) -> list:
        return [[None for _ in range(cols)] for _ in range(rows)]

    @staticmethod
    def validate(row: int, column: int, board: list) -> bool:
        """test if spot is valid and not visited"""
        if 0 <= row < len(board) and 0 <= column < len(board[0]) and board[row][column] is None:
            # Valid spot
            return True
        return False

    @staticmethod
    def neighbors_step_count(point: tuple, board: list) -> list:
        # The point will have 3 elements: step value, row coordinates, col coordinates
        # By passing board, I can limit neighbors to not include visited locations

        neighbors = []

        # Row + 2, Column + 1
        if Hadrian.validate(row=point[1] + 2, column=point[2] + 1, board=board):
            neighbors.append((point[0] + 1, point[1] + 2, point[2] + 1))

        # Row + 2, Column - 1
        if Hadrian.validate(row=point[1] + 2, column=point[2] - 1, board=board):
            neighbors.append((point[0] + 1, point[1] + 2, point[2] - 1))

        # Row - 2, Column + 1
        if Hadrian.validate(row=point[1] - 2, column=point[2] + 1, board=board):
            neighbors.append((point[0] + 1, point[1] - 2, point[2] + 1))

        # Row - 2, Column - 1
        if Hadrian.validate(row=point[1] - 2, column=point[2] - 1, board=board):
            neighbors.append((point[0] + 1, point[1] - 2, point[2] - 1))

        # Row + 1, Column + 2
        if Hadrian.validate(row=point[1] + 1, column=point[2] + 2, board=board):
            neighbors.append((point[0] + 1, point[1] + 1, point[2] + 2))

        # Row + 1, Column - 2
        if Hadrian.validate(row=point[1] + 1, column=point[2] - 2, board=board):
            neighbors.append((point[0] + 1, point[1] + 1, point[2] - 2))

        # Row - 1, Column + 2
        if Hadrian.validate(row=point[1] - 1, column=point[2] + 2, board=board):
            neighbors.append((point[0] + 1, point[1] - 1, point[2] + 2))

        # Row - 1, Column - 2
        if Hadrian.validate(row=point[1] - 1, column=point[2] - 2, board=board):
            neighbors.append((point[0] + 1, point[1] - 1, point[2] - 2))

        return neighbors

    @staticmethod
    def neighbors_step_list_v1(point: tuple, board: list) -> list:
        # The point will have 3 elements: step list, row coordinates, col coordinates
        # By passing board, I can limit neighbors to not include visited locations

        neighbors = []

        # Row + 2, Column + 1
        if Hadrian.validate(row=point[1] + 2, column=point[2] + 1, board=board):
            base = point[0][:]
            base.append((point[1] + 2, point[2] + 1))
            neighbors.append((base, point[1] + 2, point[2] + 1))

        # Row + 2, Column - 1
        if Hadrian.validate(row=point[1] + 2, column=point[2] - 1, board=board):
            base = point[0][:]
            base.append((point[1] + 2, point[2] - 1))
            neighbors.append((base, point[1] + 2, point[2] - 1))

        # Row - 2, Column + 1
        if Hadrian.validate(row=point[1] - 2, column=point[2] + 1, board=board):
            base = point[0][:]
            base.append((point[1] - 2, point[2] + 1))
            neighbors.append((base, point[1] - 2, point[2] + 1))

        # Row - 2, Column - 1
        if Hadrian.validate(row=point[1] - 2, column=point[2] - 1, board=board):
            base = point[0][:]
            base.append((point[1] - 2, point[2] - 1))
            neighbors.append((base, point[1] - 2, point[2] - 1))

        # Row + 1, Column + 2
        if Hadrian.validate(row=point[1] + 1, column=point[2] + 2, board=board):
            base = point[0][:]
            base.append((point[1] + 1, point[2] + 2))
            neighbors.append((base, point[1] + 1, point[2] + 2))

        # Row + 1, Column - 2
        if Hadrian.validate(row=point[1] + 1, column=point[2] - 2, board=board):
            base = point[0][:]
            base.append((point[1] + 1, point[2] - 2))
            neighbors.append((base, point[1] + 1, point[2] - 2))

        # Row - 1, Column + 2
        if Hadrian.validate(row=point[1] - 1, column=point[2] + 2, board=board):
            base = point[0][:]
            base.append((point[1] - 1, point[2] + 2))
            neighbors.append((base, point[1] - 1, point[2] + 2))

        # Row - 1, Column - 2
        if Hadrian.validate(row=point[1] - 1, column=point[2] - 2, board=board):
            base = point[0][:]
            base.append((point[1] - 1, point[2] - 2))
            neighbors.append((base, point[1] - 1, point[2] - 2))

        return neighbors

    @staticmethod
    def is_target_v1(point: tuple, target_point: tuple) -> bool:
        if point[1] == target_point[0] and point[2] == target_point[1]:
            return True
        return False

    @staticmethod
    def traverse_step_count_v1(start_row: int, start_col: int, stop_row: int, stop_col: int, board_rows: int,
                               board_cols: int) -> int:
        # Generate the board
        board = Hadrian.generate_board(rows=board_rows, cols=board_cols)

        # Annotate start point 
        board[start_row][start_col] = 0

        neighbor_list = Hadrian.neighbors_step_count(point=(0, start_row, start_col), board=board)
        for neighbor in neighbor_list:
            board[neighbor[1]][neighbor[2]] = neighbor[0]

        while neighbor_list:
            current = neighbor_list.pop(
                0)  # Removes the element at index 0 and shifts the remaining elements to the left.
            if Hadrian.is_target_v1(point=current, target_point=(stop_row, stop_col)):
                return current[0]  # Step count

            for neighbor in Hadrian.neighbors_step_count(point=(current[0], current[1], current[2]), board=board):
                neighbor_list.append(neighbor)  # adds to end of list
                # set each value in board as visited here
                board[neighbor[1]][neighbor[2]] = neighbor[0]

        return -1  # fail case

    @staticmethod
    def traverse_step_path_v1(start_row: int, start_col: int, stop_row: int, stop_col: int, board_rows: int,
                              board_cols: int) -> list:
        # Generate the board
        board = Hadrian.generate_board(rows=board_rows, cols=board_cols)

        # Annotate start point 
        board[start_row][start_col] = 0

        neighbor_list = Hadrian.neighbors_step_list_v1(point=([(start_row, start_col)], start_row, start_col),
                                                       board=board)
        for neighbor in neighbor_list:
            board[neighbor[1]][neighbor[2]] = len(neighbor[0]) - 1

        while neighbor_list:
            current = neighbor_list.pop(
                0)  # Removes the element at index 0 and shifts the remaining elements to the left.
            if Hadrian.is_target_v1(point=current, target_point=(stop_row, stop_col)):
                return current[0]  # Step path

            for neighbor in Hadrian.neighbors_step_list_v1(point=(current[0], current[1], current[2]), board=board):
                neighbor_list.append(neighbor)  # adds to end of list
                # set each value in board as visited here
                board[neighbor[1]][neighbor[2]] = len(neighbor[0]) - 1

        return []  # fail case

    @staticmethod
    def is_target_v2(point: tuple, target_point: tuple) -> bool:
        if point[0] == target_point[0] and point[1] == target_point[1]:
            return True
        return False

    @staticmethod
    def generate_path(point: tuple, board: list) -> list:
        current = point
        path = []
        while current and board[current[0]][current[1]] is not None:
            path.insert(0, current)
            current = board[current[0]][current[1]]
        return path

    @staticmethod
    def neighbors_step_list_v2(point: tuple, board: list) -> list:
        # The point will have 3 elements: step list, row coordinates, col coordinates
        # By passing board, I can limit neighbors to not include visited locations

        neighbors = []

        # Row + 2, Column + 1
        if Hadrian.validate(row=point[0] + 2, column=point[1] + 1, board=board):
            neighbors.append((point[0] + 2, point[1] + 1))

        # Row + 2, Column - 1
        if Hadrian.validate(row=point[0] + 2, column=point[1] - 1, board=board):
            neighbors.append((point[0] + 2, point[1] - 1))

        # Row - 2, Column + 1
        if Hadrian.validate(row=point[0] - 2, column=point[1] + 1, board=board):
            neighbors.append((point[0] - 2, point[1] + 1))

        # Row - 2, Column - 1
        if Hadrian.validate(row=point[0] - 2, column=point[1] - 1, board=board):
            neighbors.append((point[0] - 2, point[1] - 1))

        # Row + 1, Column + 2
        if Hadrian.validate(row=point[0] + 1, column=point[1] + 2, board=board):
            neighbors.append((point[0] + 1, point[1] + 2))

        # Row + 1, Column - 2
        if Hadrian.validate(row=point[0] + 1, column=point[1] - 2, board=board):
            neighbors.append((point[0] + 1, point[1] - 2))

        # Row - 1, Column + 2
        if Hadrian.validate(row=point[0] - 1, column=point[1] + 2, board=board):
            neighbors.append((point[0] - 1, point[1] + 2))

        # Row - 1, Column - 2
        if Hadrian.validate(row=point[0] - 1, column=point[1] - 2, board=board):
            neighbors.append((point[0] - 1, point[1] - 2))

        return neighbors

    @staticmethod
    def traverse_step_count_v2(start_row: int, start_col: int, stop_row: int, stop_col: int, board_rows: int,
                               board_cols: int) -> int:
        return len(Hadrian.traverse_step_path_v1(start_row=start_row, start_col=start_col, stop_row=stop_row,
                                                 stop_col=stop_col, board_rows=board_rows,
                                                 board_cols=board_cols)) - 1

    @staticmethod
    def traverse_step_path_v2(start_row: int, start_col: int, stop_row: int, stop_col: int, board_rows: int,
                              board_cols: int) -> list:
        # Generate the board
        board = Hadrian.generate_board(rows=board_rows, cols=board_cols)

        # Annotate start point 
        board[start_row][start_col] = ()

        neighbor_list = [(start_row, start_col)]

        while neighbor_list:
            # Removes the element at index 0 and shifts the remaining elements to the left.
            current = neighbor_list.pop(0)
            if Hadrian.is_target_v2(point=current, target_point=(stop_row, stop_col)):
                return Hadrian.generate_path(point=current, board=board)  # Step path

            for neighbor in Hadrian.neighbors_step_list_v2(point=current, board=board):
                neighbor_list.append(neighbor)  # adds to end of list
                # set each value in board as visited here
                board[neighbor[0]][neighbor[1]] = current

        return []  # fail case
