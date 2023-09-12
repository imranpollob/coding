def sum_rec(n):
    if n == 1:
        return 1
    return n + sum_rec(n-1)
    
    
if __name__ == "__main__":
    print(sum_rec(5))