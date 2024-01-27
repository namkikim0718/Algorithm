import sys
input = sys.stdin.readline

N = int(input())
result = 0

if N < 100:
    result = N
else:
    result = 99
    for i in range(100, N+1):
        hund = i // 100
        ten = (i - (hund * 100)) // 10
        one = i - hund * 100 - ten * 10
        if hund - ten == ten - one:
            result += 1
print(result)