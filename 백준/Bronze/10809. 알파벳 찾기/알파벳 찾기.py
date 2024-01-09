import sys
input = sys.stdin.readline

S = input()


for i in range(97, 123):
    if S.count(chr(i)) == 0:
        print(-1, end=' ')
    else:
        print(S.index(chr(i)), end=' ')