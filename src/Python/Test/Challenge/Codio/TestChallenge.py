#!/usr/bin/env python3

import unittest.mock

# noinspection PyPep8Naming
import src.Python.Code.Challenge.Codio.Challenge as baseFile
from src.Python.Code.Challenge.Codio.Challenge import Challenge

# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ['Challenge']
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
class TestChallenge(unittest.TestCase):

    def test_init(self) -> None:
        my_class = Challenge()
        self.assertIsNotNone(my_class)

    def test_magic_number(self) -> None:
        """Test description message"""
        # number
        test_cases = {
            2, 3, 4, 6, 6, 8, 4
        }

        for number in test_cases:
            result = Challenge.magic_number(number=6)
            self.assertIsNotNone(result)
            self.assertEqual(3, result)

