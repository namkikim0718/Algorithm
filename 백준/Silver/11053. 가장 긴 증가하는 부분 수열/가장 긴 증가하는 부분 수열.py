import sys
input = sys.stdin.readline

N = int(input())
num_list = list(map(int, input().split()))

dp = [1 for _ in range(N)]

for i in range(N):
    tmp = [0]
    for j in range(i):
        if num_list[i] > num_list[j]:
            tmp.append(dp[j])
    dp[i] = max(tmp) + 1

print(max(dp))