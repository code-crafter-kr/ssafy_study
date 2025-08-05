from collections import defaultdict, deque
import sys
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

a, b = map(int, input().split())

ladder = defaultdict(int)
snake = defaultdict(int)

visited = [10000] * 101

for i in range(a):
    start, end = map(int, input().split())
    ladder[start] = end

for i in range(b):
    start, end = map(int, input().split())
    snake[start] = end

# 그리디식으로 풀어야하나? 아니다
dq = deque([(1, 0)]) # 1번칸에서 시작

while dq:
    current, count = dq.popleft()
    if visited[current] <= count or current > 100: # 만약 지금까지 도달을 한 횟수가 많으면 무시해도 된다
        continue
    
    visited[current] = count
    for i in range(1, 7):
        next = current + i
        # 사다리 초 연속 탑승 가능 마치 롤로코스터
        if next > 100:
            break
        # 현재 도달점
        if snake[next] != 0 or ladder[next] != 0: # 탑승 시작
            while True:
                if snake[next] != 0:
                    visited[next] = min(visited[next], count + 1)
                    next = snake[next]
                else:
                    visited[next] = min(visited[next], count + 1)
                    next = ladder[next]

                if snake[next] == 0 and ladder[next] == 0: #탑승 중지
                    break
        
        dq.append((next, count + 1))

print(visited[-1])