class RotateMatrix(object):
    @staticmethod
    def get_description():
        print("""Arrays and Strings: Rotate Matrix
    Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write
     a method to rotate the image by 90 degrees.
    Can you do this in place?
    Example:
        If the array is
            [[1, 2],
             [3, 4]]
        Then the rotated array becomes:
            [[3, 1],
             [4, 2]]
    """)

    @staticmethod
    def rotate_matrix(matrix: list) -> list:
        """rotates a matrix 90 degrees clockwise"""
        # Creates N rows, each containing M instances of None
        result = [[None for _ in range(len(matrix))] for _ in range(len(matrix[0]))]
        for shell in range(len(matrix)):
            for space in range(len(matrix[shell])):
                result[shell].insert(0, matrix[space][shell])
                result[shell].pop()
        return result

    @staticmethod
    def rotate_matrix_in_place(matrix: list) -> list:
        """rotates a matrix 90 degrees clockwise"""
        for shell in range((len(matrix) + 1) // 2):
            for space in range(len(matrix) - 2 * shell - 1):
                # Top -> Storage
                storage = matrix[shell][space + shell]
                # Left -> Top
                matrix[shell][space + shell] = matrix[len(matrix) - 1 - shell - space][shell]
                # Bottom -> Left

                # Right -> Bottom

                # Storage -> Right
                # Not Implemented yet

        return matrix

