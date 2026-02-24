#!/usr/bin/env python3

import io
import unittest.mock

import src.Python.Code.Challenge.Random.Knights as baseFile
from src.Python.Code.Challenge.Random.Knights import Knights


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ['Knights', 'random']
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


class TestKnights(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_init(self) -> None:
        """Verify that expected class is found.
        """
        my_class = Knights()
        self.assertIsNotNone(my_class)

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_description_stdout(self, mock_stdout) -> None:
        """Nothing defined"""
        Knights.get_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_find_path(self, mock_stdout) -> None:
        # size, start_row, start_column, success
        test_cases = {
            (5, 0, 0, True),
            (2, 0, 0, False)
        }

        for size, start_row, start_column, expected in test_cases:
            result = Knights.find_path(size=size, start_row=start_row, start_column=start_column)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)




if __name__ == "__main__":
    unittest.main()
