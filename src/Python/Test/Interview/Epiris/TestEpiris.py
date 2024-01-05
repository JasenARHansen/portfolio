#!/usr/bin/env python3

import io
import unittest.mock

import src.Python.Code.Interview.Epiris.Epiris as baseFile
from src.Python.Code.Interview.Epiris.Epiris import Epiris


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ["Epiris"]
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
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        my_class = Epiris()
        self.assertIsNotNone(my_class)

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_sort_alphabetical_description_stdout(self, mock_stdout):
        Epiris.sort_alphabetical_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_sort_alphabetical_description(self) -> None:
        """Nothing defined"""
        self.assert_sort_alphabetical_description_stdout()

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_sort_numeric_description_stdout(self, mock_stdout):
        Epiris.sort_numeric_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_sort_numeric_description(self) -> None:
        """Nothing defined"""
        self.assert_sort_numeric_description_stdout()

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_sort_alphabetical_numeric_description_stdout(self, mock_stdout):
        Epiris.sort_alphabetical_numeric_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_sort_alphabetical_numeric_description_numeric(self) -> None:
        """Nothing defined"""
        self.assert_sort_alphabetical_numeric_description_stdout()

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_sort_numeric_alphabetical_description_stdout(self, mock_stdout):
        Epiris.sort_numeric_alphabetical_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_sort_numeric_alphabetical_description(self) -> None:
        """Nothing defined"""
        self.assert_sort_numeric_alphabetical_description_stdout()

    def test_output_sort_alphabetical_1(self) -> None:
        """Nothing defined"""
        expected = "nnbaaa"
        word = "banana"
        reverse = True
        result = Epiris.sort_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_alphabetical_2(self) -> None:
        """Nothing defined"""
        expected = "aaabnn"
        word = "banana"
        reverse = False
        result = Epiris.sort_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_alphabetical_3(self) -> None:
        """Nothing defined"""
        expected = "tree"
        word = "tree"
        reverse = True
        result = Epiris.sort_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_alphabetical_4(self) -> None:
        """Nothing defined"""
        expected = "eert"
        word = "tree"
        reverse = False
        result = Epiris.sort_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_alphabetical_5(self) -> None:
        """Nothing defined"""
        expected = "dddccbbaaa"
        word = "abcdabcdad"
        reverse = True
        result = Epiris.sort_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_alphabetical_6(self) -> None:
        """Nothing defined"""
        expected = "aaabbccddd"
        word = "abcdabcdad"
        reverse = False
        result = Epiris.sort_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_1(self) -> None:
        """Nothing defined"""
        expected = "aaannb"
        word = "banana"
        reverse = True
        result = Epiris.sort_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_2(self) -> None:
        """Nothing defined"""
        expected = "bnnaaa"
        word = "banana"
        reverse = False
        result = Epiris.sort_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_3(self) -> None:
        """Nothing defined"""
        expected = "eetr"
        word = "tree"
        reverse = True
        result = Epiris.sort_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_4(self) -> None:
        """Nothing defined"""
        expected = "tree"
        word = "tree"
        reverse = False
        result = Epiris.sort_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_5(self) -> None:
        """Nothing defined"""
        expected = "aaadddbbcc"
        word = "abcdabcdad"
        reverse = True
        result = Epiris.sort_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_6(self) -> None:
        """Nothing defined"""
        expected = "bbccaaaddd"
        word = "abcdabcdad"
        reverse = False
        result = Epiris.sort_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_alphabetical_numeric_1(self) -> None:
        """Nothing defined"""
        expected = "nnbaaa"
        word = "banana"
        reverse = True
        result = Epiris.sort_alphabetical_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_alphabetical_numeric_2(self) -> None:
        """Nothing defined"""
        expected = "aaabnn"
        word = "banana"
        reverse = False
        result = Epiris.sort_alphabetical_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_alphabetical_numeric_3(self) -> None:
        """Nothing defined"""
        expected = "tree"
        word = "tree"
        reverse = True
        result = Epiris.sort_alphabetical_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_alphabetical_numeric_4(self) -> None:
        """Nothing defined"""
        expected = "eert"
        word = "tree"
        reverse = False
        result = Epiris.sort_alphabetical_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_alphabetical_numeric_5(self) -> None:
        """Nothing defined"""
        expected = "dddcccbbaaa"
        word = "abcdabcdadc"
        reverse = True
        result = Epiris.sort_alphabetical_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_alphabetical_numeric_6(self) -> None:
        """Nothing defined"""
        expected = "aaabbcccddd"
        word = "abcdabcdadc"
        reverse = False
        result = Epiris.sort_alphabetical_numeric(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_alphabetical_1(self) -> None:
        """Nothing defined"""
        expected = "aaannb"
        word = "banana"
        reverse = True
        result = Epiris.sort_numeric_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_alphabetical_2(self) -> None:
        """Nothing defined"""
        expected = "bnnaaa"
        word = "banana"
        reverse = False
        result = Epiris.sort_numeric_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_alphabetical_3(self) -> None:
        """Nothing defined"""
        expected = "eetr"
        word = "tree"
        reverse = True
        result = Epiris.sort_numeric_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_alphabetical_4(self) -> None:
        """Nothing defined"""
        expected = "rtee"
        word = "tree"
        reverse = False
        result = Epiris.sort_numeric_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_alphabetical_5(self) -> None:
        """Nothing defined"""
        expected = "dddaaaccbb"
        word = "abcdabcdad"
        reverse = True
        result = Epiris.sort_numeric_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)

    def test_output_sort_numeric_alphabetical_6(self) -> None:
        """Nothing defined"""
        expected = "bbccaaaddd"
        word = "abcdabcdad"
        reverse = False
        result = Epiris.sort_numeric_alphabetical(value=word, reverse=reverse)
        self.assertEqual(expected, result)
