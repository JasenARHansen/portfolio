#!/usr/bin/env python3

import math


class PowersOfBase(object):
    @staticmethod
    def get_description():
        print("""
                Given a string of representing a number, a numeric base, and an exponent base,
                 if possible, tell the minimum number of splits that are required such that each split
                 part is a number which can be represented as power of X in the provided numeric
                 base and tell the least number of splits.
                Sample:
                 1. The string '101011001' with a numeric base of '2' splits '2' times into values
                  that are a power of '5' '[101, 011001]'
                 2. The string '101011000' with a numeric base of '2' splits '0' times into values
                  that are a power of '5' '[]
                 3. The string '55' with a numeric base of '10' splits '2' times into values that
                  are a power of '5' '[5, 5]'
                 4. The string '56' with a numeric base of '10' splits '0' times into values that
                  are a power of '5' '[]'""")

    @staticmethod
    def split_to_base(string_value: str, number_base: int, power_base: int):
        split_list = []
        # Case 1: String already meets criteria
        if PowersOfBase.test_base_exponent(PowersOfBase.convert_to_number(string_value=string_value,
                                                                          number_base=number_base),
                                           power_base=power_base):
            split_list.append(string_value)
        # Case 2: The string is not a valid value so splits are necessary
        else:
            for index in range(len(string_value) - 1):
                left_string = string_value[:index + 1]
                value = PowersOfBase.convert_to_number(string_value=left_string, number_base=number_base)
                if PowersOfBase.test_base_exponent(input_value=value, power_base=power_base):
                    right_string = string_value[index + 1:]
                    new_list = PowersOfBase.split_to_base(string_value=right_string, number_base=number_base,
                                                          power_base=power_base)
                    if new_list:
                        new_list.insert(0, left_string)
                        if not split_list:
                            # If split_list is empty this is the first match so assign split_list
                            split_list = new_list
                        elif len(new_list) < len(split_list):
                            split_list = new_list

        return split_list

    @staticmethod
    def convert_to_number(string_value: str, number_base: int):
        # Convert string into number of appropriate base
        return int(string_value, number_base)

    @staticmethod
    def test_base_exponent(input_value: int, power_base: int):
        # Log 0 is undefined
        if input_value == 0:
            return False
        # extract log value of appropriate base.
        # A longer example of the change of base logic can be found at: http://www.tpub.com/math1/9.htm
        #  Sample: 5^x = value -> log base 5 of value = x
        # Change of base formula can be seen at: http://www.mathwords.com/c/change_of_base_formula.htm
        #  Sample: log base y of value = x -> (ln value)/ (ln y) = X
        calculated = math.log(input_value, power_base)
        # Find a truncated value of the log for comparison
        truncated = int(math.floor(math.log(input_value, power_base)))
        # If the calculated value equals the truncated than return true
        return calculated == truncated
