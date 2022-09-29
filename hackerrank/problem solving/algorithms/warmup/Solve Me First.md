# Solve Me First

https://www.hackerrank.com/challenges/solve-me-first/problem?isFullScreen=true

Complete the function solveMeFirst to compute the sum of two integers.

Example
```
a = 7
b = 3
```
Return 10.

Function Description

Complete the solveMeFirst function in the editor below.

solveMeFirst has the following parameters:

- int a: the first value
- int b: the second value

Returns
- int: the sum of  and 


Sample Input
```
a = 2
b = 3
```
Sample Output
```
5
```

Explanation

2 + 3 = 5

## Solution
```py
def solveMeFirst(a,b):
	return a + b


num1 = int(input())
num2 = int(input())
res = solveMeFirst(num1,num2)
print(res)
```