#!/usr/bin/env python3

from dataclasses import dataclass
from typing import List

@dataclass
class Advert:
    s: int    # start time
    f: int    # end time
    w: float  # payout 

@dataclass
class Schedule:
    payout: float            # total payout 
    schedule: List[Advert]   # advertisment list

class Hadrian_2(object):

    @staticmethod
    def get_description() -> None:
        print("""Hadrian: Interview 2
        Interviewer email: branden@hadrian.co

        # Consider a YouTube video that starts at time 0 and runs until time
        # T ∈ Set of real numbers
        # The video can display at most one banner ad at a time at the bottom of the video.
        # Advertisers bid on showing banner ads. Each ad i has:
                    
        #     - a start time, si
        #     - an end time, fi
        #     - a payout, wi
        # and is represented as the tuple (si, fi, wi).
        # You may assume 0 <= si < fi <= T
        # Write an algorithm that calculates the maximum profit that a list of ads
        # is capable of generating
 
        Video runtime sample 0 - 10 sec
            si = Banner add start time could be 2 for 2 seconds
            fi = Banner add end time could be 4 for 2 seconds run time
            wi = value of run add
            T = in this case is 10 for total run time
        Expected value: maximum value returned, so full treversial needed     

        # Sample template for setup 
        @dataclass
        class Advert:
            s: int    # start time
            f: int    # end time
            w: float  # payout

        @dataclass
        class TestCase:
            ads: List[Advert]
            expected_value: float
        
        def calc_expected_value(ads: List[Advert]) -> float:
            return 0
        
        def run_test_cases():
            test_cases = [
                TestCase(
                    # 
                    #                   |5|
                    #       |   7   |
                    # |   3   |   |   8   |
                    # _ _ _ _ _ _ _ _ _ _ __
                    # 0 1 2 3 4 5 6 7 8 9 10
                    ads=[
                        Advert(6, 10, 8),
                        Advert(3, 7, 7),
                        Advert(0, 4, 3),
                        Advert(9, 10, 5),
                    ],
                    
                    Possible outcomes:
                        #       |   7   |   |5|
                        # |   3   |   |   8   |
                        #                   |5|
                    expected_value=12,
                    Note: Expecting a number.  Float but Python will not care
                ),
                TestCase(
                    #       | 70  |
                    #       |40 |
                    #     | 10|
                    #   |50 |
                    # _ _ _ _ _ _ _
                    # 0 1 2 3 4 5 6
                    ads=[
                        Advert(1, 3, 50),
                        Advert(2, 4, 10),
                        Advert(3, 5, 40),
                        Advert(3, 6, 70),
                    ],
                    expected_value=120,
                ),
            ]
        
            for i, tc in enumerate(test_cases, start=1):
                calculated = calc_expected_value(tc.ads)
                try:
                    assert calculated == tc.expected_value, (
                        f"test case {i} failed. "
                        f"Expected value: {tc.expected_value} "
                        f"Calculated value: {calculated}"
                    )
                    print(f"test case {i} passed!")
                except AssertionError as e:
                    print(f"test case {i} failed. {e}")
        
        if __name__ == "__main__":
            run_test_cases()
              """)

    @staticmethod
    def calc_expected_value_1(ads: List[Advert]) -> float:
        # Empty list case:
        if not ads:
            return 0

        # Exit case: List len = 1
        if len(ads) == 1:
            return ads[0].w

        # Assumption 1: I will need to sort
        # Sort the list using a lambda function as the key
        # Sort by 'start time' in ascending order (default)
        sorted_ads = sorted(ads, key=lambda ad: ad.s)

        # Case 1: use first element
        result_1 = sorted_ads[0].w

        # Find next and make recursive call, if a valid call exists:
        for index in range(1, len(sorted_ads)):
            if sorted_ads[index].s >= sorted_ads[0].f:
                result_1 += Hadrian_2.calc_expected_value_1(sorted_ads[index:])
                break

        # Case 2: do not use first element and make call to next element in list
        result_2 = Hadrian_2.calc_expected_value_1(sorted_ads[1:])

        # Choice of highest payout
        return max(result_1, result_2)

    @staticmethod
    def __process_ads(ads: List[Advert]) -> Schedule:
        # Assumption 1: List is provided sorted since this is
        #  a semi private method that is intended to be called internally

        # Empty list case:
        if not ads:
            return Schedule(0, [])

        # Exit case: List len = 1
        if len(ads) == 1:
            return Schedule(ads[0].w, [ads[0]])

        # Case 1: use first element
        result_1 = Schedule(ads[0].w, [ads[0]])

        # Find next and make recursive call, if a valid call exists:
        for index in range(1, len(ads)):
            if ads[index].s >= ads[0].f:
                data = Hadrian_2.__process_ads(ads[index:])
                result_1.payout += data.payout
                result_1.schedule.extend(data.schedule)
                break

        # Case 2: do not use first element and make call to next element in list
        result_2 = Hadrian_2.__process_ads(ads[1:])

        # Choice of highest payout
        if result_1.payout > result_2.payout:
            return result_1
        
        return result_2
        
    @staticmethod
    def calc_expected_value_2(ads: List[Advert]) -> float:

        # Assumption 1: I will need to sort
        # Sort the list using a lambda function as the key
        # Sort by 'start time' in ascending order (default)
        sorted_ads = sorted(ads, key=lambda ad: ad.s)

        return Hadrian_2.__process_ads(sorted_ads).payout

    @staticmethod
    def get_schedule(ads: List[Advert]) -> List[Advert]:

        # Assumption 1: I will need to sort
        # Sort the list using a lambda function as the key
        # Sort by 'start time' in ascending order (default)
        sorted_ads = sorted(ads, key=lambda ad: ad.s)

        return Hadrian_2.__process_ads(sorted_ads).schedule
