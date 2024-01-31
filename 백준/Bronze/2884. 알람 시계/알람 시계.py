import sys
input = sys.stdin.readline

hour, minute = map(int, input().split())
early_hour = 0
early_minute = 0

if minute >= 45:
    early_minute = minute - 45
    early_hour = hour
else:
    early_minute = 60 + minute - 45
    if hour - 1 < 0:
        early_hour = 24 + hour - 1
    else:
        early_hour = hour - 1

print(early_hour, early_minute)