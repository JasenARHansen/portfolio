class URLify(object):
    @staticmethod
    def get_description():
        print("""Arrays and Strings: URLify
    Write a method to replace all spaces in a string with '%20'.
    You may assume that the string has sufficient space at the end to hold the additional characters,
     and that you are given the "true" length of the string.
    (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
    Example:
        Input: "Mr John Smith"
        Output: "Mr%20John%20Smith""")

    @staticmethod
    def urlify(to_url: str) -> str:
        stripped_text = to_url.strip()
        old_value = " "
        new_value = "%20"
        result =  stripped_text.replace(old_value, new_value)
        return result
