#!/usr/bin/env python3

import io
import unittest.mock

import src.Python.Code.CtCI.ch_1_Arrays_and_Strings.OneAway as baseFile
from src.Python.Code.CtCI.ch_1_Arrays_and_Strings.OneAway import OneAway


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ['OneAway']
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


class TestOneAway(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_init(self) -> None:
        """Verify that expected class is found.
        """
        my_class = OneAway()
        self.assertIsNotNone(my_class)

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_description_stdout(self, mock_stdout) -> None:
        """Nothing defined"""
        OneAway.get_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_is_one_away(self) -> None:
        """Nothing defined"""
        test_cases = {
            ("1111", "2111", True),
            ("1222", "2223", False),
            ("1111", "11112", True),
            ("11112", "1111", True),
            ("1121", "11112", False),
            ("11112", "1121", False)
        }

        for base, test, expected in test_cases:
            result = OneAway.is_one_away(base=base, test=test)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)


if __name__ == "__main__":
    unittest.main()
