import sys
input = sys.stdin.readline

C = int(input())
for k in range(C):
    scores = list(map(int, input().split()))
    cnt = scores.pop(0)
    score_sum = sum(scores)
    avg = score_sum / cnt
    over_avg = 0
    for i in scores:
        if i > avg:
            over_avg += 1
    print("{:.3f}%".format(over_avg * 100 / cnt))
    