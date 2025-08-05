import sys
import heapq
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

T = int(input())
pq = []
for _ in range(T):
    for num in map(int, input().split()):
        if len(pq) < T:
            heapq.heappush(pq, num)
        else:
            if num > pq[0]:  # 최소값보다 클 때만 교체
                heapq.heappop(pq)
                heapq.heappush(pq, num)
print(pq[0])  # N번째 큰 값
