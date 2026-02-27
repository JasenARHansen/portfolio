#!/usr/bin/env python3

import io
import unittest.mock

import src.Python.Code.Challenge.Random.Queens as baseFile
from src.Python.Code.Challenge.Random.Queens import Queens


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ['Queens', 'random', 'copy']
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


class TestQueens(unittest.TestCase):
    def test_init(self) -> None:
        """Verify that expected class is found.
        """
        my_class = Queens()
        self.assertIsNotNone(my_class)

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_description_stdout(self, mock_stdout) -> None:
        """Nothing defined"""
        Queens.get_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_place_queens(self, mock_stdout) -> None:
        test_cases = {
            4,
            8,
            2,
        }

        for size in test_cases:
            result = Queens.place_queens(size=size)
            self.assertIsNotNone(result)
            self.assertIsNotNone(mock_stdout.getvalue())

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_can_place_queens(self, mock_stdout) -> None:
        test_cases = {
            (4, True),
            (8, True),
            (2, False)
        }

        for size, expected in test_cases:
            result = Queens.can_place_queens(size=size)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)
            self.assertIsNotNone(mock_stdout.getvalue())


if __name__ == "__main__":
    unittest.main()
