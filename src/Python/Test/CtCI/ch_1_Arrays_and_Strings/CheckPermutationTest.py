#!/usr/bin/env python3

import io
import unittest.mock

import src.Python.Code.CtCI.ch_1_Arrays_and_Strings.CheckPermutation as baseFile
from src.Python.Code.CtCI.ch_1_Arrays_and_Strings.CheckPermutation import CheckPermutation


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ['CheckPermutation', 're']
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


class TestCheckPermutation(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_init(self) -> None:
        """Verify that expected class is found.
        """
        my_class = CheckPermutation()
        self.assertIsNotNone(my_class)

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def test_description_stdout(self, mock_stdout) -> None:
        """Nothing defined"""
        CheckPermutation.get_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_is_character_permutation(self) -> None:
        """Nothing defined"""
        # str1, str2, is_permutation
        test_cases = (
            ("dog.", "god.", True),
            ("the dog is good.", "the dogo is god.", True),
            ("12345", "54321", True),
            ("a1b2", "2b1a", True),
            ("dogo", "gods", False),
            ("abcd`", "abcd2", False),
            ("2354", "1234", False),
            ("abcd", "efgh", False),
            ("DOG", "dog", False),
            ("dog ", "dog", False),
            ("aaab", "bbba", False),
        )

        for first, second, expected in test_cases:
            result = CheckPermutation.is_character_permutation(first=first, second=second)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)

    def test_is_character_permutation_stripped(self) -> None:
        """Nothing defined"""
        # str1, str2, is_permutation

        test_cases = (
            ("dog.", "god.", True),
            ("the dog is good.", "the dogo is god.", True),
            ("12,345", "54,321", True),
            ("a1 b2", "2b 1a", True),
            ("dogo", "gods", False),
            ("abcd`", "abcd2", False),
            ("2354", "1234", False),
            ("abcd", "efgh", False),
            ("DOG", "dog", False),
            ("dog ", "god", False),
            ("aaab", "bbba", False),
        )
        for first, second, expected in test_cases:
            result = CheckPermutation.is_character_permutation_stripped(first=first, second=second)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)

    def test_is_word_permutation(self) -> None:
        """Nothing defined"""
        # str1, str2, is_permutation
        test_cases = (
            ("dog.", "god.", False),
            ("the god is dogo", "the dogo is god", True),
            ("12,345", "54,321", False),
            ("a1 b2", "b2 a1", True),
            ("dogo", "gods", False),
            ("abcd`", "abcd2", False),
            ("2354", "1234", False),
            ("abcd", "efgh", False),
            ("DOG", "dog", False),
            ("dog ", "god", False),
            ("aaab", "bbba", False),
        )
        for first, second, expected in test_cases:
            result = CheckPermutation.is_word_permutation(first=first, second=second)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)

    def test_is_word_permutation_stripped(self) -> None:
        """Nothing defined"""
        # str1, str2, is_permutation
        test_cases = (
            ("dog, god", "god dog.", True),
            ("the dog  is god", "the god is dog", True),
            ("do.gx", "g,odz", False),
            ("abcd", "d2cba", False),
            ("2354", "1234", False),
            ("dcw4f", "dcw5f", False),
            ("DOG", "dog", False),
            ("dog ", "god", False),
            ("aaab", "bbba", False),
        )
        for first, second, expected in test_cases:
            result = CheckPermutation.is_word_permutation_stripped(first=first, second=second)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)


if __name__ == "__main__":
    unittest.main()
