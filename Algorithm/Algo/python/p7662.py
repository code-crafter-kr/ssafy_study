import sys
import heapq
from collections import defaultdict
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

# 만약 존재하지 않으면 0을
# 양수값만 존재하면 1을
# 해당 수가 두개 존재하면
TC = int(input())

for i in range (TC):
    n = int(input())
    lst_max = []
    lst_min = []
    for _ in range(n):
        command, number = input().split()
        number = int(number)
        if command == "I":
            heapq.heappush(lst_max, number * -1) # 여기서 pop시 무조건 가장 큰수임
            heapq.heappush(lst_min, number) # 여기서 pop시 무조건 가장 작은수임
        
        elif command == "D" and len(lst_max) == 0:
            continue

        elif command == "D" and number == -1:
            target = heapq.heappop(lst_min) * -1
            lst_max.remove(target)    
        
        else:
            target = heapq.heappop(lst_max) * -1
            lst_min.remove(target)
    
    if len(lst_max) == 0:
        print("EMPTY")
    elif len(lst_max) == 1:
        print(heapq.heappop(lst_min))
    else:
        print(heapq.heappop(lst_max) * -1, end = " ")
        print(heapq.heappop(lst_min))
