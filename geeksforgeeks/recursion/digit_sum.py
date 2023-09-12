def rec(n):
    if n == 0:
        return 0
    return n % 10 + rec(n // 10)

print(rec(12345))