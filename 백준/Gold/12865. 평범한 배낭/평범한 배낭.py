import sys
input = sys.stdin.readline

N, K = map(int, input().split())
stuff_list = []
for i in range(N):
    W, V = map(int, input().split())
    stuff_list.append((W, V))



dp = [[0 for _ in range(K+1)] for _ in range(N+1)]
for i in range(1, N+1):
    weight, value = stuff_list[i-1]
    for j in range(1, K+1):
        if weight > j:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j-weight]+value, dp[i-1][j])

print(dp[N][K])