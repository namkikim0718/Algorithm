import sys
input = sys.stdin.readline

X = int(input())
stick = 64
cnt = 1

while stick > X:
    stick /= 2

biggest_stick = stick

while stick != X:
    biggest_stick /= 2
    if stick + biggest_stick <= X:
        stick += biggest_stick
        cnt += 1
print(cnt)