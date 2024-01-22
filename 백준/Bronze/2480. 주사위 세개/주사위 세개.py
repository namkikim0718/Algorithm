import sys
input = sys.stdin.readline

dices = list(map(int, input().split()))
dices_kind = set(dices)

result = 0
if len(dices_kind) == 1:
    result = 10000 + dices_kind.pop() * 1000
elif len(dices_kind) == 2:
    dice1 = dices_kind.pop()
    dice2 = dices_kind.pop()
    cnt1 = dices.count(dice1)
    cnt2 = dices.count(dice2)
    if cnt1 > cnt2:
        mydice = dice1
    else:
        mydice = dice2
    result = 1000 + mydice * 100
else:
    result = max(dices) * 100

print(result)