import sys
input = sys.stdin.readline

n, w, L = map(int, input().split())

trucks = list(map(int, input().split()))
in_bridge = [0] * w

smallest_time = 0

while in_bridge:
    smallest_time += 1
    in_bridge.pop(0)
    if trucks:
        if sum(in_bridge) + trucks[0] <= L:
            in_bridge.append(trucks.pop(0))
        else:
            in_bridge.append(0)
    
print(smallest_time)