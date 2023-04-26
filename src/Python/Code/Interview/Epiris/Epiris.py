#!/usr/bin/env python3

# noinspection SpellCheckingInspection,PyTypeChecker
class Epiris(object):
    """Epiris main class."""

    @staticmethod
    def get_description_alphabetical():
        print("""
              sort_alphabetical:
                Given a string, sort it in decreasing order based on the
                 characters. If two or more characters have the same
                 frequency, they can appear in any order.
                Example 1:
                  input:  tree
                  output: eert (eetr also works)
                Example 2:
                  input:  banana
                  output: nnbaaa
                Example 3:
                  input:  abcdabcdad
                  output: dddccbbaaa""")

    @staticmethod
    def get_description_numeric():
        print("""
              sort_numeric:
                Given a string, sort it in decreasing order based on the
                 frequency of characters. If two or more characters have
                 the same frequency, they can appear in any order.
                Example 1:
                  input:  tree
                  output: eert (eetr also works)
                Example 2:
                  input:  banana
                  output: aaannb
                Example 3:
                  input:  abcdabcdad
                  output: aaadddbbcc""")

    @staticmethod
    def get_description_alphabetical_numeric():
        print("""
              sort_alphabetical_numeric:
                Given a string, sort it in decreasing order based on the
                 characters. If two or more characters have the same
                 frequency, they are than also sorted.
                Example 1:
                  input:  tree
                  output: eert
                Example 2:
                  input:  banana
                  output: nnbaaa
                Example 3:
                  input:  abcdabcdadc
                  output: dddcccbbaaa""")

    @staticmethod
    def get_description_numeric_alphabetical():
        print("""
              sort_numeric_alphabetical:
                Given a string, sort it in decreasing order based on the
                 frequency of characters. If two or more characters have
                 the same frequency, they are than also sorted.
                Example 1:
                  input:  tree
                  output: eert
                Example 2:
                  input:  banana
                  output: nnbaaa
                Example 3:
                  input:  abcdabcdad
                  output: dddaaaccbb""")

    @staticmethod
    def sort_alphabetical(value: str, reverse: bool = True) -> str:
        """Sort characters."""
        # char : int
        letter_dictionary = {}
        for letter in value:
            if letter in letter_dictionary:
                letter_dictionary[letter] += 1
            else:
                letter_dictionary[letter] = 1
        letter_dictionary = sorted(letter_dictionary.items(), key=lambda x: x[0], reverse=reverse)
        output = ""
        for letter in letter_dictionary:
            output += letter[0] * letter[1]
        return output

    @staticmethod
    def sort_numeric(value: str, reverse: bool = True) -> str:
        """Sort characters."""
        # char : int
        letter_dictionary = {}
        for letter in value:
            if letter in letter_dictionary:
                letter_dictionary[letter] += 1
            else:
                letter_dictionary[letter] = 1
        letter_dictionary = sorted(letter_dictionary.items(), key=lambda x: x[1], reverse=reverse)
        output = ""
        for letter in letter_dictionary:
            output += letter[0] * letter[1]
        return output

    @staticmethod
    def sort_alphabetical_numeric(value: str, reverse: bool = True) -> str:
        """Sort characters."""
        # char : int
        letter_dictionary = {}
        for letter in value:
            if letter in letter_dictionary:
                letter_dictionary[letter] += 1
            else:
                letter_dictionary[letter] = 1
        letter_dictionary = sorted(letter_dictionary.items(), key=lambda x: (x[0], x[1], x[0]), reverse=reverse)
        output = ""
        for letter in letter_dictionary:
            output += letter[0] * letter[1]
        return output

    @staticmethod
    def sort_numeric_alphabetical(value: str, reverse: bool = True) -> str:
        """Sort characters."""
        # char : int
        letter_dictionary = {}
        for letter in value:
            if letter in letter_dictionary:
                letter_dictionary[letter] += 1
            else:
                letter_dictionary[letter] = 1
        letter_dictionary = sorted(letter_dictionary.items(), key=lambda x: (x[1], x[0], x[1]), reverse=reverse)
        output = ""
        for letter in letter_dictionary:
            output += letter[0] * letter[1]
        return output
