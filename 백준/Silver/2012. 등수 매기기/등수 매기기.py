import sys
input = sys.stdin.readline

n = int(input())

rank_list = []
rank_list.append(0)
for i in range(n):
    tmp = int(input())
    rank_list.append(tmp)

rank_list.sort()
result = 0

for i in range(1, n+1):
    if rank_list[i] < i:
        result += i - rank_list[i]
        rank_list[i] = i
        
    elif rank_list[i] > i:
        result += rank_list[i] - i
        rank_list[i] = i

print(result)


