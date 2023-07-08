#!/usr/bin/env python3

import unittest

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

    def test_get_description_alphabetical(self) -> None:
        """Nothing defined"""
        Epiris.get_description_alphabetical()

    def test_get_description_numeric(self) -> None:
        """Nothing defined"""
        Epiris.get_description_numeric()

    def test_get_description_alphabetical_numeric(self) -> None:
        """Nothing defined"""
        Epiris.get_description_alphabetical_numeric()

    def test_get_description_numeric_alphabetical(self) -> None:
        """Nothing defined"""
        Epiris.get_description_numeric_alphabetical()

    def test_output_sort_alphabetical_1(self) -> None:
        """Nothing defined"""
        word = "banana"
        reverse = True
        print(f"alphabetical: word = {word} reversed = {reverse} result = {Epiris.sort_alphabetical(value=word)}")

    def test_output_sort_alphabetical_2(self) -> None:
        """Nothing defined"""
        word = "banana"
        reverse = False
        print(f"alphabetical: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_alphabetical(value=word, reverse=reverse)}")

    def test_output_sort_alphabetical_3(self) -> None:
        """Nothing defined"""
        word = "tree"
        reverse = True
        print(f"alphabetical: word = {word} reversed = {reverse} result = {Epiris.sort_alphabetical(value=word)}")

    def test_output_sort_alphabetical_4(self) -> None:
        """Nothing defined"""
        word = "tree"
        reverse = False
        print(f"alphabetical: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_alphabetical(value=word, reverse=reverse)}")

    def test_output_sort_alphabetical_5(self) -> None:
        """Nothing defined"""
        word = "abcdabcdad"
        reverse = True
        print(f"alphabetical: word = {word} reversed = {reverse} result = {Epiris.sort_alphabetical(value=word)}")

    def test_output_sort_alphabetical_6(self) -> None:
        """Nothing defined"""
        word = "abcdabcdad"
        reverse = False
        print(f"alphabetical: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_alphabetical(value=word, reverse=reverse)}")

    def test_output_sort_numeric_1(self) -> None:
        """Nothing defined"""
        word = "banana"
        reverse = True
        print(f"numeric: word = {word} reversed = {reverse} result = {Epiris.sort_numeric(value=word)}")

    def test_output_sort_numeric_2(self) -> None:
        """Nothing defined"""
        word = "banana"
        reverse = False
        print(f"numeric: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_numeric(value=word, reverse=reverse)}")

    def test_output_sort_numeric_3(self) -> None:
        """Nothing defined"""
        word = "tree"
        reverse = True
        print(f"numeric: word = {word} reversed = {reverse} result = {Epiris.sort_numeric(value=word)}")

    def test_output_sort_numeric_4(self) -> None:
        """Nothing defined"""
        word = "tree"
        reverse = False
        print(f"numeric: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_numeric(value=word, reverse=reverse)}")

    def test_output_sort_numeric_5(self) -> None:
        """Nothing defined"""
        word = "abcdabcdad"
        reverse = True
        print(f"numeric: word = {word} reversed = {reverse} result = {Epiris.sort_numeric(value=word)}")

    def test_output_sort_numeric_6(self) -> None:
        """Nothing defined"""
        word = "abcdabcdad"
        reverse = False
        print(f"numeric: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_numeric(value=word, reverse=reverse)}")

    def test_output_sort_alphabetical_numeric_1(self) -> None:
        """Nothing defined"""
        word = "banana"
        reverse = True
        print(f"alphabetical_numeric: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_alphabetical_numeric(value=word)}")

    def test_output_sort_alphabetical_numeric_2(self) -> None:
        """Nothing defined"""
        word = "banana"
        reverse = False
        print(f"alphabetical_numeric: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_alphabetical_numeric(value=word, reverse=reverse)}")

    def test_output_sort_alphabetical_numeric_3(self) -> None:
        """Nothing defined"""
        word = "tree"
        reverse = True
        print(f"alphabetical_numeric: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_alphabetical_numeric(value=word)}")

    def test_output_sort_alphabetical_numeric_4(self) -> None:
        """Nothing defined"""
        word = "tree"
        reverse = False
        print(f"alphabetical_numeric: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_alphabetical_numeric(value=word, reverse=reverse)}")

    def test_output_sort_alphabetical_numeric_5(self) -> None:
        """Nothing defined"""
        word = "abcdabcdadc"
        reverse = True
        print(f"alphabetical_numeric: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_alphabetical_numeric(value=word)}")

    def test_output_sort_alphabetical_numeric_6(self) -> None:
        """Nothing defined"""
        word = "abcdabcdadc"
        reverse = False
        print(f"alphabetical_numeric: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_alphabetical_numeric(value=word, reverse=reverse)}")

    def test_output_sort_numeric_alphabetical_1(self) -> None:
        """Nothing defined"""
        word = "banana"
        reverse = True
        print(f"numeric_alphabetical: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_numeric_alphabetical(value=word)}")

    def test_output_sort_numeric_alphabetical_2(self) -> None:
        """Nothing defined"""
        word = "banana"
        reverse = False
        print(f"numeric_alphabetical: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_numeric_alphabetical(value=word, reverse=reverse)}")

    def test_output_sort_numeric_alphabetical_3(self) -> None:
        """Nothing defined"""
        word = "tree"
        reverse = True
        print(f"numeric_alphabetical: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_numeric_alphabetical(value=word)}")

    def test_output_sort_numeric_alphabetical_4(self) -> None:
        """Nothing defined"""
        word = "tree"
        reverse = False
        print(f"numeric_alphabetical: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_numeric_alphabetical(value=word, reverse=reverse)}")

    def test_output_sort_numeric_alphabetical_5(self) -> None:
        """Nothing defined"""
        word = "abcdabcdad"
        reverse = True
        print(f"numeric_alphabetical: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_numeric_alphabetical(value=word)}")

    def test_output_sort_numeric_alphabetical_6(self) -> None:
        """Nothing defined"""
        word = "abcdabcdad"
        reverse = False
        print(f"numeric_alphabetical: word = {word} reversed = {reverse} result ="
              f" {Epiris.sort_numeric_alphabetical(value=word, reverse=reverse)}")
