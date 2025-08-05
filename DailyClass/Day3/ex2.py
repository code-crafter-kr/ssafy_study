import sys

n = int(sys.stdin.readline())
limit = int(n ** 0.5)

# 1개
for i in range(1, limit + 1):
    if i * i == n:
        print(1)
        sys.exit()

# 2개
for i in range(1, limit + 1):
    ii = i * i
    for j in range(i, limit + 1):          # i부터 시작해서 중복 줄이기
        s = ii + j * j
        if s == n:
            print(2)
            sys.exit()
        if s > n:
            break

# 3개
for i in range(1, limit + 1):
    ii = i * i
    for j in range(i, limit + 1):
        jj = j * j
        s = ii + jj
        if s > n:
            break
        for k in range(j, limit + 1):
            if s + k * k == n:
                print(3)
                sys.exit()
            if s + k * k > n:
                break

# 4개 (라그랑주 정리로 항상 가능)
print(4)
