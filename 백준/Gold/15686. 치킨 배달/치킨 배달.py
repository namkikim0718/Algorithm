import sys
input = sys.stdin.readline
from itertools import combinations

N, M = map(int, input().split())
city = []
houses = []
chickens = []
min_dist = 1e9

for i in range(N):
    city.append(list(map(int, input().split())))

for i in range(N):
    for j in range(N):
        if city[i][j] == 1:
            houses.append((i, j))
        elif city[i][j] == 2:
            chickens.append((i, j))

pick_chickens = list(combinations(chickens, M))

for pick_chicken in pick_chickens:
    total_dist = 0
    for house in houses:
        now_dist = 1e9
        src_i, src_j = house
        for now_chicken in pick_chicken:
            dst_i, dst_j = now_chicken
            dist = abs(dst_i - src_i) + abs(dst_j - src_j)
            now_dist = min(dist, now_dist)
        total_dist += now_dist
    min_dist = min(min_dist, total_dist)

print(min_dist)