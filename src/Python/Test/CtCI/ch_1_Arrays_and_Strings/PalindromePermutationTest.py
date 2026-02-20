#!/usr/bin/env python3

import io
import unittest.mock

import src.Python.Code.CtCI.ch_1_Arrays_and_Strings.PalindromePermutation as baseFile
from src.Python.Code.CtCI.ch_1_Arrays_and_Strings.PalindromePermutation import PalindromePermutation


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ['PalindromePermutation', 're']
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


class TestPalindromePermutation(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_init(self) -> None:
        """Verify that expected class is found.
        """
        my_class = PalindromePermutation()
        self.assertIsNotNone(my_class)

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_description_stdout(self, mock_stdout) -> None:
        """Nothing defined"""
        PalindromePermutation.get_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_is_palindrome_permutation(self) -> None:
        """Nothing defined"""
        # str1, result
        test_cases = {
            ("", True),
            ("a", True),
            ("ab", False),
            ("Tact Coa", True),
            ("Rats live on no evil st", False),
            ("Rats live on no evil str", True)
        }

        for first, expected in test_cases:
            result = PalindromePermutation.is_palindrome_permutation(palindrome=first)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)


if __name__ == "__main__":
    unittest.main()
