def rec(n):
    if n == 1:
        return 1
    return 1 + rec(n / 2)


# what will be the result?
print(rec(16))

# floor(log2n)
