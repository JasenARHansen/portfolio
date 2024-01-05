#!/usr/bin/env python3

import io
import math
import unittest.mock

# noinspection PyPep8Naming
import src.Python.Code.Interview.AIM.AIM as baseFile
from src.Python.Code.Interview.AIM.AIM import AIM


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "_" not in x]
        _test_data = ['AIM', 'Line', 'Point', 'math', 'reduce']
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

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_irregular_description_stdout(self, mock_stdout):
        AIM.find_irregular_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_irregular_description(self) -> None:
        """Test description message"""
        self.assert_find_irregular_description_stdout()

    def test_find_irregular_1(self) -> None:
        """Find the irregulars in points"""
        points = {(-2, -1), (-1, -2), (1, 2), (2, 1), (0, 0)}
        results = AIM.find_irregular(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(0, len(results))

    def test_find_irregular_2(self) -> None:
        """Find the irregulars in points"""
        points = {(-3, 1), (-1, 2), (1, 2), (2, 1), (0, 0)}
        results = AIM.find_irregular(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_kite_description_stdout(self, mock_stdout):
        AIM.find_kite_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_kite_description(self) -> None:
        """Test description message"""
        self.assert_find_kite_description_stdout()

    def test_find_kite_1(self) -> None:
        """Find the kites in points"""
        points = {(-2, 0), (2, 0), (0, -2), (0, 2), (4, 0), (0, 4)}
        results = AIM.find_kite(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_kite_2(self) -> None:
        """Find the kites in points"""
        points = {(-3, -1.5), (-1.5, -3), (0, 1.5), (1.5, 0), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_kite(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(4, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_isosceles_trapezoid_description_stdout(self, mock_stdout):
        AIM.find_isosceles_trapezoid_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_isosceles_trapezoid_description(self) -> None:
        """Test description message"""
        self.assert_find_isosceles_trapezoid_description_stdout()

    def test_find_isosceles_trapezoid_1(self) -> None:
        """Find the isosceles trapezoids in points"""
        points = {(-1, 1), (1, 1), (-2, -1), (2, -1)}
        results = AIM.find_isosceles_trapezoid(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_isosceles_trapezoid_2(self) -> None:
        """Find the isosceles trapezoids in points"""
        points = {(0, 2), (0, 4), (2, 0), (4, 0)}
        results = AIM.find_isosceles_trapezoid(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_isosceles_trapezoid_3(self) -> None:
        """Find the isosceles trapezoids in points"""
        points = {(-1, 1), (1, 1), (-2, -1), (2, -1), (0, 2), (0, 4), (2, 0), (4, 0)}
        results = AIM.find_isosceles_trapezoid(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_isosceles_trapezoid_4(self) -> None:
        """Find the isosceles trapezoids in points"""
        points = {(0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_isosceles_trapezoid(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(0, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_trapezoid_description_stdout(self, mock_stdout):
        AIM.find_trapezoid_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_trapezoid_description(self) -> None:
        """Test description message"""
        self.assert_find_trapezoid_description_stdout()

    def test_find_trapezoid_1(self) -> None:
        """Find the trapezoids in points"""
        points = {(0, 1), (1, 1), (2, -1), (-2, -1)}
        results = AIM.find_trapezoid(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_trapezoid_2(self) -> None:
        """Find the trapezoids in points"""
        points = {(0, 0), (1, 1), (0, -2), (2, 0)}
        results = AIM.find_trapezoid(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_trapezoid_3(self) -> None:
        """Find the trapezoids in points"""
        points = {(0, 1), (1, 1), (2, -1), (-2, -1), (0, 0), (1, 1), (0, -2), (2, 0)}
        results = AIM.find_trapezoid(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(5, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_parallelogram_description_stdout(self, mock_stdout):
        AIM.find_parallelogram_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_parallelogram_description(self) -> None:
        """Test description message"""
        self.assert_find_isosceles_trapezoid_description_stdout()

    def test_find_parallelogram_1(self) -> None:
        """Find the parallelograms in points"""
        points = {(-3, -1.5), (-1.5, -3), (0, 1.5), (1.5, 0), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_parallelogram(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(5, len(results))

    def test_find_parallelogram_2(self) -> None:
        """Find the parallelograms in points"""
        points = {(-3.25, -1.75), (1.75, -1.75), (-3.25, 1.75), (1.75, 1.75), (0, 0), (3, 3), (0, 3),
                  (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_parallelogram(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_parallelogram_3(self) -> None:
        """Find the parallelograms in points"""
        points = {(-3, -1.5), (-1.5, -3), (0, 1.5), (1.5, 0), (0, 0), (-3.25, -1.75), (1.75, -1.75),
                  (-3.25, 1.75), (1.75, 1.75), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_parallelogram(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(8, len(results))

    def test_find_parallelogram_4(self) -> None:
        """Find the parallelograms in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_parallelogram(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(5, len(results))

    def test_find_parallelogram_5(self) -> None:
        """Find the parallelograms in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3), (4, 0), (2, 2), (2, -2), (0, 3),
                  (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_parallelogram(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(6, len(results))

    def test_find_parallelogram_6(self) -> None:
        """Find the parallelograms in points"""
        points = {(0, 0), (1, 0), (1, 1), (0, 1), (-3, 0), (0, -3), (0, 3), (3, 0), (0, 0),
                  (3, 3), (4, 0), (2, 2), (2, -2), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_parallelogram(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(15, len(results))

    def test_find_parallelogram_7(self) -> None:
        """Find the parallelograms in points"""
        points = {(0, 0), (0, 0), (0, 0), (0, 0), (2, -2), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_parallelogram(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_parallelogram_8(self) -> None:
        """Find the parallelograms in points"""
        points = {(-1, 1), (-1, 0), (-1, -1), (1, 1), (1, 0), (1, -1), (1, 2), (2, 1), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_parallelogram(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(18, len(results))

    def test_find_parallelogram_9(self) -> None:
        """Find the parallelograms in points"""
        points = {(0, -2), (-1, -1), (0, 0), (1, -1), (1, 1), (2, 0), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_parallelogram(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(9, len(results))

    def test_find_parallelogram_10(self) -> None:
        """Find the parallelograms in points"""
        points = {(-1, 1), (-1, -1), (0, 1), (0, -1), (1, 1), (1, -1), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_parallelogram(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(17, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_rhombus_description_stdout(self, mock_stdout):
        AIM.find_rhombus_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_rhombus_description(self) -> None:
        """Test description message"""
        self.assert_find_rhombus_description_stdout()

    def test_find_rhombus_1(self) -> None:
        """Find the rhombuses in points"""
        points = {(-3, -1.5), (-1.5, -3), (0, 1.5), (1.5, 0), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rhombus(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_rhombus_2(self) -> None:
        """Find the rhombuses in points"""
        points = {(-3.25, -1.75), (1.75, -1.75), (-3.25, 1.75), (1.75, 1.75), (0, 0), (3, 3), (0, 3),
                  (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rhombus(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_rhombus_3(self) -> None:
        """Find the rhombuses in points"""
        points = {(-3, -1.5), (-1.5, -3), (0, 1.5), (1.5, 0), (0, 0), (-3.25, -1.75), (1.75, -1.75),
                  (-3.25, 1.75), (1.75, 1.75), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rhombus(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_rhombus_4(self) -> None:
        """Find the rhombuses in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rhombus(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_rhombus_5(self) -> None:
        """Find the rhombuses in points"""
        points = {(-3, 0), (0, 0), (0, 3), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rhombus(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_rhombus_6(self) -> None:
        """Find the rhombuses in points"""
        points = {(0, 0), (1, 0), (1, 1), (0, 1), (-3, 0), (0, -3), (0, 3), (3, 0), (0, 0),
                  (3, 3), (4, 0), (2, 2), (2, -2), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rhombus(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(7, len(results))

    def test_find_rhombus_7(self) -> None:
        """Find the rhombuses in points"""
        points = {(0, 0), (0, 0), (0, 0), (0, 0), (2, -2), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rhombus(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_rhombus_8(self) -> None:
        """Find the rhombuses in points"""
        points = {(-1, 1), (-1, 0), (-1, -1), (1, 1), (1, 0), (1, -1), (1, 2), (2, 1), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rhombus(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_rhombus_9(self) -> None:
        """Find the rhombuses in points"""
        points = {(0, -2), (-1, -1), (0, 0), (1, -1), (1, 1), (2, 0), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rhombus(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_rhombus_10(self) -> None:
        """Find the rhombuses in points"""
        points = {(-1, 1), (-1, -1), (0, 1), (0, -1), (1, 1), (1, -1), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rhombus(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(5, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_rectangle_description_stdout(self, mock_stdout):
        AIM.find_rectangle_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_rectangle_description(self) -> None:
        """Test description message"""
        self.assert_find_rectangle_description_stdout()

    def test_find_rectangle_1(self) -> None:
        """Find the rectangles in points"""
        points = {(-3, -1.5), (-1.5, -3), (0, 1.5), (1.5, 0), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rectangle(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_rectangle_2(self) -> None:
        """Find the rectangles in points"""
        points = {(-3.25, -1.75), (1.75, -1.75), (-3.25, 1.75), (1.75, 1.75), (0, 0), (3, 3), (0, 3),
                  (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rectangle(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_rectangle_3(self) -> None:
        """Find the rectangles in points"""
        points = {(-3, -1.5), (-1.5, -3), (0, 1.5), (1.5, 0), (0, 0), (-3.25, -1.75), (1.75, -1.75),
                  (-3.25, 1.75), (1.75, 1.75), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rectangle(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_rectangle_4(self) -> None:
        """Find the rectangles in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rectangle(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_rectangle_5(self) -> None:
        """Find the rectangles in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3), (4, 0), (2, 2), (2, -2), (0, 3), (0, -3),
                  (4, 0), (-4, 0)}
        results = AIM.find_rectangle(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_rectangle_6(self) -> None:
        """Find the rectangles in points"""
        points = {(0, 0), (1, 0), (1, 1), (0, 1), (-3, 0), (0, -3), (0, 3), (3, 0), (0, 0),
                  (3, 3), (4, 0), (2, 2), (2, -2), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rectangle(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(4, len(results))

    def test_find_rectangle_7(self) -> None:
        """Find the rectangles in points"""
        points = {(0, 0), (0, 0), (0, 0), (0, 0), (2, -2), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rectangle(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(0, len(results))

    def test_find_rectangle_8(self) -> None:
        """Find the rectangles in points"""
        points = {(-1, 1), (-1, 0), (-1, -1), (1, 1), (1, 0), (1, -1), (1, 2), (2, 1), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rectangle(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_rectangle_9(self) -> None:
        """Find the rectangles in points"""
        points = {(0, -2), (-1, -1), (0, 0), (1, -1), (1, 1), (2, 0), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rectangle(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_rectangle_10(self) -> None:
        """Find the rectangles in points"""
        points = {(-1, 1), (-1, -1), (0, 1), (0, -1), (1, 1), (1, -1), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_rectangle(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_square_description_stdout(self, mock_stdout):
        AIM.find_square_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_square_description(self) -> None:
        """Test description message"""
        self.assert_find_square_description_stdout()

    def test_find_square_1(self) -> None:
        """Find the squares in points"""
        points = {(-1.5, 0), (0, -1.5), (0, 1.5), (1.5, 0), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_square_2(self) -> None:
        """Find the squares in points"""
        points = {(-1.75, -1.75), (1.75, -1.75), (-1.75, 1.75), (1.75, 1.75), (0, 0), (3, 3), (0, 3), (0, -3),
                  (4, 0), (-4, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_square_3(self) -> None:
        """Find the squares in points"""
        points = {(-1.5, 0), (0, -1.5), (0, 1.5), (1.5, 0), (0, 0), (3, 3), (-1.75, -1.75),
                  (1.75, -1.75), (-1.75, 1.75), (1.75, 1.75), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_square_4(self) -> None:
        """Find the squares in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_square_5(self) -> None:
        """Find the squares in points"""
        points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3), (4, 0), (2, 2), (2, -2), (0, 3), (0, -3),
                  (4, 0), (-4, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(3, len(results))

    def test_find_square_6(self) -> None:
        """Find the squares in points"""
        points = {(0, 0), (1, 0), (1, 1), (0, 1), (-3, 0), (0, -3), (0, 3), (3, 0), (0, 0),
                  (3, 3), (4, 0), (2, 2), (2, -2), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(4, len(results))

    def test_find_square_7(self) -> None:
        """Find the squares in points"""
        points = {(0, 0), (0, 0), (0, 0), (0, 0), (2, -2), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(0, len(results))

    def test_find_square_8(self) -> None:
        """Find the squares in points"""
        points = {(0, 1), (-1, 0), (-1, 1), (0, 0), (0, 1), (1, 0), (1, 1), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_square_9(self) -> None:
        """Find the squares in points"""
        points = {(-1, 1), (-1, 0), (-1, -1), (1, 1), (1, 0), (1, -1), (1, 2), (2, 1), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_square_10(self) -> None:
        """Find the squares in points"""
        points = {(0, -2), (-1, -1), (0, 0), (1, -1), (1, 1), (2, 0), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(2, len(results))

    def test_find_square_11(self) -> None:
        """Find the squares in points"""
        points = {(-1, 1), (-1, -1), (0, 1), (0, -1), (1, 1), (1, -1), (0, 3), (0, -3), (4, 0), (-4, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    def test_find_square_12(self) -> None:
        """Find the squares in points"""
        points = {(1, 0), (1, 1), (0, 1), (0, 0)}
        results = AIM.find_square(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(1, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_triangle_scalene_description_stdout(self, mock_stdout):
        AIM.find_triangle_scalene_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_triangle_scalene_description(self) -> None:
        """Test description message"""
        self.assert_find_triangle_scalene_description_stdout()

    def test_find_triangle_scalene_1(self) -> None:
        """Find the scalene triangles in points"""
        points = {(0, 0), (1, math.sqrt(3)), (2, 0), (-1, math.sqrt(3)), (-2, 0),
                  (0, math.sqrt(3)), (0, 2 * math.sqrt(3)), (0, -2)}
        results = AIM.find_triangle_scalene(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(48, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_triangle_acute_description_stdout(self, mock_stdout):
        AIM.find_triangle_acute_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_triangle_acute_description(self) -> None:
        """Test description message"""
        self.assert_find_triangle_scalene_description_stdout()

    def test_find_triangle_acute_1(self) -> None:
        """Find the acute triangles in points"""
        points = {(0, 0), (1, math.sqrt(3)), (2, 0), (-1, math.sqrt(3)), (-2, 0),
                  (0, math.sqrt(3)), (0, 2 * math.sqrt(3)), (0, -2)}
        results = AIM.find_triangle_acute(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(10, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_triangle_obtuse_description_stdout(self, mock_stdout):
        AIM.find_triangle_obtuse_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_triangle_obtuse_description(self) -> None:
        """Test description message"""
        self.assert_find_triangle_obtuse_description_stdout()

    def test_find_triangle_obtuse_1(self) -> None:
        """Find the obtuse triangles in points"""
        points = {(0, 0), (1, math.sqrt(3)), (2, 0), (-1, math.sqrt(3)), (-2, 0),
                  (0, math.sqrt(3)), (0, 2 * math.sqrt(3)), (0, -2)}
        results = AIM.find_triangle_obtuse(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(21, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_triangle_right_description_stdout(self, mock_stdout):
        AIM.find_triangle_right_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_triangle_right_description(self) -> None:
        """Test description message"""
        self.assert_find_triangle_right_description_stdout()

    def test_find_triangle_right_1(self) -> None:
        """Find the right triangles in points"""
        points = {(0, 0), (1, math.sqrt(3)), (2, 0), (-1, math.sqrt(3)), (-2, 0),
                  (0, math.sqrt(3)), (0, 2 * math.sqrt(3)), (0, -2)}
        results = AIM.find_triangle_right(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(17, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_triangle_isosceles_description_stdout(self, mock_stdout):
        AIM.find_triangle_isosceles_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_triangle_isosceles_description(self) -> None:
        """Test description message"""
        self.assert_find_triangle_isosceles_description_stdout()

    def test_find_triangle_isosceles_1(self) -> None:
        """Find the isosceles triangles in points"""
        points = {(0, 0), (1, math.sqrt(3)), (2, 0), (-1, math.sqrt(3)), (-2, 0),
                  (0, math.sqrt(3)), (0, 2 * math.sqrt(3)), (0, -2)}
        results = AIM.find_triangle_isosceles(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(18, len(results))

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_find_triangle_equilateral_description_stdout(self, mock_stdout):
        AIM.find_triangle_equilateral_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_find_triangle_equilateral_description(self) -> None:
        """Test description message"""
        self.assert_find_triangle_isosceles_description_stdout()

    def test_find_triangle_equilateral_1(self) -> None:
        """Find the equilateral triangles in points"""
        points = {(0, 0), (1, math.sqrt(3)), (2, 0), (-1, math.sqrt(3)), (-2, 0),
                  (0, math.sqrt(3)), (0, 2 * math.sqrt(3)), (0, -2)}
        results = AIM.find_triangle_equilateral(points=points)
        self.assertIsNotNone(results)
        self.assertEqual(5, len(results))
