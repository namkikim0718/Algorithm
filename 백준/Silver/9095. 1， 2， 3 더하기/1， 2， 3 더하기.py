import sys
input = sys.stdin.readline

T = int(input())
dp = [0 for _ in range(11)]
dp[1] = 1
dp[2] = 2
dp[3] = 4

for i in range(4, 11):
    for j in range(1, 4):
        remain = i - j
        dp[i] += dp[remain]

for i in range(T):
    n = int(input())
    print(dp[n])