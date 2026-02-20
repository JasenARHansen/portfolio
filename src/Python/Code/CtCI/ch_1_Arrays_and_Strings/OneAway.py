class OneAway(object):
    @staticmethod
    def get_description():
        print("""Arrays and Strings: One Away
    There are three types of edits that can be performed on strings:
        insert a character
        remove a character
        replace a character
    Given two strings, write a function to check if they are one edit (or zero edits) away.
    Example:
        pale, bale -> true
        pale, pales -> true
        pales , pale -> true
        pale, bake -> false""")



    @staticmethod
    def is_one_away(base: str, test: str) -> bool:
        if base == test:
            return True
        if abs(len(base) - len (test)) > 1:
            return False
        edited = False
        base_list = list(base)
        test_list = list(test)
        while base_list and test_list:
            if base_list[0] == test_list[0]:
                base_list.pop(0)
                test_list.pop(0)
            elif edited:
                return False
            else:
                edited = True
                if len(base_list) == len(test_list):
                    base_list.pop(0)
                    test_list.pop(0)
                elif len(base_list) > len(test_list):
                    base_list.pop(0)
                else:
                    test_list.pop(0)

        if (base_list or test_list) and edited:
            return False
        return True
