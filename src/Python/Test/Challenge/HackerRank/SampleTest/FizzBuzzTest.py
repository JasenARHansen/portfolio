#!/usr/bin/env python3

import io
import unittest.mock

from src.Python.Code.Challenge.HackerRank.SampleTest.FizzBuzz import FizzBuzz


class TestSampleTest(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_description_stdout(self, mock_stdout):
        FizzBuzz.get_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_get_description(self) -> None:
        """Get class description"""
        self.assert_description_stdout()

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_stdout(self, data: int, expected_output: str, mock_stdout):
        FizzBuzz.fizzbuzz(data)
        self.assertEqual(mock_stdout.getvalue(), expected_output)

    def test_fizzbuzz(self) -> None:
        """Execute fizzbuzz"""
        expected = "1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\n"
        data = 15
        self.assert_stdout(data, expected)


if __name__ == "__main__":
    unittest.main()
