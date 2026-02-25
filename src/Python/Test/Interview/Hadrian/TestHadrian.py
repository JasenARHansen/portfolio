#!/usr/bin/env python3

import unittest.mock

# noinspection PyPep8Naming
import src.Python.Code.Interview.Hadrian.Hadrian as baseFile
from src.Python.Code.Interview.Hadrian.Hadrian import Hadrian


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "_" not in x]
        _test_data = ['Hadrian']
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


# noinspection SpellCheckingInspection,DuplicatedCode
class TestHadrian(unittest.TestCase):

    def test_init(self) -> None:
        my_class = Hadrian()
        self.assertIsNotNone(my_class)

    def test_generate_board(self) -> None:
        """Test description message"""
        board = Hadrian.generate_board(rows=6, cols=8)
        self.assertIsNotNone(board)

    def test_traverse_step_count_v1(self) -> None:
        """Test description message"""
        # start_row: int, start_col: int, stop_row: int, stop_col: int, board_rows: int, board_cols
        test_cases = {
            (2, 3, 4, 6, 6, 8, 3)
        }

        for start_row, start_col, stop_row, stop_col, board_rows, board_cols, expected in test_cases:
            result = Hadrian.traverse_step_count_v1(start_row=start_row, start_col=start_col, stop_row=stop_row,
                                                    stop_col=stop_col, board_rows=board_rows, board_cols=board_cols)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)

    def test_traverse_step_path_v1(self) -> None:
        """Test description message"""
        # start_row: int, start_col: int, stop_row: int, stop_col: int, board_rows: int, board_cols
        test_cases = {
            (2, 3, 4, 6, 6, 8, 4)
        }

        for start_row, start_col, stop_row, stop_col, board_rows, board_cols, expected in test_cases:
            result = Hadrian.traverse_step_path_v1(start_row=start_row, start_col=start_col, stop_row=stop_row,
                                                   stop_col=stop_col, board_rows=board_rows, board_cols=board_cols)
            self.assertIsNotNone(result)
            self.assertEqual(expected, len(result))

    def test_traverse_step_count_v2(self) -> None:
        """Test description message"""
        # start_row: int, start_col: int, stop_row: int, stop_col: int, board_rows: int, board_cols
        test_cases = {
            (2, 3, 4, 6, 6, 8, 3)
        }

        for start_row, start_col, stop_row, stop_col, board_rows, board_cols, expected in test_cases:
            result = Hadrian.traverse_step_count_v2(start_row=start_row, start_col=start_col, stop_row=stop_row,
                                                    stop_col=stop_col, board_rows=board_rows, board_cols=board_cols)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)

    def test_traverse_step_path_v2(self) -> None:
        """Test description message"""
        # start_row: int, start_col: int, stop_row: int, stop_col: int, board_rows: int, board_cols
        test_cases = {
            (2, 3, 4, 6, 6, 8, 4)
        }

        for start_row, start_col, stop_row, stop_col, board_rows, board_cols, expected in test_cases:
            result = Hadrian.traverse_step_path_v2(start_row=start_row, start_col=start_col, stop_row=stop_row,
                                                   stop_col=stop_col, board_rows=board_rows, board_cols=board_cols)
            self.assertIsNotNone(result)
            self.assertEqual(expected, len(result))
