#!/usr/bin/env python3

import unittest

import src.Code.Python.Interview.AmadaWeldTech.AmadaWeldTech as baseFile
from src.Code.Python.Interview.AmadaWeldTech.AmadaWeldTech import Chalenge


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ["os", "Chalenge"]
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


# noinspection SpellCheckingInspection
class TestValidatePageAccess(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_init(self) -> None:
        """Assert init creates an object.
        """
        my_class = Chalenge()
        self.assertIsNotNone(my_class)

    def test_read_file(self) -> None:
        """Verify the input file can be read.
        """
        my_class = Chalenge()
        self.assertIsNone(my_class.lines)
        my_class.read_file()
        self.assertIsNotNone(my_class.lines)

    def test_reverse_character(self) -> None:
        """Reverse characters and optput file.
        """
        my_class = Chalenge()
        my_class.read_file()
        my_class.reverse_character()

    def test_reverse_lines(self) -> None:
        """Reverse lines and optput file.
        """
        my_class = Chalenge()
        my_class.read_file()
        my_class.reverse_lines()
