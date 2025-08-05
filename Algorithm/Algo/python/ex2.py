import sys
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

# 플로이드–워셜
for k in range(n):         # 중간 경유지
    for i in range(n):     # 출발지
        for j in range(n): # 도착지
            if graph[i][k] and graph[k][j]: # 만약 경유지가 있어서 해당 사이를 이어준다면 i to 경유지 / 경유지 to j가 있다는 말.
                graph[i][j] = 1 # 갈 수 있음을 뜻함.

# 출력
for row in graph:
    print(*row)