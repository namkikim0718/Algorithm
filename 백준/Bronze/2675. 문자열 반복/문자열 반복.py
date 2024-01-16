import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    R, S = map(str, input().split())
    R = int(R)
    for i in S:
        for j in range(R):
            print(i, end='')
    print()