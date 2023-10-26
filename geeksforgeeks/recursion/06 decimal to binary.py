def rec(n):
    if n == 0:
        return
    rec(n // 2)
    print(n % 2)


# guess the output
rec(7)
