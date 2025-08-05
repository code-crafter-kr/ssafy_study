from collections import deque
import sys
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

N, M = map(int, input().split())
minimum = 10**9
maximum = -1
lst = [int(input()) for _ in range (N)]
lst.sort()

def cal(lst, length):
    result = 0
    for i in lst:
        result += (i // length)
    
    return result

left = 1
right = lst[-1]
ans = 0

while left <= right: 
    mid = (left + right) // 2

    count = cal(lst, mid)
    if count >= M:
        ans = mid
        left = mid + 1
    else:
        right = mid - 1

print(ans)