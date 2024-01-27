import sys
input = sys.stdin.readline
import math

M, N = map(int, input().split())

for i in range(M, N+1):
    if i == 1:
        continue
    is_decimal = True
    for j in range(2, int(math.sqrt(i))+1):
        if i % j == 0:
            is_decimal = False
            break
    if is_decimal:
        print(i)