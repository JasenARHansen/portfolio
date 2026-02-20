import re


class CheckPermutation(object):
    @staticmethod
    def get_description():
        print("""Arrays and Strings: Check Permutation
    Given two strings, write a method to decide if one is a permutation of the other.""")

    @staticmethod
    def is_character_permutation(first: str, second: str) -> bool:
        # This requires that punctuation is accounted for
        if len(first) != len(second):
            return False
        first_sorted = sorted(first)
        second_sorted = sorted(second)
        for i in range(len(first)):
            if first_sorted[i] != second_sorted[i]:
                return False
        return True

    @staticmethod
    def is_character_permutation_stripped(first: str, second: str) -> bool:
        # Pattern matches anything that is *not* in the specified range of letters and white space
        cleaned_first = re.sub(r'[^a-zA-Z0-9 ]', '', first)
        cleaned_second = re.sub(r'[^a-zA-Z0-9 ]', '', second)
        if len(cleaned_first) != len(cleaned_second):
            return False
        first_sorted = sorted(cleaned_first)
        second_sorted = sorted(cleaned_second)
        for i in range(len(cleaned_first)):
            if first_sorted[i] != second_sorted[i]:
                return False
        return True

    @staticmethod
    def is_word_permutation(first: str, second: str) -> bool:
        # This assumes no punctuation and space separated
        first_word_list = first.split()
        second_word_list = second.split()
        if len(first_word_list) != len(second_word_list):
            return False
        first_word_list_sorted = sorted(first_word_list)
        second_word_list_sorted = sorted(second_word_list)
        for i in range(len(first_word_list)):
            if first_word_list_sorted[i] != second_word_list_sorted[i]:
                return False
        return True

    @staticmethod
    def is_word_permutation_stripped(first: str, second: str) -> bool:
        # This removes punctuation and keeps white space
        # remove all non-character items from a Python string while keeping spaces
        cleaned_first = "".join(char for char in first if char.isalnum() or char == " ")
        cleaned_second = "".join(char for char in second if char.isalnum() or char == " ")
        first_word_list = cleaned_first.split()
        second_word_list = cleaned_second.split()
        if len(first_word_list) != len(second_word_list):
            return False
        first_word_list_sorted = sorted(first_word_list)
        second_word_list_sorted = sorted(second_word_list)
        for i in range(len(first_word_list)):
            if first_word_list_sorted[i] != second_word_list_sorted[i]:
                return False
        return True
