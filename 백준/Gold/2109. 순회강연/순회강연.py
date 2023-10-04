import sys
input = sys.stdin.readline
import heapq

n = int(input())

pay_list = []

for i in range(n):
    p = list(map(int,input().split()))
    pay_list.append(p)

pay_list.sort(key=lambda x : x[1])
my_heap = []

for i in range(n):
    heapq.heappush(my_heap, pay_list[i][0])
    if len(my_heap) > pay_list[i][1]:
        heapq.heappop(my_heap)

result = sum(my_heap)

print(result)