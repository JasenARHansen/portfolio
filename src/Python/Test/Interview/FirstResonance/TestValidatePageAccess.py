#!/usr/bin/env python3

import io
import unittest.mock

import src.Python.Code.Interview.FirstResonance.ValidatePageAccess as baseFile
from src.Python.Code.Interview.FirstResonance.ValidatePageAccess import ValidatePageAccess


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ["ValidatePageAccess"]
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


class TestValidatePageAccess(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_init(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        my_class = ValidatePageAccess()
        self.assertIsNotNone(my_class)

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_sort_alphabetical_description_stdout(self, mock_stdout):
        ValidatePageAccess.get_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_get_description(self) -> None:
        """Nothing defined"""
        self.assert_sort_alphabetical_description_stdout()
