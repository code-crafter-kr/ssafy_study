from collections import deque
import sys
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

N, M = map(int, input().split())

lst = []
for i in range(N):
    lst.append(list(input().strip()))

for i in range(N):
    for j in range(M):
        if lst[i][j] == "I":
            start_row = i
            start_col = j

ans = 0
dir = [(1, 0), (-1, 0), (0, 1), (0, -1)]
visited = [[False for _ in range (M+1)] for _ in range (N+1)]
dq = deque()
dq.append((start_row, start_col)) #시작 위치 튜플

def bfs():
    global ans
    while dq:
        pos_row, pos_col = dq.pop()
        if visited[pos_row][pos_col]:
            continue
        
        visited[pos_row][pos_col] = True
        if lst[pos_row][pos_col] == 'P':
            ans += 1
        # 인덱스 체크 및 벽 체크
        for x, y in dir:
            nRow = pos_row + x
            nCol = pos_col + y

            if nRow < N and nCol < M and nRow >= 0 and nCol >= 0 and lst[nRow][nCol] != "X": # 벽이 아닐때만 진행..
                dq.append((nRow, nCol))

bfs()
print(ans if ans != 0 else "TT")