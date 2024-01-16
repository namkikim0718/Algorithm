import sys
input = sys.stdin.readline

N = int(input())
count = 0

for i in range(N//5, 0, -1):
    tmp = N - i * 5
    if tmp % 3 == 0:
        count += i
        N = tmp
        break

if N % 3 != 0:
    print(-1)
else:
    count += (N // 3)
    print(count)