import sys
input = sys.stdin.readline
import heapq
INF = int(1e9) # 무한

n = int(input())
m = int(input())
graph = [[] for i in range(n+1)]
distance = [INF] * (n+1)

for i in range(m):
    start, end, weight = map(int, input().split())
    graph[start].append((end, weight))

src, dst = map(int, input().split())
parent = [0] * (n+1)

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, node = heapq.heappop(q)
        
        if distance[node] < dist:
            continue

        for next_node, next_dist in graph[node]:
            cost = dist + next_dist
            
            if cost < distance[next_node]:
                distance[next_node] = cost
                parent[next_node] = node
                heapq.heappush(q, (cost, next_node))
                

dijkstra(src)
print(distance[dst])

now = dst
route = [dst]
while now != src:
    now = parent[now]
    route.append(now)

route.reverse()
print(len(route))
for i in route:
    print(i, end=' ')



