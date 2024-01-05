#!/usr/bin/env python3

import io
import unittest.mock

from src.Python.Code.Interview.AmpUp.RootThreshold import RootThreshold


class TestRootThreshold(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_description_stdout(self, mock_stdout):
        RootThreshold.get_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_get_description(self) -> None:
        """Get class description"""
        self.assert_description_stdout()

    def test_numDevices(self) -> None:
        """Execute numDevices"""
        expected = 3
        status_query = "STOPPED"
        threshold = 45
        date_str = "04-2019"
        result = RootThreshold.numDevices(statusQuery=status_query, threshold=threshold, dateStr=date_str)
        self.assertEqual(expected, result)


if __name__ == "__main__":
    unittest.main()
