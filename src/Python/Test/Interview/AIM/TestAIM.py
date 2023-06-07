#!/usr/bin/env python3

import unittest

import Python.Code.Interview.AIM.AIM as baseFile
from Python.Code.Interview.AIM.AIM import AIM


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ['Line', 'Point', 'math', "AIM"]
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
        my_class = AIM()
        self.assertIsNotNone(my_class)

    def test_get_description_find_squares(self) -> None:
        """Test help message"""
        AIM.get_description_find_squares()

    def test_get_description_find_rectangles(self) -> None:
        """Test help message"""
        AIM.get_description_find_rectangles()

    def test_find_squares_1(self) -> None:
        """Find the squares in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3)}
        results = AIM.find_squares(points=points)
        print(f"squares from points: = {points} result ({len(results)}) ="
              f" {', '.join(str(x) for x in list(results))}")

    def test_find_squares_2(self) -> None:
        """Find the squares in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3), (4, 0), (2, 2), (2, -2)}
        results = AIM.find_squares(points=points)
        print(f"squares from points: = {points} result ({len(results)}) ="
              f" {', '.join(str(x) for x in list(results))}")

    def test_find_rectangles(self) -> None:
        """Find the rectangles in points"""
        points = {(0, 0), (1, 0), (1, 1), (0, 1), (-3, 0), (0, -3), (0, 3), (3, 0), (0, 0),
                  (3, 3), (4, 0), (2, 2), (2, -2)}
        results = AIM.find_rectangles(points=points)
        print(f"rectangles from points: = {points} result ({len(results)}) ="
              f" {', '.join(str(x) for x in list(results))}")
