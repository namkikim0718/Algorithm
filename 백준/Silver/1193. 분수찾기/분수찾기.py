import sys
input = sys.stdin.readline

X = int(input())
max_repeat = 1

while X > max_repeat:
    X -= max_repeat
    max_repeat += 1

if max_repeat % 2 == 1:
    a = max_repeat - X + 1
    b = X
else:
    a = X
    b = max_repeat - X + 1

print(str(a)+'/'+str(b))