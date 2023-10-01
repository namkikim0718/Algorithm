import sys
input = sys.stdin.readline
import heapq

n = int(input())
cards = []
for i in range(n):
    tmp = int(input())
    heapq.heappush(cards, tmp)

result = 0

for i in range(n-1):
    a = heapq.heappop(cards)
    b = heapq.heappop(cards)
    heapq.heappush(cards, a+b)
    result += a+b

print(result)