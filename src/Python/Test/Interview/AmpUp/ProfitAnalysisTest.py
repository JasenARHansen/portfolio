#!/usr/bin/env python3

import io
import unittest.mock

from src.Python.Code.Interview.AmpUp.ProfitAnalysis import ProfitAnalysis


class TestProfitAnalysis(unittest.TestCase):
    """Test the elements visible at the root of the file."""

    @unittest.mock.patch('sys.stdout', new_callable=io.StringIO)
    def assert_description_stdout(self, mock_stdout):
        ProfitAnalysis.get_description()
        self.assertIsNotNone(mock_stdout.getvalue())

    def test_get_description(self) -> None:
        """Get class description"""
        self.assert_description_stdout()

    def test_getMaxProfit_1(self) -> None:
        """Execute getMaxProfit"""
        expected = 8
        pnl = [-3, 4, 3, -2, 2, 5]
        n = 6
        if n < len(pnl):
            pnl = pnl[0:n]
        k = 4
        result = ProfitAnalysis.getMaxProfit(pnl=pnl, k=k)
        self.assertEqual(expected, result)

    def test_getMaxProfit_2(self) -> None:
        """Execute getMaxProfit"""
        expected = 15
        pnl = [4, 3, -2, 9, -4, 2, 7, 6]
        n = 7
        if n < len(pnl):
            pnl = pnl[0:n]
        k = 6
        result = ProfitAnalysis.getMaxProfit(pnl=pnl, k=k)
        self.assertEqual(expected, result)

    def test_getMaxProfit_3(self) -> None:
        """Execute getMaxProfit"""
        expected = 8
        pnl = [5, -7, 8, -6, 4, 1, -9, 5]
        n = 8
        if n < len(pnl):
            pnl = pnl[0:n]
        k = 5
        result = ProfitAnalysis.getMaxProfit(pnl=pnl, k=k)
        self.assertEqual(expected, result)

    def test_getMaxProfit_4(self) -> None:
        """Execute getMaxProfit"""
        expected = 0
        pnl = [-7, -5, -8, -6, -7]
        n = 5
        if n < len(pnl):
            pnl = pnl[0:n]
        k = 3
        result = ProfitAnalysis.getMaxProfit(pnl=pnl, k=k)
        self.assertEqual(expected, result)


if __name__ == "__main__":
    unittest.main()
