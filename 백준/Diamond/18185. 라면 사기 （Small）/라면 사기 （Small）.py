n = int(input())
a = list(map(int, input().split()))
a.append(0)
a.append(0)

money_sum = 0
for i in range(n):
    if(a[i+1] > a[i+2]):
        cnt = min(a[i], a[i+1] - a[i+2])
        money_sum += 5*cnt
        a[i] -= cnt; a[i+1] -= cnt

        cnt = min(a[i], a[i+2])
        money_sum += 7*cnt
        a[i] -= cnt; a[i+1] -= cnt; a[i+2] -= cnt
    else:
        cnt = min(a[i], a[i+1], a[i+2])
        money_sum += 7*cnt
        a[i] -= cnt; a[i+1] -= cnt; a[i+2] -= cnt

        cnt = min(a[i], a[i+1])
        money_sum += 5*cnt
        a[i] -= cnt; a[i+1] -= cnt
    
    money_sum += 3*a[i]


print(money_sum)