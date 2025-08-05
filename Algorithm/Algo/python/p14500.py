from collections import defaultdict, deque
import sys
sys.stdin = open("input.txt", "r")
input = sys.stdin.readline

N, M = map(int, input().split())

lst = []
for i in range(N):
    lst.append(list(map(int, input().split())))


# Type A: 4블럭 일자형 (2개)
AType = [
    ((1, 0), (2, 0), (3, 0)),  # 세로
    ((0, 1), (0, 2), (0, 3)),  # 가로
]

# Type B: 정사각형 (1개)
BType = [
    ((1, 0), (0, 1), (1, 1)),
]

# Type C: ㅗ/ㅏ/ㅜ/ㅓ (4개)
CType = [
    ((0, -1), (0, 1), (1, 0)),   # ㅗ
    ((0, -1), (0, 1), (-1, 0)),  # ㅜ
    ((-1, 0), (1, 0), (0, -1)),  # ㅓ
    ((-1, 0), (1, 0), (0, 1)),   # ㅏ
]

# Type D: L자 / J자 (8개)
DType = [
    ((1, 0), (2, 0), (2, 1)),
    ((1, 0), (2, 0), (2, -1)),
    ((0, 1), (0, 2), (1, 0)),
    ((0, 1), (0, 2), (1, 2)),
    ((1, 0), (1, 1), (1, 2)),
    ((0, 1), (1, 1), (2, 1)),
    ((1, 0), (1, -1), (1, -2)),
    ((0, -1), (1, -1), (2, -1)),
]

# Type E: Z자 / S자 (4개)
EType = [
    ((0, 1), (1, 1), (1, 2)),   # Z 가로
    ((1, 0), (1, -1), (2, -1)), # Z 세로
    ((0, 1), (-1, 1), (-1, 2)), # S 가로
    ((1, 0), (1, 1), (2, 1)),   # S 세로
]

Types = AType + BType + CType + DType + EType

def index_checker(x, y, N, M):
    if (x < 0 or y < 0 or x >= N or y >= M): return False
    return True
    
answer = 0

for i in range(N):
    for j in range(M):
        for block in Types:
            result = lst[i][j]
            valid = True  # 블록이 범위 안에 있는지 체크
            for dy, dx in block:
                ny = i + dy
                nx = j + dx
                if not index_checker(ny, nx, N, M):
                    break
                result += lst[ny][nx]
            answer = max(answer, result)

print(answer)