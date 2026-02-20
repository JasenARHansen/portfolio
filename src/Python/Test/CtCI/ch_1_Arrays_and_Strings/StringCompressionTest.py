#!/usr/bin/env python3

import io
import unittest.mock

import src.Python.Code.CtCI.ch_1_Arrays_and_Strings.StringCompression as baseFile
from src.Python.Code.CtCI.ch_1_Arrays_and_Strings.StringCompression import StringCompression


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ['StringCompression']
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


class TestStringCompression(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_init(self) -> None:
        """Verify that expected class is found.
        """
        my_class = StringCompression()
        self.assertIsNotNone(my_class)

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_description_stdout(self, mock_stdout) -> None:
        """Nothing defined"""
        StringCompression.get_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_compress(self) -> None:
        """Nothing defined"""
        test_cases = {
            ("", ""),
            ("a", "a"),
            ("aa", "aa"),
            ("aab", "aab"),
            ("aabcccccaaa", "a2b1c5a3"),
            ("string", "string")
        }

        for first, expected in test_cases:
            result = StringCompression.compress(base=first)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)

    def test_decompress(self) -> None:
        """Nothing defined"""
        test_cases = {
            ("", ""),
            ("a", "a"),
            ("a0", ""),
            ("aa", "aa"),
            ("aab", "aab"),
            ("a2b1", "aab"),
            ("a22b1", "aaaaaaaaaaaaaaaaaaaaaab"),
            ("a2b1c5a3", "aabcccccaaa"),
            ("string", "string")
        }

        for first, expected in test_cases:
            result = StringCompression.decompress(base=first)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)


if __name__ == "__main__":
    unittest.main()
