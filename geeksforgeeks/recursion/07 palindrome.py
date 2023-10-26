def rec(s, first, last):
    if len(s) == 0:
        return True

    if first >= last:
        return True

    if s[first] != s[last]:
        return False

    return rec(s, first + 1, last - 1)


def palindrome(s):
    return rec(s, 0, len(s) - 1)


print(palindrome("test"))
print(palindrome("tet"))
print(palindrome("teet"))
print(palindrome("teret"))
