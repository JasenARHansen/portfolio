#!/usr/bin/env python3

import inspect
import math
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

    def setUp(self):
        self.empty = ""

    def test_init(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        my_class = AIM()
        self.assertIsNotNone(my_class)

    @staticmethod
    def test_find_squares_0_get_description_squares() -> None:
        """Test help message"""
        print(f"{inspect.stack()[0][3]}: ")
        AIM.get_description_find_squares()

    def test_find_squares_1(self) -> None:
        """Find the squares in points"""
        points = {(-1.5, 0), (0, -1.5), (0, 1.5), (1.5, 0), (0, 0), (3, 3)}
        results = AIM.find_squares(points=points)
        headder = f"{inspect.stack()[0][3]}: squares from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:20} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_squares_2(self) -> None:
        """Find the squares in points"""
        points = {(-1.75, -1.75), (1.75, -1.75), (-1.75, 1.75), (1.75, 1.75), (0, 0), (3, 3)}
        results = AIM.find_squares(points=points)
        headder = f"{inspect.stack()[0][3]}: squares from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:20} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_squares_3(self) -> None:
        """Find the squares in points"""
        points = {(-1.5, 0), (0, -1.5), (0, 1.5), (1.5, 0), (0, 0), (3, 3), (-1.75, -1.75),
                  (1.75, -1.75), (-1.75, 1.75), (1.75, 1.75)}
        results = AIM.find_squares(points=points)
        headder = f"{inspect.stack()[0][3]}: squares from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:20} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_squares_4(self) -> None:
        """Find the squares in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3)}
        results = AIM.find_squares(points=points)
        headder = f"{inspect.stack()[0][3]}: squares from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:20} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_squares_5(self) -> None:
        """Find the squares in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3), (4, 0), (2, 2), (2, -2)}
        results = AIM.find_squares(points=points)
        headder = f"{inspect.stack()[0][3]}: squares from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:20} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_squares_6(self) -> None:
        """Find the squares in points"""
        points = {(0, 0), (1, 0), (1, 1), (0, 1), (-3, 0), (0, -3), (0, 3), (3, 0), (0, 0),
                  (3, 3), (4, 0), (2, 2), (2, -2)}
        results = AIM.find_squares(points=points)
        headder = f"{inspect.stack()[0][3]}: squares from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:20} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(4, len(results))

    def test_find_squares_7(self) -> None:
        """Find the squares in points"""
        points = {(0, 0), (0, 0), (0, 0), (0, 0), (2, -2)}
        results = AIM.find_squares(points=points)
        headder = f"{inspect.stack()[0][3]}: squares from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:20} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(0, len(results))

    def test_find_squares_8(self) -> None:
        """Find the squares in points"""
        points = {(0, 1), (-1, 0), (-1, 1), (0, 0), (0, 1), (1, 0), (1, 1)}
        results = AIM.find_squares(points=points)
        headder = f"{inspect.stack()[0][3]}: squares from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:20} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")

    def test_find_squares_9(self) -> None:
        """Find the squares in points"""
        points = {(-1, 1), (-1, 0), (-1, -1), (1, 1), (1, 0), (1, -1), (1, 2), (2, 1)}
        results = AIM.find_squares(points=points)
        headder = f"{inspect.stack()[0][3]}: squares from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:20} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_squares_10(self) -> None:
        """Find the squares in points"""
        points = {(0, -2), (-1, -1), (0, 0), (1, -1), (1, 1), (2, 0)}
        results = AIM.find_squares(points=points)
        headder = f"{inspect.stack()[0][3]}: squares from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:20} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_squares_11(self) -> None:
        """Find the squares in points"""
        points = {(-1, 1), (-1, -1), (0, 1), (0, -1), (1, 1), (1, -1)}
        results = AIM.find_squares(points=points)
        headder = f"{inspect.stack()[0][3]}: squares from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:20} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    @staticmethod
    def test_find_rectangles_0_get_description_rectangles() -> None:
        """Test help message"""
        print(f"{inspect.stack()[0][3]}: ")
        AIM.get_description_find_rectangles()

    def test_find_rectangles_1(self) -> None:
        """Find the rectangles in points"""
        points = {(-3, -1.5), (-1.5, -3), (0, 1.5), (1.5, 0), (0, 0), (3, 3)}
        results = AIM.find_rectangles(points=points)
        headder = f"{inspect.stack()[0][3]}: rectangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:23} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_rectangles_2(self) -> None:
        """Find the rectangles in points"""
        points = {(-3.25, -1.75), (1.75, -1.75), (-3.25, 1.75), (1.75, 1.75), (0, 0), (3, 3)}
        results = AIM.find_rectangles(points=points)
        headder = f"{inspect.stack()[0][3]}: rectangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:23} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_rectangles_3(self) -> None:
        """Find the rectangles in points"""
        points = {(-3, -1.5), (-1.5, -3), (0, 1.5), (1.5, 0), (0, 0), (-3.25, -1.75), (1.75, -1.75),
                  (-3.25, 1.75), (1.75, 1.75), (0, 0), (3, 3)}
        results = AIM.find_rectangles(points=points)
        headder = f"{inspect.stack()[0][3]}: rectangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:23} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_rectangles_4(self) -> None:
        """Find the rectangles in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3)}
        results = AIM.find_rectangles(points=points)
        headder = f"{inspect.stack()[0][3]}: rectangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:23} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_rectangles_5(self) -> None:
        """Find the rectangles in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3), (4, 0), (2, 2), (2, -2)}
        results = AIM.find_rectangles(points=points)
        headder = f"{inspect.stack()[0][3]}: rectangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:23} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_rectangles_6(self) -> None:
        """Find the rectangles in points"""
        points = {(0, 0), (1, 0), (1, 1), (0, 1), (-3, 0), (0, -3), (0, 3), (3, 0), (0, 0),
                  (3, 3), (4, 0), (2, 2), (2, -2)}
        results = AIM.find_rectangles(points=points)
        headder = f"{inspect.stack()[0][3]}: rectangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:23} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(4, len(results))

    def test_find_rectangles_7(self) -> None:
        """Find the rectangles in points"""
        points = {(0, 0), (0, 0), (0, 0), (0, 0), (2, -2)}
        results = AIM.find_rectangles(points=points)
        headder = f"{inspect.stack()[0][3]}: rectangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:23} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(0, len(results))

    def test_find_rectangles_8(self) -> None:
        """Find the rectangles in points"""
        points = {(-1, 1), (-1, 0), (-1, -1), (1, 1), (1, 0), (1, -1), (1, 2), (2, 1)}
        results = AIM.find_rectangles(points=points)
        headder = f"{inspect.stack()[0][3]}: rectangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:23} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_rectangles_9(self) -> None:
        """Find the rectangles in points"""
        points = {(0, -2), (-1, -1), (0, 0), (1, -1), (1, 1), (2, 0)}
        results = AIM.find_rectangles(points=points)
        headder = f"{inspect.stack()[0][3]}: rectangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:23} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_rectangles_10(self) -> None:
        """Find the rectangles in points"""
        points = {(-1, 1), (-1, -1), (0, 1), (0, -1), (1, 1), (1, -1)}
        results = AIM.find_rectangles(points=points)
        headder = f"{inspect.stack()[0][3]}: rectangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:23} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    @staticmethod
    def test_find_triangles_0_get_description() -> None:
        """Test help message"""
        print(f"{inspect.stack()[0][3]}: ")
        AIM.get_description_find_triangles()

    def test_find_triangles_1(self) -> None:
        """Find the triangles in points"""
        points = {(0, 0), (1, math.sqrt(3)), (2, 0), (-1, math.sqrt(3)), (-2, 0),
                  (0, math.sqrt(3)), (0, 2 * math.sqrt(3))}
        results = AIM.find_triangles(points=points)
        headder = f"{inspect.stack()[0][3]}: triangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:22} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(30, len(results))

    @staticmethod
    def test_find_triangles_isosceles_0_get_description() -> None:
        """Test help message"""
        print(f"{inspect.stack()[0][3]}: ")
        AIM.get_description_find_triangles_isosceles()

    def test_find_triangles_isosceles_1(self) -> None:
        """Find the isosceles triangles in points"""
        points = {(0, 0), (1, math.sqrt(3)), (2, 0), (-1, math.sqrt(3)), (-2, 0),
                  (0, math.sqrt(3)), (0, 2 * math.sqrt(3))}
        results = AIM.find_triangles_isosceles(points=points)
        headder = f"{inspect.stack()[0][3]}: isosceles triangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:32} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(15, len(results))

    @staticmethod
    def test_find_triangles_equilateral_0_get_description() -> None:
        """Test help message"""
        print(f"{inspect.stack()[0][3]}: ")
        AIM.get_description_find_triangles_equilateral()

    def test_find_triangles_equilateral_1(self) -> None:
        """Find the equilateral triangles in points"""
        points = {(0, 0), (1, math.sqrt(3)), (2, 0), (-1, math.sqrt(3)), (-2, 0),
                  (0, math.sqrt(3)), (0, 2 * math.sqrt(3))}
        results = AIM.find_triangles_equilateral(points=points)
        headder = f"{inspect.stack()[0][3]}: equilateral triangles from"
        print(f"{headder} points: = {points}\n"
              f"{self.empty:34} result ({len(results)}) = {', '.join(str(x) for x in list(results))}")
        self.assertIsNotNone(results)
        self.assertEqual(5, len(results))
