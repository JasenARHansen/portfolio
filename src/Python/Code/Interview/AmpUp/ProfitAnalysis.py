#!/usr/bin/env python3

# noinspection PyPep8Naming
class ProfitAnalysis(object):
    """Question1 main class."""

    @staticmethod
    def get_description():
        print("""1: Profit Analysis
    A data analyst wants to analyze the performance of his investments in the HackShare stock.
    The PnL of his portfolio is represented by an array pnl where pnl[i] represents the profit
     earned in the ith month that can possibly be negative indicating a loss.
    Given the pnl array of n months, find the maximum net profit (sum of profits) gained in any
     contiguous segment of months i.e. a subarray of months such that the number of months in
     the segment does not exceed a given integer k. 
    Example:
        Given n = 6, pnl = [-3, 4, 3, -2, 2, 5] , k = 4.
        We can select the subarray [3, -2, 2, 5] with a total profit 3 + (-2) + 2 + 5 = 8.
        Note that while the maximum net profit of a subarray can be 12 for the subarray
        [4, 3, -2, 2, 5] but the length of the subarray will exceed k = 4.
        Hence, we report 8 as the answer.
    Function Description:
        Complete the function getMaxProfit in the editor below.
        getMaxProfit has the following parameters:
            pnl[n]:  An array of integers
            k: An integer
    Returns:
        long_int: the sum of a contiguous subarray of size at most k that has the largest sum
    Constraints:
        1 ≤ n ≤ 2 * 10^5
        -10^9 ≤ pnl[i] ≤ 10^9
        1 ≤ k ≤ n
    Input Format For Custom Testing:
        The first line contains an integer, n, denoting the number of elements in pnl.
        Each line i of the n subsequent lines (where 0 ≤ i &lt; n) contains an integer denoting pnl[i].
    The last line contains integer k.
    Sample Case 0:
        Sample Input For Custom Testing:
            STDIN         FUNCTION
            -----         --------
            7        →    pnl[] size n = 7
            4        →    pnl = [4, 3, -2, 9, -4, 2, 7]
            3
            -2
            9
            -4
            2
            7
            6        →    k = 6
    Sample Output:
        15
    Explanation:
        Given n = 7, pnl = [4, 3, -2, 9, -4, 2, 7], k = 6.
        We can select the subarray [3, -2, 9, -4, 2, 7] with sum = 15 and size 6 which is equal to k = 6.
    Hence, the answer is 15.
    It can be shown that the answer cannot be greater than 15.
    Sample Case 1:
        Sample Input For Custom Testing
        STDIN         FUNCTION
        -----         --------
        8        →    pnl[] size n = 8  
        2        →    pnl = [2, 5, -7, 8, -6, 4, 1, -9]
        5
        -7
        8
        -6
        4
        1
        -9
        5        →    k = 5
    Sample Output:
        8
    Explanation:
        Given n = 8, pnl = [2, 5, -7, 8, -6, 4, 1, -9] , k = 5.
        We can select the subarray [2, 5, -7, 8] with sum = 8 and size 4 which is less than k = 5.
    Hence, the answer is 8.
    It can be shown that the answer cannot be greater than 8.""")

    @staticmethod
    def getMaxProfit(pnl, k: int):
        """getMaxProfit."""
        maxProfit = 0
        length = len(pnl)
        for start in range(0, length):
            # If start value is greater than 0 process, otherwise skip
            if pnl[start] > 0:
                currentProfit = pnl[start]
                for offset in range(1, k):
                    index = start + offset
                    if index < length:
                        currentProfit += pnl[index]
                        if currentProfit > maxProfit:
                            maxProfit = currentProfit
                    else:
                        break
        return maxProfit
