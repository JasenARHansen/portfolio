#!/usr/bin/env python3

import unittest.mock

# noinspection PyPep8Naming
import src.Python.Code.Interview.Hadrian.Hadrian_2 as baseFile
from src.Python.Code.Interview.Hadrian.Hadrian_2 import Hadrian_2, Advert


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ['Advert', 'Hadrian_2', 'List', 'Schedule', 'dataclass']
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
class TestHadrian_2(unittest.TestCase):

    def test_init(self) -> None:
        my_class = Hadrian_2()
        self.assertIsNotNone(my_class)

    def test_calc_expected_value_1(self) -> None:
        """Test description message"""
        test_cases = [
            ([
                Advert(1, 3, 50),
                Advert(2, 4, 10),
                Advert(3, 5, 40),
                Advert(3, 6, 70)
            ],
            120),
            ([
                Advert(6, 10, 8),
                Advert(3, 7, 7),
                Advert(0, 4, 3),
                Advert(9, 10, 5)
            ],
            12)
        ]

        for ads, expected in test_cases:
            result = Hadrian_2.calc_expected_value_1(ads=ads)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)

    def test_calc_expected_value_2(self) -> None:
        """Test description message"""
        test_cases = [
            ([
                Advert(1, 3, 50),
                Advert(2, 4, 10),
                Advert(3, 5, 40),
                Advert(3, 6, 70)
            ],
            120),
            ([
                Advert(6, 10, 8),
                Advert(3, 7, 7),
                Advert(0, 4, 3),
                Advert(9, 10, 5)
            ],
            12)
        ]

        for ads, expected in test_cases:
            result = Hadrian_2.calc_expected_value_2(ads=ads)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)

    def test_get_schedule(self) -> None:
        """Test description message"""
        test_cases = [
            ([
                Advert(1, 3, 50),
                Advert(2, 4, 10),
                Advert(3, 5, 40),
                Advert(3, 6, 70)
            ],
            [
                Advert(1, 3, 50),
                Advert(3, 6, 70)
            ]),
            ([
                Advert(6, 10, 8),
                Advert(3, 7, 7),
                Advert(0, 4, 3),
                Advert(9, 10, 5)
            ],
            [
                Advert(3, 7, 7),
                Advert(9, 10, 5)
            ])
        ]

        for ads, expected in test_cases:
            result = Hadrian_2.get_schedule(ads=ads)
            self.assertIsNotNone(result)
            self.assertEqual(expected, result)
