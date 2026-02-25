#!/usr/bin/env python3

import io
import unittest.mock

import src.Python.Code.CtCI.ch_1_Arrays_and_Strings.RotateMatrix as baseFile
from src.Python.Code.CtCI.ch_1_Arrays_and_Strings.RotateMatrix import RotateMatrix


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ['RotateMatrix']
        expected_not_found = [x for x in _test_data if x not in items_found]
        found_not_expected = [x for x in items_found if x not in _test_data]
        self.assertEqual(
            len(_test_data),
            len(items_found),
            f"Expected but not found: {expected_not_found}, found but not expected:"
            f" {found_not_expected}",
        )
        self.assertEqual(
            0,
            len(expected_not_found),
            f"Expected but not found: {expected_not_found}, found but not expected:"
            f" {found_not_expected}",
        )


class TestRotateMatrix(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_init(self) -> None:
        """Verify that expected class is found.
        """
        my_class = RotateMatrix()
        self.assertIsNotNone(my_class)

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_description_stdout(self, mock_stdout) -> None:
        """Nothing defined"""
        RotateMatrix.get_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_RotateMatrix(self) -> None:
        """Nothing defined"""
        test_cases = [
            ([[1, 2, 3], [4, 5, 6], [7, 8, 9]], [[7, 4, 1], [8, 5, 2], [9, 6, 3]]),
            (
                [
                    [1, 2, 3, 4, 5],
                    [6, 7, 8, 9, 10],
                    [11, 12, 13, 14, 15],
                    [16, 17, 18, 19, 20],
                    [21, 22, 23, 24, 25],
                ],
                [
                    [21, 16, 11, 6, 1],
                    [22, 17, 12, 7, 2],
                    [23, 18, 13, 8, 3],
                    [24, 19, 14, 9, 4],
                    [25, 20, 15, 10, 5],
                ],
            ),
        ]

        for test_matrix, expected in test_cases:
            result = RotateMatrix.rotate_matrix(matrix=test_matrix)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)

    def test_RotateMatrixInPlace(self) -> None:
        """Nothing defined"""
        test_cases = [
            ([[1, 2, 3], [4, 5, 6], [7, 8, 9]], [[7, 4, 1], [8, 5, 2], [9, 6, 3]]),
            (
                [
                    [1, 2, 3, 4, 5],
                    [6, 7, 8, 9, 10],
                    [11, 12, 13, 14, 15],
                    [16, 17, 18, 19, 20],
                    [21, 22, 23, 24, 25],
                ],
                [
                    [21, 16, 11, 6, 1],
                    [22, 17, 12, 7, 2],
                    [23, 18, 13, 8, 3],
                    [24, 19, 14, 9, 4],
                    [25, 20, 15, 10, 5],
                ],
            ),
        ]

        for test_matrix, expected in test_cases:
            result = RotateMatrix.rotate_matrix_in_place(matrix=test_matrix)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)


if __name__ == "__main__":
    unittest.main()
