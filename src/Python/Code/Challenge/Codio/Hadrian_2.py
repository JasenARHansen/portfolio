from dataclasses import dataclass
from typing import List

@dataclass
class Advert:
    s: int    # start time
    f: int    # end time
    w: float  # payout

class Hadrian(object):
    @staticmethod
    def get_description() -> None:
        print("""Hadrian: Interview 2
        Interviewer email: branden@hadrian.co

        # Consider a YouTube video that starts at time 0 and runs until time
        # T ∈ Set of real numbers
        # The video can display at most one banner ad at a time at the bottom of the video.
        # Advertisers bid on showing banner ads. Each ad i has:

              Video runtime sample 0 - 10 se c
                    si = Banner add start time could be 2 for 2 seconds in
                    fi = Banner add end time could be 4 for 2 seconds run time
                    T = in this case is 10 for total run time
                    wi = value of run add
              Expected value: masximum value returned so full treversial needed
                    
        #     - a start time, si : Question: 
        #     - an end time, fi
        #     - a payout, wi
        # and is represented as the tuple (si, fi, wi).
        # You may assume 0 <= si < fi <= T
        # Write an algorithm that calculates the maximum profit that a list of ads
        # is capable of generating
 
 
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
                # |   4   |   |   8   | : Not in data
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
              Add description
              """)

    @staticmethod
    def calc_expected_value(ads: List[Advert]) -> float:
        # Assumption 1: I will need to sort
        sorted_list = sorted(ads, lambda x: x.s)

        """"
        I am thinki8ng recursive
        Case 1: Use first element
            That means I will neeed a method concidering start time?
            Logic: Use first value and skipp all further adds that conflict.  Pass remaining adds to next call
            Pass slice [x:] to next call
        Case 2: Do not use first element
            Pass slice of [1:] to next call
        Results are incremented as neede

        """
        # Exit case: List len = 1
        if len(ads) == 1:
            return ads.w

        # Case 1: use first element
        result_1 = ads[0].w
        # Find next:
        for index in range(1, len(ads)):
            if ads[index].s > ads[0].f:
                result_1 += Hadrian.calc_expected_value(ads[index:])
                break

        # Case 2: do not use first element
        result_2 = Hadrian.calc_expected_value(ads[1:])

        # Choice
        return max (result_1, result_2)

'''  
branden@hadrian.co
 
'''