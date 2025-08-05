import heapq
from collections import defaultdict
import sys
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

n = int(input())

marking = defaultdict(int)

lst = []

for i in range(n):
    c = int(input())
    if c == 0:
        try:
            if marking[-lst[0]] != 0:
                marking[-lst[0]] -= 1
                print(-heapq.heappop(lst)) #미니멈이나 음수로 abs 기준으로 뽑고싶음
            else:
                print(heapq.heappop(lst))
        except:
            print(0)
    
    else:
        if c < 0:
            heapq.heappush(lst, -c) # 일단 절대값 기준으로 넣고
            marking[c] += 1 # 음수였으면 음수 표기
        else:
            heapq.heappush(lst, c) #양수면 그냥 넣고
