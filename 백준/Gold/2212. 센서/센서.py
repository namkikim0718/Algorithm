n = int(input())
k = int(input())
n_loc = list(map(int, input().split()))
if n == 1:
    min_sum = 0
else:
    

    n_loc.sort()
    dist = []

    for i in range(len(n_loc)-1):
        dist.append(n_loc[i+1] - n_loc[i])

    dist.sort()
    if(k == 1):
        min_sum = sum(dist)
    else:
        for i in range(k-1):
            dist.pop()
        min_sum = sum(dist)

print(min_sum)
