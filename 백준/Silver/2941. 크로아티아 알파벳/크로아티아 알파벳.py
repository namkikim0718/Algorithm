import sys
input = sys.stdin.readline

alpha_list = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

str = input()

index = 0
count = 0

while index < len(str) - 1:
    exist = False
    for alpha in alpha_list:
        length = len(alpha)
        if str[index:index+length] == alpha:
            index += length
            count += 1
            exist = True
            break
    if not exist:
        index += 1
        count += 1

print(count)