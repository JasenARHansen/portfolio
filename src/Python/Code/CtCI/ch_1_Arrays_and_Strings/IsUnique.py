class IsUnique(object):
    @staticmethod
    def get_description():
        print("""
                Arrays and Strings: Is Unique
                 Implement an algorithm to determine if a string has all unique characters.
                 What if you cannot use additional data structures?""")

    @staticmethod
    def is_unique_array(string: str):
        # Assuming character set is ASCII (128 characters)
        # test foreach character
        if len(string) > 128:
            return False

        # pre define target array
        char_set = [False] * 128
        for character in string:
            # get ordinal value of character
            val = ord(character)
            if char_set[val]:
                # Character previously found in string
                return False
            char_set[val] = True

        return True

    @staticmethod
    def is_unique_set(string: str):
        # Sets do not allow duplicates so if the length does not match the size, non-unique
        return len(set(string)) == len(string)
