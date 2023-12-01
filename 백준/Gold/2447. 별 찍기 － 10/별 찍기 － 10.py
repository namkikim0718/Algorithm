import sys
input = sys.stdin.readline

N = int(input())

def make_stars(n):
    
    if n == 1:
        return '*'
    
    stars = make_stars(n//3)
    result = []
    
    for star in stars:
        result.append(star * 3)
    
    for star in stars:
        result.append(star + ' ' * (n//3) + star)

    for star in stars:
        result.append(star * 3)
    
    return result

    
prt_stars = make_stars(N)
for i in prt_stars:
    print(i)
print()