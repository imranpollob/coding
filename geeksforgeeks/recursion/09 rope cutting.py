def check(n, a, b, c, st, ch, inc):
    st += f"-{ch} {n} "

    if n == 0:
        # print(st[2:] + '*****', inc)
        return (inc, st)
    elif n < 0:
        # print(st[2:])
        return (-1, st)

    m = max(
        check(n - a, a, b, c, st, a, inc + 1),
        check(n - b, a, b, c, st, b, inc + 1),
        check(n - c, a, b, c, st, c, inc + 1),
    )

    return m


# print(check(24, 3, 2, 4, '', 0, 0))
# print(check(9, 2, 2, 2, '', 0, 0))


def check2(n, a, b, c):
    if n == 0:
        return 0
    if n < 0:
        return -1
    m = max(check2(n - a, a, b, c), check2(n - b, a, b, c), check2(n - c, a, b, c))

    if m < 0:
        return -1

    return m + 1


# print(check2(23, 11, 12, 9))
print(check2(24, 3, 2, 4))
print(check2(9, 2, 2, 2))
