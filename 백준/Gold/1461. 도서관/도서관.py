import sys
input = sys.stdin.readline

n, m = map(int, input().split())

book_list = list(map(int, input().split()))
positive_list = []
negative_list = []

for item in book_list:
    if item > 0:
        positive_list.append(item)
    else:
        negative_list.append(item)

positive_list.sort(key=abs)
negative_list.sort(key=abs)

result = 0
if len(positive_list) == 0:
    positive_list.append(0)
if len(negative_list) == 0:
    negative_list.append(0)

if abs(negative_list[len(negative_list)-1]) > abs(positive_list[len(positive_list)-1]):
    
    last_num = len(negative_list) % m
    i = 0
    while i < len(negative_list):
        if len(negative_list) // m < 1:
            result += abs(negative_list[i+last_num-1])
            break
        elif last_num != 0:
            result += abs(negative_list[i+last_num-1]) * 2
            i += last_num
            last_num = 0
        elif len(negative_list[i:]) > m:
            result += abs(negative_list[i+m-1]) * 2
            i += m
        else:
            result += abs(negative_list[i+m-1])
            i += m
        
    last_num = len(positive_list) % m
    i = 0
    while i < len(positive_list):
        if last_num != 0:
            result += positive_list[i+last_num-1] * 2
            i += last_num
            last_num = 0
        else:
            result += positive_list[i+m-1] * 2
            i += m

else:
    last_num = len(positive_list) % m
    i = 0
    while i < len(positive_list):
        if len(positive_list) // m < 1:
            result += positive_list[i+last_num-1]
            break
        elif last_num != 0:
            result += positive_list[i+last_num-1] * 2
            i += last_num
            last_num = 0
        elif len(positive_list[i:]) > m:
            result += positive_list[i+m-1] * 2
            i += m
        else:
            result += positive_list[i+m-1]
            i += m
        
    last_num = len(negative_list) % m
    i = 0
    while i < len(negative_list):
        if last_num != 0:
            result += abs(negative_list[i+last_num-1]) * 2
            i += last_num
            last_num = 0
        else:
            result += abs(negative_list[i+m-1]) * 2
            i += m

print(result)
