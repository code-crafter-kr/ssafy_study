import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
lst = deque()
dic = dict()
for i in range (1, 10):
    dic[i] = 0

lst = list(map(int, input().split()))
for i in lst:
    dic[i] += 1



if list(dic.values()).count(0) >= 7: #끝나는 시점