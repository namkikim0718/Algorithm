import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    ps = list(map(str, input().rstrip()))
    is_VPS = True
    stack = []
    for i in ps:
        if i == '(':
            stack.append(i)
        elif i == ')':
            if stack:
                stack.pop()
            else:
                is_VPS = False
                break
    if not stack and is_VPS:
        print('YES')
    else:
        print('NO')