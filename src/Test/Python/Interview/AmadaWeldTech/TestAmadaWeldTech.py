#!/usr/bin/env python3
import unittest

import src.Code.Python.Interview.AmadaWeldTech.AmadaWeldTech as baseFile
from src.Code.Python.Interview.AmadaWeldTech.AmadaWeldTech import AmadaWeldTech


# noinspection DuplicatedCode, SpellCheckingInspection
class TestFile(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    def test_validate_file(self) -> None:
        """Verify that only expected objects are in the file.  This includes named imports,
        classes, constants, and root methods.
        """
        items_found = dir(baseFile)
        items_found = [x for x in items_found if "__" not in x]
        _test_data = ['AmadaWeldTech', 'inspect', 'os']
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
        my_class = AmadaWeldTech()
        self.assertIsNotNone(my_class)

    def test_reverse_character_memory(self) -> None:
        """Reverse characters and output file.
        """
        my_class = AmadaWeldTech()
        my_class.reverse_characters()

    def test_reverse_character_processor(self) -> None:
        """Reverse characters and output file.
        """
        my_class = AmadaWeldTech(mode=1)
        my_class.reverse_characters()

    def test_reverse_character_undefined(self) -> None:
        """Reverse characters and output file.
        """
        my_class = AmadaWeldTech(mode=-1)
        my_class.reverse_characters()

    def test_reverse_lines_memory(self) -> None:
        """Reverse lines and output file.
        """
        my_class = AmadaWeldTech()
        my_class.reverse_lines()

    def test_reverse_lines_processor(self) -> None:
        """Reverse lines and output file.
        """
        my_class = AmadaWeldTech(mode=1)
        my_class.reverse_lines()

    def test_reverse_lines_undefined(self) -> None:
        """Reverse lines and output file.
        """
        my_class = AmadaWeldTech(mode=-1)
        my_class.reverse_lines()

    def test_reverse_reverse_characters_lines_memory(self) -> None:
        """Reverse lines and characters output file.
        """
        my_class = AmadaWeldTech()
        my_class.reverse_characters_lines()

    def test_reverse_reverse_characters_lines_processor(self) -> None:
        """Reverse lines and characters output file.
        """
        my_class = AmadaWeldTech(mode=1)
        my_class.reverse_characters_lines()

    def test_reverse_reverse_characters_lines_undefined(self) -> None:
        """Reverse lines and characters output file.
        """
        my_class = AmadaWeldTech(mode=-1)
        my_class.reverse_characters_lines()

    def test_init_filename(self) -> None:
        """Assert init creates an object.
        """
        my_class = AmadaWeldTech(
            input_file=r'C:\Users\jasen\IdeaProjects\portfolio\src\Code\Python\Interview\AmadaWeldTech\data\data1.txt')
        self.assertIsNotNone(my_class)

    def test_reverse_character_filename(self) -> None:
        """Reverse characters and output file.
        """
        my_class = AmadaWeldTech(
            input_file=r'C:\Users\jasen\IdeaProjects\portfolio\src\Code\Python\Interview\AmadaWeldTech\data\data1.txt')
        my_class.reverse_characters()

    def test_reverse_lines_filename(self) -> None:
        """Reverse lines and output file.
        """
        my_class = AmadaWeldTech(
            input_file=r'C:\Users\jasen\IdeaProjects\portfolio\src\Code\Python\Interview\AmadaWeldTech\data\data1.txt')
        my_class.reverse_lines()

    def test_reverse_reverse_characters_lines_filename(self) -> None:
        """Reverse lines and characters output file.
        """
        my_class = AmadaWeldTech(
            input_file=r'C:\Users\jasen\IdeaProjects\portfolio\src\Code\Python\Interview\AmadaWeldTech\data\data1.txt')
        my_class.reverse_characters_lines()

    def test_reverse_reverse_characters_lines_filename_directory_does_not_exist(self) -> None:
        """Reverse lines and characters output file.
        """
        my_class = AmadaWeldTech(
            input_file=r'C:\Users\jasen\IdeaProjects\portfolio\src\Code\Python\Interview\AmadaWeldTech\d1\d\data1.txt')
        my_class.reverse_characters_lines()
