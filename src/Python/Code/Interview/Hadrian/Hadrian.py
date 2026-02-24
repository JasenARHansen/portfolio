class Hadrian(object):
    @staticmethod
    def get_description():
        print("""Hadrian: Interview

              Given a grid of MxN dimensions, and a starting cordinate, find the shortest path to a destination cordinate
              Minimum number of steps to travel form 1 space to a second.
                |_|_|_|_|_|_|_|_|
                |_|_|_|_|_|_|_|_|
                |_|_|_|K|_|_|_|_|
                |_|_|_|_|_|_|_|_|
                |_|_|_|_|_|_|T|_|
                |_|_|_|_|_|_|_|_|
                
                |_|_|_|_|_|_|_|_|
                |_|_|_|_|_|_|_|_|
                |_|_|_|K|_|2|_|_|
                |_|_|_|_|_|_|_|_|
                |_|_|_|_|1|_|3|_|
                |_|_|_|_|_|_|_|_|
            
              Implementation 1.  The number of steps is the only relavant piece of data
              Implementation 2.  Provide a path that has the minimum number of steps
                Note: Since the path includes the first and the last node, it will be 1 longer than implementation 1
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
    def neighbours_step_count(point: tuple, board: list) -> list:
        # The point will have 3 elements: step value, row cordinate, col cordinate
        # By passing board, I can limit neighbours to not include visited locations

        neighbours = []

        # Row + 2, Column + 1
        if Hadrian.validate(row=point[1] + 2, column=point[2] + 1, board=board):
            neighbours.append((point[0] + 1, point[1] + 2, point[2] + 1))

        # Row + 2, Column - 1
        if Hadrian.validate(row=point[1] + 2, column=point[2] - 1, board=board):
            neighbours.append((point[0] + 1, point[1] + 2, point[2] - 1))

        # Row - 2, Column + 1
        if Hadrian.validate(row=point[1] - 2, column=point[2] + 1, board=board):
            neighbours.append((point[0] + 1, point[1] - 2, point[2] + 1))

        # Row - 2, Column - 1
        if Hadrian.validate(row=point[1] - 2, column=point[2] - 1, board=board):
            neighbours.append((point[0] + 1, point[1] - 2, point[2] - 1))

        # Row + 1, Column + 2
        if Hadrian.validate(row=point[1] + 1, column=point[2] + 2, board=board):
            neighbours.append((point[0] + 1, point[1] + 1, point[2] + 2))

        # Row + 1, Column - 2
        if Hadrian.validate(row=point[1] + 1, column=point[2] - 2, board=board):
            neighbours.append((point[0] + 1, point[1] + 1, point[2] - 2))

        # Row - 1, Column + 2
        if Hadrian.validate(row=point[1] - 1, column=point[2] + 2, board=board):
            neighbours.append((point[0] + 1, point[1] - 1, point[2] + 2))

        # Row - 1, Column - 2
        if Hadrian.validate(row=point[1] - 1, column=point[2] - 2, board=board):
            neighbours.append((point[0] + 1, point[1] - 1, point[2] - 2))

        return  neighbours  

    @staticmethod
    def neighbours_step_list(point: tuple, board: list) -> list:
        # The point will have 3 elements: step list, row cordinate, col cordinate
        # By passing board, I can limit neighbours to not include visited locations

        neighbours = []

        # Row + 2, Column + 1
        if Hadrian.validate(row=point[1] + 2, column=point[2] + 1, board=board):
            base = point[0][:]
            base.append((point[1] + 2, point[2] + 1))
            neighbours.append((base, point[1] + 2, point[2] + 1))

        # Row + 2, Column - 1
        if Hadrian.validate(row=point[1] + 2, column=point[2] - 1, board=board):
            base = point[0][:]
            base.append((point[1] + 2, point[2] - 1))
            neighbours.append((base, point[1] + 2, point[2] - 1))

        # Row - 2, Column + 1
        if Hadrian.validate(row=point[1] - 2, column=point[2] + 1, board=board):
            base = point[0][:]
            base.append((point[1] - 2, point[2] + 1))
            neighbours.append((base, point[1] - 2, point[2] + 1))

        # Row - 2, Column - 1
        if Hadrian.validate(row=point[1] - 2, column=point[2] - 1, board=board):
            base = point[0][:]
            base.append((point[1] - 2, point[2] - 1))
            neighbours.append((base, point[1] - 2, point[2] - 1))

        # Row + 1, Column + 2
        if Hadrian.validate(row=point[1] + 1, column=point[2] + 2, board=board):
            base = point[0][:]
            base.append((point[1] + 1, point[2] + 2))
            neighbours.append((base, point[1] + 1, point[2] + 2))

        # Row + 1, Column - 2
        if Hadrian.validate(row=point[1] + 1, column=point[2] - 2, board=board):
            base = point[0][:]
            base.append((point[1] + 1, point[2] - 2))
            neighbours.append((base, point[1] + 1, point[2] - 2))

        # Row - 1, Column + 2
        if Hadrian.validate(row=point[1] - 1, column=point[2] + 2, board=board):
            base = point[0][:]
            base.append((point[1] - 1, point[2] + 2))
            neighbours.append((base, point[1] - 1, point[2] + 2))

        # Row - 1, Column - 2
        if Hadrian.validate(row=point[1] - 1, column=point[2] - 2, board=board):
            base = point[0][:]
            base.append((point[1] - 1, point[2] - 2))
            neighbours.append((base, point[1] - 1, point[2] - 2))

        return  neighbours  

    @staticmethod
    def is_target(point: tuple, target_point: tuple) -> bool:  
        if point[1] == target_point[0] and point[2] == target_point[1]:
            return True
        return False

    @staticmethod
    def traverse_step_count(start_row: int, start_col: int, stop_row: int, stop_col: int, board_rows: int, board_cols: int) -> int:
        # Generate the board
        board = Hadrian.generate_board(rows = board_rows, cols = board_cols)

        # Annotate start point 
        board[start_row][start_col] = 0

        neighbour_list = Hadrian.neighbours_step_count(point=(0, start_row, start_col), board=board)
        for neighbour in neighbour_list:
            board[neighbour[1]][neighbour[2]] = neighbour[0]

        while neighbour_list:
            current = neighbour_list.pop(0) # Removes the element at index 0 and shifts the remaining elements to the left.
            if Hadrian.is_target(point=current, target_point=(stop_row, stop_col)):
                return current[0] # Step count
            
            for neighbour in Hadrian.neighbours_step_count(point=(current[0], current[1], current[2]), board=board):
                neighbour_list.append(neighbour) # adds to end of list
                # set each value in board as visited here
                board[neighbour[1]][neighbour[2]] = neighbour[0]

        return -1 # fail case
 
    @staticmethod
    def traverse_step_path(start_row: int, start_col: int, stop_row: int, stop_col: int, board_rows: int, board_cols: int) -> list:
        # Generate the board
        board = Hadrian.generate_board(rows = board_rows, cols = board_cols)

        # Annotate start point 
        board[start_row][start_col] = 0

        neighbour_list = Hadrian.neighbours_step_list(point=([(start_row, start_col)], start_row, start_col), board=board)
        for neighbour in neighbour_list:
            board[neighbour[1]][neighbour[2]] = len(neighbour[0]) - 1

        while neighbour_list:
            current = neighbour_list.pop(0) # Removes the element at index 0 and shifts the remaining elements to the left.
            if Hadrian.is_target(point=current, target_point=(stop_row, stop_col)):
                return current[0] # Step path
            
            for neighbour in Hadrian.neighbours_step_list(point=(current[0], current[1], current[2]), board=board):
                neighbour_list.append(neighbour) # adds to end of list
                # set each value in board as visited here
                board[neighbour[1]][neighbour[2]] = len(neighbour[0]) - 1

        return [] # fail case
 