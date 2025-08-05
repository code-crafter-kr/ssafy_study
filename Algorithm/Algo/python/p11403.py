from collections import deque, defaultdict
import sys
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

n = int(input())
lst = [list(map(int, input().split())) for _ in range(n)]

dq = deque()
mark = defaultdict(set)
# 맨앞부터 탐색 .. 

answer = []
for i in range(n):
    temp = [0] * n
    # i점이 다른 노드 도달이 가능한가
    dq = deque()

    for x in range(n):
        if lst[i][x] == 1:
            dq.append(x) # 초기 노드가 갈 수 있는 길
    while dq:
        end = dq.pop() # 도착점만 마킹
        if temp[end] == 1: # 도착해봤으면 넘김
            continue 
        temp[end] = 1 # 도착 마킹

        for x in range(n): # 도착한 곳에서 갈 수 있는곳도 다 뽑아옴
            if lst[end][x] == 1:
                dq.append(x)
    


    answer.append(temp)

for z in answer:
    print(*z)
