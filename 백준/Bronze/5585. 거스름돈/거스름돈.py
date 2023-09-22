price = int(input())
change = 1000 - price

cnt = 0
while change > 0:
    if change >= 500:
        change -= 500
        cnt += 1
    elif change>= 100:
        change -= 100
        cnt += 1
    elif change >= 50:
        change -= 50
        cnt += 1
    elif change >= 10:
        change -= 10
        cnt += 1
    elif change >= 5:
        change -= 5
        cnt += 1
    elif change >= 1:
        change -= 1
        cnt += 1

print(cnt)