import sys
input = sys.stdin.readline

n = int(input())
p = list(map(int, input().split()))

p.sort()

sum_list = []
sum_list.append(p[0])
for i in range(1, n):
    sum_list.append(sum_list[i-1] + p[i])

print(sum(sum_list))
