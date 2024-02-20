import sys
input = sys.stdin.readline

n, k = map(int, input().split())

values = []
dp = [0 for _ in range(k+1)]
dp[0] = 1

for _ in range(n):
    values.append(int(input()))

for num in values:
    for i in range(num, k+1):
        dp[i] += dp[i-num]

print(dp[k])