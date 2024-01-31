import sys
input = sys.stdin.readline

A = int(input())
B = list(map(int, input().rstrip()))

first = A * B[2]
second = A * B[1]
third = A * B[0]

result = third * 100 + second * 10 + first

print(first)
print(second)
print(third)
print(result)

