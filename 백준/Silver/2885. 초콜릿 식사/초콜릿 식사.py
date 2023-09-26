k = int(input())

if k == 1:
    smallest_size = 1
else:
    n = 2
    m = 1
    while True:
        if k <= n:
            smallest_size = n
            break
        else:
            m += 1
            n = 2 ** m

d = smallest_size
if k == 1:
    smallest_divide = 0
else:
    smallest_divide = 0
    for i in range(1, smallest_size):
        if k == 0:
            smallest_divide = i-1
            break
        else:
            d //= 2
            if k >= d:
                k -= d 

print(smallest_size, smallest_divide)
