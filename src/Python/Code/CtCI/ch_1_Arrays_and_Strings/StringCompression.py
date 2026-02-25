class StringCompression(object):
    @staticmethod
    def get_description():
        print("""Arrays and Strings: String Compression
    Implement a method to perform basic string compression using the counts of repeated characters.
    For example, the string aabcccccaaa would become a2blc5a3.
    If the "compressed" string would not become smaller than the original string, your method should return
    the original string.
    You can assume the string has only uppercase and lowercase letters (a - z).""")

    @staticmethod
    def compress(base: str) -> str:
        if len(base) == 0:
            return base
        values = []
        char_list = list(base)
        last = ''
        counter = 0
        while char_list:
            if char_list[0] == last:
                counter += 1
                char_list.pop(0)
            else:
                if counter != 0:
                    values.append(str(last) + str(counter))
                last = char_list.pop(0)
                counter = 1
        if counter != 0:
            values.append(str(last) + str(counter))
        return min(base, "".join(values), key=len)

    @staticmethod
    def decompress(base: str) -> str:
        if len(base) == 0:
            return base
        values = []
        char_list = list(base)
        last = ''
        while char_list:
            current = char_list.pop(0)
            if current.isdigit():
                append = ''
                while char_list and char_list[0].isdigit():
                    current += char_list.pop(0)
                for i in range(int(current)):
                    append += last
                values.append(append)
                last = ''
            elif last == '':
                last = current
            else:
                values.append(last)
                last = current
        if last != '':
            values.append(last)
        return "".join(values)
