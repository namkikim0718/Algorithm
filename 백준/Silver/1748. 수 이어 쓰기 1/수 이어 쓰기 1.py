import sys
input = sys.stdin.readline

N = int(input())

k = 1
cnt = 0
length = 10**k
for i in range(1, N+1):
    if i < length:
        cnt += k
    else:
        k += 1
        length = 10**k
        cnt += k

print(cnt)