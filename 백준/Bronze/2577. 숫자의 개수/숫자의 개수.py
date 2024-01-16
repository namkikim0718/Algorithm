import sys
input = sys.stdin.readline

A = int(input())
B = int(input())
C = int(input())

multiply_num = A * B * C

multiply_str = str(multiply_num)

for i in range(10):
    print(multiply_str.count(str(i)))
