n = int(input())
l = list(map(int, input().split()))

need = n-1
cnt = 0

l.sort()
for i in range(n):
    if l[0] <= need-1:
        need -= l[0]+1
        cnt += l[0]
        l.pop(0)

    else:
        cnt += need
        break

    if need < 1:
        break

print(cnt)
