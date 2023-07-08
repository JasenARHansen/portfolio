#!/usr/bin/env python3

import unittest

import src.Python.Code.Challenge.PowersOfBase as baseFile
from src.Python.Code.Challenge.PowersOfBase import PowersOfBase


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ["PowersOfBase", "math"]
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


class TestPowersOfBase(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_init(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        my_class = PowersOfBase()
        self.assertIsNotNone(my_class)

    def test_get_description(self) -> None:
        """Nothing defined"""
        PowersOfBase.get_description()

    def test_convert_to_number(self) -> None:
        """Nothing defined"""
        my_value = PowersOfBase.convert_to_number(string_value="1001", number_base=2)
        self.assertIsNotNone(my_value)
        self.assertEqual(9, my_value)

    def test_base_exponent_success(self) -> None:
        """Nothing defined"""
        my_value = PowersOfBase.convert_to_number(string_value="11001", number_base=2)
        success = PowersOfBase.test_base_exponent(input_value=my_value, power_base=5)
        self.assertIsNotNone(success)
        self.assertTrue(success)

    def test_base_exponent_failure(self) -> None:
        """Nothing defined"""
        my_value = PowersOfBase.convert_to_number(string_value="1001", number_base=2)
        success = PowersOfBase.test_base_exponent(input_value=my_value, power_base=5)
        self.assertIsNotNone(success)
        self.assertFalse(success)

    def test_split_to_base_0(self) -> None:
        """Nothing defined"""
        my_list = PowersOfBase.split_to_base(string_value="10", number_base=2, power_base=5)
        self.assertIsNotNone(my_list)
        self.assertEqual(0, len(my_list))

    def test_split_to_base_1(self) -> None:
        """Nothing defined"""
        my_list = PowersOfBase.split_to_base(string_value="101", number_base=2, power_base=5)
        self.assertIsNotNone(my_list)
        self.assertEqual(1, len(my_list))

    def test_split_to_base_2(self) -> None:
        """Nothing defined"""
        my_list = PowersOfBase.split_to_base(string_value="101011001", number_base=2, power_base=5)
        self.assertIsNotNone(my_list)
        self.assertEqual(2, len(my_list))

    def test_split_to_base_3(self) -> None:
        """Nothing defined"""
        my_list = PowersOfBase.split_to_base(string_value="101101011001", number_base=2, power_base=5)
        self.assertIsNotNone(my_list)
        self.assertEqual(3, len(my_list))

    def test_split_to_base_5(self) -> None:
        """Nothing defined"""
        my_list = PowersOfBase.split_to_base(string_value="55", number_base=10, power_base=5)
        self.assertIsNotNone(my_list)
        self.assertEqual(2, len(my_list))

    def test_split_to_base_6(self) -> None:
        """Nothing defined"""
        my_list = PowersOfBase.split_to_base(string_value="497", number_base=10, power_base=7)
        self.assertIsNotNone(my_list)
        self.assertEqual(2, len(my_list))


if __name__ == "__main__":
    unittest.main()
