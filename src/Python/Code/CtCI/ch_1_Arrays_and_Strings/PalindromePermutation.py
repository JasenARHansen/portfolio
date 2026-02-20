import re


class PalindromePermutation(object):
    @staticmethod
    def get_description():
        print("""Arrays and Strings: Palindrome Permutation
    Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards.
    A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
    Example:
        Input: Tact Coa
        Output: True (permutations: "taco cat", "atco e t a " , etc.)""")

    @staticmethod
    def is_palindrome_permutation(palindrome: str) -> bool:
        lowercase_text = palindrome.lower()
        cleaned_text = re.sub(r'[^a-zA-Z0-9]', '', lowercase_text)
        sorted_text = sorted(cleaned_text)
        odd_found = False
        while len(sorted_text) > 1:
            if sorted_text[0] == sorted_text[1]:
                sorted_text.pop(0)
                sorted_text.pop(0)
            else:
                if odd_found:
                    return False
                else:
                    sorted_text.pop(0)
                    odd_found = True
        if sorted_text and odd_found:
            return False
        return True
