import sys
input = sys.stdin.readline

N, M = map(int, input().split())

num_list = []
for i in range(N):
    tmp = list(map(int, input().rstrip()))
    num_list.append(tmp)

result = 0

for i in range(N):
    for j in range(M):
        now = num_list[i][j]
        if (N - i) < (M - j):
            max_length = N - i
        else:
            max_length = M - j
        for k in range(max_length):
            if now == num_list[i+k][j] == num_list[i][j+k] == num_list[i+k][j+k]:
                if ((k+1) ** 2) > result:
                    result = ((k+1) ** 2)

print(result)
